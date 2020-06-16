package retosProjectEuler;

import java.util.*;

public class Project708TwosAreAllYouNeed {

	public static int descPrime(long n){
		
		long num=n;
		int cont=0;
		Queue<Long> div=new LinkedList<Long>();
		
		while(!isPrime(num)) {
			
			div.addAll(divisores(num));
			
			long aux=div.poll();
			if(isPrime(aux)) {
				num/=aux;
				cont++;
			}
			div.clear();	
		}
		cont++;
		return cont;
	}
	
	public static long replacePrime(int primes) {
		long mult=1;
		for(int i=0;i<primes;i++) {
			mult*=2;
		}
		
		return mult;
	}
	
	public static long bigSum(long n) {
		long sum=1;
		for(int i=2;i<=n;i++) {
			long aux=replacePrime(descPrime(i));
			System.out.println(i+" : "+aux);
			sum+=aux;
		}
		
		return sum;
	}
	
	public static Queue<Long> divisores(long n){
		Queue<Long> arr=new LinkedList<Long>();
		for(long i=2;i<n;i++) {
			if(n%i==0) {
				arr.add(i);
			}
		}
		return arr;
	}
	
	public static boolean isPrime(long n) {
		long j=n-1;
		while(j>0 && n%j !=0) {
			j--;
		}
		return j==1?true:false;
	}
	
	public static void main(String[] args) {
		System.out.println(bigSum((long) Math.pow(10, 8)));
	}

}
