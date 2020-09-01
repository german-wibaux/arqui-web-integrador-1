package practico1.client;

import java.sql.Connection;
import java.sql.SQLException;

import practico1.dao.DAOFactory;
import practico1.dao.MySQLPersonDAO;
import practico1.dao.MySqlJDBCDAOFactory;

public class serviceLayer {

	
	public static void main(String[] args) throws Throwable {
	
	Object mysqlFactory = DAOFactory.getDAOFactory(1);
	Connection conn = ((MySqlJDBCDAOFactory) mysqlFactory).getConnection();
	
	MySQLPersonDAO persDAO = (MySQLPersonDAO) ((MySqlJDBCDAOFactory) mysqlFactory).getPersonDAO();
	
	persDAO.insertPerson(conn, 6, "El DAO", 15);
	
	
	}
	
}
