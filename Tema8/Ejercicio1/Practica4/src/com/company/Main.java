package com.company;

import Vista.VentanaPrincipal;

import javax.swing.*;
import Vista.*;
import Modelo.UML.*;
import Modelo.BD.AcontecimientosDAO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {

    private static JFrame vp;
    private static Acontecimiento a;
    private static ArrayList<Acontecimiento> listaAcontecimientos;
    private static ArrayList<Empresa> listaEmpresas;
    private static Empresa e;
    private static AcontecimientosDAO adao;

    public static void main(String[] args) {
	   mostrarVentanaPrincipal();
       // Que la aplicación empieze por el main de la ventana
    }

    public static void mostrarVentanaPrincipal()
    {
        vp = new JFrame("VentanaPrincipal");
        vp.setContentPane(new VentanaPrincipal().getpPrincipal());
        vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vp.pack();
        vp.setVisible(true);
    }

    public static void mostrarInsertar()
    {
        // Mostrar el JDialog que permite introducir los datos de un evento
        DInsertar dialog = new DInsertar();
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
    }
    public static void personaEvento(){
        personasEvento dialog = new personasEvento();
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
    }
   public static void getDatosAcontecimiento(String n, String l, LocalDate f, LocalTime hi, LocalTime hf, int af) throws Exception
   {
       // Crear objeto y mandarlo a la base de datos
       a = new Acontecimiento(n,l,f,hi,hf,af);

       // Abrir, ejecutar y cerrar
       AcontecimientosDAO.alta(a);
   }

   public static String cancelarEvento(String nombre) throws Exception
   {
       // Primero consulta
       a = AcontecimientosDAO.consultarAcontecimiento(nombre);
       return a.toString();
   }

   public static void borrarAcontecimiento() throws Exception{
        AcontecimientosDAO.borrar(a);
   }

   public static void visualizarModificarEvento()
   {
       DModificacion dialog = new DModificacion();
       dialog.pack();
       dialog.setVisible(true);
   }

   public static ArrayList<String> datosLlenarCombo() throws Exception
   {
       listaAcontecimientos = AcontecimientosDAO.consultarAcontecimientos();
       // A la ventana van solo los nombres.
        ArrayList<String> nombres = new ArrayList<>();
        for(Acontecimiento a:listaAcontecimientos)
            nombres.add(a.getNombre());
        return nombres;
   }

    public static ArrayList<String> datosLlenarComboEmpresas() throws Exception
    {
        listaEmpresas = AcontecimientosDAO.consultarEmpresas();
        // A la ventana van solo los nombres.
        ArrayList<String> nombres = new ArrayList<>();
        for(Empresa a:listaEmpresas)
            nombres.add(a.getNombre());
        return nombres;
    }
   public static void mostrarEmpresa() {
       DCrearEmpresa dialog = new DCrearEmpresa();
       dialog.pack();
       dialog.setVisible(true);
   }
   public static void getEventoSeleccionado(int i)
   {
       a = listaAcontecimientos.get(i);
   }

   public static String getLugar()
   {
       return a.getLugar();
   }

    public static String getFecha()
    {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return a.getFecha().format(formato);
    }

    public static String getHoraInicio()
    {
        return a.getHoraI().toString();
    }

    public static String getHoraFin()
    {
        return a.getHoraF().toString();
    }

    public static String getAforo()
    {
        return a.getAforo().toString();
    }

    public static void getDatosActualizados(String l, LocalDate f, LocalTime hi, LocalTime hf, int af) throws Exception
    {
        // Modificar objetoy mandarlo a la base de datos
        a.setLugar(l);
        a.setFecha(f);
        a.setHoraI(hi);
        a.setHoraF(hf);
        a.setAforo(af);

        // Abrir, ejecutar y cerrar
        AcontecimientosDAO.actualizar(a);
    }

    public static void getEmpresa(String nombre, String direccion, int telefono) throws Exception {
        e.setNombre(nombre);
        e.setDireccion(direccion);
        e.setTelefono(telefono);

        AcontecimientosDAO.insertarEmpresa(e);

    }
}
