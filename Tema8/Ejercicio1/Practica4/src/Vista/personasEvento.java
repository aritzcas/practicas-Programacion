package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class personasEvento extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbEvento;
    private JLabel Evento;
    private JTextField tfNombre;
    private JTextField tfEdad;
    private JLabel lNombre;
    private JLabel lEdad;
    private JLabel lEmpresa;
    private JComboBox cbEmpresas;
    private JButton bEmpresa;

    public personasEvento() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        añadirEventoscb();
        añadirEmpresascb();

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
        bEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarEmpresa();
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

    public void añadirEventoscb(){
        try{
            ArrayList<String> eventos = Main.datosLlenarCombo();
        for(String n:eventos)
            cbEvento.addItem(n);
        cbEvento.setSelectedIndex(-1);
    }
        catch(Exception e)
    {
        System.out.println("Problemas llenando la combo");
    }
    }

    public void añadirEmpresascb(){
        try{
            ArrayList<String> empresas = Main.datosLlenarComboEmpresas();
            for(String n:empresas)
                cbEmpresas.addItem(n);
            cbEmpresas.setSelectedIndex(-1);
        }
        catch(Exception e)
        {
            System.out.println("Problemas llenando la combo");
        }
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
