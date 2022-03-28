package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;

public class DCrearEmpresa extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lNombre;
    private JTextField tfNombreEmpresa;
    private JTextField tfDireccion;
    private JLabel lDireccion;
    private JTextField tfTelefono;
    private JLabel lTelefono;

    public DCrearEmpresa() {
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
        try {
            validarNombre();
            validarDireccion();
            Main.getEmpresa(tfNombreEmpresa.getText(),tfDireccion.getText(),Integer.parseInt(tfTelefono.getText()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void validarNombre() throws Exception
    {
        if (tfNombreEmpresa.getText().isEmpty())
            throw new Exception("El nombre es un dato obligatorio");
        // Expresión regular para comprobar letras
    }

    public void validarDireccion() throws Exception
    {
        if (tfDireccion.getText().isEmpty())
            throw new Exception("El lugar es un dato obligatorio");
        // Expresión regular para comprobar letras
    }
    public void validarTelefono() throws Exception
    {
        if (tfTelefono.getText().isEmpty())
            throw new Exception("El nombre es un dato obligatorio");
        // Expresión regular para comprobar letras
    }
}
