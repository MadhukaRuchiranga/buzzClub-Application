package com.example.bizzclub;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPIInterface {
    // Currents API Endpoint for fetching business news
    @GET("latest-news")
    Call<NewsResponse> getBusinessNews(
            @Query("category") String category,
            @Query("apiKey") String apiKey
    );
}
