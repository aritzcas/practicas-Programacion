package com.company;

import Modelo.Cliente;
import Modelo.Producto;
import Modelo.Proveedor;
import Vista.Principal;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    private static Producto[] listaProducto;
    private static ArrayList<Cliente> listaCliente;
    private static Proveedor[] listaProveedor;
    private static Producto p;
    private static ArrayList<Proveedor> aProv;
    private static float precioUni;
    private static String cadena="";
    public static void main(String[] args) {
        generarProductos();

        mostrarVentana();

    }

    public static void generarProductos(){
        listaProveedor =new Proveedor[5];
        listaProveedor[0] = new Proveedor();
        listaProveedor[0].setNombre("Aritz");
        listaProveedor[1] = new Proveedor();
        listaProveedor[1].setNombre("Alex");
        listaProveedor[2] = new Proveedor();
        listaProveedor[2].setNombre("Maria");
        listaProveedor[3] = new Proveedor();
        listaProveedor[3].setNombre("Eva");

        listaProducto =new Producto[3];
        listaProducto[0] = new Producto();
        listaProducto[0]= new Producto("Pan",1.1f,100);
        listaProducto[1] = new Producto();
        listaProducto[1] = new Producto("Manzanas",0.9f,50);
        listaProducto[2] = new Producto();
        listaProducto[2] = new Producto("Zapatillas",15f,25);


        listaProducto[0].setListaProveedores(listaProveedor[0]);

        listaProducto[1].setListaProveedores(listaProveedor[0]);
        listaProducto[1].setListaProveedores(listaProveedor[3]);
        listaProducto[1].setListaProveedores(listaProveedor[2]);

        listaProducto[2].setListaProveedores(listaProveedor[1]);
        listaProducto[2].setListaProveedores(listaProveedor[4]);

        listaCliente = new ArrayList<>();
    }
    public static boolean buscarProducto(String producto){
        int x;
        for (x=0; x < listaProducto.length && listaProducto[x].getNombre().compareToIgnoreCase(producto)!=0;x++){}
        if (x == listaProducto.length)
            return false;

        p = listaProducto[x];
        return true;
    }
   /* public static float buscarPrecioPro(String producto){
        int x;
        for (x=0; x < listaProducto.length && listaProducto[x].getNombre().compareToIgnoreCase(producto)!=0;x++){}

       precioUni = listaProducto[x].getPrecioUnidad();
        return precioUni;
    }*/
    public static ArrayList<Proveedor> buscarProveedores(String nombre){
        int x=0;
        for (x=0; x < listaProducto.length && listaProducto[x].getNombre().compareToIgnoreCase(nombre)!=0;x++){}


        aProv = listaProducto[x].getListaProveedores();
       return aProv;
    }
    public static void guardarcompra( int unidades, float precioTotal){
        p.cambiarUnidades(unidades,precioTotal);
    }

    public static void enseñarCompra(){
        JOptionPane.showMessageDialog(null, cadena);
    }
    public static void mostrarVentana() {
        JFrame frame = new JFrame("Principal");
        frame.setContentPane(new Principal().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}
