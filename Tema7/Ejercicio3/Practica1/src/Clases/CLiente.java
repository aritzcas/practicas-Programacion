package Clases;

import java.util.ArrayList;

public class CLiente {
    private String DNI;
    private String nombreApellidos;
    private int clave;

    private ArrayList<Cuenta> listaCuentas;

    public CLiente(String DNI, String nombreApellidos, int clave) {
        this.DNI = DNI;
        this.nombreApellidos = nombreApellidos;
        this.clave = clave;

        listaCuentas = new ArrayList<Cuenta>();
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
}
