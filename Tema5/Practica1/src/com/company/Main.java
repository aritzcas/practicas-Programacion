package com.company;

import Excepciones.NumeroNoValido;
import Excepciones.OpcionNoValida;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final List<Integer> numeros = new ArrayList<Integer>();

    public static void main(String[] args) {
        pedirNumero();
        int opcion = mostrarMenu();
        llevarOperacion(opcion);
    }

    public static void pedirNumero() {
        boolean error = true;
        do {
            try {
                int numero = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el numero que quieres guardar"));
                if (numero < 0) {
                    throw new NumeroNoValido();
                } else {
                    numeros.add(numero);
                    error = false;
                }
            } catch (NumeroNoValido e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error en el numero");
                error = true;
            }
        } while (error || javax.swing.JOptionPane.showConfirmDialog(null, "Quieres continuar") == 0);
    }

    public static int mostrarMenu() {
        int opcion = 0;
        boolean error = true;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1 Visualizar el valor maximo y el minimo \n" +
                        "2 Solicitar un numero y buscarlo. Muestra un mensaje indicando si lo has encontrado o no. \n" +
                        "3 Solicitar un numero, buscarlo y borrarlo. Sino se encuentra muestra un mensaje de error. \n" +
                        "4 Convertir el arrayList en un array. \n" +
                        "5 Si no esta vacio, mostrar el numero de elementos que contiene. \n" +
                        "6 Insertar un nuevo elemento por el final. \n" +
                        "7 Insertar un nuevo elemento en la posicion que te indique el usuario. \n" +
                        "8 Borrar un elemento de una posicion concreta. \n" +
                        "9 Calcular la suma y la media aritmetica de los valores contenidos. \n" +
                        "10 Finalizar. "));
                if (opcion > 10 || opcion < 1) {
                    throw new OpcionNoValida();
                } else
                    error = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La opción tiene que ser un número");
                error = true;
            } catch (OpcionNoValida e) {
                JOptionPane.showMessageDialog(null, "La opción tiene que ser entre 1 y 10");
            }
        }
        while (error);
        return opcion;
    }

    public static void llevarOperacion(int opcion) {
        while (opcion != 10) {
            switch (opcion) {
                case 1:
                    valorMaxyMin();
                    break;
                case 2:
                    buscarNumero();
                    break;
                case 3:
                    buscaryBorrar();
                    break;
                case 4:
                    arrayListtoArray();
                    break;
                case 5:
                    sumarDiagonalInversa();
                    break;
                case 6:
                    calcularMedia();
                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "Hasta otra");
                    break;
            }
        }

    }

    public static void valorMaxyMin() {
        int numMax = Collections.max(numeros);
        int numMin = Collections.min(numeros);

        javax.swing.JOptionPane.showMessageDialog(null, "El valor maximo es " + numMax + " y el valor minimo " + numMin);
    }

    public static void buscarNumero() {
        int num = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el numero a buscar."));

        if (numeros.contains(num)){
            javax.swing.JOptionPane.showMessageDialog(null, "SI he encontrado el numero.");
        }else{
            javax.swing.JOptionPane.showMessageDialog(null, "NO he  encontrado el numero.");
        }
    }

    public static void buscaryBorrar() {
        int num = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el numero a buscar."));

        if (numeros.contains(num)){
            numeros.remove(num);
            javax.swing.JOptionPane.showMessageDialog(null, "Numero borrado.");
        }else{
            javax.swing.JOptionPane.showMessageDialog(null, "NO he  encontrado el numero.");
        }
    }

    public static void arrayListtoArray(){
        
    }
}
