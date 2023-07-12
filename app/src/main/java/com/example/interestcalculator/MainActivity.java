package com.example.interestcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText principalEditText, rateEditText, timeEditText;
    private TextView interestTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principalEditText = findViewById(R.id.editTextPrincipal);
        rateEditText = findViewById(R.id.editTextRate);
        timeEditText = findViewById(R.id.editTextTime);
        interestTextView = findViewById(R.id.textViewInterest);
        calculateButton = findViewById(R.id.buttonCalculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateInterest();
            }
        });
    }

    private void calculateInterest() {
        String principalStr = principalEditText.getText().toString().trim();
        String rateStr = rateEditText.getText().toString().trim();
        String timeStr = timeEditText.getText().toString().trim();

        if (!principalStr.isEmpty() && !rateStr.isEmpty() && !timeStr.isEmpty()) {
            double principal = Double.parseDouble(principalStr);
            double rate = Double.parseDouble(rateStr);
            double time = Double.parseDouble(timeStr);

            double interest = (principal * rate * time) / 100;

            interestTextView.setText(String.format("%.2f", interest));
        } else {
            interestTextView.setText("");
        }
    }
}
