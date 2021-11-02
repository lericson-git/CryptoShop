package test.connect.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;

import test.connect.myapplication.model.Post;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link activity_sell#newInstance} factory method to
 * create an instance of this fragment.
 */
public class activity_sell extends Fragment {
    //Activity frontend elements
    Button btn;
    EditText prodNameText, priceText, descriptonText;
    String prodName, descripton;
    int price;
    View view;
    Post post;
    Boolean listed = false;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public activity_sell() { }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment activity_home.
     */
    // TODO: Rename and change types and number of parameters
    public static activity_sell newInstance(String param1, String param2) {
        activity_sell fragment = new activity_sell();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

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
            @Override
            public void onClick(View view) {
                prodName = prodNameText.getText().toString();
                price = Integer.parseInt(priceText.getText().toString());
                descripton = descriptonText.getText().toString();
                setPost(new Post(prodName, price, descripton));
                
                Context context = getContext();
                Toast toast = Toast.makeText(context, "Product Listed", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        return view;
    }

    public Post getPost() {
        return post;
    }

    //Testing method
    protected void setPost(Post post) {
        this.post = post;
        listed = true;
    }

    public Boolean getListed() {
        return listed;
    }
}