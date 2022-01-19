package com.company;

import Clases.Estudio;
import Clases.Pelicula;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    private static Estudio[] listaEstudios;
    private static ArrayList<Pelicula> listaPeliculas=new ArrayList();
    public static void main(String[] args) {


        listaEstudios= new Estudio[3];
        listaEstudios[0]=new Estudio("Legendary Entertainment", "Burbank", "Burbank, California, Estados Unidos","www.legendary.com", LocalDate.of(2000,1,1), "Estados Unidos", 666554433);
        listaEstudios[1]=new Estudio("20th Century Studios", "Los Ángeles", "Los Ángeles, California, Estados Unidos","www.20thcenturystudios.com", LocalDate.of(1935,5,31), "Estados Unidos", 666443322);
        listaEstudios[2]=new Estudio("Paramount Pictures", "Los Angeles", "Los Angeles,California, Estados Unidos","www.paramount.com", LocalDate.of(1912,5,8), "Estados Unidos", 666332211);

        ArrayList <Estudio> lista = new ArrayList();
        lista.add(listaEstudios[1]);
        Pelicula peli1= new Pelicula("Spider-Man: No Way Home", 2021, 148, "Accion", lista);
        listaPeliculas.add(peli1);

        lista.add(listaEstudios[1]);
        lista.add(listaEstudios[2]);
        Pelicula peli2= new Pelicula("Godzilla vs. Kong", 2021, 113, "Ciencia ficción",lista);
        listaPeliculas.add(peli2);

        lista.add(listaEstudios[0]);
        Pelicula peli3= new Pelicula("Liga de la Justicia de Zack Snyder", 2021, 242, "Accion",lista);
        listaPeliculas.add(peli3);

        peliLarga();
    }

    public static void peliLarga(){
        
    }
}
