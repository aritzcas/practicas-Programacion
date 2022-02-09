package Modelo;

public class Proveedor {
     private  String Nombre;

    public Proveedor(String nombre) {
        Nombre = nombre;
    }

    public Proveedor() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
