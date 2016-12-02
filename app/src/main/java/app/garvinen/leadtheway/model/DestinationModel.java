package app.garvinen.leadtheway.model;

import java.util.List;
import app.garvinen.leadtheway.describe.Destination;
import app.garvinen.leadtheway.storage.StorageProvider;


/**
 * Created by Axel on 2016-11-30.
 */

public class DestinationModel {

    public List<Destination> getDestination() {
        return StorageProvider.getProvider().getDestination();
    }


} //end of DestinationModel
