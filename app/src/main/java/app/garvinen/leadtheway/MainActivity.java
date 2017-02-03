package app.garvinen.leadtheway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import app.garvinen.leadtheway.adapters.AddressAdapter;
import app.garvinen.leadtheway.adapters.IconSearchAdapter;
import app.garvinen.leadtheway.describe.Destination;
import app.garvinen.leadtheway.model.DestinationModel;
import app.garvinen.leadtheway.model.ItemClickSupport;

public class MainActivity extends AppCompatActivity {

    private static String LOG_TAG = MainActivity.class.getName();
    private DestinationModel dm;
    public List<Destination> myIcons;
    public RecyclerView destinationIcons;
    public static int SOJY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG,"Setting Layout");
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "Setting Layout Done");
        initiateButtons();
        setIconAdapter();
    }


    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart: ");
    }

    private void setIconAdapter() {

        // Initialize destination icons
        dm = new DestinationModel(this);
        Log.d(LOG_TAG, " value of dm: " + dm);

        myIcons = dm.getDestination();
        Log.d(LOG_TAG, " myIcons: " + myIcons);

        destinationIcons = (RecyclerView) findViewById(R.id.iconsList1);            //Initialize the RecyclerView
        IconSearchAdapter adapter = new IconSearchAdapter(this, myIcons);           // Create adapter passing in the sample user data
        destinationIcons.setAdapter(adapter);                                        // Attach the adapter to the recyclerview to populate items
        destinationIcons.setLayoutManager(new LinearLayoutManager(this));            // Set layout manager to position the items

        /*
         * Setup layout manager for items with orientation horizontal
         */
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        layoutManager.scrollToPosition(0);
        destinationIcons.setLayoutManager(layoutManager); // Attach layout manager to the RecyclerView
        iconClick();


    } //end of set adapter

    public void iconClick(){
        /*
        * Source: http://www.littlerobots.nl/blog/Handle-Android-RecyclerView-Clicks/
        */
        ItemClickSupport.addTo(destinationIcons).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Toast.makeText(getApplicationContext(), "Ikon vald", Toast.LENGTH_SHORT).show();
                Log.d(LOG_TAG, "position" + position);
                setAddress(position);
            }
        }); //end of ItemClickSupport

    }

    public void setAddress(int position){

        myIcons.get(position);
        Log.d(LOG_TAG, "myIcons position " + myIcons.get(position));

        String SOJY = myIcons.get(position).getAdress();
        Log.d(LOG_TAG, "Adressen " + myIcons.get(position));

        ListView destAdress = (ListView) findViewById(R.id.addresList1);
        Log.d(LOG_TAG, " destinationIcons: " + destAdress);
        Log.d(LOG_TAG, " dest: " + dm.getDestination());
        ArrayAdapter<Destination> addressAdapt = new AddressAdapter(this, 0, myIcons);
        Log.d(LOG_TAG, " adapter: " + addressAdapt);
        destAdress.setAdapter(addressAdapt);
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
                Intent intent = new Intent(MainActivity.this, SettingsDestinationActivity.class);
                startActivity(intent);
            return true;
        }
        if (id == R.id.settingsNotification) {
            Intent intent = new Intent(MainActivity.this, SettingsNotificationsActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.settingSettings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initiateButtons(){

        Button buttonNext =(Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ChooseActivity.class);
                startActivity(intent);
            }
        });

    }//end of initiateButtons



}//end of MainActivity
