package Vistas;

import com.company.Main;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ventanaPrincipal {
    private JPanel panel1;
    private JTextField tFOpcion;

    public ventanaPrincipal() {

        tFOpcion.setText("");
        tFOpcion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                    Main.comprobarOpcion(tFOpcion.getText());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getPanel(){
        return panel1;
    }


}
