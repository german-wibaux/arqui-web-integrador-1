package practico1.dao.interf;

import java.sql.Connection;
import java.sql.SQLException;

public interface ClienteDAO {
	
	public void insertarCliente(Connection conn, int idCliente, String nombre, String email) throws SQLException;

}
