package Modelo.UML;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private int edad;
    private Empresa empresa;

    private ArrayList<Acontecimiento> listaEventos;
    public Persona() {

    }

    public Persona(String nombre, int edad, Empresa empresa) {
        this.nombre = nombre;
        this.edad = edad;
        this.empresa = empresa;
        listaEventos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
