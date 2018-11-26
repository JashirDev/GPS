package com.example.gamer.apploginv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Retrofit;

public class Cambios2Activity extends AppCompatActivity {

    Retrofit retrofit;
    String iditem;
    String idficador;
    String fecha2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambios2);
    }
}
