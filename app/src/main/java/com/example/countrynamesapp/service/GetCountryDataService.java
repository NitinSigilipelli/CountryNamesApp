package com.example.countrynamesapp.service;

import com.example.countrynamesapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {
    // Retrofit Interface

    @GET("countries") // endpoint url
    Call<Result> getResult();
}
