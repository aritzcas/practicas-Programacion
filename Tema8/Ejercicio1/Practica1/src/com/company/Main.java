package com.company;

import Modelo.BD.BasedeDatos;
import Modelo.BD.PersonaDAO;
import Modelo.Persona;
import Vistas.ventanaPrincipal;
import Vistas.ventanaSecundaria;
import sun.print.BackgroundServiceLookup;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    private static BasedeDatos bd;
    private static PersonaDAO pdao;
    private static Persona p;

    public static void main(String[] args){
        try{
            bd = new BasedeDatos();
            pdao = new PersonaDAO(bd.getConnection());
            mostrarVentana();
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, e);
        }


    }

    public static void mostrarVentana() {
        JFrame frame = new JFrame("ventanaPrincipal");
        frame.setContentPane(new ventanaPrincipal().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void mostrarSecundaria(String opcion){
        ventanaSecundaria dialog = new ventanaSecundaria(opcion);
        dialog.pack();
        dialog.setVisible(true);
    }
    public static void comprobarOpcion(String text) throws Exception {
        if (text.equalsIgnoreCase("1")){
            mostrarSecundaria(text);
            System.out.println(text);
        }else if (text.equalsIgnoreCase("2")){
            mostrarSecundaria(text);
            System.out.println(text);
        }else if (text.equalsIgnoreCase("3")){
            mostrarSecundaria(text);
            System.out.println(text);
        }else{
            System.out.println(text);
            bd.desconectar();
            System.exit(1);
        }
    }
    public static void tenDatos(String nombre, int edad, String profesion, String telefono){
        try {
            p = new Persona(nombre, edad, profesion, telefono);
            pdao.insertPersona(p);
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, e.getClass());
        }

    }

    public static boolean validarNombre(String text) {
        try{
            Pattern p = Pattern.compile( "^[a-zA-Z\\s]+");

        Matcher m = p.matcher(text);
        if (!m.matches()){
            throw new Exception("Nombre no correcto");
        }
        return  true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static void tenDato(String text) {
        p = new Persona(text);

    }

    public static void getNombre(String text) {
    }
}

