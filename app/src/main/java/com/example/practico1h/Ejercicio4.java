package com.example.practico1h;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Ejercicio4 extends AppCompatActivity {

    private EditText editText;
    private TextView textViewUpdates;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej4);

        editText = findViewById(R.id.editText);
        textViewUpdates = findViewById(R.id.textViewUpdates);

        startDataCollection();
    }

    private void startDataCollection() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String data = editText.getText().toString();
                updateUI(data);
                handler.postDelayed(this, 3000); // Update every 3 seconds
            }
        }, 0); // Start immediately
    }

    private void updateUI(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textViewUpdates.setText("Actualizaciones: " + data);
            }
        });
    }
}
