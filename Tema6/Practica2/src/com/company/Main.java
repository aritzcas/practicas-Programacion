package com.company;

import Excepciones.CodigoNoValido;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static final ArrayList<Alumno> alumnos = new ArrayList();

    public static void main(String[] args) {
        pedirAlumnos();
        int contador=pedirCodigo();
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
        boolean error = true;
        int contador = 0;
        do {
            try {
                int codigo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el codigo del Alumno que quieres buscar:"));
                int x;
                for (x = 0; x < alumnos.size(); x++) {
                    if (alumnos.get(x).getCodigo() == codigo) {
                        System.out.println(alumnos.get(x).getCodigo());
                        contador = x;
                        error = false;
                    }
                }
                if (contador!=x){
                    JOptionPane.showMessageDialog(null, "No hay ningun alumno con ese codigo.");
                    error=true;
                }

            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"El codigo es numerico ");
                error=false;
            }
        } while (error);
    return contador;
    }
    public static void cadenaAlumno(int contador){
        String cadena="";
        cadena+=alumnos.get(contador).getCodigo()+ "\n";
        cadena+=alumnos.get(contador).getNombre()+ "\n";
        cadena+=alumnos.get(contador).getDomicilio()+ "\n";
        cadena+=alumnos.get(contador).getTelefono();
        JOptionPane.showMessageDialog(null,cadena);
    }
}

