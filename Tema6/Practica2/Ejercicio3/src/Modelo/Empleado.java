package Modelo;

import java.util.ArrayList;

public class Empleado extends Persona{
    private float saldoBruto;

    public Empleado(String nombre, int edad, float saldoBruto) {
        super(nombre, edad);
        this.saldoBruto = saldoBruto;
    }
}
