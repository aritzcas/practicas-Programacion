package Clases;

import javafx.collections.ArrayChangeListener;

import java.util.ArrayList;

public class Cuenta {
    private int numCuenta;
    private float saldo;

    private ArrayList<Movimientos> listaMovimientos;

    public Cuenta(int numCuenta, float saldo) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;

        listaMovimientos =new ArrayList<Movimientos>();
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Movimientos> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(ArrayList<Movimientos> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }
}
