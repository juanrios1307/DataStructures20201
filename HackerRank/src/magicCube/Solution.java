package magicCube;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        if(isMagic(s)){
            return 0;
        }else{
        	
        
        	
            int[][] or=new int[3][3];
            
            for (int i = 0; i < or.length; i++) {
				for (int j = 0; j < or.length; j++) {
					or[i][j]=s[i][j];
				}
			}
            
    
            int[][] magic=volver15(or);
    
            return totalCost(s,magic);
        }

    }
    
    static void printMatriz(int[][] arr) {
    	for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
    	System.out.println();
    }
    
    
    static int[][] volver15(int[][] arr1) {
    	int[][] pos=posNoCambiar(arr1);
    	
    	for(int i=0;i<arr1.length;i++) {
    		for (int j = 0; j < arr1.length; j++) {
				if(pos[i][j]==0) {
					if(j==0 && pos[i][j+1]==1 && pos[i][j+2]==1) {
						
						arr1[i][j]=15-arr1[i][j+1]-arr1[i][j+2];
						
					}else if(j==1 && pos[i][j+1]==1 && pos[i][j-1]==1) {
						
						arr1[i][j]=15-arr1[i][j+1]-arr1[i][j-1];
						
					}else if(j==2 && pos[i][j-1]==1 && pos[i][j-2]==1) {
						
						arr1[i][j]=15-arr1[i][j-1]-arr1[i][j-2];
					}
					
					
					if(i==0  && pos[i+1][j]==1 && pos[i+2][j]==1) {
						
						arr1[i][j]=15-arr1[i+1][j]-arr1[i+2][j];
						
					}else if(i==1 && pos[i+1][j]==1 && pos[i-1][j]==1) {
						
						arr1[i][j]=15-arr1[i-1][j]-arr1[i+1][j];
						
					}else if(i==2 && pos[i-1][j]==1 && pos[i-2][j]==1) {
						
						arr1[i][j]=15-arr1[i-1][j]-arr1[i-2][j];
					}
					
					
				}
				//printMatriz(arr);
				//System.out.println("=======================================");
			}
    		
    		
    	}
    	if(pos[0][0]==0 && pos[1][1]==1 && pos[2][2]==1) {
			arr1[0][0]=15-arr1[1][1]-arr1[2][2];
		}else if(pos[0][0]==1 && pos[1][1]==0 && pos[2][2]==1){
			arr1[1][1]=15-arr1[0][0]-arr1[2][2];
		}else if(pos[0][0]==1 && pos[1][1]==1 && pos[2][2]==0){
			arr1[2][2]=15-arr1[1][1]-arr1[0][0];
		}
		
		if(pos[0][2]==0 && pos[1][1]==1 && pos[2][0]==1) {
			arr1[0][2]=15-arr1[1][1]-arr1[2][0];
		}else if(pos[0][2]==1 && pos[1][1]==0 && pos[2][0]==1){
			arr1[1][1]=15-arr1[0][2]-arr1[2][0];
		}else if(pos[0][2]==1 && pos[1][1]==1 && pos[2][1]==0){
			arr1[2][0]=15-arr1[1][1]-arr1[0][2];
		}
    	
    	return arr1;
    	
    	
    	
    }
    
    static int[][] posNoCambiar(int[][] arr){
    	int[][] pos=new int[3][3];
    	
    	int dgp=arr[0][0]+arr[1][1]+arr[2][2];
    	int dgi=arr[2][0]+arr[1][1]+arr[0][2];
    	
    	if(dgp == 15) {
    		pos[0][0]=1;
    		pos[1][1]=1;
    		pos[2][2]=1;
    	}
    	
    	if(dgi==15) {
    		pos[0][2]=1;
    		pos[1][1]=1;
    		pos[2][0]=1;
    	}
    	
    	for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][0]+arr[i][1]+arr[i][2] == 15) {
					pos[i][2]=1;
		    		pos[i][1]=1;
		    		pos[i][0]=1;
				}
				
				if(arr[0][j]+arr[1][j]+arr[2][j] == 15) {
					pos[0][j]=1;
		    		pos[1][j]=1;
		    		pos[2][j]=1;
				}
			}
		}
    	
    	return pos;
    }
    
   

    static int totalCost(int[][] original, int[][] magic){
        int cost =0;
        for(int i=0;i<magic.length;i++){
            for(int j=0;j<magic.length;j++){
                if(magic[i][j] != original[i][j]){
                    cost+=Math.abs(magic[i][j] - original[i][j]);
                }
            }
        }
        return cost;
    }

    static boolean isMagic(int[][] arr){
        int dg=arr[0][0]+arr[1][1]+arr[2][2];
        int dgI=arr[0][2]+arr[1][1]+arr[2][0];
        if(dg==dgI){
            
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    if((arr[i][0]+arr[i][1]+arr[i][2])==(arr[0][j]+arr[1][j]+arr[2][j])){
                        
                    }else{
                        return false;
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       /* BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
*/
        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {  
            for (int j = 0; j < 3; j++) {
                s[i][j]= scanner.nextInt();
            }
        }

        int result = formingMagicSquare(s);
        System.out.println(result);

       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}

