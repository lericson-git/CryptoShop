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

/**
 * @author Lucas Ericson
 * activity_landing is a implemented {@link AppCompatActivity} that pulls up when the app is opened.
 * It allows users to sign up, login, or skip to testing the app. It provieds
 * the output of login page.
 */
public class activity_landing extends AppCompatActivity {

    /**
     * onCreate method runs first to instantiate the activity.
     * Sets up UI elements and creates button listener.
     * @param savedInstanceState is a {@link Bundle} that stores saved instances.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        //Get User from extras
        User user;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            user = null;
        } else {
            user = (User) extras.getParcelable("userInfo");
            Log.d("USER", this.getLocalClassName() + " Received Account: " + user.getUsername());
        }

        Button btnLogin = findViewById(R.id.activity_landing_btnLogin);
        Button btnSignup = findViewById(R.id.activity_landing_btnSignup);
        Button btnHome = findViewById(R.id.activity_landing_btnHome);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            /**
             * onClick runs when login button listener is activated and starts login activity
             * @param v is the {@link View} the activity is running in.
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), activity_login.class));
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            /**
             * onClick runs when signup button listener is activated and starts signup activity
             * @param v is the {@link View} the activity is running in.
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), activity_signup.class));
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            /**
             * onClick runs when MainActivity button listener is activated and starts MainActivity
             * @param v is the {@link View} the activity is running in.
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });

    }
}

