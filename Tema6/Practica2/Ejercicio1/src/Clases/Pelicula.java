package Clases;

import java.util.ArrayList;

public class Pelicula {
    String titulo;
    int ano;
    int duracionMinutos;
    String tipo;

    private ArrayList<Estudio> listaEstudio;
    public Pelicula(String titulo, int ano, int duracionMinutos, String tipo, ArrayList<Estudio> listaEstudio) {
        this.titulo = titulo;
        this.ano = ano;
        this.duracionMinutos = duracionMinutos;
        this.tipo = tipo;
        this.listaEstudio = listaEstudio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDuracionminutos() {
        return duracionMinutos;
    }

    public void setDuracionminutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Estudio> getListaEstudio() {
        return listaEstudio;
    }

    public void setListaEstudio(ArrayList<Estudio> listaEstudio) {
        this.listaEstudio = listaEstudio;
    }
}
