package com.example.bizzclub;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailedActivity extends AppCompatActivity {

    TextView detailName, detailTime, detailDescription;
    ImageView detailImage;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        // Initialize views
        detailName = findViewById(R.id.detailName);
        detailTime = findViewById(R.id.detailTime);
        detailDescription = findViewById(R.id.wait);
        detailImage = findViewById(R.id.detailImage);

        // Get data passed from the previous activity
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String time = intent.getStringExtra("time");
        String description = intent.getStringExtra("desc");
        int image = intent.getIntExtra("image", R.drawable.image1); // Default image if no image passed

        Button mapBtn = findViewById(R.id.mapGo);
        mapBtn.setOnClickListener(v -> {
            Intent intentNew = new Intent(DetailedActivity.this, Map.class);
            startActivity(intentNew);
        });

        // Set data to views
        detailName.setText(name);
        detailTime.setText(time);
        detailDescription.setText(description);
        detailImage.setImageResource(image);
    }
}
