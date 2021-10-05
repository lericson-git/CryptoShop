package com.example.loginactivityexperiment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import com.google.firebase.inappmessaging.model.Button;

public class MainActivity extends AppCompatActivity {

     private EditText Name;
     private EditText Password;
     private TextView Info;
    //private Button Login;
    private int counter = 10;
     private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.etName);
        Password = findViewById(R.id.etPassword);
       Info = findViewById(R.id.tvInfo);
        Login = findViewById(R.id.btnLogin);
        Info.setText("No. of attempts remaining: 5");


    }

    public void validate (String userName, String userPassword) {
        if ((userName.equals("Meet")) && (userPassword.equals("Apple"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        } else {
            counter--;
            Info.setText("No. of attempts remaining: " + String.valueOf(counter));
            if (counter == 0) {
                Login.setEnabled(false);
            }


        }
    }
}