package app.garvinen.leadtheway.describe;

/**
 * Created by sofiejyrkinen on 2016-12-14.
 */

public class Icon {

private String iconPath;

    public Icon (String iconPath){

        this.iconPath =iconPath;
    }

    @Override
    public String toString() {
        return "Hallå Liverpool";
    }

    // Get new path
    public String iconPath() {
        return iconPath;
    }


}
