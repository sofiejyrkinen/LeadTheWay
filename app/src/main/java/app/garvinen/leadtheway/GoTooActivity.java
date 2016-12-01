package app.garvinen.leadtheway;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class GoTooActivity extends AppCompatActivity {

    private static String LOG_TAG = GoTooActivity.class.getName();
    private static Button time;
    private static TextView set_time;
    private static final int Time_id = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Log.d(LOG_TAG,"Setting Layout");
        setContentView(R.layout.activity_go_too);
        Log.d(LOG_TAG, "Setting Layout Done");
        initiateButtons();
    }

    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart: ");
    }

    public void initiateButtons() {
        time = (Button) findViewById(R.id.selecttime);
        set_time = (TextView) findViewById(R.id.set_time);
        time.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Show time dialog
                showDialog(Time_id);
            }
        });
    }//end of initiateButtons

    protected Dialog onCreateDialog(int id) {
        // Get the calander
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Open the timepicker dialog
        return new TimePickerDialog(GoTooActivity.this, time_listener, hour, minute, false);
    }

    TimePickerDialog.OnTimeSetListener time_listener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hour, int minute) {
            // store the data in one string and set it to text
            String time1 = String.valueOf(hour) + ":" + String.valueOf(minute);
            set_time.setText(time1);
        }
    };



}//end of GoToActivity
