package Modelos;

import java.util.ArrayList;

public class Cursos {
    private String clase;
    private String descripcion;
    private ArrayList<Personas> listaAlumnos;

    public Cursos(String clase, String descripcion) {
        this.clase = clase;
        this.descripcion = descripcion;
        listaAlumnos = new ArrayList<>();
    }

    public String getClase() {

        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Personas> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Personas> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public void setAlumno(Personas a)
    {
        listaAlumnos.add(a);
    }

    public void borrarAlumno(Personas a)
    {
        listaAlumnos.remove(a);
    }
}
