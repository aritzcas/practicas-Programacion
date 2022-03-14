package Modelo.BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class BasedeDatos {
    private String url = "jdbc:mysql://localhost:3306/ejercicio1";
    private String user = "root";
    private  String passwd = "usbw";

    private Connection con;


    public BasedeDatos() throws Exception {


        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(url, user, passwd);

        if(con ==null){
            throw  new Exception("Error en la conexion");
        }
    }

    public Connection getConnection(){
        return con;
    }
    public void desconectar() throws Exception{
        con.close();
    }
}
