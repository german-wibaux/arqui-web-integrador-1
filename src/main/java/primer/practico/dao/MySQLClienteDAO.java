package primer.practico.dao;

import primer.practico.entity.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLClienteDAO implements ClienteDAO {

    @Override
    public void insertarCliente(Connection conn, int id, String nombre, String email) throws SQLException {
        String insertarCliente = "INSERT INTO cliente (id, nombre, email) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(insertarCliente);
        conn.setAutoCommit(false);
        ps.setInt(1, id);
        ps.setString(2, nombre);
        ps.setString(3, email);
        ps.executeUpdate();
        ps.close();
        conn.commit();
    }

    public static void createTableCliente(Connection conn) throws SQLException {
        String table = "CREATE TABLE Cliente (id INT,nombre VARCHAR(500),email VARCHAR(500),PRIMARY KEY (id))";
        conn.prepareStatement(table).execute();
    }
}