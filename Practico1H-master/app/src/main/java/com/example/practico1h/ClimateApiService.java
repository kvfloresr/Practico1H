package com.example.practico1h;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClimateApiService {
    @GET("your_api_endpoint")
    Call<ClimateDataResponse> getClimateData();
}
