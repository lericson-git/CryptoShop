package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetUserApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.User;

/**
 * @author Lucas Ericson
 * Signup activity that creates new user with given data.
 * Interacts with backend for input validation.
 */
public class activity_signup extends AppCompatActivity {

    /**
     * Converts given string password into a SHA-256 encrypted password and returns it.
     * @param base the base string we are encrypting.
     * @return encrypted string.
     * @throws NoSuchAlgorithmException when string does not properly encrypt.
     */
    public String sha256(String base) throws NoSuchAlgorithmException {
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

    /**
     * onCreate for the signup activity.
     * Sets up UI elements and button listener.
     * @param savedInstanceState is a {@link Bundle} that stores saved instances.
     */
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
            /**
             * onClick method runs when button is clicked and submits data fields to backend.
             * @param v is the {@link View} the activity is running in.
             */
            @Override
            public void onClick(View v) {
                User newUser = new User();
                newUser.setName(nameIn.getText().toString());
                newUser.setEmail(emailIn.getText().toString());
                newUser.setUsername(usernameIn.getText().toString());
                try {
                    newUser.setHashed_pass(sha256(passwordIn.getText().toString()));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                newUser.setBought_p(0);
                newUser.setSold_p(0);
                newUser.setBtc_balance(0);
                GetUserApi().addNewUser(newUser).enqueue(new SlimCallback<User>(user -> {
                    if (user == null)
                        Toast.makeText(getApplicationContext(),"Email or username taken",Toast.LENGTH_SHORT).show();
                }));
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });
    }
}