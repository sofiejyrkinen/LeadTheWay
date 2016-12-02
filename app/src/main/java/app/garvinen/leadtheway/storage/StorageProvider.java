package app.garvinen.leadtheway.storage;

import app.garvinen.leadtheway.describe.Destination;
/**
 * Created by Axel on 2016-11-30.
 */

public class StorageProvider {

    public static Storage getProvider() {
        return DBStorage.getInstance();

    }
}//end of StorageProvider
