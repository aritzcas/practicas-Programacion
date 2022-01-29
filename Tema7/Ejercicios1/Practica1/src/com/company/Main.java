package com.company;

import Modelos.Persona;
import Vistas.altaPersonas;
import Vistas.pantallaFinal;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Persona> lista=new ArrayList();
    private static JFrame altaPersonas, vista2;
    public static void main(String[] args) {

        altaPersonas= new JFrame("altaPersonas");
        altaPersonas.setContentPane(new altaPersonas().enseñarPanel());
        altaPersonas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        altaPersonas.setVisible(true);
        altaPersonas.pack();
    }

    public static void guardarPersona(String nombre, String apellido, String dni){
        lista.add(new Persona(nombre,apellido,dni));
    }
    public static void mostrarDatos(){
        String cadena="";
        for (Persona p: lista){
            cadena+=p.toString();
        }
        //altaPersonas.dispose();
        JFrame vista2 = new JFrame("pantallaFinal");
        vista2.setContentPane(new pantallaFinal(cadena).enseñarPanel());
        vista2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista2.setLocationRelativeTo(null);
        vista2.pack();
        vista2.setVisible(true);
    }
}
