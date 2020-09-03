package primer.practico.dao;

import primer.practico.entity.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacturaDAO {

    public void insertarFactura(Connection conn, int id, Cliente idCliente) throws SQLException {
        String insertarProducto = "INSERT INTO Facturas (id, idCliente) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(insertarProducto);
        conn.setAutoCommit(false);
        ps.setInt(1, id);
        ps.setObject(2, idCliente);
        ps.executeUpdate();
        ps.close();
        conn.commit();
    }

    public static void createTableFactura(Connection conn) throws SQLException {
        String table = "CREATE TABLE Facturas (id INT,idCliente INT,PRIMARY KEY (id))";
        conn.prepareStatement(table).execute();
    }
}
