package Modelo.UML;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Evento {
    private String nombre;
    private String lugar;
    private LocalDate fecha;
    private LocalTime horaIncio;
    private LocalTime horaFin;
    private int numPersonas;

    public Evento() {
    }
    public Evento(String text){
        this.nombre = text;
    }
    public Evento(String nombre, String lugar, LocalDate fecha, LocalTime horaIncio, LocalTime horaFin, int numPersonas) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horaIncio = horaIncio;
        this.horaFin = horaFin;
        this.numPersonas = numPersonas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraIncio() {
        return horaIncio;
    }

    public void setHoraIncio(LocalTime horaIncio) {
        this.horaIncio = horaIncio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }
}
