package Modelos;

import java.time.LocalDate;

public class Gato extends Mascota {
    public Gato(String nombre, LocalDate fechaNacimiento, String sexo, float peso, float longitud, String raza, String tipoPelo) {
        super(nombre, fechaNacimiento, sexo, peso, longitud, raza, tipoPelo);
    }
}


