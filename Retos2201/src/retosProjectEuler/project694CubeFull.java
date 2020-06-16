package retosProjectEuler;

import java.util.ArrayList;

public class project694CubeFull {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int n=100,sum=1;
		//System.out.println(contFullCube(100));
		
		for (int i = 2; i<=n; i++) {
			sum+=contFullCube(i);
			System.out.println("CONTFULLCUBES: "+" n: "+i+" : "+contFullCube(i));
		}
		System.out.println("\nSUMA: "+sum);
		
		
		
	}
	
	public static int contFullCube(int n) {
		int sum=1;
		for (int i = 0; i <=n; i++) {
			if(esFullCube(i) && n%i==0) {
				sum++;
			}
		}
		return sum;
	}
		
	public static boolean esFullCube(int n) {
		ArrayList<Integer> divisores=new ArrayList<Integer>();
		for (int i = 0; i <= n; i++) {
			if(esPrimo(i) && n%i==0 && n%Math.pow(i, 3)==0 ) {
				divisores.add(i);
			}else if(esPrimo(i) && n%Math.pow(i, 3) !=0 && n%i==0 ) {
				return false;
			}
		}
		if(divisores.size()>0) {
			return true;
		}else {
			return false;
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
