package primer.practico.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ClienteDAO {

    void insertarCliente(Connection conn, int id, String name, String email) throws SQLException;

}
