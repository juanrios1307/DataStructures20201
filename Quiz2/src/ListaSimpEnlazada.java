
import java.util.*;
class NodoL<E>{
    private E Info;
    private NodoL<E> next;
    
    public E getInfo() {
        return Info;
    }
    public void setInfo(E info) {
        Info = info;
    }
    public NodoL<E> getNext() {
        return next;
    }
    public void setNext(NodoL<E> next) {
        this.next = next;
    }
    public NodoL(E info) {
        super();
        Info = info;
        next = null;
    }
    @Override
    public String toString() {
        return Info.toString();
    }
    
}

public class ListaSimpEnlazada<E extends Comparable<E>> {
    
    private NodoL<E> head;
    

    public NodoL<E> getHead() {
        return head;
    }


    public void setHead(NodoL<E> head) {
        this.head = head;
    }
    
    
    public ListaSimpEnlazada(NodoL<E> head) {
        super();
        this.head = head;
    }
    
    public ListaSimpEnlazada() {
        this.head=null;
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    
    public int length(){
        int l=0;
        NodoL<E> temp=head;
        while(temp!=null){
            temp=temp.getNext();
            l++;
        }
        return l;
    }

    public void addFirst(E x){
		NodoL<E> newNodo=null;
		if (head!=null){
			newNodo=new NodoL<E>(head.getInfo());
			newNodo.setNext(head.getNext());
		} else{
			head=new NodoL<E>(x);		
		}
		head.setInfo(x);
		head.setNext(newNodo);
	}
    
    public NodoL<E> getNodo(int i) {
        NodoL<E> tmp = head;
        int j=0;
        while 	(tmp != null && j<i) {
            tmp = tmp.getNext();
            j++;
        }
        return ((tmp != null) ? tmp : null);
    }   
    
    public void printList(){
        NodoL<E> actual=head;
        while (actual!=null){
            System.out.print(actual.getInfo()+" ");
            actual=actual.getNext();
        }
        System.out.println();
    }
    
        
    public void insertNodo(E x, int pos) throws Exception{
        if (pos==0)
            addFirst(x);
        else{
            NodoL<E> n=new NodoL<E>(x);
            if (head==null)
                throw new Exception("La lista está vacía");
            NodoL<E> actual=head;
            int i=1;
            while (actual.getNext()!=null && i<pos){
                actual=actual.getNext();
                i++;
            }
            if (i==pos){
                n.setNext(actual.getNext());
                actual.setNext(n);
            }
            else
                throw new Exception("La posición no es válida");

        }
        
    }
    
    public void sort() {
    	
    		for (int i = 0; i < length()-1; i++) { 
    			for (int j = 0; j < length()-1-i; j++) {  
    				if(getNodo(j+1).getInfo().compareTo(getNodo(j).getInfo())<0) { 
    					E tmp=getNodo(j).getInfo();
    					getNodo(j).setInfo(getNodo(j+1).getInfo());
    					getNodo(j+1).setInfo(tmp);
    				}
    			}
    		}
    	
    }
    
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String line= in.nextLine();
    	String[] n=line.split(",");
    	ListaSimpEnlazada<Integer> lista = new ListaSimpEnlazada<Integer>();
        for(int i=0;i<n.length;i++){
        	Integer number=Integer.parseInt(n[i]);
			try {
				lista.insertNodo(number, i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
        }
        lista.sort();
		lista.printList();
	}    
        
}
