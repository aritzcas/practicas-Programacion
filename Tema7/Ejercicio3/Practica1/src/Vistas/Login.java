package Vistas;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends JDialog {
    private JPanel contentPane;
    private JButton bEntrar;
    private JTextField tfDNI;
    private JTextField tfContrasena;
    private JButton b3;
    private JButton b5;
    private JButton b4;
    private JButton b2;
    private JButton b1;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton b10;
    private JLabel lDNI;
    private JLabel lContasena;
    private JButton bBorrarContrasena;

    public Login() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(bEntrar);
        numerosRandom();
        tfContrasena.setEditable(false);


        bEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Main.comprobarClave(tfDNI.getText(), Integer.parseInt(tfContrasena.getText()))==true){
                    new VentanaTran();
                }else{
                    javax.swing.JOptionPane.showMessageDialog(null, "La contraseña no es correcta.");
                    tfContrasena.setText("");

                }
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfContrasena.setText(tfContrasena.getText()+textoBoton(e));
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfContrasena.setText(tfContrasena.getText()+textoBoton(e));
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfContrasena.setText(tfContrasena.getText()+textoBoton(e));
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfContrasena.setText(tfContrasena.getText()+textoBoton(e));
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfContrasena.setText(tfContrasena.getText()+textoBoton(e));
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfContrasena.setText(tfContrasena.getText()+textoBoton(e));
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfContrasena.setText(tfContrasena.getText()+textoBoton(e));
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfContrasena.setText(tfContrasena.getText()+textoBoton(e));
            }
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfContrasena.setText(tfContrasena.getText()+textoBoton(e));
            }
        });
        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfContrasena.setText(tfContrasena.getText()+textoBoton(e));
            }
        });
        tfDNI.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                comprobarDNIValido(tfDNI.getText());
            }
        });
        bBorrarContrasena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfContrasena.setText("");
                numerosRandom();
            }
        });

        this.pack();
        this.setVisible(true);
    }

    private void onOK() {
        dispose();
    }



    private void numerosRandom(){
        Integer [] numeros={1,2,3,4,5,6,7,8,9,0};
        List<Integer> listaNumeros= Arrays.asList(numeros);

        Collections.shuffle(listaNumeros);
        listaNumeros.toArray(numeros);
        b1.setText(String.valueOf(numeros[0]));
        b2.setText(String.valueOf(numeros[1]));
        b3.setText(String.valueOf(numeros[2]));
        b4.setText(String.valueOf(numeros[3]));
        b5.setText(String.valueOf(numeros[4]));
        b6.setText(String.valueOf(numeros[5]));
        b7.setText(String.valueOf(numeros[6]));
        b8.setText(String.valueOf(numeros[7]));
        b9.setText(String.valueOf(numeros[8]));
        b10.setText(String.valueOf(numeros[9]));

    }
    private String textoBoton(ActionEvent e){
        return ((JButton) e.getSource()).getText();
    }

    private void comprobarDNIValido(String dni){
        Pattern pat = Pattern.compile("[0-9]{7,8}[A-Za-z]");
        Matcher mat = pat.matcher(dni);
        if (dni.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(null,"No puede estar vacio el DNI");
            tfDNI.grabFocus();
            tfDNI.setText("");
            tfContrasena.setText("");
        }else if(!mat.matches()){
            javax.swing.JOptionPane.showMessageDialog(null,"El DNI no es correcto");
            tfDNI.grabFocus();
            tfDNI.setText("");
            tfContrasena.setText("");
        }else if (!Main.comprobarDNI(dni)){
            javax.swing.JOptionPane.showMessageDialog(null,"El DNI no esta en nuestra Base de Datos");
            tfDNI.grabFocus();
            tfDNI.setText("");
            tfContrasena.setText("");
        }
    }
}
