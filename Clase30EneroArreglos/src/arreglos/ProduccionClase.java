package arreglos;

import java.util.Random;

public class ProduccionClase {
	
	private static final String[] dias= {"Lunes","Martes","Miercoles","Jueves","Viernes"};
	private static final String[] productos= {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10"};
	private int[][] matriz=new int[10][5];
	
	public ProduccionClase() {
		
		//Llenar matriz
		
		Random r=new Random();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j]=r.nextInt(101);
			}
		}
	}
	
	
	public int produTotal() {
		int total=0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				total+=matriz[i][j];
			}
		}
		return total;
	}
	
	private int hallarPosDia(String dia) {
		String diaMayus=dia.toLowerCase();
		switch (diaMayus) {
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
			return -1;
		}
	}
	
	private int hallarPosProducto(String prod) {
		for (int i = 0; i < productos.length; i++) {
			if(productos[i].equals(prod)) {
				return i;
			}
		}
		return -1;
	}
	
	public int produccionDia(String dia) {
		int posDia=hallarPosDia(dia);
		int total=0;
		for (int i = 0; i < matriz.length; i++) {
			total+=matriz[i][posDia];
		}
		return total;
	}
	
	public int produccionProducto(String producto) {
		int posProducto=hallarPosProducto(producto);
		int total=0;
		for (int i = 0; i < matriz[posProducto].length; i++) {
			total+=matriz[posProducto][i];
		}
		return total;
	}
	
	public void imprimirMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j]+"\t");
			}
			System.out.println();
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProduccionClase p=new ProduccionClase();
		p.imprimirMatriz();
		System.out.println("Prod viernes: "+p.produccionDia("viernes"));

	}

}
