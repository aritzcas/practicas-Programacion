package Vistas.Principal;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaPrincipal {
    private JPanel jPrincipal;
    private JButton bCompras;
    private JButton bVentas;
    private JButton bSalir;

    public vistaPrincipal() {
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        bVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.verVentas();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vistaPrincipal");
        frame.setContentPane(new vistaPrincipal().jPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPrincipal() {
        return jPrincipal;
    }


}
