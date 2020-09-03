package practico1.dao.interf;

import java.sql.Connection;
import java.sql.SQLException;

public interface FacturaDAO {
	
	public void insertarFactura(Connection conn, int idFactura, int idCliente) throws SQLException;

	void insertarProducto(Connection conn, int idFactura, int idProducto, int cantidad) throws SQLException;

}
