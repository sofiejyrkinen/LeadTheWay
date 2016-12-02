package app.garvinen.leadtheway.storage;

import java.util.List;

import app.garvinen.leadtheway.describe.Destination;

/**
 * Created by Axel on 2016-12-02.
 */

public interface DestinationStore {

    public List<Destination> getDestination();
    public void addDestination(Destination d);


}
