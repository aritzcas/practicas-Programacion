package Clases;

import javafx.fxml.LoadException;

import java.time.LocalDate;

public class Persona {
    String nombre;
    LocalDate fecha;
    String direccion;
    String codigoPostal;
    String ciudad;

    public Persona(String nombre, LocalDate fecha, String direccion, String codigoPostal, String ciudad) {
        this.nombre = nombre;
        this.fecha =fecha;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;

    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }
}
