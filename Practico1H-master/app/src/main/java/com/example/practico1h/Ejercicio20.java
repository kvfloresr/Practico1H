package com.example.practico1h;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ejercicio20 extends AppCompatActivity {

    private EditText baseEditText, exponentEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej20);

        baseEditText = findViewById(R.id.baseEditText);
        exponentEditText = findViewById(R.id.exponentEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baseStr = baseEditText.getText().toString();
                String exponentStr = exponentEditText.getText().toString();
                if (!baseStr.isEmpty() && !exponentStr.isEmpty()) {
                    int a = Integer.parseInt(baseStr);
                    int n = Integer.parseInt(exponentStr);
                    long result = calculatePower(a, n);
                    resultTextView.setText(a + " elevado a la potencia de " + n + " es: " + result);
                }
            }
        });
    }

    private long calculatePower(int a, int n) {
        if (n == 0) {
            return 1;
        } else {
            return a * calculatePower(a, n - 1);
        }
    }
}