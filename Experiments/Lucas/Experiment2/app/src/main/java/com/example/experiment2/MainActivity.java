package com.example.experiment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText numOneBox, numTwoBox;
    Button addBtn, subBtn, multBtn, divBtn;
    TextView answerText;
    Float numOne, numTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numOneBox = findViewById(R.id.numOneInput);
        numTwoBox = findViewById(R.id.numTwoInput);

        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        multBtn = findViewById(R.id.multBtn);
        divBtn = findViewById(R.id.divBtn);

        answerText = findViewById(R.id.answerText);

        //Add button listener
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numOne = Float.parseFloat(numOneBox.getText().toString());
                numTwo = Float.parseFloat(numTwoBox.getText().toString());

                answerText.setText("Answer: " + String.valueOf(numOne + numTwo));
            }
        });

        //Subtract button listener
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numOne = Float.parseFloat(numOneBox.getText().toString());
                numTwo = Float.parseFloat(numTwoBox.getText().toString());

                answerText.setText("Answer: " + String.valueOf(numOne - numTwo));
            }
        });

        //Multiply button listener
        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numOne = Float.parseFloat(numOneBox.getText().toString());
                numTwo = Float.parseFloat(numTwoBox.getText().toString());

                answerText.setText("Answer: " + String.valueOf(numOne * numTwo));
            }
        });

        //Divide button listener
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numOne = Float.parseFloat(numOneBox.getText().toString());
                numTwo = Float.parseFloat(numTwoBox.getText().toString());

                answerText.setText("Answer: " + String.valueOf(numOne / numTwo));
            }
        });
    }
}