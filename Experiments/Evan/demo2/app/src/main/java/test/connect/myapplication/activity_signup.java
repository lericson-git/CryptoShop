package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetUserApi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.User;

public class activity_signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button signupSubmit = findViewById(R.id.activity_signup_submitBtn);
        EditText nameIn = findViewById(R.id.activity_signup_name);
        EditText emailIn = findViewById(R.id.activity_signup_email);
        EditText usernameIn = findViewById(R.id.activity_signup_username);
        EditText passwordIn = findViewById(R.id.activity_signup_password);

        signupSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User newUser = new User();
                newUser.setName(nameIn.getText().toString());
                newUser.setEmail(emailIn.getText().toString());
                newUser.setUsername(usernameIn.getText().toString());
                newUser.setHashed_pass(passwordIn.getText().toString());
                newUser.setBought_p(0);
                newUser.setSold_p(0);
                newUser.setBtc_balance(0);
                GetUserApi().addNewUser(newUser).enqueue(new SlimCallback<User>(user -> {
                    setContentView(R.layout.activity_main);
                }));
            }
        });
    }
}