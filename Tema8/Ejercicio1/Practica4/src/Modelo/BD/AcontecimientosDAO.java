package Modelo.BD;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Modelo.UML.Acontecimiento;
import Modelo.UML.Empresa;

public class AcontecimientosDAO {

    /* Clase que contiene los métodos necesarios para trabajar
       con la tabla acontecimientos */

    private  static Acontecimiento acontecimiento;
    private  static Empresa emp;
    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;

    public  static void alta(Acontecimiento ac) throws Exception
    {
        /* Método que inserta una fila en la tabla de los acontecimientos a partir de un objeto de tipo acontecimiento.
        Este método también se suele llamar save.*/

        // Abrir la conexión
        BaseDatos.abrirBD();

        // Preparar la sentencia que se quiere ejecutar
        plantilla = "INSERT INTO eventos (nombre, lugar, fecha,hora_i, hora_f, aforo) VALUES (?,?,?,?,?,?)";
        sentenciaPre = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,ac.getNombre());
        sentenciaPre.setString(2,ac.getLugar());
        sentenciaPre.setDate(3, conversionDate(ac.getFecha()));
        sentenciaPre.setTime(4, conversionTime(ac.getHoraI()));
        sentenciaPre.setTime(5, conversionTime(ac.getHoraF()));
        sentenciaPre.setInt(6,ac.getAforo());

        // Ejecutar sentencia
        int n = sentenciaPre.executeUpdate();
        System.out.println( n + "filas insertadas");

        // Cerrar la conexión
        BaseDatos.cerrarBD();
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

    public static Acontecimiento consultarAcontecimiento(String n) throws Exception{

        // Método que consultar un acontecimiento de la base de datos
        BaseDatos.abrirBD();

        plantilla = "select *  from eventos where nombre = ?";
        sentenciaPre = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,n);

        resultado = sentenciaPre.executeQuery();
        if (resultado.next())
        {
            crearObjeto();
        }
        else
            throw new Exception("No hay ningún acontecimiento con ese nombre");

        BaseDatos.cerrarBD();

        return acontecimiento;
    }
    public static Empresa consultarEmpresas(String n) throws Exception{

        // Método que consultar un acontecimiento de la base de datos
        BaseDatos.abrirBD();

        plantilla = "select *  from empresas where nombre = ?";
        sentenciaPre = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,n);

        resultado = sentenciaPre.executeQuery();
        if (resultado.next())
        {
           emp = new Empresa();
           emp.setNombre(resultado.getString("nombre"));
           emp.setDireccion(resultado.getString("direccion"));
           emp.setTelefono(resultado.getInt("telefono"));
        }
        else
            throw new Exception("No hay ningúna empresa con ese nombre");

        BaseDatos.cerrarBD();

        return emp;
    }
    public static void crearObjeto() throws Exception
    {
        acontecimiento = new Acontecimiento();
        acontecimiento.setNombre(resultado.getString("nombre"));
        acontecimiento.setLugar(resultado.getString("lugar"));
        // de java.sql.Date a LocalDate
        // LocalDate f = resultado.getDate("fecha").toLocalDate(); //yyyy-mm-dd
        String fe = new SimpleDateFormat("dd/MM/yyyy").format(resultado.getDate("fecha")); // paso a String
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fe, formato);


        //System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(resultado.getDate("fecha")));

        acontecimiento.setFecha(fecha);

        acontecimiento.setHoraI(resultado.getTime("hora_i").toLocalTime());
        acontecimiento.setHoraF(resultado.getTime("hora_f").toLocalTime());
        acontecimiento.setAforo(resultado.getInt("aforo"));
    }

    public static void borrar(Acontecimiento ac) throws Exception{

        // Método que borrar un acontecimiento de la base de datos
        BaseDatos.abrirBD();
        plantilla = "delete from eventos where nombre = ?";
        sentenciaPre = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,ac.getNombre());

        int n = sentenciaPre.executeUpdate();
        if (n == 0)
            throw new Exception();

        System.out.println( n + " filas borradas");

        BaseDatos.cerrarBD();
    }

    public static ArrayList<Acontecimiento> consultarAcontecimientos() throws Exception{

        // Método que consultar un acontecimiento de la base de datos
        BaseDatos.abrirBD();

        plantilla = "select *  from eventos";
        sentenciaPre = BaseDatos.getCon().prepareStatement(plantilla);

        // Podía ser un Statement

        resultado = sentenciaPre.executeQuery();
        ArrayList<Acontecimiento> lista = new ArrayList<>();
        while (resultado.next())
        {
            crearObjeto();
            lista.add(acontecimiento);
        }

        BaseDatos.cerrarBD();

        return lista;
    }

    public static ArrayList<Empresa> consultarEmpresas() throws Exception{

        // Método que consultar un acontecimiento de la base de datos
        BaseDatos.abrirBD();

        plantilla = "select *  from empresas";
        sentenciaPre = BaseDatos.getCon().prepareStatement(plantilla);

        resultado = sentenciaPre.executeQuery();
        ArrayList<Empresa> listaemp = new ArrayList<>();
        while (resultado.next())
        {
            emp = new Empresa();
            emp.setNombre(resultado.getString("nombre"));
            emp.setDireccion(resultado.getString("direccion"));
            emp.setTelefono(resultado.getInt("telefono"));
            listaemp.add(emp);
        }
        BaseDatos.cerrarBD();

        return listaemp;
    }
    public  static void actualizar(Acontecimiento ac) throws Exception
    {
        /* Método que inserta una fila en la tabla de los acontecimientos a partir de un objeto de tipo acontecimiento.
        Este método también se suele llamar save.*/

        // Abrir la conexión
        BaseDatos.abrirBD();

        // Preparar la sentencia que se quiere ejecutar
        plantilla = "update eventos set lugar = ?, fecha = ?,hora_i = ?, hora_f = ?, aforo = ?  where nombre = ?";
        sentenciaPre = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(6,ac.getNombre());
        sentenciaPre.setString(1,ac.getLugar());
        sentenciaPre.setDate(2, conversionDate(ac.getFecha()));
        sentenciaPre.setTime(3, conversionTime(ac.getHoraI()));
        sentenciaPre.setTime(4, conversionTime(ac.getHoraF()));
        sentenciaPre.setInt(5,ac.getAforo());

        // Ejecutar sentencia
        int n = sentenciaPre.executeUpdate();
        System.out.println( n + "filas modificadas");


        // Cerrar la conexión
        BaseDatos.cerrarBD();
    }

    public  static void insertarEmpresa(Empresa e) throws Exception
    {
        /* Método que inserta una fila en la tabla de los acontecimientos a partir de un objeto de tipo acontecimiento.
        Este método también se suele llamar save.*/

        // Abrir la conexión
        BaseDatos.abrirBD();

        // Preparar la sentencia que se quiere ejecutar
        plantilla = "INSERT INTO empresas (nombre, direccion, telefono) VALUES (?,?,?)";
        sentenciaPre = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,e.getNombre());
        sentenciaPre.setString(2,e.getDireccion());
        sentenciaPre.setInt(3, e.getTelefono());

        // Ejecutar sentencia
        int n = sentenciaPre.executeUpdate();
        System.out.println( n + "filas modificadas");


        // Cerrar la conexión
        BaseDatos.cerrarBD();
    }
}
