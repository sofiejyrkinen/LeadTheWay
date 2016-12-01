package app.garvinen.leadtheway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SettingsDestinationActivity extends AppCompatActivity {

    private static String LOG_TAG = SettingsDestinationActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG,"Setting Layout");
        setContentView(R.layout.activity_settings_destination);
        Log.d(LOG_TAG, "Setting Layout Done");
        initiateButtons();

    }//end of onCreate


    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart: ");
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
