package linkedList;

import java.io.*; 

public class LinkedList<T> { 

	Node head;

	 static class Node<T> { 
	     T data; 
	     Node next; 
	
	     Node(T d) { 
	         data = d; 
	         next = null; 
	     } 
	 } 
	 
	 public LinkedList addfirst(LinkedList list, T data) {
		 Node newNode =new Node(data);
		 newNode.next=list.head;
		 list.head=newNode;
		 return list;
	 }
	 
	 public LinkedList add(LinkedList list, T data){ 
	     // Creo nuevo nodo con estos datos
	     Node newNode = new Node(data); 
	     newNode.next = null; 
 
	     if (list.head == null) { 
	         list.head = newNode; 
	     } 
	     else { 
	         Node last = list.head; 
	         while (last.next != null) { 
	             last = last.next; 
	         } 
	
	         // Add en ultima posicion
	         last.next = newNode; 
	     } 

	     return list; 
	 } 
	 
	 public static void printList(LinkedList list) { 
	     Node currNode = list.head; 
	
	     System.out.print("LinkedList: "); 
	
	     while (currNode != null) { 
	         System.out.print(currNode.data + " "); 
	
	         //voy al siguiente nodo
	         currNode = currNode.next; 
	     } 
	 } 
	
	 public static void main(String[] args) 
	 { 
	     //inicializo lista vacia
	     LinkedList<Integer> list = new LinkedList<Integer>(); 
	  // agrego valores
	     
	     list.addfirst(list, 10);
	     
	     list.add(list, 1); 
	     list.add(list, 2); 
	     list.add(list, 3); 
	     list.add(list, 4); 
	     list.addfirst(list, 5); 
	     list.add(list, 6); 
	     list.add(list, 7); 
	     list.add(list, 8); 
	     
	    
	     list.addfirst(list, 58);
	     // imprimo lista 
	     printList(list); 
	 } 
} 