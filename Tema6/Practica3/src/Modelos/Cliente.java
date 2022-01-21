package Modelos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Persona{
    private LocalDate fechaAlta;

    public Cliente(String nombre, String direccion, int telefono, LocalDate fechaAlta) {
        super(nombre, direccion, telefono);
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
