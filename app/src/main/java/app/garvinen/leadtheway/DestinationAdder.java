package app.garvinen.leadtheway;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import app.garvinen.leadtheway.describe.Destination;
import app.garvinen.leadtheway.model.DestinationModel;
import app.garvinen.leadtheway.storage.DBDestinationStore;

/**
 * Created by sofiejyrkinen on 2016-11-30.
 */
public class DestinationAdder extends Activity {

    public static String LOG_TAG = DestinationAdder.class.getName();
    private DBDestinationStore dbs;
    private DestinationModel dm;
    private Destination d;

    Spinner spinner;
    String [] iconName ={"Activity", "Boy", "Dad", "Girl", "Home", "Hospital", "Mom", "School", "Store", "Work" };
    int [] iconImage = {R.drawable.icon_activity, R.drawable.icon_boy, R.drawable.icon_dad,
            R.drawable.icon_girl, R.drawable.icon_home, R.drawable.icon_hospital,
            R.drawable.icon_mom, R.drawable.icon_school, R.drawable. icon_store, R.drawable.icon_work};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_adder);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT); //This code is inspired by code from Stackoverflow
        initiateButtons();
        dm = new DestinationModel(this);

        spinner =(Spinner)findViewById(R.id.iconAdder);

        Adapter adapter = new Adapter(this, iconName, iconImage);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), iconName[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


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

    //The button that adds a new destination
    public void buttonClick(View view) {
        Log.d(LOG_TAG, " button clicked");
        EditText iconField  = (EditText) findViewById(R.id.TextFieldIcon);
        EditText nameField  = (EditText) findViewById(R.id.TextFieldIconName);
        EditText adressField = (EditText) findViewById(R.id.TextFieldAdress);
        EditText cityField = (EditText) findViewById(R.id.TextFieldCity);
        EditText postalField = (EditText) findViewById(R.id.TextFieldPostal);


        String icon = iconField.getText().toString();
        String iconName = nameField.getText().toString();
        String adress = adressField.getText().toString();
        String city = cityField.getText().toString();
        String postalCode = postalField.getText().toString();


       Destination d = new Destination(icon, iconName, adress, city, postalCode);
        Log.d(LOG_TAG, "value of d: " + (d));
        Log.d(LOG_TAG, "value of dm: " + (dm));
        dm.addDestination(d);

        Intent intent = new Intent(DestinationAdder.this, SettingsDestinationActivity.class);
        startActivity(intent);
    }


}//end of DestinationAdder
