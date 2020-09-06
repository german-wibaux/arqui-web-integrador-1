package practico1.dao.clas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import practico1.dao.interf.ClienteDAO;

public class MySQLClienteDAO implements ClienteDAO {

	@Override
	public void insertarCliente(Connection conn, int idCliente, String nombre, String email) throws SQLException {
		String insertCliente = "INSERT INTO cliente (idCliente, nombre, email) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(insertCliente);
		ps.setInt(1, idCliente);
		ps.setString(2, nombre);
		ps.setString(3, email);
		ps.executeUpdate();
		conn.commit(); 
	}


}

	
	

