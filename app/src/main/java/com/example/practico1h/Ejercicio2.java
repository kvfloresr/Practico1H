package com.example.practico1h;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Ejercicio2 extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button startButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej2);

        progressBar = findViewById(R.id.progressBar);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDownload();
            }
        });
    }

    private void startDownload() {
        progressBar.setVisibility(View.VISIBLE);
        startButton.setEnabled(false);

        // Simulate a long-running task (e.g., file download) using a Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Task completed, hide progress and enable the button
                progressBar.setVisibility(View.GONE);
                startButton.setEnabled(true);
            }
        }, 5000); // Simulate a 5-second task
    }
}