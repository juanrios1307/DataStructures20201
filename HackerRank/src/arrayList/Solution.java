package arrayList;

import java.io.*;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d=scan.nextDouble();
        scan.nextLine();
        String s=scan.nextLine();
        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}*/

public class Solution {

    public static void main(String[] args) {
        
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        ArrayList<Integer[]> lista=new ArrayList<Integer[]>();
        
        
        
        for(int j=0;j<n;j++){
            Integer arr[]=new Integer[leer.nextInt()];

            for(int i=0;i<arr.length;i++){
                arr[i]=leer.nextInt();
            }

            lista.add(arr);
            
        }

        int queries=leer.nextInt();

        int[] a=new int[queries],b=new int[queries]; 

        for(int i=0;i<queries;i++){
            a[i]=leer.nextInt();
            b[i]=leer.nextInt();
        }

        for(int i=0;i<queries;i++){
            if(a[i]>lista.size()){
                System.out.println("ERROR!");
            }else{
                if(b[i]>lista.get(a[i]-1).length){
                        System.out.println("ERROR!");
                }else{
                    System.out.println(lista.get(a[i]-1)[b[i]-1]);
                }
            }
        }
      
    }
}
