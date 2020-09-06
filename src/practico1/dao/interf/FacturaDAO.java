package practico1.dao.interf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface FacturaDAO {
	
	public void insertarFactura(Connection conn, int idFactura, int idCliente) throws SQLException;

	void insertarProducto(Connection conn, int idFactura, int idProducto, int cantidad) throws SQLException;
	
	ResultSet productoMayorRecaudacion(Connection conn) throws SQLException;
	
	ResultSet clienteMayorFacturacion(Connection conn) throws SQLException;

}
 