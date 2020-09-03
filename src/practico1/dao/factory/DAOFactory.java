package practico1.dao.factory;

import java.sql.Connection;

import practico1.dao.clas.MySqlJDBCDAOFactory;
import practico1.dao.interf.ClienteDAO;
import practico1.dao.interf.FacturaDAO;
import practico1.dao.interf.ProductoDAO;

public abstract class DAOFactory {
	
	public static final int MYSQL_JDBC = 1;
	//public static final int DERBY_JDBC = 2;
	
	public abstract ClienteDAO getClienteDAO();
	
	public abstract FacturaDAO getFacturaDAO();
	
	public abstract ProductoDAO getProductoDAO();
	
	public abstract Connection getConnection();
	
	public static DAOFactory getDAOFactory(int whichFactory) throws Exception {
		
		switch(whichFactory) {
		case MYSQL_JDBC : return new MySqlJDBCDAOFactory();
		default: return null;
		}
		
		
	}

}
