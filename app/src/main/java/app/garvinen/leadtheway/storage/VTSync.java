package app.garvinen.leadtheway.storage;

import android.app.Activity;
import android.content.Context;
import android.util.ArrayMap;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

//import android.widget.TextView;
//import com.android.volley.R;
//import com.android.volley.Request.Method.GET;

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

    String url = "https://api.vasttrafik.se/bin/rest.exe/v2/location.nearbyaddress?originCoordLong=11.981211&originCoordLat=57.709792&format=json";

    public void syncVT() {
        Log.d(LOG_TAG, "Andra!");
        // Instantiate the RequestQueue.

        String key = "047795f4bf68cde869de5ff9161d9b00";
        final Map<String, String> mHeaders = new ArrayMap<String, String>();
        mHeaders.put("authKey",key);
        mHeaders.put("Authorization", "Bearer " + key);
        RequestQueue queue = Volley.newRequestQueue(c);
        //String url = "https://www.sunet.se";

        Log.d(LOG_TAG, "Tredje!");
        // Request a string response from the provided URL.

        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET, url,
                new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    Log.d(LOG_TAG, "Femte!");
                    Log.d(LOG_TAG, "Response is: " + response.substring(0, 500));

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
