 package com.example.countrynamesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.countrynamesapp.adapter.CountryAdapter;
import com.example.countrynamesapp.model.CountryModel;
import com.example.countrynamesapp.model.Result;
import com.example.countrynamesapp.service.GetCountryDataService;
import com.example.countrynamesapp.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

 public class MainActivity extends AppCompatActivity {

    ArrayList<CountryModel> countries;
    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetCountries();

    }

     private Object GetCountries() {
         GetCountryDataService getCountryDataService = RetrofitInstance.getService();
         Call<Result> call =getCountryDataService.getResult();

         call.enqueue(new Callback<Result>() {
             @Override
             public void onResponse(Call<Result> call, Response<Result> response) {
                 Result result = response.body();

                 if (result != null && result.getResult() != null ) {
                     countries = (ArrayList<CountryModel>) result.getResult();
                     ViewData();
                 }
             }

             @Override
             public void onFailure(Call<Result> call, Throwable t) {

             }
         });

         return countries;
     }

     private void ViewData() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new CountryAdapter(countries);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
     }
 }