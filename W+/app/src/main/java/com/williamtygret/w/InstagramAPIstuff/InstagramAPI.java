package com.williamtygret.w.InstagramAPIstuff;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by williamtygret on 3/29/16.
 */
public interface InstagramAPI {

    String BASE_URL = "https://api.instagram.com/v1/";

    @GET("users/self/media/recent/?access_token=50603162.c275848.16dbc8e9a4df48f99617aa2fba645b94")
    Call<InstagramAPIResults> getInstagram();

    class Factory {

        private static InstagramAPI service;

        public static InstagramAPI getInstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();

                service = retrofit.create(InstagramAPI.class);
                return service;

            } else {
                return service;
            }

        }

    }


}
