package principal;

public class Prueba2 implements Iprueba,Iinter2 {
	

	public void imprimir(String s) {
		System.out.println(s);
	}
	
	public void met1() {
		System.out.println("Metodo");
	}
	
	public static void main(String[] args) {
		
		
	}
	
	public static void puntoE(int n) {
		int c=1;
		while(c<n) {
			System.out.println("C: "+c);
			c=2*c;
		}
	}

	public void m1() {
		int a=0,b=0,N=40;
		double c=0;
		for (int i = 1; i <= N; i++) {
			c=i;
			System.out.print("Num: "+i+"");
			while(c>1) {
				System.out.print(" "+c+" : ");
				a+=b;
				c=c/2;
			}
			System.out.println();
	}
	}
	
	public static int subsecuenciaSumaMaxima (int [] a) //1
	{
	  int sumaActual,secIni,secFin; //1
		int sumaMax = 0;  //2
		for ( int i =0; i<a.length; i++)   //a.length=n //2 +n+1 + n 
			for ( int j=i; j<a.length; j++) 	//n(2+ (n-i+1) + (n-i))
			{
				sumaActual = 0;             		//(n-i)
				for ( int k=i; k<=j; k++)   		//(n-i)(2+(n2+1)+(n2))
					sumaActual += a[k];  				//2n2
				if (sumaActual > sumaMax) 				//1n2
					{
						sumaMax = sumaActual;  			//1n2
						secIni = i;   					//1n2
						secFin = j;  					//1n2
					}
			}
		return sumaMax;  //1
	}

	
	
	
}
