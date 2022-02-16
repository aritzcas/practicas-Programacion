package Vista;

import Modelo.Producto;
import Modelo.Proveedor;
import com.company.Main;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class Principal {
    private JPanel panel1;
    private JRadioButton rbCompra;
    private JRadioButton rbVenta;
    private JTextField tfProducto;
    public  JTextField tfUnidades;
    private JLabel lAlmacen;
    private JLabel lNombre;
    private JLabel lUnidades;
    private JTextField tfPrecio;
    private JTextField tfImporte;
    private JComboBox cbProveedor;
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
    private ButtonGroup ButtonGroup;
    private ArrayList<Proveedor> listaProveedor;
    private Producto pro;
    private float precio;
    private JDialog compra;
    private JDialog venta;
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

        /*tfPrecio.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                llenarPrecio();
            }
        });*/
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

        tfImporteV.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                cbVolumen.setEnabled(true);
                cbProntoPago.setEnabled(true);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

        });


        tfUnidades.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                switch (comprobarRB()) {
                    case 1:
                        rbCompra.doClick();
                        break;
                    case 2:
                        rbVenta.doClick();
                        break;

                }
            }
        });
        cbVolumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbVenta.doClick();
            }
        });
        cbProntoPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbVenta.doClick();
            }
        });
    }

    public void habilitarCompra(){
        Compra compra  = new Compra();
        compra.rellenarP(tfProducto.getText());
        compra.pack();
        compra.setVisible(true);


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
        cbProveedor.removeAllItems();
        listaProveedor = Main.buscarProveedores(tfProducto.getText());
        for (int x=0; x<listaProveedor.size(); x++){
        cbProveedor.addItem(listaProveedor.get(x).getNombre());}
        cbProveedor.setSelectedIndex(-1);

    }
    public  void darUnidades(){
        Main.recibirUnidades(tfUnidades.getText());

    }
    public void llenarPrecio(){
        float precioUnidad = Float.parseFloat(tfUnidades.getText())*Float.parseFloat(tfPrecio.getText());
        tfImporte.setText(String.valueOf(precioUnidad));
    }
    public void guardarCompra(){
        Main.guardarcompra(Integer.parseInt(tfUnidades.getText()),Float.parseFloat(tfImporte.getText()));
        tfProducto.setText("");
        tfUnidades.setText("");
        tfImporte.setText("");
        tfPrecio.setText("");
        cbProveedor.addItem("");
        tfProducto.grabFocus();
        ButtonGroup.clearSelection();

    }

    public void habilitarVenta(){
        Venta venta  = new Venta();
        venta.pack();
        venta.setVisible(true);
        rellenarPrecioVenta();
    }

    public int comprobarRB() {
        if (compra.isVisible() && !venta.isVisible()){
            return 1;
        }else if (venta.isVisible() && !compra.isVisible()){
            return 2;
        }
        else
            return 0;
    }

    public void  rellenarPrecioVenta(){
        float precioFinal = 0.0f;
        precio = Main.buscarPrecioPro(tfProducto.getText());
        tfPrecioV.setText(String.valueOf(precio*2));
        tfPrecioV.setEditable(false);
        precio = (precio*2)* Float.parseFloat(tfUnidades.getText());
        precioFinal=precio;
        if (cbVolumen.isSelected()){
            precioFinal-=(precio *0.02);
        }
        if (cbProntoPago.isSelected()){
            precioFinal-=(precio*0.03);
        }
        tfImporteV.setText(String.valueOf(precioFinal));

   }

    public JPanel getPanel(){
        return panel1;
    }
}
