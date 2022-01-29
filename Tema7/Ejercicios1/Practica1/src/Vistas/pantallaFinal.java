package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pantallaFinal {
    private JPanel panel;
    private JLabel lTitulo;
    private JTextArea taListadoPersonas;
    private JButton bSalir;

    public pantallaFinal(String cadena) {
        taListadoPersonas.setText(cadena);
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(2);
            }
        });
    }

    public pantallaFinal() {

    }

    public JPanel enseñarPanel(){
        return panel;
    }
    /*
    public static void main(String[] args) {
        JFrame vista2 = new JFrame("pantallaFinal");
        vista2.setContentPane(new pantallaFinal().panel);
        vista2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista2.pack();
        vista2.setVisible(true);
    }*/

}
