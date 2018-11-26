package com.example.gamer.apploginv2.modelo;

public class Productoresponse {
    private boolean error;
    private String message;
    private Familia familia;

    public Productoresponse(boolean error, String message, Familia familia) {
        this.error = error;
        this.message = message;
        this.familia = familia;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
}
