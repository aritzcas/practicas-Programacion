package com.company;

import Clases.Estudio;
import Clases.Pelicula;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Pelicula peli1= new Pelicula("Spider-Man: No Way Home", 2021, 148, "Accion", "Legendary Entertainment");
        Pelicula peli2= new Pelicula("Godzilla vs. Kong", 2021, 113, "Ciencia ficción");
        Pelicula peli3= new Pelicula("Liga de la Justicia de Zack Snyder", 2021, 242, "Accion");

        Estudio estudio1=new Estudio("Legendary Entertainment", "Burbank", "Burbank, California, Estados Unidos","www.legendary.com", LocalDate.of(2000,01,01), "Estados Unidos", 666554433);
    }
}
