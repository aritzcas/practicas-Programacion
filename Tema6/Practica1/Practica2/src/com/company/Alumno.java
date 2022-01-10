package com.company;

public class Alumno {
    int codigo;
    String nombre;
    String domicilio;
    int telefono;

    public Alumno(int codigo, String nombre, String domicilio, int telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public int getTelefono() {
        return telefono;
    }
}
