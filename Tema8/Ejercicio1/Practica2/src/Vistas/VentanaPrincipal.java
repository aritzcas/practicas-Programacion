package Vistas;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {


    private JPanel jpPrincipal;
    private JMenu JMArchivo;
    private JMenuItem JMIGuardar;


    public VentanaPrincipal() {
        JMIGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostarInsertar();
            }
        });
    }

    public JPanel getPanel(){
        return jpPrincipal;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
