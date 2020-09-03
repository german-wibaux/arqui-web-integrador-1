package practico1.client;
import java.io.FileReader;
import java.sql.Connection;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import practico1.dao.factory.DAOFactory;
import practico1.dao.interf.ClienteDAO;
import practico1.dao.interf.FacturaDAO;
import practico1.dao.interf.ProductoDAO;





public class serviceLayer {

	
	public static void main(String[] args) throws Throwable {
	
	DAOFactory mysqlFactory = DAOFactory.getDAOFactory(1);
	ClienteDAO cliente = mysqlFactory.getClienteDAO();
	FacturaDAO factura = mysqlFactory.getFacturaDAO();
	ProductoDAO producto = mysqlFactory.getProductoDAO();
	
	CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("/home/yermans/Documentos/clientes.csv"));
	Connection connection = mysqlFactory.getConnection();
	for(CSVRecord row: parser) {
		cliente.insertarCliente(connection, Integer.parseInt(row.get("idCliente")) , row.get("nombre"), row.get("email"));
	}
	
	CSVParser parser1 = CSVFormat.DEFAULT.withHeader().parse(new FileReader("/home/yermans/Documentos/facturas.csv"));
	for(CSVRecord row: parser1) {
		factura.insertarFactura(connection, Integer.parseInt(row.get("idFactura")) , Integer.parseInt(row.get("idCliente")));
	}
	
	CSVParser parser2 = CSVFormat.DEFAULT.withHeader().parse(new FileReader("/home/yermans/Documentos/productos.csv"));
	for(CSVRecord row: parser2) {
		producto.insertarProducto(connection, Integer.parseInt(row.get("idProducto")), row.get("nombre") , Integer.parseInt(row.get("valor")) );
	}
	
	CSVParser parser3 = CSVFormat.DEFAULT.withHeader().parse(new FileReader("/home/yermans/Documentos/facturas-productos.csv"));
	for(CSVRecord row: parser3) {
		factura.insertarProducto(connection, Integer.parseInt(row.get("idFactura")), Integer.parseInt(row.get("idProducto")) , Integer.parseInt(row.get("cantidad")) );
	}
	connection.close();
	
	
	
	
	
	}
	
}
