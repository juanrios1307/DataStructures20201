package produccion;

public class Producto {
	private String nombre;
	int[] produccionSemana;
	final static String[] dias= {"Lunes","Martes","Miercoles","Jueves","Viernes"};
		
	public Producto(String nombre, int[] produccionSemana) {
		super();		
		this.nombre = nombre;
		this.produccionSemana = produccionSemana;	
	}

	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int buscarDia(String d) {
		d=d.toLowerCase();
		switch (d) {
		case "lunes":
			return 0;
		case "martes":
			return 1;
		case "miercoles":
			return 2;
		case "jueves":
			return 3;
		case "viernes":
			return 4;
		default:
			return 5;
		}
	}
	
	public int prodDia(String d) {
		return produccionSemana[buscarDia(d)];
	}
	
	public int prodTotal() {
		int sum=0;
		for (int i = 0; i < produccionSemana.length; i++) {
			sum+=produccionSemana[i];
		}
		return sum;
	}
	
	public boolean addProdDia(String d, int p) {
		produccionSemana[buscarDia(d)]+=p;
		return true;
	}
		
}
