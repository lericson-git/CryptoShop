package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetProductApi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.Product;
import test.connect.myapplication.model.User;

/**
 * page to display a single product that is clicked on
 */
public class activity_product extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //Get User from extras
        Product prod;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            prod = new Product();
        } else {
            prod = (Product) extras.getParcelable("prodInfo");
            Log.d("PRODUCT", "activity_product received Product: " + prod.getName());
        }

        Button backButton = findViewById(R.id.activity_product_backButton);
        Button buyButton = findViewById(R.id.activity_product_buyButton);
        TextView productName = findViewById(R.id.activity_product_productName);
        TextView productPrice = findViewById(R.id.activity_product_productPrice);
        TextView productDescription = findViewById(R.id.activity_product_productDescription);
        TextView productCondition = findViewById(R.id.activity_product_productCondition);
        TextView productMainTag = findViewById(R.id.activity_product_productMainTag);
        TextView productSubTag = findViewById(R.id.activity_product_productSubTag);

        productName.setText(prod.getName());
        productPrice.setText(Double.toString(prod.getPrice()));
        productDescription.setText(prod.getDescription());
        productCondition.setText(prod.getCondition());

        /*GetProductApi().getProductById(1).enqueue(new SlimCallback<Product>(product -> {
            if (product == null)
                Toast.makeText(getApplicationContext(),"Error Retrieving Product",Toast.LENGTH_SHORT).show();
            else{

                productMainTag.setText();
                productSubTag.setText();

                productName.append(product.getName());
                productPrice.append("$" + product.getPrice().toString());
                productDescription.append("Description: "+product.getDescription());
                productCondition.append("Condition: "+product.getCondition());
                productMainTag.append(product.getMainTag());
                productSubTag.append(product.getSubTag());
            }
        })); */

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go back to previous screen
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product();
                //add product to cart
                Toast.makeText(getApplicationContext(),"Purchased for "+productPrice.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}