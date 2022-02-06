package Vistas.Ventas;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;

public class cuadroVentas extends JDialog {
    private JPanel VentanaVentas;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfProducto;
    private JTextField tfUnidades;
    private JTextField tfImporte;
    private JLabel lTituloVentas;
    private JLabel lProducto;
    private JLabel lUnidades;
    private JLabel lImporte;

    public cuadroVentas() {
        setContentPane(VentanaVentas);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
        VentanaVentas.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        tfUnidades.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                mirarProducto();
            }
        });
    }

    private void onOK() {
        // add your code here
        Main.registarVenta(tfUnidades.getText());
    }
    private void onCancel() {
        // add your code here if necessary
       dispose();
    }
    private  void  mirarProducto(){
        if (!tfProducto.getText().isEmpty()){
            ensenaImporte();
        }else{
            JOptionPane.showMessageDialog(null, "No puede esatar vacio el Producto.");
        }
    }
    public  static void ensenaImporte() {

    }
    public static void main(String[] args) {
        cuadroVentas dialog = new cuadroVentas();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
