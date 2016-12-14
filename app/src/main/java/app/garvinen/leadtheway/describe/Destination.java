package app.garvinen.leadtheway.describe;

/**
 * Created by Axel on 2016-11-30.
 */

public class Destination {


    private String iconName;
    private String adress;
    private String city;
    private String postalCode;

    public Destination(String iconName, String adress, String city, String postalCode) {

        this.iconName = iconName;
        this.adress = adress;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return iconName  + " | " + adress + ", " + city + ", " + postalCode;}


        public String iconName() {return iconName;}
        public String adress() {return adress;}
        public String city() {return city;}
        public String postalCode() {return postalCode;}


} //end of Destination
