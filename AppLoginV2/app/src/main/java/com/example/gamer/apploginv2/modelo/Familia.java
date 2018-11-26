package com.example.gamer.apploginv2.modelo;

public class Familia {

    private String idficador;
    private String id;
    private String producto;
    private double pre_unit;
    /*private String idtienda;
    private String fecha;*/
/*
    public Familia(String idficador, String id, String producto, double precio, String idtienda, String fecha) {
        this.idficador = idficador;
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.idtienda = idtienda;
        this.fecha = fecha;
    }

    public String getIdficador() {
        return idficador;
    }

    public void setIdficador(String idficador) {
        this.idficador = idficador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getIdtienda() {
        return idtienda;
    }

    public void setIdtienda(String idtienda) {
        this.idtienda = idtienda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }*/

    public Familia(String idficador, String id, String producto, double pre_unit) {
        this.idficador = idficador;
        this.id = id;
        this.producto = producto;
        this.pre_unit = pre_unit;
    }

    public String getIdficador() {
        return idficador;
    }

    public void setIdficador(String idficador) {
        this.idficador = idficador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPre_unit() {
        return pre_unit;
    }

    public void setPre_unit(double pre_unit) {
        this.pre_unit = pre_unit;
    }
}
