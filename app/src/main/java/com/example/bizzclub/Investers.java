package com.example.bizzclub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bizzclub.databinding.ActivityInvestersBinding;

import java.util.ArrayList;

public class Investers extends AppCompatActivity {
    ActivityInvestersBinding binding;
    ListAdapter listAdapter;
    Button button;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInvestersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        // Example data (you can replace these with your actual data)
        int[] imageList = {R.drawable.image1, R.drawable.image2}; // Example images
        String[] nameList = {"Investor 1", "Investor 2"};
        String[] timeList = {"Amal Gunawardhana", "Nisal Perera",};
        String[] ingredientList = {"Investing in tech", "Investing in agriculture"};
        String[] descList = {"Investor 1 is a tech enthusiast.", "Investor 2 focuses on agriculture."};

        // Populate the data list with the example data
        // Populate the data list with the example data
        for (int i = 0; i < nameList.length; i++) {
            listData = new ListData(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }


        // Create and set the adapter
        listAdapter = new ListAdapter(Investers.this, dataArrayList);
        binding.listView.setAdapter(listAdapter);

        // Handle item click event
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Pass data to DetailedActivity
                Intent intent = new Intent(Investers.this, DetailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}
