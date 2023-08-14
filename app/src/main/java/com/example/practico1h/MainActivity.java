package com.example.practico1h;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goEjercicio2(View v) {
        startActivity(new Intent(MainActivity.this, Ejercicio2.class));
    }

    public void goEjercicio4(View v) {
        startActivity(new Intent(MainActivity.this, Ejercicio4.class));
    }

    public void goEjercicio6(View v) {
        startActivity(new Intent(MainActivity.this, Ejercicio6.class));
    }

    public void goEjercicio8(View v) {
        startActivity(new Intent(MainActivity.this, Ejercicio8.class));
    }

    public void goEjercicio10(View v) {
        startActivity(new Intent(MainActivity.this, Ejercicio10.class));
    }

    public void goEjercicio12(View v) {
        startActivity(new Intent(MainActivity.this, Ejercicio12.class));
    }
}