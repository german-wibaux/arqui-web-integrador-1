package practico1.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface PersonDAO {
	
	public void insertPerson(Connection conn, int id, String name, int years) throws SQLException;

}
