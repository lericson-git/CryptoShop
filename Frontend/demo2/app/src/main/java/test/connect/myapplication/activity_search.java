package test.connect.myapplication;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import test.connect.myapplication.model.Post;
import test.connect.myapplication.model.Product;

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
    static ArrayList<Product> productList = new ArrayList<Product>();
    private static final String USER_INFO = "userObj";
    private Parcelable userObj;

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
    public static activity_search newInstance(Parcelable userObj) {
        activity_search fragment = new activity_search();
        Bundle args = new Bundle();
        args.putParcelable(USER_INFO, userObj);
        fragment.setArguments(args);
        return fragment;
    }

    public static void addProduct(Product prod) {
        productList.add(prod);
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
        List<Product> productList = new ArrayList<Product>();
        Product artNFT = new Product();
        artNFT.setName("Digital Art NFT");
        artNFT.setCondition("Brand new");
        artNFT.setDescription("A newly minted digital art NFT from rising artist JerryFromTwitter! Buy now and it's value will surely raise over time!");
        artNFT.setId(productList.size());
        productList.add(artNFT);
        Product bookCollection = new Product();
        bookCollection.setName("Classic Book Collection");
        bookCollection.setCondition("Some as old as 100 years, all kept in pristine condition and untouched.");
        bookCollection.setDescription("One dozen books ranging from 100 years old to 50 years old, all kept in great condition and looked after. Includes rare classics and original prints.");
        bookCollection.setId(productList.size());
        productList.add(bookCollection);
        Product iPhone = new Product();
        iPhone.setName("iPhone 12");
        iPhone.setCondition("Brand New");
        iPhone.setDescription("Unopened iPhone 12 case from BestBuy, reselling online due to scalpers! Warranty is still valid.");
        iPhone.setId(productList.size());
        productList.add(iPhone);

        list = (ListView) view.findViewById(R.id.listView);

        // Pass results to test.connect.myapplication.ListViewAdapter Class
        adapter = new ListViewAdapter(this.getContext(), productList);
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