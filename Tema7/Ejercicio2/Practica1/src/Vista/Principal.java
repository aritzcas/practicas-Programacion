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
    }

    public void habilitarCompra(){
        jpVentas.setVisible(false);
        jpCompra.setVisible(true);

       rellenarCompra();
    }
    public void comprobarProducto(){
        if (!Main.buscarProducto(tfProducto.getText())){
            JOptionPane.showMessageDialog(null, "No hay productos con ese nombre");
            tfProducto.setText("");
            tfUnidades.setText("");
            tfProducto.grabFocus();
        }
    }
    public void rellenarCompra(){
        listaProveedor = Main.buscarProveedores(tfProducto.getText());

        cbProveedor.setName();
    }
    public void habilitarVenta(){

        jpCompra.setVisible(false);
        jpVentas.setVisible(true);
    }

    public JPanel getPanel(){
        return panel1;
    }
}
