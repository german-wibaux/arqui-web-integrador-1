package primer.practico.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlJDBCDAOFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/exampleDB?serverTimezone=UTC";

    public static Connection createConnection() throws InvocationTargetException, ClassNotFoundException {
        Connection conn = null;

        try {
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(URL, "root", "password");
            return conn;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return conn;

    }

    public Connection getConnection() throws InvocationTargetException, ClassNotFoundException {
        return MySqlJDBCDAOFactory.createConnection();
    }

    public ClienteDAO getClienteDAO() {
        return new MySQLClienteDAO();
    }

    public ProductoDAO getProductoDAO() {
        return new ProductoDAO();
    }

    public FacturaDAO getFacturaDAO() {
        return new FacturaDAO();
    }

    public FacturaProductoDAO getFacturaProductoDAO() {
        return new FacturaProductoDAO();
    }
}
