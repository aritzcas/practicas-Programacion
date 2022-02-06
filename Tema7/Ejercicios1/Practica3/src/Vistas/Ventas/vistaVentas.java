package Vistas.Ventas;

import Vistas.Principal.vistaPrincipal;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaVentas {
    private JPanel jVentas;
    private JLabel lTitulo;
    private JTextField tfProducto;
    private JTextField tfUnidad;
    private JTextField tfImporte;
    private JButton bAceptar;
    private JButton bCancelar;
    private JLabel lProducto;
    private JLabel lUnidad;
    private JLabel lImporte;

    public vistaVentas() {

        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.fCancelar();
            }
        });
    }

    public void main(String[] args) {
        JFrame vistaV = new JFrame("vistaVentas");
        vistaV.setContentPane(new vistaVentas().jVentas);
        vistaV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaV.pack();
        vistaV.setVisible(true);
    }
    public JPanel getVentas(){
                return jVentas;
            }
}

