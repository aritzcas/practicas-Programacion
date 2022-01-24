package com.company;

import Clases.Estudio;
import Clases.Pelicula;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Estudio> listaEstudios= new ArrayList<Estudio>();
    private static ArrayList<Pelicula> listaPeliculas=new ArrayList<Pelicula>();
    public static void main(String[] args) {



        listaEstudios.add(new Estudio("Legendary Entertainment", "Burbank", "Burbank, California, Estados Unidos","www.legendary.com", LocalDate.of(2000,1,1), "Estados Unidos", 666554433));
        listaEstudios.add(new Estudio("20th Century Studios", "Los Ángeles", "Los Ángeles, California, Estados Unidos","www.20thcenturystudios.com", LocalDate.of(1935,5,31), "Estados Unidos", 666443322));
        listaEstudios.add(new Estudio("Paramount Pictures", "Los Angeles", "Los Angeles,California, Estados Unidos","www.paramount.com", LocalDate.of(1912,5,8), "Estados Unidos", 666332211));

        ArrayList <Estudio> lista = new ArrayList();
        lista.add(listaEstudios.get(1));
        Pelicula peli1= new Pelicula("Spider-Man: No Way Home", 2021, 148, "Accion", lista);
        listaPeliculas.add(peli1);

        lista = new ArrayList();
        lista.add(listaEstudios.get(1));
        lista.add(listaEstudios.get(2));
        Pelicula peli2= new Pelicula("Godzilla vs. Kong", 2021, 113, "Ciencia ficción",lista);
        listaPeliculas.add(peli2);

        lista = new ArrayList();
        lista.add(listaEstudios.get(0));
        Pelicula peli3= new Pelicula("Liga de la Justicia de Zack Snyder", 2021, 242, "Accion",lista);
        listaPeliculas.add(peli3);

        peliLarga();
        buscarEstudio();
    }

    public static void peliLarga(){
        int duracionMaxima=0;
        Pelicula nomPeliMaxima=null;
        String estudiosPeli = "";
        for (int x=0; x<listaPeliculas.size(); x++) {
            if (listaPeliculas.get(x).getDuracionminutos() > duracionMaxima) {
                duracionMaxima = listaPeliculas.get(x).getDuracionminutos();
                nomPeliMaxima = listaPeliculas.get(x);
            }
        }

       for (int x=0; x < nomPeliMaxima.getListaEstudio().size(); x++){
           estudiosPeli += nomPeliMaxima.getListaEstudio().get(x).getNombre();
       }
        JOptionPane.showMessageDialog(null, "La peli " +  nomPeliMaxima.getTitulo() + " fue producida por " + estudiosPeli);

    }

    public static  void buscarEstudio(){
        int[] peliculasEstudio = new int[listaEstudios.size()];
        for (Pelicula p:listaPeliculas) {
            for (Estudio e:p.getListaEstudio()) {
                int posicion = listaEstudios.indexOf(e);
                peliculasEstudio[posicion]++;
            }
        }
        int contador=0;
        int valorMaximo=0;
        Estudio estudioMaximo=null;
        for (int i: peliculasEstudio) {
           if (valorMaximo< i){
               valorMaximo=i;
               estudioMaximo=listaEstudios.get(contador);
           }
            contador++;
        }
        JOptionPane.showMessageDialog(null,  estudioMaximo.getNombre()+ " es el estudio con mas peliculas producidas.");
    }
}
