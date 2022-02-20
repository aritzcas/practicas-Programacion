package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Clases.*;
public class VentanaP {
    private JPanel panel1;
    private JButton bAcceso;
    private JPanel JPImagen;
    private JLabel lTitulo;


    public VentanaP() {
        JFrame frame = new JFrame("VentanaP");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



        bAcceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login dialog = new Login();

            }
        });
    }
}
