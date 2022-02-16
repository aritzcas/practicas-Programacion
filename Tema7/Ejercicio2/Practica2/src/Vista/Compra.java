package Vista;

import Modelo.Proveedor;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Compra extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lPrecio;
    private JTextField tfPrecio;
    private JLabel lProveedor;
    private  JComboBox cbProveedor;
    private JLabel lImporte;
    private JTextField tfImporte;
    private static ArrayList<Proveedor> listaProveedor;
    public Compra() {
        setContentPane(contentPane);
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

    }




    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    public void rellenarP(String pro){
        cbProveedor.removeAllItems();
        listaProveedor = Main.buscarProveedores(pro);
        for (int x=0; x<listaProveedor.size(); x++){
            cbProveedor.addItem(listaProveedor.get(x).getNombre());}
        cbProveedor.setSelectedIndex(-1);

            float precioUnidad = Float.parseFloat(Main.darUnidades())*Float.parseFloat(tfPrecio.getText());
            tfImporte.setText(String.valueOf(precioUnidad));
    }
    public static void main(String[] args) {
        Compra dialog = new Compra();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
