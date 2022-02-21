package com.example.solar;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.Date;

import android.os.Bundle;
import org.json.JSONObject;
import org.json.JSONException;

import com.android.volley.Request;
import com.example.solar.model.Nasa;
import com.example.solar.model.NasaObserver;
import com.example.solar.model.NasaSearchObserver;

public class Solar implements NasaObserver {
    private String url;
    public NasaSearchObserver observer;

    public Solar(Context context) {
        Nasa.getInstance().init(context);
        Nasa.getInstance().setObserver(this);

    }

    public void setObserver(NasaSearchObserver observer) {
        this.observer = observer;
    }


    public void requestSolarFlareData(Date start, Date end) {
        //String startDate = obj.startDate;
        //String endDate = obj.endDate;
        // int activityID = obj.activityID;
        // String link = obj.link;

        String request = "";
        String prefix = "https://api.nasa.gov/DONKI/FLR?";

        if (start != null && end != null) {
            // request = prefix + "startDate=" + startDate + "&endDate=" + endDate +"&activityID=" + activityID + "&link=" + link;
        }
        request += "&api_key=wvbDTZzC70fJgFgy2MMgNm3llmt7eRhyrbmGTD4w";
        //
        Nasa.getInstance().requestData(request);
    }



   public void requestSolarFlareData() {
       this.requestSolarFlareData(null, null);
         }


        public void onDataFound (JSONObject object){
            Log.d("SOLAR", "onDataFound: " + object);
            if (observer != null)
            observer.onSearchFinished(object.toString());
        }
    }











