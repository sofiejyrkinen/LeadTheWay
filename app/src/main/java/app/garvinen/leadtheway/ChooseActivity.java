package app.garvinen.leadtheway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {


    private static String LOG_TAG = ChooseActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG,"Setting Layout");
        setContentView(R.layout.activity_choose);
        Log.d(LOG_TAG, "Setting Layout Done");
        initiateButtons();
    }

    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart: ");
    }

    public void initiateButtons(){

        Button buttonWantGo =(Button) findViewById(R.id.buttonWantGo);
        buttonWantGo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ChooseActivity.this, GoTooActivity.class);
                startActivity(intent);
            }
        });

        Button buttonWantEnd =(Button) findViewById(R.id.buttonWantEnd);
        buttonWantEnd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ChooseActivity.this, EndAtActivity.class);
                startActivity(intent);
            }
        });

    }//End of initiateButtons



}//end of ChooseActivity
