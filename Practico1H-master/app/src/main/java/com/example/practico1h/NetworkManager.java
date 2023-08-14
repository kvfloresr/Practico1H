package com.example.practico1h;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    private static final String BASE_URL = "your_base_url";
    private ClimateApiService climateApiService;

    public NetworkManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        climateApiService = retrofit.create(ClimateApiService.class);
    }

    public ClimateDataResponse fetchClimateData() throws Exception {
        // Use Coroutines to execute the network request
        // and return the ClimateDataResponse
        return null;
    }
}
