package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import test.connect.myapplication.model.User;

public class activity_landing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        //Get User from extras
        User user;
        /*if (savedInstanceState == null) {*/
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            user = null;
        } else {
            user = (User) extras.getParcelable("userInfo");
            Log.d("USER", "Account: " + user.getUsername());
        }
        Log.d("USER", "Account: NULL");

        /*
        } else {
            user = savedInstanceState.getParcelable("userInfo");
        }
        */


        Button btnLogin = findViewById(R.id.activity_landing_btnLogin);
        Button btnSignup = findViewById(R.id.activity_landing_btnSignup);
        Button btnHome = findViewById(R.id.activity_landing_btnHome);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), activity_login.class));
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), activity_signup.class));
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });

    }
}

