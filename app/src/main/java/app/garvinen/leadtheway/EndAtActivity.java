package app.garvinen.leadtheway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class EndAtActivity extends AppCompatActivity {


    private static String LOG_TAG = EndAtActivity.class.getName();
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG,"Setting Layout");
        setContentView(R.layout.activity_end_at);
        Log.d(LOG_TAG, "Setting Layout Done");
        initiateButtons();

        timePicker = (TimePicker) findViewById(R.id.endAtTime);
        timePicker.setIs24HourView(true);
    }


    public void initiateButtons(){

        Button buttonNext =(Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(EndAtActivity.this, TravelInfoActivity.class);
                startActivity(intent);
            }
        });

    }//end of initiateButtons

}//end of EndAtActivity
