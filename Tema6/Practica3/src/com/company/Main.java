package com.company;


import Modelos.*;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    private static final ArrayList<Mascota> listaMascota = new ArrayList<>();
    private static final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static final ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();

    public static void main(String[] args) {
        try
        {
            guardarDatos();
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"El programa termina");
        }
        catch(Exception e)
        {
            System.out.println("Problemas: " + e.getClass());
        }

    }
    public static void guardarDatos(){
            guardarVeterinarios();
            crearMascotas();
    }


    public static void guardarVeterinarios() {
        boolean mas = true;
        while (mas) {
            try {

                String nombre = JOptionPane.showInputDialog("Introduce el nombre de la veterinario:");
                String direccion = JOptionPane.showInputDialog("Introduce la direccion:");
                int telefono  =Integer.parseInt(JOptionPane.showInputDialog("Introduce el telefono:"));
                String dni = JOptionPane.showInputDialog("Introduce el DNI: ");
                int numsocial =Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de la seguridad social: "));

                listaVeterinarios.add(new Veterinario(nombre,direccion,telefono,dni,numsocial));

            } catch (Exception e) {
                System.out.println(e.getClass());
            }
            int respuesta = JOptionPane.showConfirmDialog(null,"¿Hay más veterinarios?");
            if (respuesta != 0)
                mas = false;
        }
    }





    public static void crearMascotas() {
        do {
            try {

                String nombre = JOptionPane.showInputDialog("Introduce el nombre de la mascota");
                int dia = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dia de Alta del cliente."));
                int mes = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes de Alta del cliente."));
                int ano = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de Alta del cliente."));
                String sexo = JOptionPane.showInputDialog("Introduce el sexo de la mascota.");
                float peso = Float.parseFloat(JOptionPane.showInputDialog("Introduce el peso de la mascota."));
                float longitud = Float.parseFloat(JOptionPane.showInputDialog("Introduce la longitud de la mascota."));
                String tipoMascota=JOptionPane.showInputDialog("De que tipo es tu mascota?");
                String raza=JOptionPane.showInputDialog("De que raza es tu mascota?");
                String tipoPelo = JOptionPane.showInputDialog("Introduce el tipo de pelo de la mascota.");
                String dueno = JOptionPane.showInputDialog("Introduce el dueño de la mascota:");
                String v = JOptionPane.showInputDialog("Introduce el veterinario de la mascota:");
                if(!listaClientes.contains(dueno)){
                    crearCliente();
                    dueno=listaClientes.toString().ge;
                }
                if (!listaVeterinarios.contains(v)){
                    guardarVeterinarios();
                    listaVeterinarios.g;
                }
                Mascota mascota = new Mascota(nombre, LocalDate.of(ano, mes, ano), sexo, peso, longitud, tipoMascota,raza, tipoPelo, dueno,v);
                listaMascota.add(mascota);

            } catch (Exception e) {
                System.out.println(e.getClass());
            }
        } while (JOptionPane.showConfirmDialog(null, "Hay mas mascotas") == 0);
    }

    public static void crearCliente() {
        do {
            try {
                ArrayList <Mascota> lista = new ArrayList();

                String nombre = JOptionPane.showInputDialog("Introduce el nombre del cliente");
                String direccion = JOptionPane.showInputDialog("Introduce la direccion del cliente.");
                int telefono = Integer.parseInt(JOptionPane.showInputDialog("Introduce el telefono del cliente"));
                int dia = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dia de Alta del cliente."));
                int mes = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes de Alta del cliente."));
                int ano = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de Alta del cliente."));
                ArrayList<Mascota> mascotaid=
                Cliente p = new Cliente(nombre, direccion, telefono, , LocalDate.of(ano, mes, dia));
                listaClientes.add(p);
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
        } while (JOptionPane.showConfirmDialog(null, "Hay mas mascotas") == 0);
    }
}
