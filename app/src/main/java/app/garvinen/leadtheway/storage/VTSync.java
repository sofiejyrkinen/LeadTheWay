package app.garvinen.leadtheway.storage;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.util.ArrayMap;
import android.util.Log;
//import android.widget.TextView;
//import com.android.volley.R;

//import com.android.volley.Request.Method.GET;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

import app.garvinen.leadtheway.R;

/**
 * Created by Axel on 2016-12-12.
 */

public class VTSync {

    private static String LOG_TAG = VTSync.class.getName();
    private Activity activity;
    private Context c;

    public VTSync(Context c) {
        this.c = c;
    }
    //Log.d(LOG_TAG, "Första!");

    public void syncVT() {
        Log.d(LOG_TAG, "Andra!");
        // Instantiate the RequestQueue.

        String key = "98eb573a1bad4d1640855da3bad8da72";
        final Map<String, String> mHeaders = new ArrayMap<String, String>();
        mHeaders.put("authKey",key);
        mHeaders.put("Authorization", "Bearer " + key);
        RequestQueue queue = Volley.newRequestQueue(c);
        //String url = "https://www.sunet.se";
        String url = "https://api.vasttrafik.se/bin/rest.exe/v2/location.nearbystops?originCoordLong=11.9&originCoordLat=57.7&maxNo=3&format=json";
        Log.d(LOG_TAG, "Tredje!");
        // Request a string response from the provided URL.

        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET, url,
                new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    Log.d(LOG_TAG, "Response is: " + response.substring(0, 500));
                    Log.d(LOG_TAG, "Femte!");
                }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(LOG_TAG, "That didn't work!");
                    }
                }) {

            public Map<String, String> getHeaders() {
                Log.d(LOG_TAG, "nån hämtade header " + mHeaders);
                return mHeaders;
            }
        };

// Add the request to the RequestQueue.
        Log.d(LOG_TAG, "Sjätte!");

        queue.add(stringRequest);

    }
}
