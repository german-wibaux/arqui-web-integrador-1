package practico1.client;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.MessageFormat;

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
	
	
	ResultSet productoRec = factura.productoMayorRecaudacion(connection);
	DecimalFormat df = new DecimalFormat("0");
	df.setMaximumFractionDigits(0);
	System.out.println("-------------------------------------------");
    System.out.printf("%20s %10s %10s ", "Producto", "Valor", "Recaudacion");
    System.out.println();
    System.out.println("-------------------------------------------");
	while(productoRec.next()){
		System.out.format("%20s %10s %10s",
				productoRec.getString(2), df.format(Float.parseFloat(productoRec.getString(3))), df.format(Float.parseFloat(productoRec.getString(4))));
		System.out.println();
	}
	
	System.out.println();
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////");
	System.out.println();
	
	ResultSet clienteFacturado = factura.clienteMayorFacturacion(connection);	
	
	// Print the list objects in tabular format.
    System.out.println("-----------------------------------------------------------------------------------------------------------");
    System.out.printf("%20s %55s %30s ", "Cliente", "Email", "Facturacion");
    System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------------------------");
    while(clienteFacturado.next()){
    	System.out.format("%20s %55s %30s",
		 clienteFacturado.getString(2), clienteFacturado.getString(3), df.format(Float.parseFloat(clienteFacturado.getString(4))));
    	System.out.println();
	}
    System.out.println("-----------------------------------------------------------------------------------------------------------");
	
	connection.close();
	
	}
	
}
