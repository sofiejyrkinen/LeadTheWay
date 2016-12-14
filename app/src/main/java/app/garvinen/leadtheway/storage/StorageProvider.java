package app.garvinen.leadtheway.storage;

import android.content.Context;
/**
 * Created by Axel on 2016-11-30.
 */

public class StorageProvider {

    public static DestinationStore getProvider(Context c) {
        return new DBDestinationStore(c);

    }

    public static IconStore getIconProvider(Context c){
        return new DBIconStore(c);
    }

}//end of StorageProvider
