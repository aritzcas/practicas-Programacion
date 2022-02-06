package vistas;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class paginaPrincipal {
    private JPanel panelPrincipal;
    private JLabel lTitulo;
    private JTextField tfDNI;
    private JTextField tfNombre;
    private JTextField tfApellidos;
    private JTextField tfCurso;
    private JLabel lDNI;
    private JLabel lNombre;
    private JLabel lApellidos;
    private JLabel lCurso;
    private JButton bAceptar;
    private JButton bSalir;

    public paginaPrincipal() {
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,"Hola");
                fAceptar();
            }
        });
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }
    public void fAceptar()
    {
        //JOptionPane.showMessageDialog(null,"Adios");
        // Validar y enviar al Controlador
        if (datosCorrectos()&& validarCurso())
        {
            Main.crearPersona(tfNombre.getText(), tfApellidos.getText(), tfDNI.getText());
            limpiarTF();
        }
    }

    public boolean datosCorrectos(){
        try {
            Pattern pat = Pattern.compile("^[0-9]{8}[A-Za-z]$");
            Matcher mat = pat.matcher(tfDNI.getText());
            if (tfDNI.getText().isEmpty() || !mat.matches()) {
                JOptionPane.showMessageDialog(null, "El dni no existe o no puede estar vacio.");
            }
            if (tfNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio.");
            }
            if (tfApellidos.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "El apellido no puede estar vacio.");
            }
           return true;
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error");
            return false;
        }

    }
    public boolean validarCurso(){

            if (tfCurso.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "No puede estar vacio.");

            if (!Main.tenDatos(tfCurso.getText()))
                JOptionPane.showMessageDialog(null, "No existe el curso");

            return true;

    }
    public  void main(String[] args) {
        JFrame frame = new JFrame("paginaPrincipal");
        frame.setContentPane(new paginaPrincipal().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public  JPanel getPanel(){
        return panelPrincipal;
    }
    public void limpiarTF(){
        tfDNI.setText("");
        tfDNI.setEditable(true);
        tfNombre.setText("");
        tfNombre.setEditable(true);
        tfApellidos.setText("");
        tfApellidos.setEditable(true);
        tfCurso.setText("");
        tfCurso.setEditable(true);
        tfDNI.requestFocus();
    }
}


