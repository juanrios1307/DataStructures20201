package principal;

import java.util.ArrayList;

public class Empresa {
	
	public double costoSolicitudesCliente(ArrayList<Solicitud> clientes, int codCliente) throws eNoClientes{
		double costos=0;
		if(clientes.isEmpty()) {
			throw new eNoClientes();
		}
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getCodigoCliente()==codCliente) {
				costos += clientes.get(i).costoSolicitudesCliente();
			}
		}
		return costos;
	}
	
	public Cliente clienteVIP(ArrayList<Solicitud> clientes) throws eNoClientes{
		double vip=0;
		int indexVIP=0;
		if(clientes.isEmpty()) {
			throw new eNoClientes();
		}
		for (int i = 0; i < clientes.size(); i++) {
			if(costoSolicitudesCliente(clientes, i)>vip) {
				vip=costoSolicitudesCliente(clientes, i);
				indexVIP=i;
			}
		}
		return clientes.get(indexVIP);
	}
	
}
