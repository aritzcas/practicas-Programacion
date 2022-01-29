package Modelo;

import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private int ano;
    private int duracionMinutos;
    private String tipo;


    private ArrayList<Estudio> listaEstudios;


    public Pelicula(String titulo, int ano, int duracionMinutos, String tipo, ArrayList<Estudio> listaEstudios) {
        this.titulo = titulo;
        this.ano = ano;
        this.duracionMinutos = duracionMinutos;
        this.tipo = tipo;
        this.listaEstudios = listaEstudios;
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

    public ArrayList<Estudio> getListaEstudios() {
        return listaEstudios;
    }

    public void setListaEstudios(ArrayList<Estudio> listaEstudios) {
        this.listaEstudios = listaEstudios;
    }

    public void setListaEstudio(Estudio e)
    {
        this.listaEstudios.add(e);
    }

}
