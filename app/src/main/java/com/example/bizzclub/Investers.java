package com.example.bizzclub;
import android.content.Intent;
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
        String[] nameList = {"Amal Gunawardhana", "Nisal Perera"};
        String[] locationList = {"Galewela", "Dambulla",};
        String[] descList = {"Mr. Amal is a seasoned investor with over 15 years of experience in real estate and startup funding. He is known for his strategic thinking and strong commitment to nurturing innovative business ideas. Based in Colombo, he has successfully supported multiple SMEs in Sri Lanka and believes in sustainable and community-driven investments. Mr. Perera is always open to new collaborations that drive growth and make a positive social impac",
                "\"Ms. Nadeesha Fernando is a visionary technology investor with a strong passion for innovation and entrepreneurship. With over a decade of experience in the tech industry, she has successfully combined her expertise in software engineering and venture capital to support the growth of numerous startups across South Asia. Based in Sri Lanka, she has funded and mentored more than 20 groundbreaking projects in areas such as artificial intelligence, financial technology (fintech), health tech, and e-commerce platforms.\n" +
                        "\n" +
                        "She is well known for her hands-on approach, actively engaging with startup founders to provide not just funding, but strategic guidance and technical mentorship. Nadeesha strongly believes in the power of technology to drive economic transformation, especially among youth-led enterprises. Her investment philosophy centers on scalability, social impact, and long-term sustainability. In addition to her professional endeavors, she is also a keynote speaker at international tech conferences and regularly contributes to entrepreneurship development programs throughout the region.\n" +
                        "\n" +
                        "Her ultimate goal is to build a thriving tech ecosystem in Sri Lanka that connects local talent to global opportunities and fosters a culture of innovation that benefits future generations.\""};

        // Populate the data list with the example data
        for (int i = 0; i < nameList.length; i++) {
            listData = new ListData(nameList[i], locationList[i], descList[i], imageList[i]);
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
                intent.putExtra("location", locationList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}
