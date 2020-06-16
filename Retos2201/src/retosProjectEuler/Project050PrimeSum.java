package retosProjectEuler;
public class Project050PrimeSum {

	public static void main(String[] args) {
		
		System.out.println("P");
		
		primos(1000);
		
	}
	
	public static void primos(int n) {
		int primos[]=new int[n],num=n,sumP=0,otroC=0;
		for (int i = num; i > 1; i--) {
		
			if(esPrimo(i)) {
				primos[i]=i;
				otroC++;
				//System.out.println("CONTADOR primos: "+otroC+" + num primo: "+primos[i]+"\n");
			}
			
		}
		
		System.out.println("\n");
		otroC=0;
		for (int i = 0; i < primos.length; i++) {
			if(primos[i]!=0) {
				otroC++;
				System.out.println("PRIMOS: "+primos[i]+" numero de consecutivo: "+otroC);
			}
				
			
			sumP+=primos[i];
				
			if(sumP<n && esPrimo(sumP)) {
				
				System.out.println("SUMA primos: "+sumP);
			}else {

			}
		}
		
	}
	
	public static boolean esPrimo(int n) {
		int cont=0;
		for (int i = n; i >1; i--) {
			for (int j = i-1; j >1; j--) {
				if(i%j==0) {
					cont++;
				}
			}
			if(cont==0) {
				return true;
			}else {
			}
			
		}
		return false;

	}

}
