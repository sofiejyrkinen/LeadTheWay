package app.garvinen.leadtheway.storage;

import android.content.Context;

import app.garvinen.leadtheway.describe.Destination;
/**
 * Created by Axel on 2016-11-30.
 */

public class StorageProvider {

    public static DestinationStore getDestinationStore(Context c) {
        return new DBDestinationStore(c);

    }
}//end of StorageProvider
