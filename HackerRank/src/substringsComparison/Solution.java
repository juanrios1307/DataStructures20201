package substringsComparison;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        String[] arr=s.split("");
        String[] substrings=new String[arr.length-2];

        for(int i=0;i<arr.length-2;i++){
            substrings[i]=arr[i]+arr[i+1]+arr[i+2];
        }
        printLista(substrings);
       substrings=mergeSort(substrings);
       printLista(substrings);
       System.out.println();
        return substrings[0]+"\n"+substrings[substrings.length-1];

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        //return smallest + "\n" + largest;
    }

    public static String[] mergeSort(String[] arr){
        if(arr.length==1){
            return arr;
        }else{
            int mitad=(arr.length)/2;

            String[] left=java.util.Arrays.copyOfRange(arr,0,mitad);
            String[] rigth=java.util.Arrays.copyOfRange(arr,mitad,arr.length);

            return merge(mergeSort(left),mergeSort(rigth));

        }
    }

    public static String[] merge(String[] a,String[] b ){
        int i=0,j=0;
        String[] result=new String[a.length+b.length];
        while(i<a.length && j<b.length)
            result[i+j]=(a[i].compareTo(b[j])<=0)?a[i++]:b[j++];
        
        for(int k=i;k<a.length;k++){
            result[k+j]=a[k];
        }

        for(int k=j;k<b.length;k++){
            result[k+i]=b[k];
        }
        return result;
    }
    
    public static void printLista(String[] lista) {
    	for(String a:lista) {
    		System.out.print(a+"\t");
    	}
    	System.out.println();
    }

/*public static Comparable[] merge(Comparable[] lista1, Comparable[] lista2) {
        
        Comparable[] result= new Comparable[lista1.length+lista2.length];
        int i=0,j=0;
       
        while (i<lista1.length && j<lista2.length)
            result[i+j]=(lista1[i].compareTo(lista2[j])<=0)? lista1[i++]:lista2[j++];
       
        for(int k=i;k<lista1.length;k++)
            result[k+j]=lista1[k];
       
        for (int k=j;k<lista2.length;k++)
            result[k+i]=lista2[k];
        return result;
    }
	*/
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}