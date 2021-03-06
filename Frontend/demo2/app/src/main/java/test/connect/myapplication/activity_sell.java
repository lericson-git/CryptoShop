package test.connect.myapplication;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;

import test.connect.myapplication.model.Post;
import test.connect.myapplication.model.Product;

/**
 * @author Lucas Ericson
 * A {@link Fragment} subclass that runs a sell activity for posting new listings.
 * Can use the {@link activity_sell#newInstance} factory method to
 * create an instance of this fragment.
 * Should be called from {@link MainActivity}'s NavBar.
 */
public class activity_sell extends Fragment {
    //Activity frontend elements
    Button btn;
    EditText prodNameText, priceText, descriptonText;
    String prodName, descripton;
    double price;
    View view;
    Product prod;
    Boolean listed = false;

    /**
     * Empty constructor for activity
     */
    public activity_sell() { }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment activity_home.
     */
    public static activity_sell newInstance() {
        activity_sell fragment = new activity_sell();
        Bundle args = new Bundle();
        return fragment;
    }

    /**
     * onCreate method that creates instance of activity.
     * @param savedInstanceState a {@link Bundle} needed to store the instance.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Creates and inflates the view for the activity.
     * Takes post listing data from user and creates new {@link Post}.
     * @param inflater {@link LayoutInflater} for fragment.
     * @param container {@link View} for fragment.
     * @param savedInstanceState {@link Bundle} for fragment.
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sell, container, false);
        btn = view.findViewById(R.id.submitBtn);
        prodNameText = view.findViewById(R.id.inputProductName);
        priceText = view.findViewById(R.id.inputPrice);
        descriptonText = view.findViewById(R.id.inputDescription);

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
                Product prod = new Product();
                prodName = prodNameText.getText().toString();
                price = Double.parseDouble(priceText.getText().toString());
                descripton = descriptonText.getText().toString();
                prod.setName(prodName);
                prod.setPrice(price);
                prod.setDescription(descripton);
                setProduct(prod);

                activity_search.addProduct(prod);
                Log.d("PRODUCT", "sell_activity added " + prod.getName());
                
                Context context = getContext();
                Toast toast = Toast.makeText(context, "Product Listed", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        return view;
    }

    public Product getProd() {
        return prod;
    }

    //Testing method
    protected void setProduct(Product product) {
        this.prod = prod;
        listed = true;
    }

    public Boolean getListed() {
        return listed;
    }
}