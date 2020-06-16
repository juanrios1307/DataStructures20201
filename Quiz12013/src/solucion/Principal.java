package solucion;

public class Principal {

	public static void main(String[] args) {
		Empresa e=new Empresa("Mi", "Empresa");
		
		Cliente c1=new Cliente(1, "Juan", "RN", "@", "efectivo");
		Cliente c2=new Cliente(2, "Esteban","RN","@", "efectivo");
		
		e.addCliente(c1);
		e.addCliente(c2);
		
		PiezaPlastica p1=new PiezaPlastica(1, "1", 10.5);
		PiezaMetalica p2=new PiezaMetalica(2, "Jaja", 2.5);
		PiezaMetalica p3=new PiezaMetalica(3,"fe",26);
		
		Pieza[] piezas= {p2,p3};
		PiezaMixta p4=new PiezaMixta(4, "d4", piezas);
		
		Solicitud s1=new Solicitud(1, p1, 5);
		Solicitud s2=new Solicitud(2, p4, 3);
		
		c1.addSolicitud(s1);
		c2.addSolicitud(s2);
		
		try {
			Cliente clienteVip=e.getClienteVIP();
			System.out.println("El cliente vip es: "+clienteVip.getNombre());
		} catch (ESinClientes e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
