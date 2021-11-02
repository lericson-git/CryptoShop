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
 * A simple {@link Fragment} subclass.
 * Use the {@link activity_search#newInstance} factory method to
 * create an instance of this fragment.
 */
public class activity_search extends Fragment implements SearchView.OnQueryTextListener{
    View view;
    ListView list;
    ListViewAdapter adapter;
    SearchView search;
    String[] productList;
    ArrayList<Post> arraylist = new ArrayList<Post>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public activity_search() {
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
    public static activity_search newInstance(String param1, String param2) {
        activity_search fragment = new activity_search();
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
        view = inflater.inflate(R.layout.fragment_search, container, false);

        SearchView searchView = (SearchView) view.findViewById(R.id.searchView); // inititate a search view
        CharSequence query = searchView.getQuery(); // get the query string currently in the text field

        // Sample data
        productList = new String[]{"Lawn Chair", "Alarm Clock", "Dog",
                "Cat", "Bike", "Plates", "Wine Bottle", "Headphones",
                "Media NFT","Harry Potter Books","Movie Collection"};

        // Locate the ListView in listview_main.xml
        list = (ListView) view.findViewById(R.id.listView);

        for (int i = 0; i < productList.length; i++) {
            Post product = new Post(productList[i]);
            // Binds all strings into an array
            arraylist.add(product);
        }

        // Pass results to test.connect.myapplication.ListViewAdapter Class
        adapter = new ListViewAdapter(this.getContext(), arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
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