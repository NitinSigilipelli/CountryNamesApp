package com.example.countrynamesapp.service;
;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    //singleton
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.printful.com/";

    //Singleton Pattern used to create an instance of retrofit
    public static GetCountryDataService getService() {
        //Instance is not created Before
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        //if instance is already created
        return retrofit.create(GetCountryDataService.class);
    }



}
