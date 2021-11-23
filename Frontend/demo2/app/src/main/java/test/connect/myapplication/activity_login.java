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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.User;

/**
 * @author Lucas Ericson
 * Login Activity for users. It provides the login page of the user
 * as the output
 */
public class activity_login extends AppCompatActivity {

    /**
     *
     * Converts given string password into a SHA-256 encrypted password and returns it.
     * @param base the base string we are encrypting. It will give
     *  login page as output and users are expected to enter their
     *  credentials as their input
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
     * Sets activity UI elements and creates a button listener for submission.
     * @param savedInstanceState is a {@link Bundle} that stores the instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etUsername, etPassword;
        Button btSubmit;

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btSubmit = findViewById(R.id.bt_submit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            /**
             * onClick runs when submission button is pressed and submits user login data.
             * @param v is the {@link View} that the activity is running in.
             */
            @Override
            public void onClick(View v) {
                User newUser = new User();
                newUser.setName(etUsername.getText().toString());
                try {
                    newUser.setHashed_pass(sha256(etPassword.getText().toString()));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }

                GetUserApi().userLogin(newUser.getUsername(), newUser.getHashed_pass()).enqueue(new SlimCallback<String>(string -> {
                    if (string == "Login succesfull")
                        startActivity(new Intent(v.getContext(), activity_landing.class));
                    else
                        Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_SHORT).show();
                }));

            }
        });
/*        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etUsername.getText().toString().equals("admin") &&
                        etPassword.getText().toString().equals("admin")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            activity_login.this
                    );
                    builder.setIcon(R.drawable.ic_check);
                    builder.setTitle("Login Successfully !!!");
                    builder.setMessage("Welcome Admin");
                    builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                   // Intent in = new Intent(activity_login.this, MainActivity2.class);
                    //startActivity(in);


                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Username & Password",
                            Toast.LENGTH_SHORT).show();


                }
            }
        }); */
    }
}