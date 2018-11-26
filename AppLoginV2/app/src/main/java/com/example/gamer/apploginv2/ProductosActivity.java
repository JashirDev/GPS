package com.example.gamer.apploginv2;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.gamer.apploginv2.adaptadores.FamiliaAdapter;
import com.example.gamer.apploginv2.modelo.Familia;
import com.example.gamer.apploginv2.servicios.Apiservicio;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductosActivity extends AppCompatActivity {

    @BindView(R.id.reciclador)
    RecyclerView reciclador;
    ArrayList<Familia> lisa;
    FamiliaAdapter adapter;
    Retrofit retrofit;
    private String nombre="";
    String url;
    Apiservicio servicio;
    Call<ArrayList<Familia>> call;
    String idtienda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        ButterKnife.bind(this);
        reciclador.setLayoutManager(new LinearLayoutManager(this));

        Bundle parametros = this.getIntent().getExtras();
        nombre = parametros.getString("familia");
        idtienda= parametros.getString("tienda");



        //-------- contatenar  idificador , idtienda y fecha


        retrofit = new Retrofit.Builder()
                .baseUrl("http://35.185.74.160/Productos3/")//el que funciona era era sin el 2
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Consultar2(nombre);
    }

    private void Consultar2( String entrada){
        switch (entrada){
            case "Familia Vegetal":
                url = "Vegetal/"+idtienda; //era String url
                Log.e("aa",url);
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                    String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();
                                    String idificador=lisa.get(reciclador.getChildAdapterPosition(view)).getIdficador();
                                    Log.e("apsra", nombreitem +" "+ precio +" "+  iditem +" "+  idificador);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                   i.putExtra("iditem", iditem );
                                    i.putExtra("idificador", idificador);
                                    i.putExtra("idtienda",idtienda);
                                   startActivity(i);
                                   // String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   // Log.e("apsra", "paso"+nombreitem);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;



            case "Arroz":
                url ="arroz/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    i.putExtra("idtienda",idtienda);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });

                break;

            case "azucar":
                url ="azucar/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    i.putExtra("idtienda",idtienda);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });

                break;

            case"Bebidas":
                url ="bebidas/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    i.putExtra("idtienda",idtienda);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });

                break;
            case"carne de cerdo":
                url ="cerdo/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    i.putExtra("idtienda",idtienda);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });

                break;
            case"carne de pollo":

                url ="pollo/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    i.putExtra("idtienda",idtienda);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;
            case"carne vacuno":

                url ="vacuno/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    i.putExtra("idtienda",idtienda);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;
            case"comida":

                url ="comida/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    i.putExtra("idtienda",idtienda);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;
            case"crema dental":

                url ="dental/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    i.putExtra("idtienda",idtienda);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;
            case"detergente":
                url ="detergente/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    i.putExtra("idtienda",idtienda);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });

                break;
            case"embutidos":

                url ="embutido/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    i.putExtra("idtienda",idtienda);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;
            case"enlatados":

                url ="enlatado/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    i.putExtra("idtienda",idtienda);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;
            case"frutas":
                url ="fruta/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    i.putExtra("idtienda",idtienda);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });

                break;
            case"galletas":
                url ="galleta/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;
            case"gaseosas":
                url ="gaseosa/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;
            case"harinas":
                url ="harina/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });

                break;
            case"infusiones":

                url ="infucion/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;
            case"jabon de lavar":
                url ="jabon/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });

                break;
            case"lavavajillas":

                url ="lavavajilla/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;
            case"leche":

                url ="leche/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;
            case"Mantequilla":
                url ="mantequilla/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                //mayonesa

                break;


            case"Mayonesa":
                url ="mayonesa/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;
            case"Pan":

                url ="pan/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;


            case"pañales":

                url ="panal/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;

            case"paneton":

                url ="paneton/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;

            case"papel higienico":

                url ="papelhi/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;

            case"postres":

                url ="postre/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;

            case"queso":

                url ="queso/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;

            case"snacks":

                url ="snack/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;

            case"suavizante":

                url ="suavizante/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;

            case"toallitas humedas":

                url ="toallahumeda/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;

            case"turron":

                url ="turron/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;


            case"verduras":

                url ="verdura/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;


            case"yogurt":

                url ="yogurt/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;
            case"pavo":

                url ="pavo/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;

            case"fideos":

                url ="fideos/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;

            case"pan embolsado":

                url ="panembolsado/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });
                break;

            case"alcoholicas":
                url ="bebidac/"+idtienda;
                servicio = retrofit.create(Apiservicio.class);
                call  = servicio.obternerlista(url);
                call.enqueue(new Callback<ArrayList<Familia>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Familia>> call, Response<ArrayList<Familia>> response) {
                        if(response.isSuccessful()){
                            lisa= response.body();





                            adapter = new FamiliaAdapter(lisa);
                            adapter.setonclciklsitener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(ProductosActivity.this,CambiosActivity.class);
                                    String nombreitem= lisa.get(reciclador.getChildAdapterPosition(view)).getProducto();
                                   String precio= String.valueOf(lisa.get(reciclador.getChildAdapterPosition(view)).getPre_unit());
                                    String iditem= lisa.get(reciclador.getChildAdapterPosition(view)).getId();

                                    i.putExtra("idificador", url);
                                    i.putExtra("nombreitem", nombreitem);
                                    i.putExtra("precio", precio);
                                    i.putExtra("iditem", iditem);
                                    startActivity(i);


                                }
                            });
                            reciclador.setAdapter(adapter);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Familia>> call, Throwable t) {

                    }
                });

                break;


        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        Consultar2(nombre);
        Log.e("resumen","resumen");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Consultar2(nombre);
        Log.e("pasua","pausa");
    }
}
