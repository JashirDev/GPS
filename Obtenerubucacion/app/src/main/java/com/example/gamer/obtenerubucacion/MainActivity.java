package com.example.gamer.obtenerubucacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
 /*@BindView(R.id.boton)
    Button boton;
    @Override*/
 @OnClick(R.id.boton)
 public void pasar(View v){
     Intent transporte = new Intent(MainActivity.this, DireccionActivity.class);

     startActivity(transporte);
 }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

}
