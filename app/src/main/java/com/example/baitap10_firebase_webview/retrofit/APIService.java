package com.example.baitap10_firebase_webview.retrofit;

import com.example.baitap10_firebase_webview.model.MessageVideoModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface APIService {
    // Tạo Gson với định dạng ngày tháng tùy chỉnh
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy MM dd HH:mm:ss")
            .create();

    // Tạo Retrofit client
    APIService serviceApi = new Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIService.class);

    // Interface APIService
    @GET("df9545f1-9757-48c5-a56b-87f1efecff89")
    Call<MessageVideoModel> getVideos();
}
