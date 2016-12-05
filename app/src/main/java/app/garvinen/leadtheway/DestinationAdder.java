package app.garvinen.leadtheway;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sofiejyrkinen on 2016-11-30.
 */
public class DestinationAdder extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_adder);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT); //This code is inspired by code from Stackoverflow
        initiateButtons();

        /*
        dm = new DestinationModel(this);

        destinationList = (ListView) findViewById(R.id.destination_List);
        adapter = new ArrayAdapter<Destination>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                dm.getDestination());
        destinationList.setAdapter(adapter);
*/
        /*
        * The code below is inspired by code from Stackoverflow.
        * The code below we can use if we don't want the popup window to fill the whole screen
        * /

        /* DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int Width=dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(Width*.9),(int)(height*.6)); */

    }//end of onCreate

    public void initiateButtons() {
        Button buttonClose = (Button) findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DestinationAdder.this, SettingsDestinationActivity.class);
                startActivity(intent);
            }
        });

    }//end of initiateButtons

    /*
    private ListView destinationList;
    private ArrayAdapter<Destination> adapter;
    private DestinationModel dm;

    public void buttonClick(View view) {
        EditText nameField  = (EditText) findViewById(R.id.TextFieldIconName);
        EditText adressField = (EditText) findViewById(R.id.TextFieldAdress);

        String icon = nameField.getText().toString();
        String iconName = nameField.getText().toString();
        String adress = adressField.getText().toString();
        String city = adressField.getText().toString();
        String postalCode = adressField.getText().toString();

        Destination d = new Destination (icon, iconName, adress, city, postalCode);

    }
*/

}//end of DestinationAdder
