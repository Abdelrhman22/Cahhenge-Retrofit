package com.example.abdo.challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.abdo.challenge.Model.ImageContainer;
import com.squareup.picasso.Picasso;

public class Info extends AppCompatActivity {

    private ImageView imageView;
    private Button prev,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Log.d("",""+ImageContainer.getUrl());
        imageView=findViewById(R.id.image_clicked);
        prev=findViewById(R.id.prev);
        next=findViewById(R.id.next);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Info.this, "Prev Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Info.this, "Next Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        Intent intent = getIntent();

        Picasso.get().load(intent.getStringExtra("image")).placeholder(R.drawable.load).error(R.drawable.error).into(imageView);


    }
}
