package com.company;

import Modelo.BD.*;
import Modelo.UML.Evento;
import Vistas.VentanaPrincipal;
import Vistas.vistaSecundaria;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

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
    public static void mostarVentanaSecundaria(String opcion) {
        vistaSecundaria dialog = new vistaSecundaria(opcion);
        dialog.pack();
        dialog.setVisible(true);

    }
    public static void insertar(String nombre, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, int numPersonas) throws Exception {
        Evento e = new Evento(nombre,lugar,fecha,horaInicio,horaFin,numPersonas);
        EventosDAO.insertar(e);
    }

    public static void borrarEvento(String text) throws Exception {
        Evento e = new Evento(text);
        EventosDAO.borrarEvento(e);
    }
    public static Evento buscarEvento(String text) throws Exception {
        Evento e = new Evento(text);
        Evento eventoRelleno=EventosDAO.buscarEvento(e);

        return eventoRelleno;
    }

    public static void updateEvento(String nombre, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, int numPersonas, String nombreViejo) throws Exception {
        Evento e = new Evento(nombre,lugar,fecha,horaInicio,horaFin,numPersonas);
        EventosDAO.updateEvento(e, nombreViejo);
    }
}
