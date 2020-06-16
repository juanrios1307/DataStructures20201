
import java.io.*;
import java.util.*;

public class SelectSortIndirecto<E extends Comparable<E>> {
	int[] pos=new int[0];
	
    public int[] ArrayIndirecto(E[] a){
        
        E[] aux=Arrays.copyOf(a,a.length);
        
        for(int i=0;i<a.length;i++){
           int min=i;
            for(int j=i+1;j<a.length;j++){
                if(aux[j].compareTo(aux[min])<0){
                    min=j;
                }
            }
            E tmp=aux[i];
            aux[i]=aux[min];
            aux[min]=tmp;
           
            if(contains(pos, busqueda(a,aux[i]))){
         		
            }else
                addPos(busqueda(a,aux[i]));
        }
            
        
        return pos;
    }
    
    public int busqueda(E[] ps, E p3){
        int i=0;
        while ( i<ps.length && ps[i].compareTo(p3)!=0) i++ ;
        return(i==ps.length) ? -1: i;
    }
    
    public boolean contains(int[] a,int dato) {
    	for(int i=0;i<a.length;i++) {
    		if(a[i]==dato) {
    			return true;
    		}
    	}
    	return false;
    }
     
    public void addPos(int d){
        pos=Arrays.copyOf(pos,pos.length+1);
        pos[pos.length-1]=d;
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String line= in.nextLine();
        String[] n=line.split(",");
        Integer[] numbers=new Integer[n.length];
        for(int i=0;i<numbers.length;i++){
            numbers[i]=Integer.parseInt(n[i]);
        }
        SelectSortIndirecto<Integer> s=new SelectSortIndirecto<Integer>();
        int[] result=s.ArrayIndirecto(numbers);
        for (int i=0;i<result.length;i++) {
            if (i>0)
                System.out.print(',');
            System.out.print(result[i]);
        }          
        in.close();
    }

}