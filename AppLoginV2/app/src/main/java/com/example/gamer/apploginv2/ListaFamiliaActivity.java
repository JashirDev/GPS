package com.example.gamer.apploginv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListaFamiliaActivity extends AppCompatActivity {
    String idtienda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_familia);


        Bundle parametros = this.getIntent().getExtras();
        idtienda= parametros.getString("tienda");
        ButterKnife.bind(this);


    }

    @OnClick({ R.id.btFamilia, R.id.btFamilia1, R.id.btFamilia2
            , R.id.btFamilia3, R.id.btFamilia4, R.id.btFamilia5
            , R.id.btFamilia6, R.id.btFamilia7, R.id.btFamilia8
            , R.id.btFamilia9, R.id.btFamilia10, R.id.btFamilia11
            , R.id.btFamilia12, R.id.btFamilia13, R.id.btFamilia14
            , R.id.btFamilia15, R.id.btFamilia16, R.id.btFamilia17
            , R.id.btFamilia18, R.id.btFamilia19, R.id.btFamilia20
            , R.id.btFamilia21, R.id.btFamilia22, R.id.btFamilia23
            , R.id.btFamilia24, R.id.btFamilia25, R.id.btFamilia26
            , R.id.btFamilia27, R.id.btFamilia28, R.id.btFamilia29
            , R.id.btFamilia30, R.id.btFamilia31, R.id.btFamilia32
            , R.id.btFamilia33, R.id.btFamilia34, R.id.btfamilia35
            , R.id.btFamilia36, R.id.btFamilia37})
    public void pasar(View v){
        if(v.hasOnClickListeners()){
            Intent i= new Intent(this,ProductosActivity.class );
            String familia =  ((TextView)v).getText().toString();
            i.putExtra("familia", familia);
            i.putExtra("tienda", idtienda);
            Log.e("familia",familia);
            startActivity(i);

        }


    }
}
