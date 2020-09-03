package practico1.entity;

public class Factura {
	
	private int idFactura;
	private int idCliente;
	
	public Factura(int idFactura, int idCliente) {
		super();
		this.idFactura = idFactura;
		this.idCliente = idCliente;
	}
	
	public int getIdFactura() {
		return idFactura;
	}
	
	public int getIdCliente() {
		return idCliente;
	}

}
