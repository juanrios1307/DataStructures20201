package principal;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solicitud s1=new Solicitud(1,1, 1, 10); 
		Solicitud s2=new Solicitud(1,2, 1, 20); 
		
		Solicitud s3=new Solicitud(2, 3, 3, 10);
		Solicitud s4=new Solicitud(2, 3, 3, 10);
		Empresa e1=new Empresa();
		
		ArrayList<Solicitud> clientes = new ArrayList<Solicitud>();
		clientes.add(s1);
		clientes.add(s2);
		clientes.add(s3);
		clientes.add(s4);
		
		try {
			System.out.println("VIP: "+e1.clienteVIP(clientes).getCodigoCliente());
			System.out.println(e1.costoSolicitudesCliente(clientes, 1));
			System.out.println(e1.costoSolicitudesCliente(clientes, 2));
		} catch (Exception e) {
			System.out.println("No hay clientes");
		}
	}

}
