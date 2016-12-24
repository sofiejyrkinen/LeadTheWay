package app.garvinen.leadtheway;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

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

    /*String [] iconName ={"Activity", "Boy", "Dad", "Girl", "Home", "Hospital", "Mom", "School", "Store", "Work" };


    int [] iconImage = {R.drawable.icon_activity, R.drawable.icon_boy, R.drawable.icon_dad,
            R.drawable.icon_girl, R.drawable.icon_home, R.drawable.icon_hospital,
            R.drawable.icon_mom, R.drawable.icon_school, R.drawable. icon_store, R.drawable.icon_work}; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_adder);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT); //This code is inspired by code from Stackoverflow
        initiateButtons();
        initiateSpinner();
        dm = new DestinationModel(this);

        /*
        ArrayList<Integer> array_image = new ArrayList<Integer>();
        array_image.add(R.drawable.icon_activity);
        array_image.add(R.drawable.icon_boy); */

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

        /*
        //Henrik provar 1
        im = new IconModel(this);
        spinner = (Spinner) findViewById(R.id.iconAdder);
        Log.d(LOG_TAG, " icon: " + im.getIcon());
        Log.d(LOG_TAG, " iconlist: " + iconList);

        ArrayList<Icon> SOJY = new ArrayList<>();
        SOJY.add(new Icon(666));
        SOJY.add(new Icon(667));

        adapter = new ArrayAdapter<Icon>((Context)this,
                android.R.layout.simple_spinner_item,
                android.R.id.text1,
                SOJY);

        Log.d(LOG_TAG, " icon: " + im.getIcon());
        Log.d(LOG_TAG, " adapter: " + adapter);
        spinner.setAdapter(adapter);

*/
        //Jag provar 2
        /*
        im = new IconModel(this);
        Log.d(LOG_TAG, " icon: " + im.getIcon());
        Log.d(LOG_TAG, " iconlist: " + iconList);
        spinner =(Spinner)findViewById(R.id.iconAdder);

        ArrayList<Icon> SOJY = new ArrayList<>();
        SOJY.add(new Icon("Tjohej"));
        SOJY.add(new Icon("Tjoho"));

        MyAdapter adapt = new MyAdapter(this,SOJY);
        spinner.setAdapter(adapt);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Kajkaj", Toast.LENGTH_SHORT).show();
                //Log.d(LOG_TAG, " iconImage: " + iconImage[i]);
                //nameIcon = iconImage[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/

        //Jag provar 3
        ArrayList<Icon> myIcons = new ArrayList<>();
        myIcons.add(new Icon("icon_activity"));
        myIcons.add(new Icon("icon_boy"));

        ArrayAdapter<Icon> adapter = new MyAdapter(this, 0, myIcons);

        Spinner spinner = (Spinner)findViewById(R.id.iconAdder);
        spinner.setAdapter(adapter);
    } //end of initiateSpinner

    //The button that adds a new destination
    public void buttonClick(View view) {
        Log.d(LOG_TAG, " button clicked");

        EditText nameField  = (EditText) findViewById(R.id.TextFieldIconName);
        EditText adressField = (EditText) findViewById(R.id.TextFieldAdress);
        EditText cityField = (EditText) findViewById(R.id.TextFieldCity);
        EditText postalField = (EditText) findViewById(R.id.TextFieldPostal);

        String iconName = nameField.getText().toString();
        String adress = adressField.getText().toString();
        String city = cityField.getText().toString();
        String postalCode = postalField.getText().toString();
        long iconId = 1;


       Destination d = new Destination(iconName, adress, city, postalCode, iconId);
        Log.d(LOG_TAG, "value of d: " + (d));

        Log.d(LOG_TAG, "value of dm: " + (dm));
        dm.addDestination(d);

        Intent intent = new Intent(DestinationAdder.this, SettingsDestinationActivity.class);
        startActivity(intent);
    }


}//end of DestinationAdder
