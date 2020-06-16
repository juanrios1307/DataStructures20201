package retosProjectEuler;

public class Project020FactorialDigitSum {

	public static void main(String[] args) {
		System.out.println("Suma: " + suma(digitos(factorial(65))));
	}
	
	public static long factorial(int n) {
		long fact=1;
		for (int i = n; i>1; i--) {
			fact*=i;
		}
		System.out.println(fact);
		return fact;
	}
	
	public static int[] digitos(long n) {
		String s=Long.toString(n);
		s=s.replace(".","").replace("-", "").replace("E", "");
		String arr[]=s.split("");
		int arra[]=new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arra[i]=Integer.parseInt(arr[i]);
		}
		return arra;
	}
	
	public static int suma(int[] arr) {
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}

}
