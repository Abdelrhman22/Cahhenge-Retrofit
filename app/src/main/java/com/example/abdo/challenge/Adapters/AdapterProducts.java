package com.example.abdo.challenge.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdo.challenge.Info;
import com.example.abdo.challenge.MainActivity;
import com.example.abdo.challenge.Model.DataEncap;
import com.example.abdo.challenge.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterProducts extends RecyclerView.Adapter<AdapterProducts.ViewHolder> implements View.OnClickListener {

    ArrayList<DataEncap> arrayList;
    Context context;
    MainActivity mainActivity;

    DataEncap encap = new DataEncap();

    public AdapterProducts(ArrayList<DataEncap> arrayList, Context context, MainActivity mainActivity) {
        this.arrayList = arrayList;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @Override
    public AdapterProducts.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);

        ViewHolder viewHolder = new ViewHolder(layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterProducts.ViewHolder holder, int position) {
        encap = arrayList.get(position);

        holder.cardView.setTag(position);
        holder.txtPrice.setText(" $ "+encap.getPrice());
        holder.txtDesc.setText(encap.getProductDescription());
        Picasso.get().load(encap.getUrl()).placeholder(R.drawable.load).error(R.drawable.error).into(holder.imageView);
        holder.imageView.getLayoutParams().height =Integer.parseInt(encap.getHeight());
        holder.imageView.requestLayout();

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cardView;
        ImageView imageView;
        TextView txtPrice;
        TextView txtDesc;

        public ViewHolder(View layout) {
            super(layout);

            cardView = layout.findViewById(R.id.list_row_container);
            imageView = layout.findViewById(R.id.imageView);
            txtPrice = layout.findViewById(R.id.txt_price);
            txtDesc = layout.findViewById(R.id.txt_description);
            cardView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();
            int index=getAdapterPosition();

            encap = arrayList.get(index);


          Intent intent = new Intent(mainActivity, Info.class);
          intent.putExtra("image", encap.getUrl());
          mainActivity.startActivity(intent);

        }

    }

}


