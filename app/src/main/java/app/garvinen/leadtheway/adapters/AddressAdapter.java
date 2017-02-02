package app.garvinen.leadtheway.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import app.garvinen.leadtheway.R;
import app.garvinen.leadtheway.describe.Destination;

/**
 * Created by sofiejyrkinen on 2017-01-31.
 */

public class AddressAdapter extends ArrayAdapter<Destination> {

    private Context c;
    private List<Destination> destList;
    public static String LOG_TAG = AddressAdapter.class.getName();


    //constructor, call on creation
    public AddressAdapter(Context c, int resource, List<Destination> objects) {
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
        View view = inflater.inflate(R.layout.address_row, null);

        TextView address = (TextView) view.findViewById(R.id.destAddress);


        //set address
        String setAddress = dest.getAdress();
        address.setText(setAddress);

        Log.d(LOG_TAG, " getIconID: " + dest.getAdress());


        return view;
    }
}
