package app.garvinen.leadtheway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;


public class GoTooActivity extends AppCompatActivity {


    private static String LOG_TAG = GoTooActivity.class.getName();
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Log.d(LOG_TAG,"Setting Layout");
        setContentView(R.layout.activity_go_too);
        Log.d(LOG_TAG, "Setting Layout Done");
        initiateButtons();

        timePicker = (TimePicker) findViewById(R.id.goTooTime);
        timePicker.setIs24HourView(true);
    }

    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart: ");
    }


    public void initiateButtons(){

        Button buttonNext =(Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(GoTooActivity.this, TravelInfoActivity.class);
                startActivity(intent);
            }
        });

    }//end of initiateButtons




}//end of GoToActivity
