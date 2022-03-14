package com.company;

import Modelo.BD.*;
import Vistas.VentanaPrincipal;
import Vistas.vistaInsertar;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    private static BaseDatos bd;
    public static void main(String[] args) {
        try {

            bd = new BaseDatos();
            mostrarVentana();

        }
        catch(Exception e)
        {
            System.out.println(e.getClass());
        }
    }

    public static void mostrarVentana() {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void mostarInsertar() {
        vistaInsertar dialog = new vistaInsertar();
        dialog.pack();
        dialog.setVisible(true);

    }
    public static void insertar(String nombre, String lugar, LocalDate fecha, int horaInicio, int horaFin, int numPersonas){

    }
    }
