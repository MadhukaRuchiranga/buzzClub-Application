package com.example.bizzclub;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailedActivity extends AppCompatActivity {

    TextView detailHome,detailName, detailLocation, detailDescription;
    ImageView detailImage;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        // Initialize views
        detailHome = findViewById(R.id.homeName);
        detailName = findViewById(R.id.detailName);
        detailLocation = findViewById(R.id.wait);
        detailDescription = findViewById(R.id.desc);
        detailImage = findViewById(R.id.detailImage);

        // Get data passed from the previous activity
        Intent intent = getIntent();
        String home = intent.getStringExtra("home");
        String name = intent.getStringExtra("name");
        String location = intent.getStringExtra("location");
        String description = intent.getStringExtra("desc");
        int image = intent.getIntExtra("image", R.drawable.image1); // Default image if no image passed

        Button mapBtn = findViewById(R.id.mapGo);
        mapBtn.setOnClickListener(v -> {
            Intent intentNew = new Intent(DetailedActivity.this, Map.class);
            intentNew.putExtra("user_location", detailLocation.getText().toString().trim()); // 💥 Add location here
            startActivity(intentNew);
        });


        // Set data to views
        detailHome.setText(home);
        detailName.setText(name);
        detailLocation.setText(location);
        detailDescription.setText(description);
        detailImage.setImageResource(image);
    }
}
