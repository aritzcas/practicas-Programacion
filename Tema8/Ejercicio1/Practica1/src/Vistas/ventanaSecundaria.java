package Vistas;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;

public class ventanaSecundaria extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField tfNombre;
    private JTextField tfProfesion;
    private JTextField tfTelefono;
    private JTextField tfEdad;
    private JButton bAtras;
    private JButton bAdelante;
    private JButton bSalir;
    private JLabel lNombre;
    private JLabel lEdad;
    private JLabel lProfesion;
    private JLabel lTelefono;
    private JPanel jPBotones;
    private JPanel jPAceptar;

    public ventanaSecundaria(String opciones) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        if(!opciones.equalsIgnoreCase("3")){
            jPBotones.setVisible(false);
            jPAceptar.setVisible(true);
        }else{
            jPBotones.setVisible(true);
            jPAceptar.setVisible(false);
        }
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.tenDatos(tfNombre.getText(),Integer.parseInt(tfEdad.getText()),tfProfesion.getText(),tfTelefono.getText());
            }
        });
        tfNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Main.validarNombre(tfNombre.getText())){
                Main.tenDato(tfNombre.getText());}
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
