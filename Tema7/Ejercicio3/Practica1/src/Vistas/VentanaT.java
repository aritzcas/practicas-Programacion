package Vistas;

import Clases.Cliente;
import Clases.Cuenta;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;

public class VentanaT extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JMenuBar MenuBarra;
    private JMenu MenuResumen;
    private JMenu MenuTarjetas;
    private JMenu MenuInversiones;
    private JMenu MenuMercados;
    private JMenu MenuPrestamos;
    private JMenu MenuSeguros;
    private JMenu MenuServicios;
    private JMenu MenuCuentas;
    private JMenuItem MenuConsulta;
    private JMenuItem MenuMovimientos;
    private JPanel JPCuentas;

    private Cliente clienteT;

    public VentanaT(String DNI) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        pillarCliente();
        ponerCuentas(clienteT);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
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
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    public void pillarCliente(){
        clienteT= Main.darCliente();
    }
    public void ponerClientes(Cliente cliente){
        Cuenta cuentas;

        for (cliente.getListaCuentas():cuentas) {
            
        }
    }
}
