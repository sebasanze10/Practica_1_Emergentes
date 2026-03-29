package com.example.Practica_1;

import java.util.List;

public class Peliculas {
    private String nombre;
    private String fechaEstreno;
    private List<String> generos;
    private String descripcion;

    public Peliculas(String nombre, String fechaEstreno, List<String> generos, String descripcion) {
        this.nombre = nombre;
        this.fechaEstreno = fechaEstreno;
        this.generos = generos;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public String getFechaEstreno() { return fechaEstreno; }
    public List<String> getGeneros() { return generos; }
    public String getDescripcion() { return descripcion; }
}