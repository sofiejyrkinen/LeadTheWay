package app.garvinen.leadtheway.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import app.garvinen.leadtheway.R;
import app.garvinen.leadtheway.describe.Destination;

/**
 * Created by sofiejyrkinen on 2017-01-31.
 */

public class IconShAdapter extends ArrayAdapter<Destination> {


    private Context c;
    private List<Destination> destList;
    public static String LOG_TAG = IconShAdapter.class.getName();


    //constructor, call on creation
    public IconShAdapter(Context c, int resource, List<Destination> objects) {
        super (c, resource, objects);
        this.c = c;
        this.destList = objects;
    }

    //called when rendering the list
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the property we are displaying
        Destination dest = destList.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.icon_row, null);
        ImageView image = (ImageView) view.findViewById(R.id.imageIcon);

        Log.d(LOG_TAG, " getIconID: " + dest.getPostalCode());
        Log.d(LOG_TAG, " getIconID: " + dest.getIconId());


        int imageID = dest.getIconId();
        image.setImageResource(imageID);

        Log.d(LOG_TAG, " imageId: " + imageID);
        Log.d(LOG_TAG, " image: " + image);

        return view;

    }
}

