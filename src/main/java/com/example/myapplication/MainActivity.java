package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.speech.tts.TextToSpeech;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private SurfaceView surfaceView;
    private CameraSource cameraSource;
    private TextRecognizer textRecognizer;

    private TextToSpeech textToSpeech;

    private String stringResult = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);
        Button b1;
        b1 = findViewById(R.id.button4);
        b1.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent i = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(i);
                    }
                }
        );


        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                //default settings will be changed here
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cameraSource.release();
    }

    private void textRecognizer() {
        textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();
        cameraSource = new CameraSource.Builder(getApplicationContext(), textRecognizer)
                .setRequestedPreviewSize(1280, 1024)
                .build();
        surfaceView = findViewById(R.id.surfaceView);

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                try {
                    cameraSource.start(surfaceView.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                cameraSource.stop();
            }
        });

        textRecognizer.setProcessor(new Detector.Processor<TextBlock>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(@NonNull Detector.Detections<TextBlock> detections) {
                SparseArray<TextBlock> sparseArray = detections.getDetectedItems();
                StringBuilder stringBuilder = new StringBuilder();

                for(int i = 0; i < sparseArray.size(); ++i)
                {
                    TextBlock textBlock = sparseArray.valueAt(i);
                    if (textBlock != null && textBlock.getValue() != null)
                    {
                        stringBuilder.append(textBlock.getValue() + " ");
                    }
                }

                String stringFullText = stringBuilder.toString();

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        stringResult = stringFullText;
                        resultObtained();
                    }
                });
            }
        });
    }



    private void resultObtained(){
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        //Translate using either firebase or mlkit, didn't have time to embed either of them.
        textView.setText(stringResult + " means Welcome to the City!");
        textToSpeech.speak(stringResult, TextToSpeech.QUEUE_FLUSH, null, null);
        Button b1;
        b1 = findViewById(R.id.button4);
        b1.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent i = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(i);
                    }
                }
        );

    }

    public void buttonStart(View view)
    {
        setContentView(R.layout.surfaceview);

        System.out.println("hello");
        textRecognizer();
    }
}