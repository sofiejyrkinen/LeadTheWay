package app.garvinen.leadtheway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import app.garvinen.leadtheway.describe.Destination;
import app.garvinen.leadtheway.model.DestinationModel;
import app.garvinen.leadtheway.storage.DBDestinationStore;

public class SettingsDestinationActivity extends AppCompatActivity {

    private static String LOG_TAG = SettingsDestinationActivity.class.getName();
    private ListView destinationList;
    private ArrayAdapter<Destination> adapter;
    private DestinationModel dm;
    //private DBDestinationStore dbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG,"Setting Layout");
        setContentView(R.layout.activity_settings_destination);
        Log.d(LOG_TAG, "Setting Layout Done");
        initiateButtons();

        dm = new DestinationModel(this);

        destinationList = (ListView) findViewById(R.id.destination_list);
        Log.d(LOG_TAG, " dest: " + dm.getDestination());
        Log.d(LOG_TAG, " dest: " + dm.getDestination());
        Log.d(LOG_TAG, " list: " + destinationList);

     /*   ArrayList<Destination> dests = new ArrayList<>();
        dests.add(new Destination("Hjalmar", "", "", "", ""));
*/



        Log.d(LOG_TAG, " dest: " + dm.getDestination());
        adapter = new ArrayAdapter<Destination>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                dm.getDestination());
                //dbs.getDestination());
                //dests);
        Log.d(LOG_TAG, " adapter: " + adapter);
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
            Intent intent = new Intent(SettingsDestinationActivity.this, SettingsDestinationActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.settingsNotification) {
            Intent intent = new Intent(SettingsDestinationActivity.this, SettingsNotificationsActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.settingSettings) {
            Intent intent = new Intent(SettingsDestinationActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initiateButtons(){
        Button buttonNext =(Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(SettingsDestinationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button buttonAdd =(Button) findViewById(R.id.ButtonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(SettingsDestinationActivity.this, DestinationAdder.class);
                startActivity(intent);
            }
        });

    }//end of initiateButtons


}//end of SettingsDestinationActivity
