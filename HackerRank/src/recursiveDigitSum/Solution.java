package recursiveDigitSum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	 // Complete the superDigit function below.
    static BigInteger superDigit(String n, int k) {
        BigInteger num=new BigInteger(n);
        return superDigit(sum(num).multiply(new BigInteger(Integer.toString(k))));

    }

    /*static String repeat(String n,int k){
        if(k==1){
            return n;
        }
        return n+repeat(n,(k-1));
    } */
    

    static BigInteger superDigit(BigInteger n){
        if(n.compareTo(BigInteger.TEN)<0 && n.compareTo(new BigInteger("-10"))>0){
            return n;
        }else{
            return superDigit(sum(n));
        }
    }

    static BigInteger sum(BigInteger n){
        if(n.compareTo(BigInteger.TEN)<0){
            return n;
        }else{
            return (n.mod(BigInteger.TEN)).add(sum(n.divide(BigInteger.TEN)));
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        BigInteger result = superDigit(n, k);
        System.out.println("result:"+result);

       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/
        

        scanner.close();
    }
}

