package produccion;

public class Produccion {
	private Producto[] productos;
	
	public Produccion( Producto[] productos) {
		this.productos = productos;
	}

	public int prodDia(String d) {
		int suma=0;
		for (int i = 0; i < productos.length; i++) {
			suma+=productos[i].prodDia(d);
		}
		return suma;
	}
	
	public int prodTotal() {
		int suma=0;
		for (int i = 0; i < productos.length; i++) {
			suma+=productos[i].prodTotal();
		}
		return suma;
	}
	
	public int prodProducto(String p) {
		for (int i = 0; i < productos.length; i++) {
			if(p.equals(productos[i].getNombre())) {
				return productos[i].prodTotal();
			}
		}
		return 0;

	}
	
	public int prodProductoDia(String p, String d) {
		for (int i = 0; i < productos.length; i++) {
			if(p.equals(productos[i].getNombre())) {
				return productos[i].prodDia(d);
			}
		}
		return 0;
	}
	
	public boolean addProducto(Producto p) {
		Producto[] productoNew=new Producto[productos.length+1];
		for (int i = 0; i < productos.length; i++) {
			productoNew[i]=productos[i];
			
		}
		
		for (int i = 0; i < productoNew.length; i++) {
			if(productoNew[i].equals(p.getNombre())) {
				return false;
			}
		}
		productoNew[productoNew.length-1]=p;
		
		return true;	
	}
	
}
