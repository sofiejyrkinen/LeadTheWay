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

public class MyAdapter extends ArrayAdapter <Icon> {

    private Context c;
    private List<Icon> icons;
    private int [] SOJY;
    /*    private String [] iconName;
    private int [] iconImage;

    Adapter(Context c, String[] iconName, int[] iconImage){
        super(c, R.layout.model,iconName);
        this.c = c;
        this.iconName = iconName;
        this.iconImage = iconImage;
    }
*/
    public MyAdapter(Context c, int resource, List<Icon> icons){
        super(c, resource, icons);
        //super(c, R.layout.model,iconImage);
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
        int imageID = c.getResources().getIdentifier(icon.iconPath(), "drawable", c.getPackageName());
        image.setImageResource(imageID);

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        //get the property we are displaying
        Icon icon = icons.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.model, null);

        ImageView image = (ImageView) view.findViewById(iconImage);
        //get the image associated with this property
        int imageID = c.getResources().getIdentifier(icon.iconPath(), "drawable", c.getPackageName());
        image.setImageResource(imageID);

        return view;
    }

    /* Old stuff
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            LayoutInflater inflater =(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model,null);
        }

        ImageView img = (ImageView)convertView.findViewById(iconImage);

        //Set data
        img.setImageResource(SOJY[position]);

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater =(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model,null);
        }
        //TextView iconText = (TextView) convertView.findViewById(iconText);
        ImageView img = (ImageView)convertView.findViewById(iconImage);

        //Set data
        //iconText.setText(iconName[position]);
        img.setImageResource(SOJY[position]);

        return convertView;
    } */
}
