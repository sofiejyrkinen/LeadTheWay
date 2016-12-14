package app.garvinen.leadtheway.model;

import android.content.Context;

import java.util.List;

import app.garvinen.leadtheway.describe.Icon;
import app.garvinen.leadtheway.storage.StorageProvider;

/**
 * Created by sofiejyrkinen on 2016-12-14.
 */

public class IconModel {


    private Context c;

    public IconModel(Context c) {
        this.c = c;
    }

    public List<Icon> getIcon() {
        return StorageProvider.getIconProvider(c).getIcon();
    }

    public void addIcon(Icon i) {
        StorageProvider.getIconProvider(c).addIcon(i);
    }
}
