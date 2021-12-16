package com.company;

import javax.swing.*;
import Excepciones.*;
public class Main {

    public static void main(String[] args) {
        try{
            menu();
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public static void menu() throws Exception {
        int opcion = 0;
        boolean error = true;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1 Longitud de una Circunferencia \n" +
                        "2 Area de una Circunferencia. \n" +
                        "3 Volumen de una Esfera . \n"));
                if (opcion > 3 || opcion < 1) {
                    throw new OpcionNoValida();
                } else
                    error = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La opción tiene que ser un número");
                error = true;
            } catch (OpcionNoValida e) {
                JOptionPane.showMessageDialog(null, "La opción tiene que ser entre 1 y 3");
            }
        }
        while (error);
        llevarOperacion(opcion);
    }
    public  static void llevarOperacion(int opcion){
        switch (opcion){
            case 1:
                longitud();
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    public  static void longitud(){
        Radio rad = null;

        rad.setRad(Integer.parseInt(JOptionPane.showInputDialog("introduce el radio")));
        int resultado;
        double pi=Math.PI;
        resultado=2 * pi * rad;
    }
}
