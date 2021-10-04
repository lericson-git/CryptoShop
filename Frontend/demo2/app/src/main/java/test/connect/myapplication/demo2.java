package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetUserApi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.User;

public class demo2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);


        TextView apiText1 = findViewById(R.id.activity_demo2_textView1);
        apiText1.setMovementMethod(new ScrollingMovementMethod());
        apiText1.setHeight(350);
        apiText1.setText("WOrking");
        Button loadUsers = findViewById(R.id.activity_demo2_loadUsersBtn);

        GetUserApi().GetAllUser().enqueue(new SlimCallback<List<User>>(users -> {
            apiText1.setText("");

            for (int i = users.size() - 1; i >= 0; i--) {
                //apiText1.append("test");
               apiText1.append(users.get(i).printable());
            }
        }, "GetAllUser"));


    }
}