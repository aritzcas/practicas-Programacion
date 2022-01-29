package com.company;

import Modelo.Estudio;
import Modelo.Pelicula;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    private static final ArrayList<Estudio> listaEstudios = new ArrayList<Estudio>();
    private static final ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();

    public static void main(String[] args) {
        guardarEstudios();
        guardarPeliculas();
        estudiosconPelis();
        buscarPeliLarga();
        buscarEstudioPelis();


    }

    public static void guardarEstudios() {

        ArrayList<String> telefonosLista = new ArrayList();
        telefonosLista.add("666554433");
        listaEstudios.add(new Estudio("Legendary Entertainment", "Burbank", "Burbank, California, Estados Unidos", "www.legendary.com", LocalDate.of(2000, 1, 1), "Estados Unidos", telefonosLista));

        telefonosLista = new ArrayList();
        telefonosLista.add("666115522");
        telefonosLista.add("678543210");
        listaEstudios.add(new Estudio("20th Century Studios", "Los Ángeles", "Los Ángeles, California, Estados Unidos", "www.20thcenturystudios.com", LocalDate.of(1935, 5, 31), "Estados Unidos", telefonosLista));

        telefonosLista = new ArrayList();
        telefonosLista.add("654321098");
        listaEstudios.add(new Estudio("Paramount Pictures", "Los Angeles", "Los Angeles,California, Estados Unidos", "www.paramount.com", LocalDate.of(1912, 5, 8), "Estados Unidos", telefonosLista));
    }

    public static void guardarPeliculas() {

        ArrayList<Estudio> lista = new ArrayList();
        lista.add(listaEstudios.get(1));
        Pelicula peli1 = new Pelicula("Spider-Man: No Way Home", 2021, 148, "Accion", lista);
        listaPeliculas.add(peli1);

        lista = new ArrayList();
        lista.add(listaEstudios.get(1));
        lista.add(listaEstudios.get(2));
        Pelicula peli2 = new Pelicula("Godzilla vs. Kong", 2021, 113, "Ciencia ficción", lista);
        listaPeliculas.add(peli2);

        lista = new ArrayList();
        lista.add(listaEstudios.get(0));
        Pelicula peli3 = new Pelicula("Liga de la Justicia de Zack Snyder", 2021, 242, "Accion", lista);
        listaPeliculas.add(peli3);


    }

    public static void estudiosconPelis() {
        ArrayList<Pelicula> listaPelis = new ArrayList();

        listaPelis.add(listaPeliculas.get(2));
        listaEstudios.get(0).setListaPeliculas(listaPelis);

        listaPelis = new ArrayList();
        listaPelis.add(listaPeliculas.get(0));
        listaPelis.add(listaPeliculas.get(1));
        listaEstudios.get(1).setListaPeliculas(listaPelis);

        listaPelis = new ArrayList();
        listaPelis.add(listaPeliculas.get(1));
        listaEstudios.get(2).setListaPeliculas(listaPelis);
    }

    public static void buscarPeliLarga() {
        int duracionMaxima = 0;
        Pelicula nomPeliMaxima = null;
        String estudiosPeli = "";
        for (int x = 0; x < listaPeliculas.size(); x++) {
            if (listaPeliculas.get(x).getDuracionminutos() > duracionMaxima) {
                duracionMaxima = listaPeliculas.get(x).getDuracionminutos();
                nomPeliMaxima = listaPeliculas.get(x);
            }
        }
        for (int x = 0; x < nomPeliMaxima.getListaEstudios().size(); x++) {
            estudiosPeli += nomPeliMaxima.getListaEstudios().get(x).getNombre();
        }
        JOptionPane.showMessageDialog(null, "La peli " + nomPeliMaxima.getTitulo() + " fue producida por " + estudiosPeli);
    }
    public static void buscarEstudioPelis() {
        int pelisMaxima = 0;
        Estudio nomEstudioMaxima = null;
        String estudiosMax = "";
        for (int x = 0; x < listaEstudios.size(); x++) {
            if (listaEstudios.get(x).getListaPeliculas().size() > pelisMaxima) {
                pelisMaxima = listaPeliculas.get(x).getListaEstudios().size();
                nomEstudioMaxima = listaEstudios.get(x);
            }
        }
        for (int x = 0; x < nomEstudioMaxima.getListaPeliculas().size(); x++) {
            estudiosMax += nomEstudioMaxima.getListaPeliculas().get(x).getTitulo();
        }
        JOptionPane.showMessageDialog(null, "El estudio con mas pelis es  " + nomEstudioMaxima.getNombre() );
    }
}


