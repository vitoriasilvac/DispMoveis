package com.example.solar.model;

import org.json.JSONObject;


public interface NasaObserver {
    void onDataFound (JSONObject object);
}
