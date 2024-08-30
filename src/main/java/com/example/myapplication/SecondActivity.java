

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        b1 = findViewById(R.id.button3);
        b1.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent i = new Intent(SecondActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                }
        );

        b2 = findViewById(R.id.button17);
        b2.setOnClickListener(
                new View.OnClickListener()
                    {
                        @Override
                    public void onClick(View v)
                    {
                        Intent i = new Intent(SecondActivity.this, recyclerView.class);
                        startActivity(i);
                    }
                }
        );

        Button b3;
        b3 = findViewById(R.id.button2);
        b3.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent i = new Intent(SecondActivity.this, RatingSystem.class);
                        startActivity(i);
                    }
                }
        );

        Button b4;
        b4 = findViewById(R.id.button4);
        b4.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent i = new Intent(SecondActivity.this, AboutScreen.class);
                        startActivity(i);
                    }
                }
        );

        Button b5;
        b5 = findViewById(R.id.button7);
        b5.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent i = new Intent(SecondActivity.this, maps.class);
                        startActivity(i);
                    }
                }
        );

    }

}