package retosProjectEuler;
import java.io.*;
import java.util.*;

public class Project218PerfectTrangle {
	
	    public static void main(String[] args) {
	        Scanner leer=new Scanner(System.in);
	        int n=leer.nextInt();
	        for(int i=0;i<n;i++){
	            System.out.println(perfectNotSuper(leer.nextInt()));
	        }
	    }

	    public static boolean perfectTriangle(int c,int a,int b){
	    	
	        if(mcd(a,b)==1 && mcd(b,c)==1 && isRaiz(c)){
	        	System.out.println("	Perfect: a: "+a+" b: "+b+" c: "+c);
	            return true;
	        }else{
	            return false;
	        }
	    }
	    //Maximo comun divisor
	    //Hipo es raiz perfecta
	    public static int mcd(int a,int b){
	    	while(a != b){
	    	     if(a > b){
	    	        a = a - b;
	    	     }else{
	    	        b = b - a;
	    	     }
	    	  }
	    	  return a;
	    }

	    public static boolean isRaiz(int c){
	        double r=Math.sqrt(c);
	        if(r-(int)r ==0){
	            return true;
	        }else{
	            return false;
	        }
	    }

	    public static boolean superPerfect(int c,int a ,int b){
	        if(perfectTriangle(c,a,b) && area(a,b)){
	        	System.out.println("	super Perfect: a: "+a+" b: "+b+" c: "+c);
	            return true;
	        }else{
	            return false;
	        }
	    }
	    public static boolean area(int a,int b){
	        int area=a*b/2;
	        if(area%6==0 && area%28==0 ){
	            return true;
	        }else{
	            return false;
	        }
	    }
	    //es perfecto y area%6 y area%28 ==0

	    public static int perfectNotSuper(int max){
	        int cont=0;
	        int i=max;
	        
	        return crearT(max);
	    }
	    
	    public static int crearT(int c) {
	    	int cont=0;
	    	int a=c-1;
	    	int b=(int)Math.sqrt(Math.pow(c, 2) -Math.pow(a, 2));
	    	while(a>=b) {
	    		b=(int)Math.sqrt(Math.pow(c, 2) -Math.pow(a, 2));
	    		System.out.println("b: "+b+" a: "+a+" c: "+c);
	    		
				if(Math.pow(c, 2)==Math.pow(a, 2)+Math.pow(b, 2)
				 && (a+b>c && b+c>a && c+a>b)
				&& perfectTriangle(c, a, b)  && !superPerfect(c, a, b)) {
					cont++;
				}
				a--;
	    	}
	    	
	    	return cont;
	    }
	

}
