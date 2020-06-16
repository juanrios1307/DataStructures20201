package principal;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Decodificador {

	public static void main(String[] args) {
		System.out.println(decodificar("S.ALLETOS BES TRATROR AMPRO CEUGINSO CI SAE. VENTERGU"));
		System.out.println(codificar("URGENTE. VEA SI CONSIGUE COMPRAR OTRAS TRES BOTELLAS."));
	
	}
	
	public static String decodificar(String msg) {
		msg=msg.toLowerCase();
		Stack<Character> pilai=new Stack<Character>();
		for (int i = 0; i < msg.length(); i++) {
			pilai.add(msg.charAt(i));
		}
		//print(pilai);
		
		Queue<Character> colaReverse=new LinkedList<Character>();
		while(!pilai.isEmpty()) {
			colaReverse.add(pilai.pop());
		}
		//print(colaR);
		
		Queue<Character> cola=new LinkedList<Character>();
		
		Stack<Character> pilaAux=new Stack<Character>();
		
		while(!colaReverse.isEmpty()) {
			
			while(!colaReverse.isEmpty() && 
					!(colaReverse.peek().equals('a') || colaReverse.peek().equals('e') 
					|| colaReverse.peek().equals('i')|| colaReverse.peek().equals('o') 
					|| colaReverse.peek().equals('u'))) {
				
					pilaAux.add(colaReverse.poll());	
			}
			
			while(!pilaAux.isEmpty()) {
				cola.add(pilaAux.pop());
			}
			if(!colaReverse.isEmpty())
				cola.add(colaReverse.poll());
			
			//System.out.println("Cola: ");
			//print(cola);
		}
		
		
		String result="";
		
		while(!cola.isEmpty()) {
			result+=cola.poll();
		}
		
		return result.toUpperCase();
	}

	
	public static String codificar(String msg) {
		msg=msg.toLowerCase();
		Stack<Character> pilai=new Stack<Character>();
		for (int i = 0; i < msg.length(); i++) {
			pilai.add(msg.charAt(i));
		}
		print(pilai);
		
		Queue<Character> colaReverse=new LinkedList<Character>();
		
		while(!pilai.isEmpty()) {
			colaReverse.add(pilai.pop());
		}
		print(colaReverse);
		
		Queue<Character> cola=new LinkedList<Character>();
		
		Stack<Character> pilaAux=new Stack<Character>();
		
		while(!colaReverse.isEmpty()) {
			while(!colaReverse.isEmpty() && 
					!(colaReverse.peek().equals('a') || colaReverse.peek().equals('e') 
					|| colaReverse.peek().equals('i')|| colaReverse.peek().equals('o') 
					|| colaReverse.peek().equals('u'))) {
				
					pilaAux.add(colaReverse.poll());		
				
			}
			
			while(!pilaAux.isEmpty()) {
				cola.add(pilaAux.pop());
			}
			if(!colaReverse.isEmpty())
				cola.add(colaReverse.poll());
			
			//System.out.println("Cola: ");
			print(cola);

		}

		String result="";
		
		while(!cola.isEmpty()) {
			result+=cola.poll();
		}
		
		return result.toUpperCase();
	}
	
	
	public static void print(Queue<Character> cola) {
		for(Character str:cola) {
			System.out.print(str);
		}
		System.out.println();
	}
	
	public static void print(Stack<Character> pila) {
		for(Character str:pila) {
			System.out.print(str);
		}
		System.out.println();
	}
	
}
