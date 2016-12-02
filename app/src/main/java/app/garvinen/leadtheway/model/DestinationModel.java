package app.garvinen.leadtheway.model;

import android.content.Context;
import java.util.List;
import app.garvinen.leadtheway.describe.Destination;
import app.garvinen.leadtheway.storage.StorageProvider;


/**
 * Created by Axel on 2016-11-30.
 */

public class DestinationModel {


    private Context c;

    public DestinationModel(Context c) {
        this.c = c;
    }

    public List<Destination> getDestination() {
        return StorageProvider.getProvider(c).getDestination();
    }

    public void addDestination(Destination d) {
        StorageProvider.getProvider(c).addDestination(d);
    }


} //end of DestinationModel
