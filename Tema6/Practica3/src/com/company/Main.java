package com.company;


import Excepciones.DatoNoValido;
import Modelos.Cliente;
import Modelos.Gato;
import Modelos.Mascota;
import Modelos.Veterinario;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    private static final ArrayList<Mascota> listaMascota = new ArrayList<>();
    private static final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static final ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();

    public static void main(String[] args) {
        try {
            guardarDatos();
            menu();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "El programa termina");
        } catch (Exception e) {
            System.out.println("Problemas: " + e.getClass());
        }

    }

    public static void guardarDatos() {

        crearVeterinarios();
        crearMascotas();
    }

    public static void crearVeterinarios() {
        int x = 0;
        do {
            try {
                String nombre = JOptionPane.showInputDialog("Introduce el nombre de la veterinario:");
                String direccion = JOptionPane.showInputDialog("Introduce la direccion:");
                int telefono = Integer.parseInt(JOptionPane.showInputDialog("Introduce el telefono:"));
                String dni = JOptionPane.showInputDialog("Introduce el DNI: ");
                int numsocial = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de la seguridad social: "));

                listaVeterinarios.add(new Veterinario(nombre, direccion, telefono, dni, numsocial));
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
        } while (JOptionPane.showConfirmDialog(null, "¿Hay más veterinarios?") == 0);

    }

    public static void crearMascotas() {
        do {
            try {
                String tipoMascota = JOptionPane.showInputDialog(null, "Es perro o gato)").toLowerCase();
                if (tipoMascota.equalsIgnoreCase("perro")) {
                    String nombre = JOptionPane.showInputDialog("Introduce el nombre de la mascota");
                    int dia = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dia de Alta del cliente."));
                    int mes = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes de Alta del cliente."));
                    int ano = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de Alta del cliente."));
                    String sexo = JOptionPane.showInputDialog("Introduce el sexo de la mascota.");
                    float peso = Float.parseFloat(JOptionPane.showInputDialog("Introduce el peso de la mascota."));
                    float longitud = Float.parseFloat(JOptionPane.showInputDialog("Introduce la longitud de la mascota."));
                    String raza = JOptionPane.showInputDialog("De que raza es tu mascota?");
                    String tipoPelo = JOptionPane.showInputDialog("Introduce el tipo de pelo de la mascota.");
                    LocalDate fecha = LocalDate.of(ano, mes, dia);
                    listaMascota.add(new Gato(nombre, fecha, sexo, peso, longitud, raza, tipoPelo));
                } else {
                    if (tipoMascota.equalsIgnoreCase("gato")) {
                        String nombre = JOptionPane.showInputDialog("Introduce el nombre de la mascota");
                        int dia = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dia de Alta del cliente."));
                        int mes = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes de Alta del cliente."));
                        int ano = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de Alta del cliente."));
                        String sexo = JOptionPane.showInputDialog("Introduce el sexo de la mascota.");
                        float peso = Float.parseFloat(JOptionPane.showInputDialog("Introduce el peso de la mascota."));
                        float longitud = Float.parseFloat(JOptionPane.showInputDialog("Introduce la longitud de la mascota."));
                        String raza = JOptionPane.showInputDialog("De que raza es tu mascota?");
                        String tipoPelo = JOptionPane.showInputDialog("Introduce el tipo de pelo de la mascota.");
                        LocalDate fecha = LocalDate.of(ano, mes, dia);
                        listaMascota.add(new Gato(nombre, fecha, sexo, peso, longitud, raza, tipoPelo));
                    } else {
                        throw new DatoNoValido("El dato introducido no concuerda con perro o gato");
                    }
                }
                Mascota m = listaMascota.get(listaMascota.size() - 1);
                m.setDueno(crearCliente(m));
                //listaMascota.get(listaMascota.size() - 1).setDueno(crearCliente(listaMascota.get(listaMascota.size() - 1)));
                listaMascota.get(listaMascota.size() - 1).setV(pedirVeterinarios(listaMascota.get(listaMascota.size() - 1)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (JOptionPane.showConfirmDialog(null, "Hay mas mascotas") == 0);
    }

    public static Veterinario pedirVeterinarios(Mascota mascota) {
        int x = 0;
        boolean error = true;
        do {
            try {


                String nombre = JOptionPane.showInputDialog("Nombre del veterinario");
                for (x = 0; x < listaVeterinarios.size() && listaVeterinarios.get(x).getNombre().compareToIgnoreCase(nombre) != 0; x++) {
                }
                if (x == listaVeterinarios.size()) {
                    throw new DatoNoValido("No existe ningun veterinario con ese nombre en este momento");
                }
                error = false;
            } catch (DatoNoValido e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        } while (error != false);
        listaVeterinarios.get(x).setListaMascotas(mascota);
        return listaVeterinarios.get(x);
    }


    public static Cliente crearCliente(Mascota mascota) {
        int x = 0;
        try {
            String nombre = JOptionPane.showInputDialog("Introduce el nombre del cliente");
            String direccion = JOptionPane.showInputDialog("Introduce la direccion del cliente.");
            int telefono = Integer.parseInt(JOptionPane.showInputDialog("Introduce el telefono del cliente"));
            int dia = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dia de Alta del cliente."));
            int mes = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes de Alta del cliente."));
            int ano = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de Alta del cliente."));

            listaClientes.add(new Cliente(nombre, direccion, telefono, LocalDate.of(ano, mes, dia)));
            x = listaClientes.size() - 1;
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        listaClientes.get(0).setListaMascotas(mascota);
        return listaClientes.get(x);
    }

    private static void menu() {
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1.- Mostrar el número de clientes que poseen un tipo de animal concreto.\n" +
                        "2 - Datos personales del cliente a partir del nombre de mascota.\n" +
                        "3- Datos del veterinario a partir de los datos de una mascota.\n" +
                        "4- Datos de las mascotas de un cliente.\n" +
                        "5- Datos de las mascotas de un veterinario.\n" +
                        "6- Terminar.\n"));

                switch (opcion) {
                    case 1:
                        numeroClientes();
                        break;
                    case 2:
                        datosClientes();
                        break;
                    case 3:
                        datosVeterinario();
                        break;
                    case 4:
                        datosMascotaCliente();
                        break;
                    case 5:
                        datosMascotaVeterinario();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        throw new DatoNoValido("Opcion no valida.");

                }
            } catch (DatoNoValido e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (opcion != 6);
    }

    private static void numeroClientes(){

    }
}
