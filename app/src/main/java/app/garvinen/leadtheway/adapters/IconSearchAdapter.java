package app.garvinen.leadtheway.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.garvinen.leadtheway.R;
import app.garvinen.leadtheway.describe.Destination;

import static app.garvinen.leadtheway.R.id.nameIcon;

/**
 * Created by sofiejyrkinen on 2017-02-02.
 */

/*
* The code below is inspired by: https://guides.codepath.com/android/using-the-recyclerview
 */

public class IconSearchAdapter extends
        RecyclerView.Adapter<IconSearchAdapter.ViewHolder>{


    public static String LOG_TAG = IconShAdapter.class.getName();

    // Store the context
    private Context c;
    // Store a dest variable for the destinations
    private List<Destination> destList;


    // Pass in the contact array into the constructor
    public IconSearchAdapter(Context context, List<Destination> destinationList) {
        c = context;
        destList = destinationList;
    }

// Provide a direct reference to each of the views within a data item
// Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
    // Your holder should contain a member variable
    // for any view that will be set as you render a row
    public ImageView iconImage;
    public TextView iconName;


    // We also create a constructor that accepts the entire item row
    // and does the view lookups to find each subview
    public ViewHolder(View itemView) {
        // Stores the itemView in a public final member variable that can be used
        // to access the context from any ViewHolder instance.
        super(itemView);

        iconImage = (ImageView) itemView.findViewById(R.id.imageIcon);
        iconName = (TextView) itemView.findViewById(nameIcon);
    }
}


    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public IconSearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.icon_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(IconSearchAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Destination dest = destList.get(position);

        // Set item views based on your views and data model
        ImageView imageIcon = viewHolder.iconImage;
        TextView imageName = viewHolder.iconName;

        String iconText = dest.getIconName();
        imageName.setText(iconText);

        int imageID = dest.getIconId();
        imageIcon.setImageResource(imageID);

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return destList.size();
    }

}