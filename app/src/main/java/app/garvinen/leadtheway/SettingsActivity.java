package app.garvinen.leadtheway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import app.garvinen.leadtheway.describe.Destination;
import app.garvinen.leadtheway.model.DestinationModel;


public class SettingsActivity extends AppCompatActivity {

    private static String LOG_TAG = SettingsActivity.class.getName();


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG,"Setting Layout");
        setContentView(R.layout.activity_settings_destination);
        Log.d(LOG_TAG, "Setting Layout Done");
        //initiateButtons();
        dm = new DestinationModel(this);

        destinationList = (ListView) findViewById(R.id.destination_List);
        adapter = new ArrayAdapter<Destination>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                dm.getDestination());
        destinationList.setAdapter(adapter);

    }//end of onCreate

    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart: ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.settingsDestination) {
            Intent intent = new Intent(SettingsActivity.this, SettingsDestinationActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.settingsNotification) {
            Intent intent = new Intent(SettingsActivity.this, SettingsNotificationsActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.settingSettings) {
            Intent intent = new Intent(SettingsActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}//end of SettingsActivity
