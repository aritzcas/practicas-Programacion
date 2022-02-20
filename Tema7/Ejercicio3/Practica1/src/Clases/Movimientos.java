package Clases;

import java.time.LocalDate;

public class Movimientos {
    private LocalDate fecha;
    private String descripcion;
    private float importe;

    public Movimientos(LocalDate fecha, String descripcion, float importe) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.importe = importe;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
}
