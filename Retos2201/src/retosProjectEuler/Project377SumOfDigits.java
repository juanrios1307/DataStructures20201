package retosProjectEuler;
import java.util.*;
public class Project377SumOfDigits {
	
	public static ArrayList<Integer> sumN(int n){
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(int i=1;i<1000000;i++) {
			if(sumD(i,n) && sinCero(i)) {
				arr.add(i);
			}
		}
		
			
		return arr;
	}
	
	public static long bigSum(int n) {
		long sum=0;
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.addAll(sumN(n));
		
		for(int i=0;i<arr.size();i++) {
			sum+=arr.get(i);
		}
		return sum;
	}
	
	public static boolean sumD(int num,int n) {
		String string=Integer.toString(num);
		Stack<String> ss=new Stack<String>();
		ss.addAll(Arrays.asList(string.split("")));
		
		int sum=0;
		while(!ss.isEmpty()) {
			sum+=Integer.parseInt(ss.pop());
		}
		
		if(sum==n) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean sinCero(int num) {
		String string=Integer.toString(num);
		Stack<String> ss=new Stack<String>();
		ss.addAll(Arrays.asList(string.split("")));
		
		int sum=0;
		while(!ss.isEmpty()) {
			if(Integer.parseInt(ss.pop())==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(sumN(5));
		System.out.println(bigSum(5));
	}
	
}
