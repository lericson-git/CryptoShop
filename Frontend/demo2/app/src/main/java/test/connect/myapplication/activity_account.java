package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetProductApi;
import static test.connect.myapplication.api.ApiClientFactory.GetUserApi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
    TextView userName, userUsername, userEmail, userBalance;
    private static final String USER_INFO = "userObj";
    private Parcelable userObj;

    public activity_account() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param userObj User class
     * @return A new instance of fragment activity_home.
     */
    public static activity_account newInstance(Parcelable userObj) {
        activity_account fragment = new activity_account();
        Bundle args = new Bundle();
        args.putParcelable(USER_INFO, userObj);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Parcelable userObj = getArguments().getParcelable(USER_INFO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        userName = view.findViewById(R.id.fragment_account_name);
        userEmail = view.findViewById(R.id.fragment_account_email);
        userUsername = view.findViewById(R.id.fragment_account_username);
        userBalance = view.findViewById(R.id.fragment_account_balance);

        //Set user data to display
        User user = (User) getArguments().getParcelable(USER_INFO);
        if (user != null) {
            userName.setText(user.getName());
            userEmail.setText(user.getEmail());
            userUsername.setText(user.getUsername());
            userBalance.setText(Double.toString(user.getBtc_balance()));
        }
        Log.d("USER", "activity_account received: " + user.getUsername() + user.printable());
        return view;
    }
}