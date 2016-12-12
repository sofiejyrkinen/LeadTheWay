package app.garvinen.leadtheway;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sofiejyrkinen on 2016-12-12.
 */

public class Adapter extends ArrayAdapter <String> {

    private Context c;
    private String [] iconName;
    private int [] iconImage;

    Adapter(Context c, String[] iconName, int[] iconImage){
        super(c, R.layout.model,iconName);
        this.c = c;
        this.iconName = iconName;
        this.iconImage = iconImage;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater =(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model,null);
        }

        TextView iconText = (TextView) convertView.findViewById(R.id.iconText);
        ImageView img = (ImageView)convertView.findViewById(R.id.iconImage);

        //Set data
        iconText.setText(iconName[position]);
        img.setImageResource(iconImage[position]);


        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater =(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model,null);
        }
        TextView iconText = (TextView) convertView.findViewById(R.id.iconText);
        ImageView img = (ImageView)convertView.findViewById(R.id.iconImage);

        //Set data
        iconText.setText(iconName[position]);
        img.setImageResource(iconImage[position]);


        return convertView;
    }
}
