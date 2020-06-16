package retosProjectEuler;

public class Project699TriffleNumber {
	
	public int multiplos(int n) {
		int suma=0;
		for (int i = 1; i <= n; i++) {
			if(n%i==0) {
				System.out.println("Num i:" +i+" n: "+n);
				suma+=i;
			}
				
		}
		System.out.println("Suma multiplos: "+suma);
		return suma;
	}
	
	public int exp3(int n,int max) {
		//System.out.println("exp3: "+Math.pow(3, n));
		return (int) ((int) Math.pow(3, n)<=max?Math.pow(3, n):1);
	}
	
	public int fraccion(int n,int max) {
		if(exp3(n,max)==1) {
			return 0;
		}else 
			System.out.println("fraccion: "+multiplos(exp3(n,max))/exp3(n,max)+"\n");
			return multiplos(exp3(n,max))/exp3(n,max);
		
	}
	
	public int sumaTotal(int n) {
		int suma=0;
		for (int i = 1; i < n; i++) {
			suma+=fraccion(i,n);
			if(fraccion(i,n)==0) {
				return suma;
			}
			
		}
		System.out.println("Suma : "+suma);
		return suma;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Project699TriffleNumber p=new Project699TriffleNumber();
		System.out.println("Suma total: "+p.sumaTotal(100));
	}

}
