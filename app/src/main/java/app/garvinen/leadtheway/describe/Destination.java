package app.garvinen.leadtheway.describe;

/**
 * Created by Axel on 2016-11-30.
 */

public class Destination {

    private String icon;
    private String iconName;
    private String adress;
    private String city;
    private String postalCode;

    public Destination(String icon, String iconName, String adress, String city, String postalCode) {
        this.icon = icon;
        this.iconName = iconName;
        this.adress = adress;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return icon + " | " + iconName  + " | " + adress + ", " + city + ", " + postalCode;}

        public String icon() {return icon;}
        public String iconName() {return iconName;}
        public String adress() {return adress;}
        public String city() {return city;}
        public String postalCode() {return postalCode;}


} //end of Destination
