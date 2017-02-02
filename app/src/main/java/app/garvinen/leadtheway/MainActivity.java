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
import android.widget.Button;

import java.util.List;

import app.garvinen.leadtheway.adapters.IconSearchAdapter;
import app.garvinen.leadtheway.describe.Destination;
import app.garvinen.leadtheway.model.DestinationModel;

public class MainActivity extends AppCompatActivity {

    private static String LOG_TAG = MainActivity.class.getName();
    private DestinationModel dm;
    public List<Destination> myIcons;
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

    private void setIconAdapter() {

        dm = new DestinationModel(this);
        Log.d(LOG_TAG, " value of dm: " + dm);

        // Initialize destination icons
        myIcons = dm.getDestination();
        Log.d(LOG_TAG, " myIcons+dm: " + dm.getDestination());

        //Provar RecycleView

        RecyclerView rvIcons = (RecyclerView) findViewById(R.id.iconsList1);


        // Create adapter passing in the sample user data
        IconSearchAdapter adapter = new IconSearchAdapter(this, myIcons);

        // Attach the adapter to the recyclerview to populate items
        rvIcons.setAdapter(adapter);

        // Set layout manager to position the items
        rvIcons.setLayoutManager(new LinearLayoutManager(this));
        // That's all!

        // Setup layout manager for items with orientation
// Also supports `LinearLayoutManager.HORIZONTAL`
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
// Optionally customize the position you want to default scroll to
        layoutManager.scrollToPosition(0);
// Attach layout manager to the RecyclerView
        rvIcons.setLayoutManager(layoutManager);

        //Detta nedan fungerar typ

        /*
        ListView destinationIcons = (ListView) findViewById(R.id.iconsList1);
        Log.d(LOG_TAG, " destinationIcons: " + destinationIcons);
        Log.d(LOG_TAG, " dest: " + dm.getDestination());

        ArrayAdapter<Destination> adapt = new IconShAdapter(this, 0, myIcons);
        Log.d(LOG_TAG, " adapter: " + adapt);

        destinationIcons.setAdapter(adapt);

        destinationIcons.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                        Toast.makeText(getApplicationContext(), "Ikon vald", Toast.LENGTH_SHORT).show();

                        /*This doesn't yet work as I want..
                        ListView destAdress = (ListView) findViewById(R.id.addresList1);
                        Log.d(LOG_TAG, " destinationIcons: " + destAdress);
                        Log.d(LOG_TAG, " dest: " + dm.getDestination());

                        ArrayAdapter<Destination> addressAdapt = new AddressAdapter(this, 0, myIcons);
                        Log.d(LOG_TAG, " adapter: " + addressAdapt);

                        destAdress.setAdapter(addressAdapt);


                    }
                }); //end of onItemClickListener

*/
    } //end of set adapter

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
