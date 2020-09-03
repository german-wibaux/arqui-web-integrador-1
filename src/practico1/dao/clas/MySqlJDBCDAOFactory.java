package practico1.dao.clas;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import practico1.dao.factory.DAOFactory;
import practico1.dao.interf.ClienteDAO;
import practico1.dao.interf.FacturaDAO;
import practico1.dao.interf.ProductoDAO;

public class MySqlJDBCDAOFactory extends DAOFactory implements AutoCloseable {	
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/exampleDB";
	public static Connection conn = null;
	
	public MySqlJDBCDAOFactory() throws Exception {
		Connection connection = this.getConnection();
		MySqlJDBCDAOFactory.createTables(connection);
		this.close();
	}
	
	private static Connection createConnection() {		
		
		try {
			Class.forName(DRIVER).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		try {
			conn = DriverManager.getConnection(DBURL, "root", "password");
			conn.setAutoCommit(false);
			return conn;
			
		} catch (SQLException e) {  
			e.printStackTrace();
		}		
		
		return conn;
		
	}
	
	private static void createTables(Connection conn) throws SQLException {
		String t_cliente = "CREATE TABLE IF NOT EXISTS cliente(" +
				"idCliente INT," +
				"nombre VARCHAR(500)," +
				"email VARCHAR(150)," +
				"PRIMARY KEY(idCliente))";
		
		String t_factura = "CREATE TABLE IF NOT EXISTS factura(" +
				"idFactura INT," +
				"idCliente INT," +
				"PRIMARY KEY(idFactura))";
		
		String t_producto = "CREATE TABLE IF NOT EXISTS producto(" +
				"idProducto INT," +
				"nombre VARCHAR(45)," +
				"valor FLOAT," +
				"PRIMARY KEY(idProducto))";
		
		String t_factura_producto = "CREATE TABLE IF NOT EXISTS factura_producto(" +
				"idFactura INT," +
				"idProducto INT," +
				"cantidad INT," +
				"PRIMARY KEY(idFactura, idProducto))";		
		conn.prepareStatement(t_cliente).execute();
		conn.prepareStatement(t_factura).execute();
		conn.prepareStatement(t_producto).execute();
		conn.prepareStatement(t_factura_producto).execute();
		conn.commit();
	}
	
	public Connection getConnection() {
		return MySqlJDBCDAOFactory.createConnection();
	}
	
	public void close() throws Exception {
		conn.close();
	}	

	@Override
	public ClienteDAO getClienteDAO() {
		return new MySQLClienteDAO();
	}
	
	@Override
	public FacturaDAO getFacturaDAO() {
		return new MySQLFacturaDAO();
	}
	
	@Override
	public ProductoDAO getProductoDAO() {
		return new MySQLProductoDAO();
	}
	

}
