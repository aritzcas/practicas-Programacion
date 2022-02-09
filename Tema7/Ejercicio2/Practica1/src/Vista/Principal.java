package Vista;

import Modelo.Proveedor;
import com.company.Main;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class Principal {
    private JPanel panel1;
    private JRadioButton rbCompra;
    private JRadioButton rbVenta;
    private JTextField tfProducto;
    private JTextField tfUnidades;
    private JLabel lAlmacen;
    private JLabel lNombre;
    private JLabel lUnidades;
    private JTextField tfPrecio;
    private JTextField tfImporte;
    private JComboBox cbProveedor;
    private JLabel lPrecio;
    private JLabel lProveedor;
    private JLabel lImporte;
    private JTextField tfCliente;
    private JCheckBox cbVolumen;
    private JCheckBox cbProntoPago;
    private JLabel lPrecioV;
    private JTextField tfPrecioV;
    private JLabel lCliente;
    private JPanel jpVentas;
    private JPanel jpCompra;
    private JPanel jpContabilizar;
    private JLabel lImporteVenta;
    private JTextField tfImporteV;
    private JButton bAceptar;
    private JButton bCancelar;

    private ArrayList<Proveedor> listaProveedor;

    public Principal() {

        rbCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                habilitarCompra();
            }
        });
        rbVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                habilitarVenta();
            }
        });
        tfProducto.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                comprobarProducto();
            }
        });

        tfPrecio.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                llenarPrecio();
            }
        });
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbCompra.isSelected()){
                guardarCompra();}
            }
        });
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbCompra.isSelected()){
                   Main.enseñarCompra();}
                    System.exit(1);
            }
        });
    }

    public void habilitarCompra(){
        jpVentas.setVisible(false);
        jpCompra.setVisible(true);

       rellenarProveedor();
    }
    public void comprobarProducto(){
        if (!Main.buscarProducto(tfProducto.getText())){
            JOptionPane.showMessageDialog(null, "No hay productos con ese nombre");
            tfProducto.setText("");
            tfUnidades.setText("");
            tfProducto.grabFocus();
        }
    }
    public void rellenarProveedor(){
        listaProveedor = Main.buscarProveedores(tfProducto.getText());
        for (int x=0; x<listaProveedor.size(); x++){
        cbProveedor.addItem(listaProveedor.get(x).getNombre());}

    }
    public void llenarPrecio(){
        float precioUnidad = Float.parseFloat(tfUnidades.getText())*Float.parseFloat(tfPrecio.getText());
        tfImporte.setText(String.valueOf(precioUnidad));
    }
    public void guardarCompra(){
        Main.guardarcompra(tfProducto.getText(),Integer.parseInt(tfUnidades.getText()),Float.parseFloat(tfImporte.getText()));
        tfProducto.setText("");
        tfUnidades.setText("");
        tfImporte.setText("");
        tfPrecio.setText("");
        cbProveedor.addItem("");
        tfProducto.grabFocus();

    }

    public void habilitarVenta(){

        jpCompra.setVisible(false);
        jpVentas.setVisible(true);
    }

    public JPanel getPanel(){
        return panel1;
    }
}
