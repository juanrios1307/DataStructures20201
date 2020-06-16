package retosProjectEuler;

public class Project655DivisiblePalindromes {
	
	public static boolean verificarPalindrome(long n) {
		char[] digits=Long.toString(n).toCharArray();
		
		for (int i = 0; i < digits.length; i++) {
				if(digits[i]==digits[digits.length-1-i]) {
					
				}else {
					return false;
				}
			
		}
		return true;
	}
	
	public static boolean divisible(int n) {
		if(n>10000019 && n%10000019==0)
			return true;
		return false;
	}
	
	public static int contDivisibles() {
		int cont=0;
		for (int i = 0; i <Math.pow(10, 32); i++) {
			if(verificarPalindrome(i) && divisible(i)) {
				cont++;
			}
		}
		return cont;
	}
	
	public static void main(String[] args) {
		System.out.println(contDivisibles());
		
	}

}
