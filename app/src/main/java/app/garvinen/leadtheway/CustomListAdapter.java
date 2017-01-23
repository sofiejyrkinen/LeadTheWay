package app.garvinen.leadtheway;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.garvinen.leadtheway.describe.Destination;


/**
 * Created by sofiejyrkinen on 2017-01-03.
 */

class CustomListAdapter extends ArrayAdapter <Destination>{

    private Context c;
    private List<Destination> dests;
    public static String LOG_TAG = CustomListAdapter.class.getName();


    //constructor, call on creation
    public CustomListAdapter(Context c, int resource, List<Destination> objects) {
        super (c, resource, objects);
        this.c = c;
        this.dests = objects;
    }


    //called when rendering the list
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the property we are displaying
        Destination dest = dests.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_row, null);

        TextView address = (TextView) view.findViewById(R.id.wholeAdress);
        TextView nameIcon = (TextView) view.findViewById(R.id.nameIcon);
        ImageView image = (ImageView) view.findViewById(R.id.imageIcon);

        //set address and description
        String iconText = dest.getIconName();
        nameIcon.setText(iconText);
        String completeAddress = dest.getAdress() + ", " +dest.getCity() + ", " + dest.getPostalCode();
        address.setText(completeAddress);

        Log.d(LOG_TAG, " getIconID: " + dest.getIconId());

        //get the image associated with this property
        //int imageID = c.getResources().getIdentifier(String.valueOf(dest.getIconId()), "drawable", c.getPackageName());
        //Log.d(LOG_TAG, " imageID: " + imageID);

        int imageID = dest.getIconId();
        image.setImageResource(imageID);

        return view;
    }




}