package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final ArrayList<Alumno> alumnos = new ArrayList();

    public static void main(String[] args) {
        pedirAlumnos();
        int contador;
        do {
           contador= pedirCodigo();
        }while (contador<0);

        cadenaAlumno(contador);

    }

    public static void pedirAlumnos() {
        do {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el codigo del Alumno:"));
            String nombre = JOptionPane.showInputDialog("Introduce el nombre del Alumno:");
            String calle = JOptionPane.showInputDialog("Introduce el nombre de la calle del Alumno:");
            int telefono = Integer.parseInt(JOptionPane.showInputDialog("Introduce el telefono del Alumno:"));

            alumnos.add(new Alumno(codigo, nombre, calle, telefono));

        } while (JOptionPane.showConfirmDialog(null, "Hay mas alumnos") == 0);
    }

    public static int pedirCodigo() {
        AtomicInteger contador = new AtomicInteger(0);
        AtomicInteger x = new AtomicInteger(-1);

        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el codigo del Alumno que quieres buscar:"));

            alumnos.forEach(alumno -> {
                System.out.println(alumno.getCodigo() == codigo);
                if (alumno.getCodigo() == codigo) {
                    x.set(contador.intValue());

                }
                contador.getAndAdd(1);
            });

            if (x.intValue() == -1) {
                JOptionPane.showMessageDialog(null, "No hay ningun alumno con ese codigo.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El codigo es numerico ");
            return -1;
        }

        return x.intValue();
    }

    public static void cadenaAlumno(int contador) {
        String cadena = "Alumno: \n";
        cadena +="Codigo: "+ alumnos.get(contador).getCodigo() + "\n";
        cadena +="Nombre: "+  alumnos.get(contador).getNombre() + "\n";
        cadena +="Domicilio: "+  alumnos.get(contador).getDomicilio() + "\n";
        cadena +="Telefono: "+  alumnos.get(contador).getTelefono();
        JOptionPane.showMessageDialog(null, cadena);
    }
}

