package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingSystem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_system);
        EditText editNamePlace = (EditText) findViewById(R.id.editNamePlace);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        RatingBar ratingBar2 = (RatingBar) findViewById(R.id.ratingBar2);
        RatingBar ratingBar3 = (RatingBar) findViewById(R.id.ratingBar3);
        RatingBar ratingBar4 = (RatingBar) findViewById(R.id.ratingBar4);
        Button button = findViewById(R.id.submittButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ratingBar.setRating(0F);
                ratingBar2.setRating(0F);
                ratingBar3.setRating(0F);
                ratingBar4.setRating(0F);
                editNamePlace.setText("Name of Visited Place");
                textView2.setText("Thank you for your Submission");

            }
        });
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RatingSystem.this, SecondActivity.class);
                startActivity(intent);

            }
        });
    }
}