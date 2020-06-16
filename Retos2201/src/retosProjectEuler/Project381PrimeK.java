package retosProjectEuler;
import java.util.*;
public class Project381PrimeK {
	
	public static ArrayList<Integer> primes(int n){
		ArrayList<Integer> arr=new ArrayList<Integer>();
		
		for(int i=5;i<n;i++) {
			
			int j=i-1;
			
			while(j>0 && i%j !=0) {
				j--;
			}
			
			if(j==1) {
				arr.add(i);
			}
			
		}
		
		return arr;
	}
	
	public static long bigSum(int n) {
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.addAll(primes(n));
		
		long bigS=0;
		
		for(int i=0;i<arr.size();i++) {
			long aux=sumK(arr.get(i));
			System.out.println("sumK "+arr.get(i)+" : "+aux);
			bigS+=aux;
		}
		
		return bigS;
	}
	
	public static long sumK(int n) {
		long sum=0;
		for(int i=1;i<=5;i++) {
			sum+=factorial(n-i);
		}
		System.out.println("sum facts: "+n+" : "+sum );
		return sum%n;
	}
	
	public static long factorial(int n) {
		long f=1;
		for(int i=n;i>0;i--) {
			f*=i;
		}
		return f;
	}
	
	
	public static void main(String[] args) {
		System.out.println(primes(100));
		System.out.println(bigSum(100));
		
	}
}
