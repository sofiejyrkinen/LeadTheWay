package app.garvinen.leadtheway;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class TravelInfoActivity extends ListActivity {


    private static String LOG_TAG = TravelInfoActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG,"Setting Layout");
        setContentView(R.layout.activity_travel_info);
        Log.d(LOG_TAG, "Setting Layout Done");
        initiateButtons();

        String [] travel = {"Dag","Fordonstyp", "Hållplats", "Läge", "Avgångstid", "Ankomsttid"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getListView().getContext(),android.R.layout.simple_list_item_1,travel);
        getListView().setAdapter(adapter);

    } //end of onCreate


    public void initiateButtons(){

        Button buttonNext =(Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(TravelInfoActivity.this, TravelInfoActivity.class);
                startActivity(intent);
            }
        });

    }//end of initiateButtons



}//end of TravelInfoActivity
