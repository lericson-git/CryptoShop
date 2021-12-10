package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetUserApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicInteger;

import okhttp3.ResponseBody;
import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.LoginDTO;
import test.connect.myapplication.model.User;

/**
 * login page for the app
 */
public class activity_login extends AppCompatActivity {

    /**
     * used to hash the password
     * @param base password to hash
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
        setContentView(R.layout.activity_login);

        EditText etUsername, etPassword;
        Button btSubmit;
        Bundle bundle = new Bundle();

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btSubmit = findViewById(R.id.bt_submit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginDTO loginUser = new LoginDTO();
                loginUser.setUsernameOrEmail(etUsername.getText().toString());
                try {
                    loginUser.setPassword(sha256(etPassword.getText().toString()));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                //Setting up User class to be passed (this should be removed when backend implemented)
                User newUser = new User();
                newUser.setUsername(loginUser.getUsernameOrEmail());
                newUser.setHashed_pass(loginUser.getPassword());

                Intent next = new Intent(activity_login.this, MainActivity.class);
                next.putExtra("userInfo", newUser);
                User test = (User) next.getParcelableExtra("userInfo");
                Log.d("USER", "Logged in user: " +  test.getUsername());
                startActivity(next);


                GetUserApi().userLogin(loginUser).enqueue(new SlimCallback<ResponseBody>(response -> {
                    String res = "";
                    try {
                        res = response.string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\n\n\nHERE\n"+res);
                    if(res.equals("Login succesfull")) {
                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                        GetUserApi().getUsernameOrEmail(loginUser.getUsernameOrEmail()).enqueue(new SlimCallback<User>(user -> {
                            intent.putExtra("user", user.getId().toString());
                        }));
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_SHORT).show();
                }));
            }
        });
    }

}