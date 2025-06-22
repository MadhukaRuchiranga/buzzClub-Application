package com.example.bizzclub;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.List;

public class Map extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap myMap;
    EditText edt;
    Button btn;
    List<Address> listGeocorder;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        edt = findViewById(R.id.textInput);
        btn = findViewById(R.id.search);

        String receivedLocation = getIntent().getStringExtra("user_location");
        if (receivedLocation != null && !receivedLocation.isEmpty()) {
            edt.setText(receivedLocation);
        }

        // Button click
        btn.setOnClickListener(v -> {
            String city = edt.getText().toString().trim();
            if (!city.isEmpty()) {
                getCity(city);
            } else {
                Toast.makeText(this, "Enter a city", Toast.LENGTH_SHORT).show();
            }
        });

    }



    public void getCity(String city){
        Geocoder geocoder = new Geocoder(this);
        try {
            List<Address> addresses = geocoder.getFromLocationName(city, 100);
            if (addresses != null && !addresses.isEmpty()) {
                Address address = addresses.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());

                myMap.clear(); // clear old markers
                myMap.addMarker(new MarkerOptions().position(latLng).title(city));
                myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
            } else {
                Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error finding location", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        myMap = googleMap;
        myMap.getUiSettings().setZoomControlsEnabled(true);
    }
}


