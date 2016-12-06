package app.garvinen.leadtheway;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TimePicker;


public class GoTooActivity extends AppCompatActivity {


    private static String LOG_TAG = GoTooActivity.class.getName();
    private TimePicker timePicker;
    private int hour;
    private int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Log.d(LOG_TAG,"Setting Layout");
        setContentView(R.layout.activity_go_too);
        Log.d(LOG_TAG, "Setting Layout Done");
        //initiateButtons();

        timePicker = (TimePicker) findViewById(R.id.goTooTime);
        timePicker.setIs24HourView(true);
    }

    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart: ");
    }







}//end of GoToActivity
