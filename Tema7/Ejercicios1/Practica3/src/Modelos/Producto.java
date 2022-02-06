package Modelos;

public class Producto {
    String Nombre;
    float precioUnidad;
    int numUnidades;

    public Producto(String nombre, float precioUnidad, int numUnidades) {
        Nombre = nombre;
        this.precioUnidad = precioUnidad;
        this.numUnidades = numUnidades;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
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
}
