package test.connect.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import test.connect.myapplication.model.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link activity_account#newInstance} factory method to
 * create an instance of this fragment.
 */
public class activity_account extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_USER = "userInfo";

    // TODO: Rename and change types of parameters
    private User user;

    public activity_account() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param user User class
     * @return A new instance of fragment activity_home.
     */
    // TODO: Rename and change types and number of parameters
    public static activity_account newInstance(User user) {
        activity_account fragment = new activity_account();
        Bundle args = new Bundle();
        args.putParcelable(ARG_USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_USER);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }
}