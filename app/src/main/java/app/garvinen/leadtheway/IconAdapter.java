package app.garvinen.leadtheway;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import app.garvinen.leadtheway.describe.Icon;

import static app.garvinen.leadtheway.R.id.iconImage;

/**
 * Created by sofiejyrkinen on 2016-12-12.
 */

public class IconAdapter extends ArrayAdapter <Icon> {
    private Context c;
    private List<Icon> icons;
    public static String LOG_TAG = IconAdapter.class.getName();

    public IconAdapter(Context c, int resource, List<Icon> icons){
        super(c, resource, icons);
        this.c = c;
        this.icons = icons;
    }

    // Code below from https://www.sitepoint.com/custom-data-layouts-with-your-own-android-arrayadapter/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the property we are displaying
        Icon icon = icons.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.model, null);

        ImageView image = (ImageView) view.findViewById(iconImage);
        //get the image associated with this property
        //int imageID = c.getResources().getIdentifier(icon.iconPath(), "drawable", c.getPackageName());
        image.setImageResource(icon.iconPath());

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        //get the property we are displaying
        Icon icon = icons.get(position);
        //Log.d(LOG_TAG, "icons.get(position):" + (icons.get(position)));

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.model, null);
        ImageView image = (ImageView) view.findViewById(iconImage);

        //get the image associated with this property
        image.setImageResource(icon.iconPath());
        return view;
    }

}
