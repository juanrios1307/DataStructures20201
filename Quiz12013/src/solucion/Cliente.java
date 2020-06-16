package solucion;

import java.util.Arrays;

public class Cliente {
	private int codigo;
	private String nombre,direccion,correo,formaPago;
	
	private Solicitud[] solicitudes;
	
	public Cliente(int codigo, String nombre, String direccion, String correo, String formaPago) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.formaPago = formaPago;
		
		solicitudes=new Solicitud[0];
	}
	
	public void addSolicitud(Solicitud solicitud) {
		solicitudes=Arrays.copyOf(solicitudes, solicitudes.length+1);
		
		solicitudes[solicitudes.length-1]=solicitud;
	}
	
	public double calcularCostoSolicitudes() {
		double costo=0;
		for (int i = 0; i < solicitudes.length; i++) {
			costo +=solicitudes[i].calcularCosto();
		}
		return costo;
	}
	
	
	public Solicitud[] getSolicitudes() {
		return solicitudes;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public String getFormaPago() {
		return formaPago;
	}
	
	
	
}
