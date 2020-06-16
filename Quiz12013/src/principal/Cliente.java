package principal;

public class Cliente {
	
	private int codigoCliente;
	private String nombre,dirEmpresa,email,formaPago;
	private double costoSolitudes;
	

	
	public Cliente(int codigoCliente) {
		super();
		this.codigoCliente = codigoCliente;
		
	}

	

	public double getCostoSolitudes() {
		return costoSolitudes;
	}
	
	public void setCostoSolitudes(double costoSolitudes) {
		this.costoSolitudes = costoSolitudes;
	}
	
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigo) {
		this.codigoCliente = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDirEmpresa() {
		return dirEmpresa;
	}
	public void setDirEmpresa(String dirEmpresa) {
		this.dirEmpresa = dirEmpresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	
}
