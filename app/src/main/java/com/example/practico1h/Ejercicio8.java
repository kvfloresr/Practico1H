package com.example.practico1h;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ejercicio8 extends AppCompatActivity {

    private EditText editTextUrls;
    private TextView textViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej8);

        editTextUrls = findViewById(R.id.editTextUrls);
        textViewStatus = findViewById(R.id.textViewStatus);
    }

    public void startDownloads(View view) {
        String urlsInput = editTextUrls.getText().toString();
        List<String> urlList = Arrays.asList(urlsInput.split(","));

        ExecutorService executorService = Executors.newFixedThreadPool(urlList.size());

        for (final String url : urlList) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    downloadFile(url);
                }
            });
        }

        executorService.shutdown();
    }

    private void downloadFile(String urlStr) {
        try {
            // Simulate downloading the file
            Thread.sleep(2000); // Simulate file download time

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String status = textViewStatus.getText().toString();
                    status += "\nArchivo descargado: " + urlStr;
                    textViewStatus.setText(status);
                }
            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
