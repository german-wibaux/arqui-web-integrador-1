package practico1.dao.interf;

import java.sql.Connection;
import java.sql.SQLException;

public interface ProductoDAO {
	
	public void insertarProducto(Connection conn, int idProducto, String nombre, float valor) throws SQLException;

}
