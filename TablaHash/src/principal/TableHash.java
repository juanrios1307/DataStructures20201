package principal;

import java.util.*;

public class TableHash {

		public static void main(String[] args) {
			Persona2 p1=new Persona2("Alex", 23);
			Persona2 p2=new Persona2("Pedro", 27);
			Persona2 p3=new Persona2("Juan", 20);
			Persona2 p4=new Persona2("Ana", 18);
			HashMap<Integer,Persona2> mapP=new HashMap<Integer,Persona2>();//Creating HashMap
			mapP.put(3,p3);
			mapP.put(1,p1);
			mapP.put(2,p2);
			mapP.put(4,p4);
			
			for(Map.Entry<Integer,Persona2> m : mapP.entrySet()){
			    Persona2 aux=m.getValue();
			    System.out.println(m.getKey()+": "+aux.getNombre()+" "+aux.getEdad());   
			}
			System.out.println(mapP);
		
			TreeMap<Integer,Persona2> mapT=new TreeMap<Integer,Persona2>();
	        mapT.put(3,p3);
	        mapT.put(1,p1);
	        mapT.put(2,p2);
	        mapT.put(4,p4);

	        System.out.println("___________________________");
	        
	        for(Map.Entry<Integer,Persona2> m : mapT.entrySet()){ 
	            Persona2 aux=m.getValue();
	            System.out.println(m.getKey()+": "+aux.getNombre()+" "+aux.getEdad());    
	        } 
	        System.out.println(mapT);
	        
	        
	        SortedMap<Integer,Persona2> mapTS=new TreeMap<Integer,Persona2>(new Comparator<Integer>() {
	        	
	            @Override
	            public int compare(Integer o1, Integer o2) {
	                // TODO Auto-generated method stub
	                return o2.compareTo(o1);
	            }
	        });
	        mapTS.put(3,p3);
	        mapTS.put(1,p1);
	        mapTS.put(2,p2);
	        mapTS.put(4,p4);

	        System.out.println("___________________________");
	        
	        for(Map.Entry<Integer,Persona2> m : mapTS.entrySet()){ 
	            Persona2 aux=m.getValue();
	            System.out.println(m.getKey()+": "+aux.getNombre()+" "+aux.getEdad());    
	        } 
	        System.out.println(mapTS);
	        
	        mapTS.put(2,p1);
	        System.out.println(mapTS);
	        
	        mapTS.remove(3);
	        System.out.println(mapTS);
	        
		}
}
