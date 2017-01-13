package app.garvinen.leadtheway.describe;

/**
 * Created by Axel on 2016-11-30.
 */

public class Destination {


    private String iconName;
    private String adress;
    private String city;
    private String postalCode;
    private int iconId;


    public Destination(String iconName, String adress, String city, String postalCode, int iconId) {

        this.iconName = iconName;
        this.adress = adress;
        this.city = city;
        this.postalCode = postalCode;
        this.iconId = iconId;
    }

    @Override
    public String toString() {
        return iconName  + " | " + adress + " | " + city + " | " + postalCode;}

        public String iconName() {return iconName;}
        public String adress() {return adress;}
        public String city() {return city;}
        public String postalCode() {return postalCode;}
        public int iconId() {return iconId;}

        public String getIconName() {return iconName;}
        public String getAdress() {return adress;}
        public String getCity() {
        return city;
    }
        public String getPostalCode(){
        return postalCode;
    }
        public int getIconId(){
            return iconId;
        }

} //end of Destination
