package betweenTwoSets;

import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        List<Integer> resultA=new ArrayList<>();
         List<Integer> resultB=new ArrayList<>();
         int contA=0,contB=0,contR=0;

        for(int j=menor(b);j>=mayor(a);j--){
            contB=0;
            int i=0;
            while(i<b.size()) {
	           if( b.get(i) % j ==0) {
	              System.out.println("entro b w con: "+j);
	              contB++;
	                
	           }
	           i++;
           	
            }
             if(contB==b.size()){
            	 System.out.println("entro b con: "+j);
                 resultB.add(j);
             }
             
             contA=0;
             i=0;
             
             while(i<a.size()) {
            	 if(j % a.get(i)==0) {
                 	System.out.println("entro a w con: "+j);
                 	contA++;
                 
                 }
            	i++;
            	
             }
              if(contA==a.size()){
            	  System.out.println("entro a con: "+j);
                  resultA.add(j);
              }
             
         }

             for(int i=0;i<resultA.size();i++){
                 for(int j=0;j<resultB.size();j++){
                     if(resultA.get(i)==resultB.get(j)){
                         contR++;
                     }
                 }
             }
             return contR;
         

    }
    
    public static List<Integer> sonDivisores(int a){
    	List<Integer> result=new ArrayList<Integer>();
    	for(int i=a;i>1;i--) {
    		if(a%i==0) {
    			result.add(i);
    		}
    	}
    	
    	return result;
    }
    

    public static int mayor(List<Integer> a){
        int max=0;
        for(int i=0;i<a.size();i++){
            if(a.get(i)>max){
                max=a.get(i);
            }
        }

        return max;
    }
    
    public static int menor(List<Integer> a){
        int min=99999999;
        for(int i=0;i<a.size();i++){
            if(a.get(i)<min){
                min=a.get(i);
            }
        }

        return min;
    }
}

