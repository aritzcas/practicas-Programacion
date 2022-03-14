package Modelo.BD;

import Modelo.Personas;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PersonaDAO {
    private final Connection con;

    public PersonaDAO(Connection con) {
        this.con = con;
    }

    public void insertPersona(Personas p) throws Exception {

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

}
