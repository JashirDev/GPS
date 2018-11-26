package com.example.gamer.apploginv2.servicios;

import com.example.gamer.apploginv2.modelo.Familia;
import com.example.gamer.apploginv2.modelo.Productoresponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Url;

public interface Apiservicio {

    @GET
    Call<ArrayList<Familia>> obternerlista(@Url String a);

    @FormUrlEncoded
    @PUT("actualizarG")
    Call<Productoresponse> actualizar(
            @Field("id") String id,
            @Field("precio") String precio,
            @Field("idficador") String idficador,
            @Field("idtienda") String idtienda,
            @Field("fecha") String fecha
    );
}
