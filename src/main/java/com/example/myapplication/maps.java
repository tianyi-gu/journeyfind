package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.IOException;
import java.util.List;
import android.webkit.WebView;



public class maps extends AppCompatActivity {
    String address = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                address = editText.getText().toString();



            }
        });
        Button button = findViewById(R.id.button17);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double[] p1 = getLocationFromAddress(address);
                web(p1[0],p1[1]);
            }
        });
        Button button2 = findViewById(R.id.changeActivities);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(maps.this, SecondActivity.class);
                startActivity(intent);

            }
        });



    }
    public double[] getLocationFromAddress(String strAddress) {

        Geocoder coder = new Geocoder(this.getApplicationContext());
        List<Address> address;
        double[] p1 = new double[2];

        try {
            address = coder.getFromLocationName(strAddress, 1);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1[0] = (location.getLatitude());
            p1[1] = (location.getLongitude());

            return p1;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void web(double Latitude, double Longitude){

        WebView webView = (WebView)findViewById(R.id.webView);
        String placeTypeList[] = {"restraunt, store"}; //WIP
        String url = "https://www.google.com/maps/search/?api=1&query=" + Latitude +"%2C" + Longitude;
        //https://www.google.com/maps/search/?api=1&query=47.5951518%2C-122.3316393
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}