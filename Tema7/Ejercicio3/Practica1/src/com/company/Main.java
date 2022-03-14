package com.company;

import Clases.Cliente;
import Clases.Cuenta;
import Vistas.Login;
import Vistas.VentanaP;
import Vistas.VentanaT;

import java.util.ArrayList;

public class Main {
    private static Cliente[] listaClientes;
    private static Cuenta[] Cuentas;
    private static Cliente cliente;
    public static void main(String[] args) {
        generarDatos();
        new VentanaP();
    }

    public static void generarDatos(){
        listaClientes =new Cliente[3];

        listaClientes[0]=new Cliente("18028396Z","Alberto Garcia",12345);
        listaClientes[1]=new Cliente("91028365A","Pedro Lopez",67890);
        listaClientes[2]=new Cliente("52739173B","Ana Martinez",13579);

        Cuentas=new Cuenta[6];
        Cuentas[0]= new Cuenta(0101010101,200f);
        Cuentas[1]= new Cuenta(0101010102,100f);
        Cuentas[2]= new Cuenta(0101010103,50f);
        Cuentas[3]= new Cuenta(0101010104,150f);
        Cuentas[4]= new Cuenta(0101010105,250f);
        Cuentas[5]= new Cuenta(0101010106,300f);

        ArrayList<Cuenta> listasCuenta=new ArrayList<>();
        listasCuenta.add(Cuentas[0]);
        listaClientes[0].setListaCuentas(listasCuenta);
        listasCuenta=new ArrayList<>();
        listasCuenta.add(Cuentas[1]);
        listasCuenta.add(Cuentas[2]);
        listaClientes[1].setListaCuentas(listasCuenta);
        listasCuenta=new ArrayList<>();
        listasCuenta.add(Cuentas[3]);
        listasCuenta.add(Cuentas[4]);
        listasCuenta.add(Cuentas[5]);
        listaClientes[2].setListaCuentas(listasCuenta);
    }

    public static boolean comprobarClave(String dni, int clave){
        boolean encontrado=false;
        for (int i=0; i<listaClientes.length && !encontrado;i ++){
            if(listaClientes[i].getDNI().equalsIgnoreCase(dni)){
                if (listaClientes[i].getClave() == clave){
                    encontrado=true;
                    cliente=listaClientes[i];
                    return true;
                }
            }

        }
        return false;
    }
    public static Cliente darCliente(){
        return cliente;
    }
    public static boolean comprobarDNI(String dni){
        for (int i=0; i<listaClientes.length;i ++){
            if(listaClientes[i].getDNI().equalsIgnoreCase(dni)){
                    return true;
            }

        }
        return false;
    }
    public static void mostrarLogin(){
        Login dialog = new Login();
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void mostrarT(String dni){
        VentanaT dialog = new VentanaT(dni);
        dialog.pack();
        dialog.setVisible(true);
    }
}
