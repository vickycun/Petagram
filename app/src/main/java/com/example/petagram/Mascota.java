package com.example.petagram;

public class Mascota {

    private String nombre;
    private String num;
    private int foto;

    public Mascota(int foto, String nombre, String num) {
        this.foto   = foto;
        this.nombre = nombre;
        this.num    = num;
         }

    // a continuación van los getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
