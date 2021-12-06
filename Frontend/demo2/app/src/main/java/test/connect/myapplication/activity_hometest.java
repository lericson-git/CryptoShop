package test.connect.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_hometest extends AppCompatActivity {
    ImageButton btnfortableclock;
    ImageButton btnhandclock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hometest);
        btnfortableclock = (ImageButton) findViewById(R.id.btnfortableclock);
        btnfortableclock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                second_page(view);
            }
        });
        btnhandclock = (ImageButton) findViewById(R.id.btnhandclock);
        btnhandclock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                third_page(view);
            }
        });
    }
    public void second_page(View view) {
        Intent intent = new Intent(this,activity_tableclock.class);
        startActivity(intent);
   // btnfortableclock = (ImageButton) findViewById(R.id.btnfortableclock);
    //btnfortableclock.setOnClickListener(new View.onClickListener) {

    }
    public void third_page(View view) {
        Intent intentone = new Intent (this, activity_handclock.class);
        startActivity(intentone);
    }




}