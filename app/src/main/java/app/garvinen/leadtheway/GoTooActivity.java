package app.garvinen.leadtheway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class GoTooActivity extends AppCompatActivity {

    private static String LOG_TAG = GoTooActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG,"Setting Layout");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_too);
        Log.d(LOG_TAG, "Setting Layout Done");
        //initiateButtons();
    }

    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart: ");
    }



}//end of GoToActivity
