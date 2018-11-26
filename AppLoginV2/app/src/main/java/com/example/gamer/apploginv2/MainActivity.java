package com.example.gamer.apploginv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    String fecha2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Date fecha = new Date();
        fecha2= new SimpleDateFormat("dd-MM-yyyy").format(fecha);


    }

    @OnClick({ R.id.bttienda1, R.id.bttienda2, R.id.button4})
    public void pasar(View v){
        if(v.hasOnClickListeners()){
            Intent i= new Intent(this,ListaFamiliaActivity.class );
            String tienda =  ((TextView)v).getText().toString();

            switch (tienda){
                case "Tienda 1":
                    tienda="01";
                    i.putExtra("tienda", tienda);
                    break;
                case "Tienda 2":
                    tienda="02";
                    i.putExtra("tienda", tienda);
                    break;
                case "Tienda 3":
                    tienda="03";
                    i.putExtra("tienda", tienda);
                    break;
            }
            Log.e("tienda",tienda);
            startActivity(i);

        }


    }
}
