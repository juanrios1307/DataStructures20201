package betweenTwoSets;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) throws IOException {
      /*  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());*/
        
        List<Integer> arr=new ArrayList<Integer>();
        List<Integer> brr=new ArrayList<Integer>();
        arr.add(2);
        arr.add(4);
      
        brr.add(16);
        brr.add(32);
        brr.add(96);

        int total = Result.getTotalX(arr, brr);
        System.out.println(total);

       /* bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    	/*int N=20;
    	int i=1;//2
    	while(i<N)  //4
    		if (i==1) {  //3
    			i*=4; //1
    	System.out.println("i if: "+i);
    		}else {	//2      N-3  N-4
    			for (int j=i; j<N; j++) {  
    				System.out.println(" el j: "+(j-4)); //3JVC
    				i+=2; //JVC
    			}
    			System.out.println("i: "+i);
    		} */
    	
    }

	
}
