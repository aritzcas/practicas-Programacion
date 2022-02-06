package com.company;

import Vistas.Principal.vistaPrincipal;
import Vistas.Ventas.cuadroVentas;

import javax.swing.*;
import java.util.ArrayList;
import Modelos.*;

public class Main {
    private static JFrame vistaP;
    private static JDialog  cuadroVentas, cuadroProducto;

    private static ArrayList<Producto> listaProductos;
    public static void main(String[] args) {
        generarPrductos();
        mostarVentanaPrincipa();


    }

    public static void generarPrductos() {
        listaProductos = new ArrayList<>();
        listaProductos.add(new Producto ("Platano",0.90f,200));
        listaProductos.add(new Producto ("Naranjas",2.0f,50));
        listaProductos.add(new  Producto ("Zanahorias",2.2f,20));
        listaProductos.add(new Producto ("Lechuga",2.3f,18));
        listaProductos.add(new Producto ("Fresas",4f,76));
        listaProductos.add(new Producto ("Piña",4f,28));


    }

    public static void mostarVentanaPrincipa() {
        vistaP = new JFrame("vistaPrincipal");
        vistaP.setContentPane(new vistaPrincipal().getPrincipal());
        vistaP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaP.pack();
        vistaP.setVisible(true);

    }
       public static void verVentas() {
        cuadroVentas = new cuadroVentas();
        cuadroVentas.pack();
        cuadroVentas.setVisible(true);
        //System.exit(0);
        
    }
   
    public static void fCancelar() {

    }

    public static void registarVenta(String text) {
    }
}
