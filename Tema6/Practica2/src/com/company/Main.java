package com.company;

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Main {

    public static void main(String[] args) {
        ArrayList alumnos = new ArrayList ();

        do {
            int codigo=Integer.parseInt(JOptionPane.showInputDialog("Introduce el codigo del Alumno:"));
            String nombre=JOptionPane.showInputDialog("Introduce el nombre del Alumno:");
            String calle=JOptionPane.showInputDialog("Introduce el nombre de la calle del Alumno:");
            int telefono=Integer.parseInt(JOptionPane.showInputDialog("Introduce el telefono del Alumno:"));

            alumnos.add(new Alumno(codigo,nombre,calle,telefono));

        }while (JOptionPane.showConfirmDialog(null, "Hay mas alumnos")==0);

        System.out.println(alumnos.get(0));
    }
}
