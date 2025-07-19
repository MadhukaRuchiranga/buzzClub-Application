//Package of the project
package com.example.bizzclub;

//imports for the projects
import static com.example.bizzclub.R.*;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//splash class
public class splash extends AppCompatActivity {

    //constructor
    ProgressBar progressBar;

    //on create method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(layout.activity_splash);

        // handling the progress bar part
        progressBar=findViewById(id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        // handling the splash part
        new Handler().postDelayed(()->{
            startActivity(new Intent(splash.this,MainActivity.class)); //naviagtion to main activity
            finish();
        },4000); // Time out of the splash screen

        //view compact part --> put this bottom
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}