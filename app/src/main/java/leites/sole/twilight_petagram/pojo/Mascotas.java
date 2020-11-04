package leites.sole.twilight_petagram.pojo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;

public class Mascotas implements Serializable {
    private int id;
    private String nombre;
    private int likes;
    private int imagen;
    private String orden;

    public Mascotas(String nombre,int likes, int imagen, String orden){
        this.nombre = nombre;
        this.likes = likes;
        this.imagen = imagen;
        this.orden = orden;
    }

    public Mascotas(String nombre, int likes, int imagen) {
        this.nombre = nombre;
        this.likes = likes;
        this.imagen = imagen;
    }

    public Mascotas(int likes, int imagen){
        this.likes = likes;
        this.imagen = imagen;
    }

    public Mascotas() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getlikes() {
        return likes;
    }

    public void setlikes(int likes) {
        this.likes = likes;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public void suma(){this.likes = likes + 1;}
}