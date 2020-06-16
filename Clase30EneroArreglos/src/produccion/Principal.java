package produccion;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,4,6,8,10};
		Producto[] productos=new Producto[10];
		for (int i = 0; i < productos.length; i++) {
			productos[i]=new Producto("Papa"+i,arr);
		}
		
		
		Produccion produ=new Produccion(productos);
		
		
		
		System.out.println(produ.prodDia("Lunes"));
		System.out.println(produ.prodTotal());
		System.out.println(produ.prodProducto("Papa1"));
		System.out.println(produ.prodProductoDia("Papa9", "Miercoles"));
		
	}

}
