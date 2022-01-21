package Modelos;

import java.time.LocalDate;

public class Gato extends Mascota{
    public Gato(String nombre, LocalDate fechaNacimiento, String sexo, float peso, float longitud, String tipo, String raza, String tipoPelo, Cliente dueño, Veterinario v) {
        super(nombre, fechaNacimiento, sexo, peso, longitud, tipo, raza, tipoPelo, dueño, v);
    }
}
