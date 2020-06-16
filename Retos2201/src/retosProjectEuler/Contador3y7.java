package retosProjectEuler;

public class Contador3y7 {
	public static void main(String[] args) {
		System.out.println(cont3y7());
	}
	
	public static int cont3y7() {
		int cont=0;
		String[] arr=new String[900];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.toString(i+100);
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].contains("7") && arr[i].contains("3")) {
				//System.out.println(arr[i]);
				cont++;
			}
		}
		
		return cont;
	}
}
