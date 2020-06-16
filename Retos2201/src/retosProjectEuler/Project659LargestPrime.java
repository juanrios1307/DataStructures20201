package retosProjectEuler;

public class Project659LargestPrime {
	
	public static int divConsecutivos(int n, int n1) {

		for (int i = 1; i < n; i++) {
			if(n%i==0 && n1%i==0 && esPrimo(i)) {
				return i;
			}
		}
		
		return 0;
	}
	
	public static int mayorDivPrimo(int k) {
		int mayor=0;
		for (int n = 0; n <100; n++) {
			if(divConsecutivos((int)(Math.pow(n, 2)+Math.pow(k, 2)), (int)(Math.pow(n+1, 2)+Math.pow(k, 2))) != 0) {
				mayor=divConsecutivos((int)(Math.pow(n, 2)+Math.pow(k, 2)), (int)(Math.pow(n+1, 2)+Math.pow(k, 2)));
			}
		}
		return mayor;
	}
	
	public static boolean esPrimo(int n ){
		int cont=0;
		for (int i = n; i >1; i--) {
			for (int j = i-1; j > 1; j--) {
				if(i%j==0) {
					cont++;
				}
			}
			if(cont==0) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		System.out.println("mayor div primo: "+mayorDivPrimo(1000));
	}

}
