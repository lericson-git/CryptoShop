package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetUserApi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.User;

public class activity_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button loginSubmit = findViewById(R.id.activity_login_loginButton);
        EditText emailIn = findViewById(R.id.activity_login_email);
        EditText passwordIn = findViewById(R.id.activity_login_password);
        loginSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User loginUser = new User();
                loginUser.setEmail(emailIn.getText().toString());
                loginUser.setHashed_pass(passwordIn.getText().toString());
                GetUserApi().userLogin(emailIn.getText().toString(), passwordIn.getText().toString()).enqueue(new SlimCallback<String>(string -> {
                    if (string == "Login succesfull") {
                        setContentView(R.layout.activity_main);
                    }
                }));
            }
        });
    }
}