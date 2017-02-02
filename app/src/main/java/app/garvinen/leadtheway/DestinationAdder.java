package app.garvinen.leadtheway;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import app.garvinen.leadtheway.adapters.IconAdapter;
import app.garvinen.leadtheway.describe.Destination;
import app.garvinen.leadtheway.describe.Icon;
import app.garvinen.leadtheway.model.DestinationModel;
import app.garvinen.leadtheway.model.IconModel;
import app.garvinen.leadtheway.storage.DBDestinationStore;
import app.garvinen.leadtheway.storage.DBIconStore;

/**
 * Created by sofiejyrkinen on 2016-11-30.
 */
public class DestinationAdder extends Activity {

    public static String LOG_TAG = DestinationAdder.class.getName();

    private DBDestinationStore dbs;
    private DestinationModel dm;
    private Destination d;
    private DBIconStore dbis;
    private IconModel im;
    private Icon i;
    private ArrayAdapter<Icon> adapter;
    private ListView iconList;
    private Cursor cursor;
    private Spinner spinner;
    public static int spinn;
    public List<Icon> myIcons ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_adder);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT); //This code is inspired by code from Stackoverflow
        initiateButtons();
        initiateSpinner();
        dm = new DestinationModel(this);

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

    public void initiateSpinner(){
        im = new IconModel(this);
        final Spinner spinner = (Spinner)findViewById(R.id.iconAdder);

        Log.d(LOG_TAG, " im: " + im.getIcon());
        Log.d(LOG_TAG, " spinner " + spinner);

        myIcons = im.getIcon();
        Log.d(LOG_TAG, " myIcons: " + myIcons);

        ArrayAdapter<Icon> adapter = new IconAdapter(this, 0, myIcons);
        Log.d(LOG_TAG, " adapter: " + adapter);
        Log.d(LOG_TAG, "im" + im.getIcon());
        spinner.setAdapter(adapter);

        Log.d(LOG_TAG, " spinner: " + spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Ikon vald", Toast.LENGTH_SHORT).show();
                spinn = i;
                Log.d(LOG_TAG, " spinn i: " + spinn);
                if (myIcons!=null && myIcons.size()>0)
                    Log.d(LOG_TAG, " spinn i: " + myIcons.get(i));
                else
                    Log.d(LOG_TAG, " spinn  ås å e NULL");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    } //end of initiateSpinner

    //The button that adds a new destination
    public void buttonClick(View view) {
        Log.d(LOG_TAG, " button clicked");
        EditText nameField  = (EditText) findViewById(R.id.TextFieldIconName);
        EditText adressField = (EditText) findViewById(R.id.TextFieldAdress);
        EditText cityField = (EditText) findViewById(R.id.TextFieldCity);
        EditText postalField = (EditText) findViewById(R.id.TextFieldPostal);
        //ImageView spinnerImage = (ImageView) findViewById(iconImage);

        String iconName = nameField.getText().toString();
        String adress = adressField.getText().toString();
        String city = cityField.getText().toString();
        String postalCode = postalField.getText().toString();
        int iconId = myIcons.get(spinn).iconPath();
        Log.d(LOG_TAG, "value of id: " + iconId);


        Destination d = new Destination(iconName, adress, city, postalCode, iconId);
        Log.d(LOG_TAG, "value of d: " + (d));

        Log.d(LOG_TAG, "value of dm: " + (dm));
        dm.addDestination(d);
        Log.d(LOG_TAG, "value of dm add: " + (dm));


        Intent intent = new Intent(DestinationAdder.this, SettingsDestinationActivity.class);
        startActivity(intent);
    }


}//end of DestinationAdder
