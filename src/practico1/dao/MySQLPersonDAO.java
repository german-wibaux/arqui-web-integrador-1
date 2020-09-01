package practico1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLPersonDAO implements PersonDAO {

	@Override
	public void insertPerson(Connection conn, int id, String name, int years) throws SQLException {
		String insertPerson = "INSERT INTO person (id, name, age) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(insertPerson);
		conn.setAutoCommit(false);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, years);
		ps.executeUpdate();
		ps.close();
		conn.commit(); 
	}


}

	
	

