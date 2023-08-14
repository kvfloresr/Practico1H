package com.example.practico1h;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ejercicio18 extends AppCompatActivity {

    private EditText termEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej18);

        termEditText = findViewById(R.id.termEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String termStr = termEditText.getText().toString();
                if (!termStr.isEmpty()) {
                    int n = Integer.parseInt(termStr);
                    long nthTerm = findNthFibonacciTerm(n);
                    resultTextView.setText("El " + n + "th termino en Fibonacci secuencia es: " + nthTerm);
                }
            }
        });
    }

    private long findNthFibonacciTerm(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return findNthFibonacciTerm(n - 1) + findNthFibonacciTerm(n - 2);
        }
    }
}