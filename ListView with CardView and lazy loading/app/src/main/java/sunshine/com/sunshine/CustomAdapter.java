package sunshine.com.sunshine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Subham Mishra on 23-07-2016.
 */
public class  CustomAdapter extends ArrayAdapter<String> {
    private final Activity context;
    ArrayList<Integer> images;
    ArrayList<String> web;

    public CustomAdapter(Activity context,
                         ArrayList<String> web, List<Integer> images) {
        super(context, R.layout.list_item_forecast, web);
        this.context = context;
        this.web = new ArrayList<>(web);
        this.images = new ArrayList<>(images);
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_item_forecast, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.label);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        txtTitle.setText(web.get(position));

        imageView.setImageResource(images.get(position));
        return rowView;
    }
    public void notifyDataSetChanged(List<Integer> newlist,List<String> newlist1){
        images.clear();
        web.clear();
        images.addAll(newlist);
        web.addAll(newlist1);
        this.notifyDataSetChanged();
    }
}