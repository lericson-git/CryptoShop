package com.example.experiment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String user, pass, email;
    Button submitBtn;

    EditText userInput, passInput, emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editUser);
        passInput = (EditText) findViewById(R.id.editPass);
        emailInput = (EditText) findViewById(R.id.editEmail);

        submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = userInput.getText().toString();
                pass = passInput.getText().toString();
                email = emailInput.getText().toString();

                showToast(user);
                showToast(pass);
                showToast(email);
            }
        });
    }

    private void showToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}