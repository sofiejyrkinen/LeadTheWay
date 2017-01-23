package app.garvinen.leadtheway.describe;

/**
 * Created by sofiejyrkinen on 2016-12-14.
 */

public class Icon {

    private int iconPath;

    public Icon (int iconPath){
        this.iconPath =iconPath;
    }


    @Override
    public String toString() {
        return "Henrik är en idiot. " + iconPath;
    }

    // Get new path
    public int iconPath() {
        return iconPath;
    }

}
