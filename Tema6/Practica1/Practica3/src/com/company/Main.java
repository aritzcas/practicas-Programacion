package com.company;

import Clases.Persona;
import Excepciones.ValidacionErronea;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    private static final ArrayList<Persona> personas = new ArrayList();
    private static String cadena=("Personas de Elche: \n");
    private static String cadenaMayoresEdad=("Personas Mayores de Edad: \n");
    private static String nombreMayor;

    public static void main(String[] args) {
        pedirPersona();
        mostrarPantalla();
    }
    public static void mostrarPantalla(){
        personaMasMayor();
        personasElche();
        personasMayoresEdad();

    }
    public static void pedirPersona() {

        do {
            try {
                String nombre = JOptionPane.showInputDialog("Introduce el Nombre:");
                validarNombre(nombre);
                String fecha1=JOptionPane.showInputDialog("Intgoduce una fecha de nacimiento (dd/mm/aaaa)");
                LocalDate fecha = inputDate(fecha1);
                String domicilio=JOptionPane.showInputDialog("Introduce el Domicilio:");
                validarDomicilio(domicilio);
                String codigoPostal=JOptionPane.showInputDialog("Introduce el Codigo Postal:");
                validarCodigoPostal(codigoPostal);
                String ciudad= JOptionPane.showInputDialog("Introduce la Ciudad:");
                validarNombre(ciudad);
                Persona nueva= new Persona(nombre,fecha,domicilio,codigoPostal,ciudad);

                personas.add(nueva);
            }catch (ValidacionErronea e) {
                System.out.println("Dato introducido NO valido, empieza de nuevo.");
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

    public static void validarCodigoPostal(String codigoPostal) throws Exception {
        boolean error = false;
        if (codigoPostal.length() != 5){
            error = true;}
        if (error){
            throw new ValidacionErronea();}
    }
    public static LocalDate parseDateString(String dateString){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, dateTimeFormatter);
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
    public static void personaMasMayor(){
        AtomicReference<LocalDate> maxFecha= new AtomicReference<>(LocalDate.now());
        //AtomicReference<String> maxNombre = null;

        personas.forEach(persona -> {
            LocalDate fecha= LocalDate.of(persona.getFecha().getYear(),persona.getFecha().getMonthValue(),persona.getFecha().getDayOfMonth());
            if (fecha.isBefore(maxFecha.get())){
                maxFecha.set(fecha);
                nombreMayor=persona.getNombre();
            }
        });

        JOptionPane.showMessageDialog(null, "La persona mas mayor es "+nombreMayor);
    }
    public static void personasElche(){
        personas.forEach(persona -> {
            if (persona.getCiudad().equalsIgnoreCase("Elche"))
                cadena+=persona.getNombre()+" \n";
        });
        JOptionPane.showMessageDialog(null, cadena);
    }
    public static void personasMayoresEdad(){
        personas.forEach(persona -> {
            int anoNacimiento= persona.getFecha().getYear();
            int anoHoy= LocalDate.now().getYear();
            if ((anoHoy-anoNacimiento)>18){
                cadenaMayoresEdad+=persona.getNombre()+" \n";
            }
        });
        JOptionPane.showMessageDialog(null, cadenaMayoresEdad);
    }
}



