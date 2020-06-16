package retosProjectEuler;

public class Project407idempotents {
	
	public static long pot2(int a) {
		return (long) Math.pow(a, 2);
	}
	
	public static long mod(int a,int n) {
		return pot2(a)%n;
	}
	
	public static long maxn(int n) {
		int max=0;
		for (int i = 0; i <n ; i++) {
			if(mod(i,n)==i) {	
				if(i>max) {
					max=i;
				}
			}
		}
		return max;
	}
	
	public static long sumaMaxN(int n) {
		long suma=0;
		for (int i = 1; i <=n; i++) {
			System.out.println("Maximo "+i+" : "+maxn(i));
			suma+=maxn(i);
		}
		return suma;
	}
	
	public static void main(String[] args) {
		System.out.println("suma total: "+sumaMaxN(100000));
		
	}
}
