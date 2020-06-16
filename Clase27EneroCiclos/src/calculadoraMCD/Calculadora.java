package calculadoraMCD; 
public class Calculadora {
	public int mcd(int n1, int n2) {
		while(n1 != n2) {
			if(n1>n2)
				n1-=n2;
			else 
				n2-=n1;
		}
		return n1;
	}
	
	public int fact(int n1) {
		for (int i = n1-1; i >1; i--) {
			n1*=i;
		}
		return n1;
	}
	
	public int factWhile(int n1) {
		int i=n1-1;
		while(i>1) {
			n1*=i;
			i--;
		}
		return n1;
	}
	
	public int factorialRecursivo(int n) {
		if(n==1 || n==0) {
			return 1;
		}else {
			return n*factorialRecursivo(n-1);
		}
	}
	
	
	public static void main(String[] args) {
		Calculadora c =new Calculadora();
		System.out.println(c.mcd(8,4));
		System.out.println(c.fact(12)+"nn"+c.factWhile(12));
		System.out.println("Recursion: "+c.factorialRecursivo(12));
	}
}
