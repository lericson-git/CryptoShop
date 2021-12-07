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
 * page used to signup for a new account
 */
public class activity_signup extends AppCompatActivity {
    User user;
    Boolean createdUser = false;

    //Encrypts string base into sha256 format

    /**
     * hashed password into sha256 format
     * @param base password to be hashed
     * @return hashed password
     * @throws NoSuchAlgorithmException
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
                try {
                    newUser.setHashed_pass(sha256(passwordIn.getText().toString()));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }

                newUser.setBought_p(0);
                newUser.setSold_p(0);
                newUser.setBtc_balance(0);
//                setUser(new User(newUser));

                GetUserApi().addNewUser(newUser).enqueue(new SlimCallback<User>(user -> {
                    if (user == null)
                        Toast.makeText(getApplicationContext(),"Email or username taken",Toast.LENGTH_SHORT).show();
                    //Pass data
                    Bundle bundle = new Bundle();
                    bundle.putString("user", user.getId().toString());
                    // set MyFragment Arguments
                    activity_account myObj = new activity_account();
                    myObj.setArguments(bundle);

                    startActivity(new Intent(v.getContext(), MainActivity.class));
                }));
            }
        });
    }

//    public User getUser() {
//        return user;
//    }
//
//    protected void setUser(User user){
//        this.user = user;
//        createdUser = true;
//    }
//
//    public Boolean getCreated(){
//        return createdUser;
//    }
}