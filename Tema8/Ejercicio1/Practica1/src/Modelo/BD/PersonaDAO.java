package Modelo.BD;

import Modelo.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonaDAO {
    private final Connection con;

    public PersonaDAO(Connection con) {
        this.con = con;
    }

    public void insertPersona(Persona p) throws Exception {

        String insert = ("INSERT INTO tabla1 VALUES (?,?,?,?)");
        PreparedStatement ps = con.prepareStatement(insert);
        ps.setString(1, p.getNombre());
        ps.setInt(2, p.getEdad());
        ps.setString(3, p.getProfesion());
        ps.setString(4, p.getTelefono());

        int n = ps.executeUpdate();

        if (n != 1) {
            throw new Exception("El numero de filas actualizadas no es el correcto");
        }
    }

    public Persona consultarPersona(String nombre) throws Exception
    {
        Persona persona=null;

        PreparedStatement consulta = con.prepareStatement("SELECT * FROM personas where nombre = ' " + nombre +" '");
        ResultSet res = consulta.executeQuery();
        // 0 o 1 fila seleccionada
        if(res.next())
        {
            persona= new Persona();
            persona.setNombre(res.getString("nombre"));
            persona.setEdad(res.getInt("edad"));
            persona.setProfesion(res.getString("profesion"));
            persona.setTelefono(res.getString("telefono"));
        }
        else
            throw new Exception ("Persona no encontrada");


        res.close();
        consulta.close();

        return persona;
    }

}
