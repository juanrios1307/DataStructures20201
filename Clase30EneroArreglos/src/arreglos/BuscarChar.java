package arreglos;

public class BuscarChar {
	
	public static int[] buscar(String str,char a) {
		int[] arr=new int[str.length()];
		char b;
		for (int i = 0; i < str.length(); i++) {
			b=str.charAt(i);
			if(b==a) {
				arr[i]=i;
			}
		}
		return arr;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=buscar("iussisipi",'i');
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] !=0 || i==0)
				System.out.println("pos: "+i+" : "+arr[i]);
		}
	}

}
