package test.connect.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * @author Lucas Ericson
 * A {@link Fragment} subclass that allows users to search posted products.
 * Can use the {@link activity_search#newInstance} factory method to
 * create an instance of this fragment.
 * Page is meant to be reached from {@link MainActivity}'s NavBar.
 * User will write names of the data in their inputs and will get
 * the correct list of array as their output
 */
public class activity_search extends Fragment {

    /**
     * Empty constructor for activity
     */
    public activity_search() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of activity_home.
     */
    // TODO: Rename and change types and number of parameters
    public static activity_search newInstance() {
        activity_search fragment = new activity_search();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }

    /**
     * Runs first, creates instance of fragment.
     * @param savedInstanceState a {@link Bundle} needed to store the instance.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Inflates fragment view given app parameters needed.
     * @param inflater {@link LayoutInflater} for fragment.
     * @param container {@link View} for fragment.
     * @param savedInstanceState {@link Bundle} for fragment.
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }
}