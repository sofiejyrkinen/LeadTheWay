package app.garvinen.leadtheway;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TimePicker;

public class EndAtActivity extends AppCompatActivity {


    private static String LOG_TAG = EndAtActivity.class.getName();
    private TimePicker timePicker;
    private int hour;
    private int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG,"Setting Layout");
        setContentView(R.layout.activity_end_at);
        Log.d(LOG_TAG, "Setting Layout Done");
        //initiateButtons();

        timePicker = (TimePicker) findViewById(R.id.endAtTime);
        timePicker.setIs24HourView(true);
    }




}//end of EndAtActivity
