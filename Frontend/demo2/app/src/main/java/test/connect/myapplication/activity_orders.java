package test.connect.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import test.connect.myapplication.model.User;

/**
 * @author Meet Patel
 *
 * Gives the output of the orders that the customers placed.
 * Customer has to provide the input of the orders
 * A simple {@link Fragment} subclass.
 * Use the {@link activity_orders#newInstance} factory method to
 * create an instance of this fragment.
 */

//nice job in creating activity orders page
    
public class activity_orders extends Fragment {
    ImageButton myImageButton;
    private ImageButton btntableclock;
    private ImageButton btnplant;
    private ImageButton btnlipstick;
    private ImageButton btnclickmepls;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String USER_INFO = "userObj";

    // TODO: Rename and change types of parameters
    private Parcelable userObj;

    public activity_orders() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param userObj to receive Parcelable containing User object
     * @return A new instance of fragment activity_home.
     */
    public static activity_orders newInstance(Parcelable userObj) {
        activity_orders fragment = new activity_orders();
        Bundle args = new Bundle();
        args.putParcelable(USER_INFO, userObj);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userObj = getArguments().getParcelable(USER_INFO);
        }
        User user = (User) userObj;
        Log.d("USER", "activity_orders received: " + user.getUsername() + user.printable());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_orders, container, false);
//        btntableclock = v.findViewById(R.id.btntableclock);
//        btntableclock.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentloadnewactivity = new Intent(getActivity(), activity_third.class);
//                startActivity(intentloadnewactivity);
//
//            }
//        });
        btnclickmepls = v.findViewById(R.id.btnclickmesorry);
        btnclickmepls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenthumesha = new Intent(getActivity(), activity_third.class);
                startActivity(intenthumesha);
            }
        });
//        btnplant = v.findViewById(R.id.btnplant);
//        btnplant.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), activity_plant.class);
//                startActivity(intent);
//            }
//        });
//        btnlipstick = v.findViewById(R.id.btnlipstick);
//        btnlipstick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentsecond = new Intent(getActivity(), activity_lipstick.class);
//                startActivity(intentsecond);
//            }
//        });


        return v;


    }
}