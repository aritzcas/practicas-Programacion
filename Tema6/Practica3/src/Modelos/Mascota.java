package Modelos;

import java.time.LocalDate;

public class Mascota {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String sexo;
    private float peso;
    private float longitud;
    private String raza;
    private String tipoPelo;

    private Cliente dueno;
    private Veterinario v;

    public Mascota(String nombre, LocalDate fechaNacimiento, String sexo, float peso, float longitud, String raza, String tipoPelo) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.peso = peso;
        this.longitud = longitud;
        this.raza = raza;
        this.tipoPelo = tipoPelo;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getTipoPelo() {
        return tipoPelo;
    }

    public void setTipoPelo(String tipoPelo) {
        this.tipoPelo = tipoPelo;
    }

   public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Cliente getDueno() {
        return dueno;
    }

    public void setDueno(Cliente dueño) {
        this.dueno = dueno;
    }

    public Veterinario getV() {
        return v;
    }

    public void setV(Veterinario v) {
        this.v = v;
    }
}
