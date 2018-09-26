package com.example.gamer.obtenerubucacion;

import android.Manifest;

import android.content.Context;
import android.content.pm.PackageManager;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DireccionActivity extends AppCompatActivity {

    @BindView(R.id.mensaje1)
    TextView mensaje1;
    @BindView(R.id.mensaje2)
    TextView mensaje2;

    Double latitud,longtud;

    @OnClick(R.id.Miboton)
    public void solicitar(View view){
        //escucador de ubucacion
        LocationManager locationManager =  (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitud=location.getLatitude();
                longtud=location.getLongitude();

                mensaje1.setText(String.valueOf(latitud));
                mensaje2.setText(String.valueOf(longtud));
            }//cauando cambia ubicacion

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        int permissionCheck= ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direccion);
        ButterKnife.bind(this);

        //almaceno si hay permiso desde el manifest
        int permissionCheck= ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION);

        //pregunto si el permiso esta denegado y si lo esta solicitarlo
        if (permissionCheck == PackageManager.PERMISSION_DENIED){
            //pregunto si requiere mostrar un mensaje aparte para solicitud del servicoi
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_CONTACTS)){

            }
        } else {
            //se hace la solicitud del permiso
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
    }


}
