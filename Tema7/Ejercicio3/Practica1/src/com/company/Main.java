package com.company;

import Clases.Cliente;
import Vistas.VentanaP;

public class Main {
    private static Cliente[] listaClientes;
    public static void main(String[] args) {
        generarClientes();
        new VentanaP();
    }

    public static void generarClientes(){
        listaClientes =new Cliente[3];

        listaClientes[0]=new Cliente("18028396Z","Alberto Garcia",12345);
        listaClientes[1]=new Cliente("91028365A","Pedro Lopez",67890);
        listaClientes[2]=new Cliente("52739173B","Ana Martinez",13579);
    }

    public static boolean comprobarClave(String dni, int clave){
        boolean encontrado=false;
        for (int i=0; i<listaClientes.length && !encontrado;i ++){
            if(listaClientes[i].getDNI().equalsIgnoreCase(dni)){
                if (listaClientes[i].getClave() == clave){
                    encontrado=true;
                    return true;
                }
            }

        }
        return false;
    }
    public static boolean comprobarDNI(String dni){
        for (int i=0; i<listaClientes.length;i ++){
            if(listaClientes[i].getDNI().equalsIgnoreCase(dni)){
                    return true;
            }

        }
        return false;
    }
}
