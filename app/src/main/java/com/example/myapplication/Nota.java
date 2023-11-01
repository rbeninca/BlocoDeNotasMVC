package com.example.myapplication;

public class Nota {
    int id;
    String titulo;
    String txt;
    public Nota(int id , String titulo, String txt) {
        this.id = id;
        this.titulo = titulo;
        this.txt = txt;
    }
    public  Nota (String titulo, String txt){
        this.titulo = titulo;
        this.txt = txt;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
