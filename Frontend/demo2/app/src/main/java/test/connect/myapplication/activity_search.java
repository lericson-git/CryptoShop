package test.connect.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import test.connect.myapplication.model.Post;

/**
 * @author Lucas Ericson
 * A {@link Fragment} subclass that allows users to search posted products.
 * Can use the {@link activity_search#newInstance} factory method to
 * create an instance of this fragment.
 * Page is meant to be reached from {@link MainActivity}'s NavBar.
 * User will write names of the data in their inputs and will get
 * the correct list of array as their output
 */

//Code review:- activity search does
public class activity_search extends Fragment implements SearchView.OnQueryTextListener{
    View view;
    ListView list;
    ListViewAdapter adapter;
    SearchView search;
    String[] productList;
    ArrayList<Post> arraylist = new ArrayList<Post>();

    /**
     * Empty constructor for activity
     */
    public activity_search() {
        // Required empty public constructor
    }

    // great job in providing comments again
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
        view = inflater.inflate(R.layout.fragment_search, container, false);

        SearchView searchView = (SearchView) view.findViewById(R.id.searchView); // inititate a search view
        CharSequence query = searchView.getQuery(); // get the query string currently in the text field

        // Sample data
        productList = new String[]{"Lawn Chair", "Alarm Clock", "Dog",
                "Cat", "Bike", "Plates", "Wine Bottle", "Headphones",
                "Media NFT","Harry Potter Books","Movie Collection"};

        list = (ListView) view.findViewById(R.id.listView);

        for (int i = 0; i < productList.length; i++) {
            Post product = new Post(productList[i]);
            arraylist.add(product);
        }

        // Pass results to test.connect.myapplication.ListViewAdapter Class
        adapter = new ListViewAdapter(this.getContext(), arraylist);
        list.setAdapter(adapter);
        search = (SearchView) view.findViewById(R.id.searchView);
        search.setOnQueryTextListener(this);

        return view;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}