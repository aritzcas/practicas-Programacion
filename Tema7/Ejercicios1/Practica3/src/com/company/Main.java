package com.company;

import Vistas.Principal.vistaPrincipal;
import Vistas.Ventas.vistaVentas;

import javax.swing.*;
import java.util.ArrayList;
import Modelos.*;
import Vistas.*;
public class Main {
    private static JFrame vistaP, vistaV;
    private static ArrayList<Producto> listaProductos;

    public static void main(String[] args) {
        generarPrductos();
        mostarVentanaPrincipa();


    }

    public static void generarPrductos() {
        listaProductos = new ArrayList<>();

    }

    public static void mostarVentanaPrincipa() {
        vistaP = new JFrame("vistaPrincipal");
        vistaP.setContentPane(new vistaPrincipal().getPrincipal());
        vistaP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaP.pack();
        vistaP.setVisible(true);
        vistaV.dispose();
    }

    public static void verVentas() {
        vistaV = new JFrame("vistaVentas");
        vistaV.setContentPane(new vistaVentas().getVentas());
        vistaV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        vistaV.pack();
        vistaV.setVisible(true);
        vistaP.dispose();
    }

    public static void fCancelar() {

    }
}
