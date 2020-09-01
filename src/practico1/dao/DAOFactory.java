package practico1.dao;

public abstract class DAOFactory {
	
	public static final int MYSQL_JDBC = 1;
	//public static final int DERBY_JDBC = 2;
	
	public abstract PersonDAO getPersonDAO();
	
	public static Object getDAOFactory(int whichFactory) {
		
		switch(whichFactory) {
		case MYSQL_JDBC : return new MySqlJDBCDAOFactory();
		default: return null;
		}
		
		
	}

}
