package com.example.practico1h;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ejercicio22 extends AppCompatActivity {

    private EditText numbersEditText;
    private Button findMinButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej22);

        numbersEditText = findViewById(R.id.numbersEditText);
        findMinButton = findViewById(R.id.findMinButton);
        resultTextView = findViewById(R.id.resultTextView);

        findMinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numbersStr = numbersEditText.getText().toString();
                if (!numbersStr.isEmpty()) {
                    String[] numbersArray = numbersStr.split(",");
                    int[] numbers = new int[numbersArray.length];
                    for (int i = 0; i < numbersArray.length; i++) {
                        numbers[i] = Integer.parseInt(numbersArray[i].trim());
                    }
                    int minValue = findMinimum(numbers);
                    resultTextView.setText("The minimum value is: " + minValue);
                }
            }
        });
    }

    private int findMinimum(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int minValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        return minValue;
    }
}