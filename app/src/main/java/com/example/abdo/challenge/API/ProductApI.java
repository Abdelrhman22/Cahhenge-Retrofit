package com.example.abdo.challenge.API;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductApI {

   // @FormUrlEncoded
    @GET("products")
    Call<ResponseBody> getproducts(@Query("count") int count,@Query("from") int from);
}
