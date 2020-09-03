package primer.practico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductoDAO {

    public void insertarProducto(Connection conn, int id, String nombre, float valor) throws SQLException {
        String insertarProducto = "INSERT INTO Productos (id, nombre, valor) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(insertarProducto);
        conn.setAutoCommit(false);
        ps.setInt(1, id);
        ps.setString(2, nombre);
        ps.setFloat(3, valor);
        ps.executeUpdate();
        ps.close();
        conn.commit();
    }

    public static void createTableProducto(Connection conn) throws SQLException {
        String table = "CREATE TABLE Productos (id INT,nombre VARCHAR(500),valor FLOAT ,PRIMARY KEY (id))";
        conn.prepareStatement(table).execute();
    }
}
