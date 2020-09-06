package practico1.dao.clas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	@Override
	public ResultSet productoMayorRecaudacion(Connection conn) throws SQLException {
		
		String productoRecaudacion =	" SELECT prod.*, SUM(fac.cantidad * prod.valor) AS Recaudacion" +
				 						" FROM factura_producto fac" +
									 	" INNER JOIN producto prod ON fac.idProducto = prod.idProducto" +
										" GROUP BY prod.idProducto" +
										" ORDER BY SUM(fac.cantidad * prod.valor) desc" +
										" LIMIT 1;";
		PreparedStatement ps = conn.prepareStatement(productoRecaudacion);
		ResultSet result = ps.executeQuery();
		return result;
		
	}

	@Override
	public ResultSet clienteMayorFacturacion(Connection conn) throws SQLException {
		
		String clienteFacturacion = " SELECT c.*, SUM(fp.cantidad * p.valor) AS 'Total Facturado' FROM cliente c" +
									 " JOIN factura f ON c.idCliente = f.idCliente" +
									 " JOIN factura_producto fp ON f.idFactura = fp.idFactura" +
									 " JOIN producto p ON fp.idProducto = p.idProducto" +
									 " GROUP BY c.idCliente" +
									 " ORDER BY SUM(fp.cantidad * p.valor) DESC;";
		PreparedStatement ps = conn.prepareStatement(clienteFacturacion);
		ResultSet result = ps.executeQuery();
		
		return result;
	}
	
	

}
