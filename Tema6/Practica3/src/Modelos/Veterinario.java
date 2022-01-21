package Modelos;

import java.util.ArrayList;

public class Veterinario extends Persona{
    private String DNI;
    private int seguridadSocial;

    public Veterinario(String nombre, String direccion, int telefono,  String DNI, int seguridadSocial) {
        super(nombre, direccion, telefono);
        this.DNI = DNI;
        this.seguridadSocial = seguridadSocial;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getSeguridadSocial() {
        return seguridadSocial;
    }

    public void setSeguridadSocial(int seguridadSocial) {
        this.seguridadSocial = seguridadSocial;
    }
}
