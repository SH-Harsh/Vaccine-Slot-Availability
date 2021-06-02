package com.example.cowinslot.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyBase {

    public static Retrofit retrofit;
    public static String Base_Url ="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/";

    public static Retrofit getMyBase() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }
}
