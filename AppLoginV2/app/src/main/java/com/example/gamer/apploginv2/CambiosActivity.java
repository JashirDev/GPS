package com.example.gamer.apploginv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gamer.apploginv2.modelo.Productoresponse;
import com.example.gamer.apploginv2.servicios.Apiservicio;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CambiosActivity extends AppCompatActivity {
    Retrofit retrofit;
    String iditem;
    String idficador;
    String fecha2;
    String idtienda;

    @BindView(R.id.nmbproducto)
    TextView nombreproductos;
    @BindView(R.id.precioitem)
    TextView precioitem;


    @BindView(R.id.nuevopreciov2)
    TextView nuevopreciov2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambios);
        ButterKnife.bind(this);

        Date fecha = new Date();
         fecha2= new SimpleDateFormat("yyy-dd-MM").format(fecha);
  /*     Log.e("dia",""+fecha2);
       Bundle parametros = this.getIntent().getExtras();

            Log.e("intent", "NO NULL");
            String nomreproducto = parametros.getString("nombreitem");
             String precioactual =parametros.getString("precio");
            idficador = parametros.getString("idificador");
            Log.e("intent", nomreproducto+"/"+precioactual);

            precioitem.setText(precioactual);

*/


        Bundle parametros = this.getIntent().getExtras();
        String nomreproducto = parametros.getString("nombreitem");
        String precioactual = parametros.getString("precio");
        idficador = parametros.getString("idificador");
        idtienda = parametros.getString("idtienda");

        iditem=parametros.getString("iditem");
        nombreproductos.setText(nomreproducto);
        precioitem.setText(precioactual);

        // Log.e("el identificador",idficador);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://35.185.74.160/Productos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @OnClick(R.id.btactualizar)
    public void actualziar (View v){
        // String nuevoprecio = etdnuevoprecio.getText().toString();
        String nuevoprecio2=nuevopreciov2.getText().toString();
        Apiservicio apiservicio = retrofit.create(Apiservicio.class);
        Call<Productoresponse> call = apiservicio.actualizar(iditem,nuevoprecio2,idficador,idtienda,fecha2);
        call.enqueue(new Callback<Productoresponse>() {
            @Override
            public void onResponse(Call<Productoresponse> call, Response<Productoresponse> response) {
                if(response.isSuccessful()){
                    Log.e("Dale","con fe ");
                    Toast.makeText(CambiosActivity.this,"Precio actualizado",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Productoresponse> call, Throwable t) {

            }
        });

        finish();
    }
    @OnClick(R.id.btalmacenar)
    public void borrar (View v){
        String mostrar = nuevopreciov2.getText().toString();
        if (!mostrar.equals("")){
            mostrar = mostrar.substring(0,mostrar.length()-1);
            nuevopreciov2.setText(mostrar);
        }

        //finish();
    }


    @OnClick({ R.id.bt1, R.id.bt2, R.id.bt3
            , R.id.bt4, R.id.bt5, R.id.bt6
            , R.id.bt7, R.id.bt8, R.id.bt9
            ,R.id.bt0,R.id.btpunto
    })
    public void agregarNuemro(View v){

        String preciocambio=nuevopreciov2.getText().toString();

        if(v.hasOnClickListeners()){

            String numero =  ((TextView)v).getText().toString();

            preciocambio = preciocambio + numero;
            nuevopreciov2.setText(preciocambio);


        }
    }

    @OnClick(R.id.btcancelar)
    public void cacnelaraccion(View v){
        finish();
    }
}
