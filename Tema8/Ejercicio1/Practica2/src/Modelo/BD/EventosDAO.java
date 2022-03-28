package Modelo.BD;

import Modelo.UML.Evento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

public class EventosDAO {
    private static String plantilla;

    private  static PreparedStatement sentenciaPre;
    public static void insertar(Evento e) throws Exception {
        BaseDatos.AbrirBase();
        plantilla = "INSERT INTO tabla2 VALUES (?,?,?,?,?,?)";
        sentenciaPre = BaseDatos.getConnection().prepareStatement(plantilla);
        sentenciaPre.setString(1,e.getNombre());
        sentenciaPre.setString(2,e.getLugar());
        sentenciaPre.setDate(3, conversionDate(e.getFecha()));
        sentenciaPre.setTime(4, conversionTime(e.getHoraIncio()));
        sentenciaPre.setTime(5, conversionTime(e.getHoraFin()));
        sentenciaPre.setInt(6,e.getNumPersonas());
        int n = sentenciaPre.executeUpdate();
        System.out.println( n + "filas insertadas");

        // Cerrar la conexión
        BaseDatos.desconectar();


    }
    public static java.sql.Date conversionDate(LocalDate fecha)
    {
        // Conversión LocalDate en java.sql.Date
        return java.sql.Date.valueOf(fecha);
    }

    public static java.sql.Time conversionTime(java.time.LocalTime hora)
    {
        // Conversion java.time.LocalTime en java.sql.Time
        return java.sql.Time.valueOf(hora);
    }


    public static void borrarEvento(Evento e) throws Exception{
        BaseDatos.AbrirBase();
        plantilla = "DELETE FROM tabla2 where nombre = '"+e.getNombre()+"'";
        sentenciaPre = BaseDatos.getConnection().prepareStatement(plantilla);

        int n = sentenciaPre.executeUpdate();
        System.out.println( n + "filas Eliminadas");
        BaseDatos.desconectar();
    }


    public static Evento buscarEvento(Evento e) throws Exception{
        BaseDatos.AbrirBase();
        plantilla ="SELECT * FROM tabla2 where nombre = '"+e.getNombre()+"'";
        sentenciaPre = BaseDatos.getConnection().prepareStatement(plantilla);
        ResultSet res = sentenciaPre.executeQuery();
        Evento evento;
        if(res.next())
        {
            evento= new Evento();
            evento.setNombre(res.getString("nombre"));
            evento.setLugar(res.getString("lugar"));
            evento.setFecha(LocalDate.parse(res.getString("fecha")));
            evento.setHoraIncio(LocalTime.parse(res.getString("horaInicio")));
            evento.setHoraFin(LocalTime.parse(res.getString("horaFinal")));
            evento.setNumPersonas(res.getInt("numPersonas"));
        }
        else
            throw new Exception ("Evento no encontrado");
        BaseDatos.desconectar();
        return evento;
    }
    public  static void updateEvento(Evento e,String nombreViejo) throws  Exception{
        BaseDatos.AbrirBase();
        plantilla ="UPDATE `tabla2` SET `nombre`='"+e.getNombre()+ "',`lugar`='"+e.getLugar()+"',`fecha`='"+e.getFecha()+"',`horaInicio`='"+e.getHoraIncio()+"',`horaFinal`='"+e.getHoraFin()+"',`numPersonas`='"+e.getNumPersonas()+"' WHERE= `nombre`='"+nombreViejo+"' ";
        sentenciaPre = BaseDatos.getConnection().prepareStatement(plantilla);

        int n = sentenciaPre.executeUpdate();
        System.out.println( n + "filas Actualizadas");
        BaseDatos.desconectar();
    }
}
