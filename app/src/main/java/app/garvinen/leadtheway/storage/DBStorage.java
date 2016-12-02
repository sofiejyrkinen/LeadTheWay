package app.garvinen.leadtheway.storage;

import java.util.ArrayList;
import java.util.List;
import app.garvinen.leadtheway.describe.Destination;

/**
 * Created by Axel on 2016-11-30.
 */

public class DBStorage implements Storage {


    private static DBStorage storage = new DBStorage();

    private DBStorage() {
    }

    public List<Destination> getDestination() {
        ArrayList<Destination> destination = new ArrayList<>();
        destination.add(new Destination("Hem", "Räntmästaregatan 25i", "Göteborg", 41658));
        destination.add(new Destination("Sjukhus", "Berättelsegatan 5", "Brunnsbo", 66666 ));
        return destination;
    }

    public static DBStorage getInstance() {
        return storage;
    }
}//end of DBStorage
