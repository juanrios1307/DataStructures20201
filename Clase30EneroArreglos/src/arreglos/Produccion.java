package arreglos;

public class Produccion {
	
	private String dia;
	private int[] prod=new int[10];
	private static int[] prodTotal=new int[10];
	
	public Produccion(String dia, int[] prod) {
		super();
		this.dia = dia;
		this.prod = prod;
		
		for (int i = 0; i < prod.length; i++) {
			prodUnitaria(i);
		}
	}
	
	public int prodDia() {
		int sum=0;
		for (int i = 0; i < prod.length; i++) {
			sum+=prod[i];
		}
		return sum;
	}
	
	public int prodUnitaria(int n) {
		return prodTotal[n]+=prod[n];
	}
	
	public int produTotal() {
		int produccion=0;
		for (int i = 0; i < prodTotal.length; i++) {
			produccion+=prodTotal[i];
		}
		return produccion;
	}
	
	public int convDia() {
		switch (dia) {
		case "Lunes":
			return 1;
		case "Martes":
			return 2;
		case "Miercoles":
			return 3;
		case "Jueves":
			return 4;
		case "Viernes":
			return 5;
		default:
			return 0;
		}
	}
	public static void main(String[] args) {
		
		
		int[] lun= {1,1,2,3,4,5,6,6,7,65};
		int[] mar= {1,1,2,3,4,5,6,6,7,65};
		int[] mie= {1,1,2,3,4,5,6,6,7,65};
		int[] jue= {1,1,2,3,4,5,6,6,7,65};
		int[] vie= {1,1,2,3,4,5,6,6,7,65};
		
		
		Produccion lunes=new Produccion("Lunes", lun);
		Produccion martes=new Produccion("Martes", mar);
		Produccion miercoles=new Produccion("Miercoles", mie);
		Produccion jueves=new Produccion("Jueves", jue);
		Produccion viernes=new Produccion("Viernes", vie);
		
		
		System.out.println("Produccion por dia "+lunes.convDia()+" : "+lunes.prodDia());
		System.out.println("Produccion por dia "+martes.convDia()+": "+martes.prodDia());
		System.out.println("Produccion por dia "+miercoles.convDia()+": "+miercoles.prodDia());
		System.out.println("Produccion por dia "+jueves.convDia()+": "+jueves.prodDia());
		System.out.println("Produccion por dia "+viernes.convDia()+": "+viernes.prodDia());
		
		
		
		for (int j = 0; j < 10; j++) {
			System.out.println("Produccion unitaria del elemento: "+j+" : "+prodTotal[j]);
		}
		
		
		System.out.println("Produccion total:  "+martes.produTotal());
		
		
	}
	
	
}
