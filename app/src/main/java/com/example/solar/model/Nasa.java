package com.example.solar.model;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Nasa {
    private static Nasa instance;
    private static RequestQueue queue;
    private NasaObserver observer;

    public static Nasa getInstance(){
        if (instance == null) instance = new Nasa();
        return instance;
    }

    private Nasa(){

    }

    public void init (Context c){ queue = Volley.newRequestQueue(c); }

    public void setObserver(NasaObserver observer) { this.observer = observer;}

    public void requestData (String request){
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, request, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        processSucess(response); }
                        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { processError(error);}

            });
        queue.add(stringRequest);
        }

    private void processError(VolleyError error) {
        Log.d("NASA", "processError: " + error);
    }

    private void processSucess(JSONObject response) {
        if(observer != null) {
            observer.onDataFound(response);
    }
    }

}
