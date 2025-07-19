//Package of the project
package com.example.bizzclub;

//imports for the projects
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//register class
public class Register extends AppCompatActivity {

    //constructor
    ImageView logoImage;
    ImageView imageViewGoogle;
    ImageView imageViewFacebook;
    ImageView imageViewinkedIn;
    TextView signIn;

    //on create method

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        //get the items by their ID
        signIn = findViewById(R.id.existAccount);
        logoImage = findViewById(R.id.logoImage);
        imageViewGoogle = findViewById(R.id.google);
        imageViewFacebook = findViewById(R.id.facebook);
        imageViewinkedIn = findViewById(R.id.linkedIn);

        //Home  page Navigation
        logoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Register.this, MainActivity.class);
                startActivity(browserIntent);

                //Sign In navigation
                signIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent browserIntent = new Intent(Register.this, LoginPage.class);
                        startActivity(browserIntent);
                        finish();
                    }
                });

                //Google navigation
                imageViewGoogle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/v3/signin/"));
                        startActivity(browserIntent);
                    }
                });

                //facebook navigation
                imageViewFacebook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/login/?locale=en_GB"));
                        startActivity(browserIntent);
                    }
                });

                //Linked In navigation
                imageViewinkedIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin"));
                        startActivity(browserIntent);
                    }
                });

                //view compact part --> put this bottom
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });
            }
        });

    };
}
