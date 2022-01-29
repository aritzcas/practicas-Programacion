package Modelos;

import java.util.ArrayList;

public class Cursos {
    private int nivel;
    private char letraClase;
    private ArrayList<Personas> listaAlumnos;

    public Cursos(int nivel, char letraClase) {
        this.nivel = nivel;
        this.letraClase = letraClase;
        listaAlumnos = new ArrayList<>();
    }

    public int getNivel() {

        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public char getLetraClase() {
        return letraClase;
    }

    public void setLetraClase(char letraClase) {
        this.letraClase = letraClase;
    }

    public ArrayList<Personas> getAlumnos() {
        return listaAlumnos;
    }

    public void setAlumnos(ArrayList<Personas> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

}
