package com.example.abdo.challenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdo.challenge.API.ProductApI;
import com.example.abdo.challenge.Adapters.AdapterProducts;
import com.example.abdo.challenge.Model.DataEncap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<DataEncap> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=findViewById(R.id.recycler_view);

        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        arrayList = new ArrayList<>();
        LoadData();

    }

    private void LoadData() {
        String BASE_URL="http://grapesnberries.getsandbox.com/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).build();
        ProductApI productApI = retrofit.create(ProductApI.class);
        productApI.getproducts(10,1).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    JSONArray mainArray=new JSONArray(response.body().string());
                    for (int i = 0; i < mainArray.length(); i++) {

                        JSONObject mainObject = mainArray.getJSONObject(i);
                        String des=mainObject.getString("productDescription");
                        String price=mainObject.getString("price");

                        JSONObject Image=mainObject.getJSONObject("image");
                        String url=Image.getString("url");

                        String height = Image.getString("height");

                        DataEncap encap = new DataEncap(des,url,height,price);
                        arrayList.add(encap);

                    }
                    mAdapter = new AdapterProducts(arrayList,getApplicationContext(),MainActivity.this);
                    mRecyclerView.setAdapter(mAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


}

