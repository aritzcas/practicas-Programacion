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
    }
    public void fAceptar()
    {
        //JOptionPane.showMessageDialog(null,"Adios");
        // Validar y enviar al Controlador
        if (datosCorrectos())
        {
            Main.tenDatos(tfDNI.getText());

            //Main.crearPersona(tfNombre.getText(),tfApellidos.getText(),tfDNI.getText());
        }
    }

    public boolean datosCorrectos(){
        try {
            Pattern pat = Pattern.compile("^[0-9]{8}[A-Za-z]$");
            Matcher mat = pat.matcher(tfDNI.getText());
            if (tfDNI.getText().isEmpty() || !mat.matches()) {
                throw new Exception("El DNI no esta, o no es correcto.");
            }
            if (tfNombre.getText().isEmpty()){
                throw new Exception("El nombre no puede estar vacio.");
            }
            if (tfApellidos.getText().isEmpty()){
                throw new Exception("El apellido no puede estar vacio.");
            }
            if (tfCurso.getText().isEmpty()){
                throw new Exception("El curso no puede estar vacio.");
            }
            return true;
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("paginaPrincipal");
        frame.setContentPane(new paginaPrincipal().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}


