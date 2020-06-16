package solucion;

import java.util.Arrays;

public class Empresa {
	private String nombre,direccion;
	private Cliente[] clientes;
	
	public Empresa(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		clientes=new Cliente[0];
	}
	
	public void addCliente(Cliente cliente) {
		clientes=Arrays.copyOf(clientes, clientes.length+1);
		clientes[clientes.length-1]=cliente;
	}
	
	public Cliente getClienteVIP() throws ESinClientes{
		if(clientes.length==0) {
			throw new ESinClientes();
		}

		double costoMayor=-1;
		Cliente clienteVIP=null;
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i].calcularCostoSolicitudes()>costoMayor) {
				costoMayor=clientes[i].calcularCostoSolicitudes();
				clienteVIP=clientes[i];
			}
		}
		return clienteVIP;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	
	
}
