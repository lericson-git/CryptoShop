package com.example.addtocart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    mywish MyWish;
    TextView total;
    double total_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyWish = new mywish();
        total = findViewById(R.id.total);

    }

    public void radioClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.rb1:
                if (checked)
                    MyWish.setMywish_size_price(69.99);
                else
                    MyWish.setMywish_size_price(0);
                break;
            case R.id.rb2:
                if (checked)
                    MyWish.setMywish_size_price(640.00);
                else
                    MyWish.setMywish_size_price(0);
                break;
            case R.id.rb3:
                if (checked)
                    MyWish.setMywish_size_price(5);
                else
                    MyWish.setMywish_size_price(69.99);
                break;

        }
        total.setText("Total Price: " + MyWish.getMywish_size_price());


    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.cb1:
                if (checked)
                MyWish.setArmchair_price(35);
                else
                    MyWish.setArmchair_price(0);
                break;
            case R.id.cb2:
                if (checked)
                    MyWish.setSmartWatch_price(85);
                else
                    MyWish.setSmartWatch_price(0);
                break;


        }
            total.setText("Total Price: " + calculate_total());
    }
    private double calculate_total() {
        total_price = MyWish.getMywish_size_price() + MyWish.getSmartWatch_price() + MyWish.getArmchair_price();
        return total_price;
    }

}