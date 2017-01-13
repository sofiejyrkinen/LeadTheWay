package app.garvinen.leadtheway.storage;

import java.util.List;

import app.garvinen.leadtheway.describe.Icon;

/**
 * Created by sofiejyrkinen on 2016-12-14.
 */

public interface IconStore {

    public List<Icon> getIcon();
    public void addIcon(Icon i);


}
