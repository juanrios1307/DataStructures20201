package retosProjectEuler;

public class Project294experience23 {
	
	private int sumDigits(int k) {
		String s=Integer.toString(k);
		int sum=0;
		
		for (int i = 0; i < s.length(); i++) {
			sum+=Character.getNumericValue(s.charAt(i));
		}
		
		return sum;
	}
	
	private boolean divisible23(int k) {
		if(k>23 && k%23==0) {
			return true;
		}else {
			return false;
		}
	}
	
	private long exponencial(long n) {
		return (long)Math.pow(10, n);
	}
	
	public long experience(long n) {
		n=exponencial(n);
		int cont=0;
		for (int i = 0; i <= n; i++) {
			if(sumDigits(i)==23 && divisible23(i)) {
				cont++;
			}
				
		}
		return cont;
		
	}
	
	public static void main(String[] args) {
		Project294experience23 p=new Project294experience23();
		System.out.println(p.experience(9));
		
	}

}
