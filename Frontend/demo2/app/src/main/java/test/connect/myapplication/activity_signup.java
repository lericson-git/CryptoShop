package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetUserApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.User;

public class activity_signup extends AppCompatActivity {

    //Encrypts string base into sha256 format
    public String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

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
            public void onClick(View v) {
                User newUser = new User();
                newUser.setName(nameIn.getText().toString());
                newUser.setEmail(emailIn.getText().toString());
                newUser.setUsername(usernameIn.getText().toString());
                newUser.setHashed_pass(sha256(passwordIn.getText().toString()));
                newUser.setBought_p(0);
                newUser.setSold_p(0);
                newUser.setBtc_balance(0);
                GetUserApi().addNewUser(newUser).enqueue(new SlimCallback<User>(user -> {

                }));
                startActivity(new Intent(v.getContext(), demo2.class));
            }
        });
    }
}