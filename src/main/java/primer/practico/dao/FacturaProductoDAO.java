package primer.practico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacturaProductoDAO {

    public void insertarFacturaProducto(Connection conn, int id, int idProducto, int idFactura) throws SQLException {
        String insertarProducto = "INSERT INTO Producto (id, idProducto, idFactura) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(insertarProducto);
        conn.setAutoCommit(false);
        ps.setInt(1, id);
        ps.setInt(2, idProducto);
        ps.setInt(3, idFactura);
        ps.executeUpdate();
        ps.close();
        conn.commit();
    }

    public static void createTableFacturaProducto(Connection conn) throws SQLException {
        String table = "CREATE TABLE Factura_Producto (id INT,idProducto INT,idFactura INT,PRIMARY KEY (id))";
        conn.prepareStatement(table).execute();
    }
}
