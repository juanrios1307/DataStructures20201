package arbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ABB<E extends Comparable<E>> extends ArbolB<E>{

	
	
	public ABB(NodoB<E> root) {
		super(root);
		
	}
	
	public NodoB<E> buscar(E dato) throws ExceptionNodo{
		return buscar(getRoot(),dato);
	}
	
	public NodoB<E> buscar(NodoB<E> r,E dato) throws ExceptionNodo{
		if(r!= null) {			
			if(r.getLlave().compareTo(dato)==0) {
				return r;
			}else {
				return r.getLlave().compareTo(dato)<0? buscar(r.getHijoDer(),dato):buscar(r.getHijoIzq(),dato);
			}
		}else
			throw new ExceptionNodo("Error: Dato no encontrado "+dato);
			
	}
	
	public void insertar(NodoB<E> node) throws ExceptionNodo{
		insertar(getRoot(),node);
	}
	
	public void insertar(NodoB<E> r,NodoB<E> node) throws ExceptionNodo {
		if(r==null) {
			setRoot((node));
		}else {
			NodoB<E> tmp=r;
			while(r != null) {
				if(r.getLlave().compareTo(node.getLlave())==0){
					throw new ExceptionNodo("Error: Nodo repetido");
				}
				tmp=r;
				if(node.getLlave().compareTo(r.getLlave())<0) {
					r=r.getHijoIzq();
				}else {
					r=r.getHijoDer();
				}
				
			}
				
			if(node.getLlave().compareTo(tmp.getLlave())<0) {
				tmp.setHijoIzq(node);
			}else {
				tmp.setHijoDer(node);
			}
		}
		
	}
	
	public void insertNodo(NodoB<E> n) throws ExceptionNodo{
        raiz=insertNodo(n, raiz);
    }

    protected NodoB<E> insertNodo(NodoB<E> n, NodoB<E> r) throws ExceptionNodo {
        if (r==null){
            r=n;
        }else{
            if (n.getLlave().compareTo(r.getLlave())<0)
                r.setHijoIzq(insertNodo(n,r.getHijoIzq()));
            if (n.getLlave().compareTo(r.getLlave())>0)
                r.setHijoDer(insertNodo(n,r.getHijoDer()));
            if (n.getLlave().compareTo(r.getLlave())==0)
                throw new ExceptionNodo("El nodo está repetido");
        }
        return r;
        
    }
    
    
   /* public ABB<E> crearArbol(Queue<E> preorden) throws ExceptionNodo{
		
		System.out.println(preorden);
		NodoB<E> raiz=new NodoB<E>((E)preorden.poll());
		
		return crearArbol(new ABB<E>(raiz),raiz  ,preorden);
	}
    
    public ABB<E> crearArbol(ABB<E> a,NodoB<E> r, Queue<E> preordenS) throws ExceptionNodo{
    	if(!preordenS.isEmpty()) {
    		NodoB<E> aux=new NodoB<E>(preordenS.poll());
    		aux.setParent(r);
    		if(aux.getLlave().compareTo(r.getLlave())<0) {
    			r.setHijoIzq(aux);
    			
    			return crearArbol(a,aux, preordenS);
    			
    		}else {
    			int c=0;
	    			while(aux.getLlave().compareTo(aux.getParent().getLlave())>0 && 
	    					aux.getParent()!=a.getRoot() &&
	    					aux.getLlave().compareTo(aux.getParent().getParent().getLlave())>0) {
	    				aux.setParent(aux.getParent().getParent());
	    				c++;
	    			}
    			
	    		if(c==0) {	
	    			r.setHijoDer(aux);	
	    		}else {
	    			aux.getParent().setHijoDer(aux);
	    		}
	    		return crearArbol(a,aux, preordenS);
    		}
    		
    	}else {
    		return a;
    	}
	}*/
	
    public NodoB<E> buscarAntecesor(NodoB<E> n) throws ExceptionNodo{
        return (n.getHijoIzq()==null)? null:buscarMax(n.getHijoIzq());
    }
   
    public NodoB<E> buscarMax(NodoB<E> n) throws ExceptionNodo{
        return (n.getHijoDer()==null)? n: buscarMax(n.getHijoDer());      
    }
    
    
    public void eliminar(E dato) throws ExceptionNodo {
    	NodoB<E> aux=buscar(dato);
    	if(aux.equals(getRoot())) 
    		eliminar(aux);
    	else
    		eliminar(aux,aux);	
    }
    
    public void eliminar(NodoB<E> nodoEliminar) throws ExceptionNodo {
    	if(nodoEliminar==null) {
    		throw new ExceptionNodo("No existe el dato a eliminar");
    	}else {
    		if(nodoEliminar.getHijoDer() != null && nodoEliminar.getHijoIzq() !=null) {
    			NodoB<E> aux=buscarAntecesor(nodoEliminar);
    			NodoB<E> papaAux=aux;
    			
    			if(aux.equals(papaAux.getHijoDer()))
					papaAux.setHijoDer(aux.getHijoIzq()!=null?aux.getHijoIzq():null);
				else 
					papaAux.setHijoIzq(aux.getHijoIzq()!=null?aux.getHijoIzq():null);
				
    			
				aux.setHijoDer(nodoEliminar.getHijoDer());
				aux.setHijoIzq(nodoEliminar.getHijoIzq());
				
				
				setRoot(aux);
				
    		}else if(nodoEliminar.getHijoDer() == null && nodoEliminar.getHijoIzq() ==null) {
    			setRoot(null);
    			
    		}else {
    			if(nodoEliminar.getHijoDer() != null ) {
    				setRoot(nodoEliminar.getHijoDer());
    			}else {
    				setRoot(nodoEliminar.getHijoIzq());
    			}
    		}
    	}
    }
    
    public void eliminar(NodoB<E> papa,NodoB<E> nodoEliminar) throws ExceptionNodo {
    	if(nodoEliminar==null) {
    		throw new ExceptionNodo("No existe el dato a eliminar");
    	}else {
    		
    		if(nodoEliminar.getHijoIzq()==null && nodoEliminar.getHijoDer()==null) { //Si nodo es hoja c1
    			if(nodoEliminar==papa.getHijoDer())
    				papa.setHijoDer(null);
    			else 
    				papa.setHijoIzq(null);
    			
    		}else {
    			if(nodoEliminar.getHijoIzq()!=null && nodoEliminar.getHijoDer()!=null) { //Si es nodo con dos hijos	
    				NodoB<E> aux=buscarAntecesor(nodoEliminar);
    				NodoB<E> papaAux=aux;
					
    				if(aux.equals(papaAux.getHijoDer()))
						papaAux.setHijoDer(aux.getHijoIzq()!=null?aux.getHijoIzq():null);
					else 
						papaAux.setHijoIzq(aux.getHijoIzq()!=null?aux.getHijoIzq():null);
					
    				aux.setHijoDer(nodoEliminar.getHijoDer());
					aux.setHijoIzq(nodoEliminar.getHijoIzq());
    				
					if(nodoEliminar.equals(papa.getHijoDer()))
	    				papa.setHijoDer(aux);
	    			else
	    				papa.setHijoIzq(aux);
					
    			}else {  //Si es nodo con 1 hijo c2 
    				if(nodoEliminar.getHijoDer() != null) {
    					if(nodoEliminar.equals(papa.getHijoDer())) 
    	    				papa.setHijoDer(nodoEliminar.getHijoDer());
    	    			else 
    	    				papa.setHijoIzq(nodoEliminar.getHijoDer());
    				}else {
    					if(nodoEliminar==papa.getHijoDer())
    	    				papa.setHijoDer(nodoEliminar.getHijoIzq());
    	    			else 
    	    				papa.setHijoIzq(nodoEliminar.getHijoIzq());	
    				}		
    			}
    		}		
    	}
    }
    
	
	public static void main(String[] args) {

		ABB<Integer> c=new ABB<Integer>(new NodoB<Integer>(1));
			Queue<Integer> pre=new LinkedList<Integer>();
			Integer[] arr={15, 6, 3, 1, 2, 5, 4, 11, 7, 9, 8, 20, 16};
			
			pre.addAll(Arrays.asList(arr));
			
			/*c=c.crearArbol(pre);*/
			c.preorden();
			
		
		
		System.out.println("=====================================");
		NodoB<Integer> n1 = new NodoB<Integer>(1);
        NodoB<Integer> n2 = new NodoB<Integer>(2);
        NodoB<Integer> n3 = new NodoB<Integer>(3);
        NodoB<Integer> n4 = new NodoB<Integer>(4);
        NodoB<Integer> n5 = new NodoB<Integer>(5);
        NodoB<Integer> n6 = new NodoB<Integer>(6);
        NodoB<Integer> n7 = new NodoB<Integer>(7);
        NodoB<Integer> n8 = new NodoB<Integer>(8);
        NodoB<Integer> n9 = new NodoB<Integer>(9);
        NodoB<Integer> n10 = new NodoB<Integer>(10);
        n6.setHijoIzq(n4);
        n4.setHijoIzq(n1);
        n4.setHijoDer(n5);
        n6.setHijoDer(n8);
        n8.setHijoIzq(n7);   
       
        ABB<Integer> a= new ABB<Integer>(n6);               
        System.out.println();
        try {
        	a.preorden();
        	
        	a.insertar(n2);
        	a.preorden();
        	a.insertar(n9);
        	
        	
        	System.out.println(n7.getAltura());
        	
            //a.inorden();
          /*  a.preorden();
            
            a.eliminar(4);
            
            a.preorden();
            a.eliminar(6);
            a.preorden();
            a.eliminar(8);
            a.preorden();*/
           
        } catch (ExceptionNodo e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
        System.out.println("=======================");
        //10, 15, 17, 13, 5, 8, 6, 3
        NodoB<Integer> n10a = new NodoB<Integer>(10);
        NodoB<Integer> n15 = new NodoB<Integer>(15);
        NodoB<Integer> n17 = new NodoB<Integer>(17);
        NodoB<Integer> n13 = new NodoB<Integer>(13);
        NodoB<Integer> n5a = new NodoB<Integer>(5);
        NodoB<Integer> n8a = new NodoB<Integer>(8);
        NodoB<Integer> n6a = new NodoB<Integer>(6);
        NodoB<Integer> n3a = new NodoB<Integer>(3);
        
        ABB<Integer> b=new ABB<Integer>(n10a);
        try {
			b.insertar(n15);
			b.insertar(n17);
			b.insertar(n13);
			b.insertar(n5a);
			b.insertar(n8a);
			b.insertar(n6a);
			b.insertar(n3a);
			
			b.preorden();
			
			System.out.println(n10a.getAltura());
	
		} catch (ExceptionNodo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        

        
	}
	
}
