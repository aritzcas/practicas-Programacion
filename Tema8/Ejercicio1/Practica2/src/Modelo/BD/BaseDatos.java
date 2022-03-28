package Modelo.BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/ejercicio1";
    private static String user = "root";
    private static   String passwd = "usbw";

    private static Connection con;


    public static void AbrirBase() throws Exception {

        // 1. Cargar el controlador de acceso a datos
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(url, user, passwd);

        if(con ==null){
            throw  new Exception("Error en la conexion");
        }
    }

    public static Connection getConnection(){
        return con;
    }
    public static void desconectar() throws Exception{
        con.close();
    }
}
