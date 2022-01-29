package Vistas;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class altaPersonas extends JFrame {
    private JPanel panelPrincipal;
    private JTextField tfNombre;
    private JTextField tfApellidos;
    private JLabel lTitulo;
    private JLabel lNombre;
    private JLabel lApellidos;
    private JTextField tfDNI;
    private JButton bAceptar;
    private JButton bSalir;
    private JLabel lDNID;


    public altaPersonas() {
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String name = tfNombre.getText();
                    String apellido = tfApellidos.getText();
                    String dni = tfDNI.getText();
                    if (!name.isEmpty() && !apellido.isEmpty() && !dni.isEmpty()) {
                        Main.guardarPersona(name, apellido, dni);
                        vaciar();
                    }else{
                        throw new Exception("No puedes dejar ningun campo vacio.");
                    }
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());

                }}});
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarDatos();
            }
        });
    }
    public  void vaciar(){
        tfNombre.setText("");
        tfApellidos.setText("");
        tfDNI.setText("");
        tfNombre.requestFocus();
    }
    public JPanel enseñarPanel(){
        return panelPrincipal;
    }

    public static void main(String args[]){
        JFrame altaPersonas = new JFrame("altaPersonas");
        altaPersonas.setContentPane(new altaPersonas().panelPrincipal);
        altaPersonas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        altaPersonas.setVisible(true);
        altaPersonas.pack();

    }
}
