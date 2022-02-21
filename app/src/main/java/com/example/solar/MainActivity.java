package com.example.solar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.util.List;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.example.solar.model.Nasa;
import com.example.solar.model.NasaSearchObserver;
import com.example.solar.model.NasaObserver;

import com.example.solar.model.NasaSearchObserver;
import com.google.gson.Gson;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


    }
    public void segundaTela(View view){
        Intent intent = new Intent(getApplicationContext(), Curiositiess.class);
        startActivity(intent);


    Solar s = new Solar(getApplicationContext());
        s.setObserver(new NasaSearchObserver () {
        public void onSearchFinished(String data){
            TextView texto = findViewById(R.id.bt_info_erup);
            texto.setText(data);

    }

            public void showSolarFragment() {
                TextView header = findViewById(R.id.bt_info_erup);
                header.setText("últimas erupções solares");
            }
              //  Intent intent = new Intent(getApplicationContext(), Solar.class);
               // startActivity(intent);



    });

       // Request r = new Request();
        //r.startDate

        };

        }

