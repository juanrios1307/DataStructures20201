package pangram;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(pangram(A)?"Yes":"No");
    }

    public static boolean pangram(String s){
        s=s.toLowerCase();
        String[] str=s.split("");

        for(int i=0;i<str.length;i++){
            System.out.println(" str: "+str[i]+" i: "+i);
            System.out.println("str fin: "+str[str.length-1-i]+ " f: "+(str.length-1-i));
            if(str[i].equals(str[str.length-1-i])){
               
            }else{
                return false;
            }
        }
        return true;
    }
}

