package practico1.dao.clas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import practico1.dao.interf.ProductoDAO;

public class MySQLProductoDAO implements ProductoDAO {

	@Override
	public void insertarProducto(Connection conn, int idProducto, String nombre, float valor) throws SQLException {
		String insertFactura = "INSERT INTO producto (idProducto, nombre, valor) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(insertFactura);
		ps.setInt(1, idProducto);
		ps.setString(2, nombre);
		ps.setFloat(3, valor);
		ps.executeUpdate();
		conn.commit();		
	}
	
		 
	

	
	
}
