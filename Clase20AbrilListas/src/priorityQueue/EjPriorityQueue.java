package priorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class EjPriorityQueue {

	public static void main(String[] args) {
		
		PriorityQueue<Persona> pq=new PriorityQueue<Persona>();
		
		Persona[] p=new Persona[100];
		for (int i = 0; i < p.length; i++) {
			p[i]=new Persona("Carlos",p.length-i);
		}
		
		
		pq.addAll(Arrays.asList(p));
        pq.add(new Persona("Juan",20));
        pq.add(new Persona("Juan",16));
        pq.add(new Persona("Abel",20));
        pq.add(new Persona("Ana",20));
        pq.add(new Persona("Abel",15));    

 

        while(!pq.isEmpty())
            System.out.println(pq.poll());
	}
	
	public Comparator<Persona> compPersona =new Comparator<Persona>() {
		
		@Override
		public int compare(Persona p1, Persona p2) {
			return p1.getNombre().compareTo(p2.getNombre());
		}
	};
	
}
