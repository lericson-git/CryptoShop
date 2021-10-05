package com.example.myactivity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String description = "Android Development tutorial";
    EditText editTextTextPersonName;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                String namevalue = editTextTextPersonName.getText().toString();
                Intent intent = new Intent (MainActivity.this, SecondActivity.class);
                intent.putExtra("Name", namevalue);
                intent.putExtra("DESCRIPTION", description);
                startActivity(intent);
            }

        });


    }
}