package com.company;

import Modelos.*;
import vistas.paginaPrincipal;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static JFrame paginaPrincipal;

    private static ArrayList<Personas> listaAlumnos;
    private static ArrayList<Cursos> listaCursos;
    private static Cursos c;
    public static void main(String[] args) {
        generarCursos();
        listaAlumnos = new ArrayList<>();
        ventana();

    }
    public static void generarCursos(){
        listaCursos= new ArrayList<Cursos>();
        c = new Cursos("1A","Primero de la ESO A");
        listaCursos.add(c);
        c = new Cursos("1B","Primero de la ESO B");
        listaCursos.add(c);
        c = new Cursos("1C","Primero de la ESO C");
        listaCursos.add(c);
        c = new Cursos("1D","Primero de la ESO D");
        listaCursos.add(c);
        c = new Cursos("2A","Segundo de la ESO A");
        listaCursos.add(c);
        c = new Cursos("2B","Segundo de la ESO B");
        listaCursos.add(c);
        c = new Cursos("2C","Segundo de la ESO C");
        listaCursos.add(c);
        c = new Cursos("2D","Segundo de la ESO D");
        listaCursos.add(c);
        c = new Cursos("3A","Tercero de la ESO A");
        listaCursos.add(c);
        c = new Cursos("3B","Tercero de la ESO B");
        listaCursos.add(c);
        c = new Cursos("3C","Tercero de la ESO C");
        listaCursos.add(c);
        c = new Cursos("3D","Tercero de la ESO D");
        listaCursos.add(c);
        c = new Cursos("4A","Cuarto de la ESO A");
        listaCursos.add(c);
        c = new Cursos("4B","Cuarto de la ESO B");
        listaCursos.add(c);
        c = new Cursos("4C","Cuarto de la ESO C");
        listaCursos.add(c);
        c = new Cursos("4D","Cuarto de la ESO D");
        listaCursos.add(c);
    }
    public static boolean tenDatos(String curso){
        int x;
        for (x=0; x <listaCursos.size() && listaCursos.get(x).getClase().compareToIgnoreCase(curso)!= 0; x++);
        if (x==listaCursos.size()){
            return false;
        }
        c=listaCursos.get(x);
        return true;
    }

    public static void crearPersona(String nombre,String apellidos,String dni){
        listaAlumnos.add(new Personas(nombre,apellidos,dni))
    }

    public static void ventana(){
        paginaPrincipal = new JFrame("paginaPrincipal");
        paginaPrincipal.setContentPane(new paginaPrincipal().getPanel());
        paginaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paginaPrincipal.pack();
        paginaPrincipal.setVisible(true);
    }
}
