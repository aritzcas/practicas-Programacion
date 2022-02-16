package Modelo;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private ArrayList<Producto> listaProductos;

    public Cliente(String nombre) {
        this.nombre = nombre;
        listaProductos=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    public void setProductos(Producto p) {
        this.listaProductos.add(p);
    }
}
