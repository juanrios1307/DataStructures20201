package retosProjectEuler;

import java.util.*;

public class Project374MaximunPartition {
	

	public static ArrayList<Stack<Integer>> sumsPartitions(int n,int sobra,int i,ArrayList<Stack<Integer>> arr){
		Stack<Integer> aux=new Stack<Integer>();
		int a=i;
		while(sobra>0) {
			aux.add(a);
			sobra-=aux.peek();
			if(sobra==a) {
				
			}else
				a=sobra;
		}
		System.out.println(aux);
		
		arr.add(aux);
		
		
		return sumsPartitions(n,n, i--, arr);
	}
	
	public static ArrayList<Stack<Integer>> sumsPartitions(int n){
		ArrayList<Stack<Integer>> arr=new ArrayList<Stack<Integer>>();
		
		return sumsPartitions(n,n,n-1,arr);
	}
	
	public static Stack<Integer> maxProduct(ArrayList<Stack<Integer>> sums){
		long mult=1;
		Stack<Integer> ret=new Stack<Integer>();
		for(int i=0;i<sums.size();i++) {
			long aux=1;
			Stack<Integer> sAux=new Stack<Integer>();
			
			sAux.addAll(sums.get(i));
			while(!sums.get(i).isEmpty()) {
				aux*=sums.get(i).pop();
			}
			
			if(aux>mult) {
				mult=aux;
				ret.clear();
				ret.addAll(sAux);
			}
			
			sAux.clear();
		}
		return ret;
	}
	
	public static long cantAndProduct(Stack<Integer> num) {
		int c=0;
		long m=1;
		while(!num.isEmpty()) {
			c++;
			m*=num.pop();
		}
		return c*m;
	}
	
	
	public static long fm(int n) {
		return cantAndProduct(maxProduct(sumsPartitions(n)));
	}
	
	public static void main(String[] args) {
		ArrayList<Stack<Integer>> prueba=new ArrayList<Stack<Integer>>();
		Stack<Integer> a=new Stack<Integer>();
		a.add(5);
		a.add(3);
		a.add(2);
		
		Stack<Integer> b=new Stack<Integer>();
		b.add(8);
		b.add(2);
		
		prueba.add(a);
		prueba.add(b);
		
		
		long sum=0;
		for(int i=1;i<100;i++) {
			sum+=fm(i);
			System.out.println("f(i) m(i): "+i+" : "+fm(i));
		}
		System.out.println(sum);
		
	}
	
}

// f(n)·m(n) for 1 ≤ n ≤ 100 = 1683550844462.