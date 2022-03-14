package Vistas;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDate;

public class vistaInsertar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfNombre;
    private JTextField tfLugar;
    private JTextField tfFecha;
    private JTextField tfHoraInicio;
    private JTextField tfHoraFin;
    private JPanel lNombre;
    private JLabel lLugar;
    private JLabel lFecha;
    private JLabel lHoraInicio;
    private JLabel lHoraFin;
    private JTextField tfPersonas;
    private JLabel lPersonas;

    public vistaInsertar() {
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
        Main.insertar(tfNombre.getText(),tfLugar.getText(),LocalDate.parse(tfFecha.getText()), Integer.parseInt(tfHoraInicio.getText()), Integer.parseInt(tfHoraFin.getText()),Integer.parseInt(tfPersonas.getText()));
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        vistaInsertar dialog = new vistaInsertar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
