package practico1.dao.clas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import practico1.dao.interf.FacturaDAO;

public class MySQLFacturaDAO implements FacturaDAO {

	@Override
	public void insertarFactura(Connection conn, int idFactura, int idCliente) throws SQLException {
		String insertFactura = "INSERT INTO factura (idFactura, idCliente) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(insertFactura);
		ps.setInt(1, idFactura);
		ps.setInt(2, idCliente);
		ps.executeUpdate();
		conn.commit(); 
	}

	@Override
	public void insertarProducto(Connection conn, int idFactura, int idProducto, int cantidad) throws SQLException {
		String insertFactura = "INSERT INTO factura_producto (idFactura, idProducto, cantidad) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(insertFactura);
		ps.setInt(1, idFactura);
		ps.setInt(2, idProducto);
		ps.setInt(3, cantidad);
		ps.executeUpdate();
		conn.commit();		
	}
	
	

}
