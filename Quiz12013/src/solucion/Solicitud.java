package solucion;

import java.util.Date;

public class Solicitud {
	
	private int codigo,cantidad;
	private Date fecha;
	private Pieza pieza;
	
	public Solicitud(int codigo, Pieza pieza, int cantidad) {
		super();
		this.codigo = codigo;
		this.pieza = pieza;
		this.cantidad = cantidad;
		fecha=new Date();
	}
	
	public double calcularCosto() {
		return pieza.calcularCosto()*cantidad;
	}
	

	public int getCodigo() {
		return codigo;
	}
	
	public Pieza getPieza() {
		return pieza;
	}

	public int getCantidad() {
		return cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	
	
}
