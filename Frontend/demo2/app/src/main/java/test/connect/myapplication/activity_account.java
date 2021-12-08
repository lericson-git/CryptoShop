package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetProductApi;
import static test.connect.myapplication.api.ApiClientFactory.GetUserApi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.Post;
import test.connect.myapplication.model.User;

/**
 * This is the account page for the app
 */
public class activity_account extends Fragment {
    private Button btn1;

    TextView userName, userUsername, userEmail, userBalance;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button Btnmove;

    public activity_account() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment activity_home.
     */
    // TODO: Rename and change types and number of parameters
    public static activity_account newInstance(String param1, String param2) {
        activity_account fragment = new activity_account();
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
        View view = inflater.inflate(R.layout.fragment_account, container, false);


//        String strtext = getArguments().getString("user");

        String strtext = "10";

//        if (getArguments() != null) {
//            mParam1 = getArguments().getString("user");
//        }
        int userId = 1;
        //    strtext = activity.getMyData();

        strtext = "14";


        try{
            userId = Integer.parseInt(strtext);
            System.out.println(userId); // output = 25
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }


        userName = view.findViewById(R.id.fragment_account_name);
        userEmail = view.findViewById(R.id.fragment_account_email);
        userUsername = view.findViewById(R.id.fragment_account_username);
        userBalance = view.findViewById(R.id.fragment_account_balance);

        GetUserApi().getUserById(userId).enqueue(new SlimCallback<User>(user -> {
            if (user == null)
                Toast.makeText(view.getContext(),"Error Retrieving Account",Toast.LENGTH_SHORT).show();
            else{
                userName.setText("");
                userEmail.setText("");
                userUsername.setText("");
                userBalance.setText("");

                userName.append(user.getName());
                userEmail.append(user.getEmail());
                userUsername.append(user.getUsername());
                userBalance.append(Double.toString(user.getBtc_balance()));
            }
        }));

        return view;
    }
}