package Modelo;

import java.util.ArrayList;

public class Directivo extends Empleado{
    private  String categoria;
    private ArrayList<Empleado> subordinados;

    public Directivo(String nombre, int edad, float saldoBruto, String categoria, ArrayList<Empleado> subordinados) {
        super(nombre, edad, saldoBruto);
        this.categoria = categoria;
        this.subordinados = subordinados;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Empleado> getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(ArrayList<Empleado> subordinados) {
        this.subordinados = subordinados;
    }
}
