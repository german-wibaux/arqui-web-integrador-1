package practico1.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlJDBCDAOFactory extends DAOFactory {	
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/exampleDB";
	
	public static Connection createConnection() {
		Connection conn = null;
		
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
			return conn;
			
		} catch (SQLException e) {  
			e.printStackTrace();
		}
		
		
		return conn;
		
	}
	
	public Connection getConnection() {
		return MySqlJDBCDAOFactory.createConnection();
	}

	@Override
	public PersonDAO getPersonDAO() {
		return new MySQLPersonDAO();
	}
	
	

}
