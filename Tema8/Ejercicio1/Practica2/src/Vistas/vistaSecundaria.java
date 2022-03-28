package Vistas;

import Modelo.UML.Evento;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class vistaSecundaria extends JDialog {
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
    private JPanel JPInsertar;
    private JButton bBuscar;
    private LocalDate fechaLD;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String nombreViejo;
    public vistaSecundaria(String opcion) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        if (opcion.equalsIgnoreCase("cancelar")) {
            JPInsertar.setVisible(false);
        }else if(opcion.equalsIgnoreCase("editar")){
            bBuscar.setVisible(true);
        }
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (opcion.equalsIgnoreCase("cancelar")) {
                    try {
                        validarTexto(tfNombre.getText());
                        Main.borrarEvento(tfNombre.getText());
                        dispose();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }else if (opcion.equalsIgnoreCase("editar")) {
                    try {
                        updateEvento();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                else
                {
                    onOK();
                }
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
        bBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (opcion.equalsIgnoreCase("editar")){
                    try {
                        rellenar(tfNombre.getText());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    private void onOK() {
        try {
            validarTexto(tfNombre.getText());
            validarTexto(tfLugar.getText());
            validarFecha(tfFecha.getText());
            validarHoras();

            Main.insertar(tfNombre.getText(), tfLugar.getText(), fechaLD, horaInicio, horaFin, Integer.parseInt(tfPersonas.getText()));
            dispose();
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void validarTexto(String texto) throws Exception {
        if (texto.isEmpty())
            throw new Exception("El no puedes dejar nada vacio.");
    }

    public void validarFecha(String fecha) throws Exception {
        if (fecha.isEmpty()) {
            throw new Exception("No puedes dejar la fecha vacia.");
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fechaLD = LocalDate.parse(fecha, format);
        if (fechaLD.isBefore(LocalDate.now())) {
            throw new Exception("La fecha no puede ser antes que hoy");
        }
    }

    public void validarHoras() throws Exception {
        if (tfHoraInicio.getText().isEmpty())
            throw new Exception("La hora de inicio del acontecimiento es un dato obligatorio");
        if (tfHoraFin.getText().isEmpty())
            throw new Exception("La hora de finalización del acontecimiento es un dato obligatorio");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        horaFin = LocalTime.parse(tfHoraFin.getText(), formatter);
        horaInicio = LocalTime.parse(tfHoraInicio.getText(), formatter);

        if (horaFin.compareTo(horaInicio) <= 0)
            throw new Exception("Horas no validas");
    }

    public void rellenar(String nombre) throws Exception{
        Evento e = Main.buscarEvento(tfNombre.getText());
        nombreViejo=tfNombre.getText();
        tfLugar.setText(e.getLugar());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String text = e.getFecha().format(format);
        LocalDate fecha =LocalDate.parse(text, format);;

        tfFecha.setText(String.valueOf(fecha));
        tfHoraInicio.setText(String.valueOf(e.getHoraIncio()));
        tfHoraFin.setText(String.valueOf(e.getHoraFin()));
        tfPersonas.setText(String.valueOf(e.getNumPersonas()));
    }
    public void updateEvento()throws Exception{
        validarTexto(tfNombre.getText());
        validarTexto(tfLugar.getText());
        validarFecha(tfFecha.getText());
        validarHoras();

        Main.updateEvento(tfNombre.getText(), tfLugar.getText(), fechaLD, horaInicio, horaFin, Integer.parseInt(tfPersonas.getText()), nombreViejo);
    }

}
