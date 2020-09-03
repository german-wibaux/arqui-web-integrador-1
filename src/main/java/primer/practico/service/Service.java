package primer.practico.service;

import primer.practico.dao.*;

import java.sql.Connection;

public class Service {
    public static void main(String[] args) throws Throwable {

        Object mysqlFactory = DAOFactory.getDAOFactory(1);
        Connection conn = ((MySqlJDBCDAOFactory) mysqlFactory).getConnection();

        //MySQLClienteDAO cliente = (MySQLClienteDAO) ((MySqlJDBCDAOFactory) mysqlFactory).getClienteDAO();
        //cliente.createTableCliente(conn);
        //cliente.insertarCliente(conn, 1, "Juana", "Juana@gmail.com");

        //ProductoDAO producto = (ProductoDAO) ((MySqlJDBCDAOFactory) mysqlFactory).getProductoDAO();
        //producto.createTableProducto(conn);
        //.insertarProducto(conn, 1, "Cerveza", 120);

        FacturaDAO factura = (FacturaDAO) ((MySqlJDBCDAOFactory) mysqlFactory).getFacturaDAO();
        //factura.createTableFactura(conn);
        factura.insertarFactura(conn, 1, 1);

        FacturaProductoDAO facturaProducto = (FacturaProductoDAO) ((MySqlJDBCDAOFactory) mysqlFactory).getFacturaProductoDAO();
        facturaProducto.createTableFacturaProducto(conn);
        facturaProducto.insertarFacturaProducto(conn, 1, 1, 1);

    }
}
