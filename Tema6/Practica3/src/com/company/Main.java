package com.company;

import Clases.Persona;
import Excepciones.ValidacionErronea;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    private static final ArrayList<Persona> personas = new ArrayList();

    public static void main(String[] args) {
        pedirPersona();
        personasElche();
    }

    public static void pedirPersona() {

        do {
            try {
                String nombre = JOptionPane.showInputDialog("Introduce el Nombre:");
                validarNombre(nombre);
                LocalDate fecha = inputDate("Intgoduce una fecha de nacimiento (dd/mm/aaaa)");
                String domicilio=JOptionPane.showInputDialog("Introduce el Domicilio:");
                validarDomicilio(domicilio);
                int codigoPostal=Integer.parseInt(JOptionPane.showInputDialog("Introduce el Codigo Postal:"));
                validarCodigoPostal(codigoPostal);
                String ciudad= JOptionPane.showInputDialog("Introduce la Ciudad:");
                validarNombre(ciudad);
                Persona nueva= new Persona(nombre,fecha.getDayOfMonth(),fecha.getMonthValue(),fecha.getYear(),domicilio,codigoPostal,ciudad);

                personas.add(nueva);
            }catch (ValidacionErronea e) {
                System.out.println("Dato no valido");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (JOptionPane.showConfirmDialog(null, "Hay mas personas") == 0);
    }

    public static void validarNombre(String nombre) throws Exception {

        boolean error = false;
        for (int x = 0; x < nombre.length() && !error; x++){
                if (Character.isDigit(nombre.charAt(x)))
                    error = true;}
        if (error){
            throw new ValidacionErronea();}

    }

    public static void validarDomicilio(String domicilio) throws Exception {
        if (domicilio.length() <= 10)
            throw new ValidacionErronea();

    }

    public static void validarCodigoPostal(int codigoPostal) throws Exception {
        boolean error = false;
        if (String.valueOf(codigoPostal).length() != 5){
            error = true;}
        if (error){
            throw new ValidacionErronea();}
    }
    public static LocalDate inputDate(String datoIntroducido) {
        LocalDate fecha;
        try {
            fecha = parseDateString(datoIntroducido);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"El dato introducido no es valido");
            fecha = inputDate(datoIntroducido);
        }
        return fecha;
    }
    public static LocalDate parseDateString(String dateString){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, dateTimeFormatter);
    }

    public static void personasElche(){
        AtomicReference<String> cadena= new AtomicReference<>("Personas de Elche: \n");
        personas.forEach(persona -> {
            if (persona.getCiudad().equalsIgnoreCase("Elche"))
                cadena.set(persona.getNombre() + "\n");
        });
    }

}



