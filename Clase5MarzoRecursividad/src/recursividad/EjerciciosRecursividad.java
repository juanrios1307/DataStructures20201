package recursividad;

import java.util.Arrays;


public class EjerciciosRecursividad {
	
	
	public long fact(int n) {
		if(n==1) {
			return 1;
		}else {
			return n*fact(n-1);
		}
	}
	
	public static int sumaNat(int n) {
		return n==1?1:n+sumaNat(n-1);
	}
	
	public static int fibo(int n) {
		if(n==1 || n==2) {
			return 1;
		}else {
			return fibo(n-1)+fibo(n-2);
		}
	}
	
	
	
	
	
	public static boolean palindrome(String str) {
		str=str.toLowerCase();
		if(str.length()==1 ) {
			return true;
		}else {
			return str.charAt(0)==str.charAt(str.length()-1)?palindrome(str.substring(1, str.length()-1)):false;
		}
	}
	
	public static String reverseString(String str) {
		if(str.length()==1) {
			return str;
		}else {
			return str.replace(str.charAt(0), reverseString(str.substring(1, str.length()-1)).charAt(0));
		}
	}
	
	
	
	public static int[] reverseVector(int[] v,int i) {
		if(i==(v.length-1)/2) {
			return v;
		}else {
			int aux=v[i];
			v[i]=v[v.length-1-i];
			v[v.length-1-i]=aux;
			return reverseVector(v, i-1);
		}
	}
	public static int[] reverseVector(int[] v ) {
		return reverseVector(v, v.length-1);
	}
	/*
	  	Mover n-1 discos desde varinicial a varcentral con varfinal como auxiliar
		Mover el disco n desde varinicial a varfinal
		Mover n-1 discos desde varcentral a varfinal utilizando varinicial como auxiliar
	 */
	
	public static void hanoi(int n,char varI ,char varF,char aux) {
		if(n==1) {
			System.out.println("Muevo "+n+" de vI: "+varI+" a vF: "+varF);
		}else {
			hanoi(n-1,varI,aux,varF);
			System.out.println("Muevo "+n+" de vI:"+varI+" a vF: "+varF);
			hanoi(n-1,aux,varF,varI);
		}
	}
	
	public static int sumaVector(int[] nums) {
		return nums.length==1?nums[0]:nums[nums.length-1]+sumaVector(Arrays.copyOf(nums, nums.length-1));
	}
	
	public static int sumarMatrix(int[][] arr,int j) {
		if(j==0) {
			return sumaVector(arr[j]);
		}
		return sumaVector(arr[j])+sumarMatrix(arr, j-1);
	}
	
	/*rango(desde, hasta) -> lista de números: similar a rango, pero ahora se puede especificar el "desde". 
	 * Ej: rango(5, 10) -> [5,6,7,8,9,10]. 
	 * No hace falta validar que desde sea menor a hasta o tener rangos decrecientes.*/
	
	public static int[] rango(int i,int[] arr) {
		
		if(i==1) {
			//arr[arr.length-i]=i;
			return arr;
		}else {
			arr[arr.length-i]=i;
			return rango(i-1,Arrays.copyOf(arr, arr.length));
		}
	}
	

	
	/*aparear(unaLista, otra) -> lista de pares (x, y): tal que "x" pertence a "unaLista", 
	 * e y pertenece a "otra". 
	 * Ejemplo: aparear([1,2,3], ['a','b','c']) -> [ (1,'a'), (2,'b'), (3,'c')]
	 */
	
	public static void aparear(int[] v1,int[] v2){
		String[] arr=new String[6];
		if(v1.length==1 && v2.length==1) {
			arr[v1.length-1]="("+v1[0]+","+v2[0]+")";
			System.out.println(arr[v1.length-1]);
		}else {
			arr[v1.length-1]="("+v1[v1.length-1]+","+v2[v2.length-1]+")";
			System.out.println(arr[v1.length-1]);
			aparear(Arrays.copyOf(v1, v1.length-1),Arrays.copyOf(v2, v2.length-1));
		}
	}
	
	
	/*sumarN(n, numeros): Realizar una función que dada una lista de números y un número N, 
	 * retorna la suma de todos los N primeros elementos.
	 *  Ejemplo sumarN(3, [2, 4, 6, 8, 10, 12]) -> 2+4+6 = 24*
	 */
	
	public static int sumarN(int n,int[] nums) {
		 if(n==1) {
			 return nums[0];
		 }else {
			 return nums[n-1]+sumarN(n-1,Arrays.copyOf(nums,n));
		 }
	}
	
	/*ordenar(numeros): Realizar una función que dada una lista de números 
	 * retorne otra lista con los mismos números pero ordenados de menor a mayor. 
 Pista: en una lista ordenada siempre se da que un elemento en la posición x es el mínimo de la sublista que sigue. 
	 * Ej: ordenar([3,6, -1]) -> [-1,3,6]*/
	
	public static void ordenar(int[] arr) {
		if(arr.length==1) {
			System.out.print(arr[arr.length-1]+"\t");
		}else {
			int aux=arr[index(arr)];
			arr[index(arr)]=arr[arr.length-1];
			
			arr[arr.length-1]=aux;
	
			System.out.print(arr[arr.length-1]+"\t");
			
			ordenar(Arrays.copyOf(arr, arr.length-1));
		}
	}
	
	public static int maxNum(int[] nums) {
		if(nums.length==1) {
			return nums[0];
		}else {
			return nums[nums.length-1]>maxNum(Arrays.copyOf(nums, nums.length-1))?nums[nums.length-1]:maxNum(Arrays.copyOf(nums, nums.length-1));
		}
	}
	
	public static int index(int[] nums) {
		if(nums.length==1) {
			return nums.length;
		}else {
			return nums[nums.length-1]==maxNum(nums)?nums.length-1:index(Arrays.copyOf(nums, nums.length-1));
		}
	}
	
	/*public static void orden(int[] arr) {
		arr[]
	}*/
	
	
	/*esPar(n) -> boolean: Dado un numero dice si ese numero es par o no.
Para esto recordar que el caso más básico es el 0 que es par. 
Luego un numero es par si su anterior es impar. Y un numero es impar si su anterior es par.
	Ej esPar(4) si esImpar(3)
   esImpar(3) si esPar(2)
   esPar(2) si esImpar(1)
   esImpar(1) si esPar(0)
   esPar(0) ? SI !*/
	
	public static boolean esPar(int n) {
		if(n==0) {
			return true;
		}else 
			return esImpar(n-1);
	}
	
	public static boolean esImpar(int n) {
		if(n==0) {
			return false;
		}else 
			return esPar(n-1);
	}
	
	/*Calcula la potencia de un numero de forma recursiva, tanto para exponentes
negativos como positivos.*/
	public static int power(int a,int b) {
		if(b==1) {
			return a;
		}else {
			return a*power(a,(b-1));
		}
	}
	
	/* Invertir un numero de forma recursiva (no usar String)*/
	public static int invertirInt(int a,int pos) {
		if(a-10<0) {
			return a;
		}else {
			return (a%10)*(int)Math.pow(10,pos)+invertirInt(a/10, pos-1);
		}
		
	}
	
	/*Programar un algoritmo recursivo que permita sumar los dígitos de un número.
	 * Ejemplo: Entrada:123 Resultado:6*/
	
	public static int sumaDigits(int a) {
		if(a<10) {
			return a;
		}else {
			return (a%10)+sumaDigits(a/10);
		}
	}
	
	public static void main(String[] args) {
		int[] v= {45,78,54,2,7,200,8,65};
		
		int[] v2= {7,8,4,3,2,1};
		
		int[][] arr= {{1,2,3},
					  {1,4,7},
					  {7,2,3}};
		
		//ordenar(v);
		
		//System.out.println(power(3,3));
		System.out.println(invertirInt(1437, 3));
		
		/*
		for (int i = 0; i < v1.length; i++) {
			System.out.print(v1[i]+"\t");
		}*/
		
		//aparear(v, v2);
		/*int a=sumarN(4,v);
		System.out.println(a);*/
		
		//System.out.println(esPar(40));
		
		/*int[] a=rango(5,v);
		
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"\t");
		}*/
		
		
		
		
	}
}
