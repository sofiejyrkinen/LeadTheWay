package app.garvinen.leadtheway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG,"Setting Layout");
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "Setting Layout Done");
        initiateButtons();
    }

    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart: ");
    }

    public void initiateButtons(){

        Button buttonNext =(Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ChooseActivity.class);
                startActivity(intent);
            }
        });

        Button preButton =(Button) findViewById(R.id.prebutton);
        preButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SettingsDestinationActivity.class);
                startActivity(intent);
            }
        });
    }//end of initiateButtons



}//end of MainActivity
