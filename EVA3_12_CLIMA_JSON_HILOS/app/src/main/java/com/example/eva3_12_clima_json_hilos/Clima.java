package com.example.eva3_12_clima_json_hilos;


public class Clima {
    private int imagen_clima;
    private  String ciudad;
    private  String clima;
    private  String desc_clima;
    private double temperatura;

    public Clima(int imagen_clima, String ciudad, String clima, String desc_clima, double temperatura) {
        this.setImagen_clima(imagen_clima);
        this.setCiudad(ciudad);
        this.setClima(clima);
        this.setDesc_clima(desc_clima);
        this.setTemperatura(temperatura);
    }

    public Clima() {

    }

    public int getImagen_clima() {
        return imagen_clima;
    }

    public void setImagen_clima(int imagen_clima) {
        this.imagen_clima = imagen_clima;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getDesc_clima() {
        return desc_clima;
    }

    public void setDesc_clima(String desc_clima) {
        this.desc_clima = desc_clima;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}

