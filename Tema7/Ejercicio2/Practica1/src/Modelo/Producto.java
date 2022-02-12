package Modelo;

import java.util.ArrayList;

public class Producto {
    private String nombre;
    private float precioUnidad;
    private int numUnidades;

    private ArrayList<Proveedor> listaProveedores;

    public Producto(String nombre, float precioUnidad, int numUnidades) {
        this.nombre = nombre;
        this.precioUnidad = precioUnidad;
        this.numUnidades = numUnidades;

        listaProveedores= new ArrayList<>();
    }

    public Producto() {

    }

    public ArrayList<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(Proveedor pro) {
        this.listaProveedores.add(pro);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getNumUnidades() {
        return numUnidades;
    }

    public void setNumUnidades(int numUnidades) {
        this.numUnidades = numUnidades;
    }
    public void cambiarUnidades(int unidadesNuevas,float precioNuevo) {
        this.numUnidades = this.numUnidades+unidadesNuevas;
        setPrecioNuevo(unidadesNuevas,precioNuevo);
    }
    public void setPrecioNuevo(int unidadesNuevas, float precioNuevo){
        precioUnidad = ((this.numUnidades * this.precioUnidad) + (unidadesNuevas * precioNuevo))/(this.numUnidades+ unidadesNuevas);
    }
}
