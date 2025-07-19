package com.example.bizzclub;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView newsRecyclerView;
    private NewsAdapter newsAdapter;
    private RetrofitClient retrofitClient;
    private NewsAPIInterface newsAPIInterface;
    private String apiKey = "your_api_key"; // Replace with your Currents API Key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        newsRecyclerView = findViewById(R.id.newsRecyclerView);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize Retrofit
        retrofitClient = new RetrofitClient();
        newsAPIInterface = retrofitClient.getRetrofitInstance().create(NewsAPIInterface.class);

        // Fetch business news
        fetchBusinessNews();
    }

    private void fetchBusinessNews() {
        Call<NewsResponse> call = newsAPIInterface.getBusinessNews("business", apiKey);

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("API_ERROR", "Failure: " + t.getMessage());
                t.printStackTrace();
                Toast.makeText(NewsActivity.this, "Failed to load news", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (!response.isSuccessful()) {
                    Log.e("API_ERROR", "Error code: " + response.code());
                    Toast.makeText(NewsActivity.this, "Error loading news", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Get the list of news (updated from getArticles() to getNews())
                if (response.body() != null && response.body().getNews() != null) {
                    List<NewsItem> newsList = response.body().getNews();
                    // Set the adapter
                    newsAdapter = new NewsAdapter(newsList);
                    newsRecyclerView.setAdapter(newsAdapter);
                } else {
                    Toast.makeText(NewsActivity.this, "No news found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
