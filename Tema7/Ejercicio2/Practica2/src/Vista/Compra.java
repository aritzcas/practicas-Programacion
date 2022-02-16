package Vista;

import Modelo.Producto;
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
    private Producto p;
    private int unidades;
    private static ArrayList<Proveedor> listaProveedor;
    public Compra(Producto p, int unidades) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.p=p;
        this.unidades=unidades;
        rellenarP();
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
        tfPrecio.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                ponerPrecio();
            }
        });
        this.pack();
        this.setVisible(true);

    }




    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    public void rellenarP(){
        for (Proveedor prov: p.getListaProveedores()){
            cbProveedor.addItem(prov.getNombre());
        }
    }
    public void ponerPrecio(){
        float precioUnidad = unidades*Float.parseFloat(tfPrecio.getText());
        tfImporte.setText(String.valueOf(precioUnidad));
    }
}
