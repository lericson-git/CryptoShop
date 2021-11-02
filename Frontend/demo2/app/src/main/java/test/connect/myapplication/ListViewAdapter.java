package test.connect.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import test.connect.myapplication.model.Post;

public class ListViewAdapter extends BaseAdapter {
    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Post> productList = null;
    private ArrayList<Post> arraylist;

    public ListViewAdapter(Context context, List<Post> productList) {
        mContext = context;
        this.productList = productList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Post>();
        this.arraylist.addAll(productList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Post getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_items, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(productList.get(position).getTitle());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        productList.clear();
        if (charText.length() == 0) {
            productList.addAll(arraylist);
        } else {
            for (Post wp : arraylist) {
                if (wp.getTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
                    productList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
