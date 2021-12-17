package Clases;

import java.time.LocalDate;

public class Persona {
    String nombre;
    int dNacimiento;
    int mNacimiento;
    int aNacimiento;
    String direccion;
    int codigoPostal;
    String ciudad;

    public Persona(String nombre, int dNacimiento, int mNacimiento, int aNacimiento, String direccion, int codigoPostal, String ciudad) {
        this.nombre = nombre;
        this.dNacimiento = dNacimiento;
        this.mNacimiento = mNacimiento;
        this.aNacimiento = aNacimiento;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;

    }

    public String getNombre() {
        return nombre;
    }

    public int getdNacimiento() {
        return dNacimiento;
    }

    public int getmNacimiento() {
        return mNacimiento;
    }

    public int getaNacimiento() {
        return aNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }
}
