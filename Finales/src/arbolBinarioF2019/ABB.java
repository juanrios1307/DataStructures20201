package arbolBinarioF2019;

import java.util.ArrayList;
import java.util.Arrays;

class ExceptionNodo extends Exception{
	public ExceptionNodo(String s){
		super(s);
	}
}

public class ABB<E extends Comparable<E>> extends ArbolB<E> {

	public ABB(NodoB<E> raiz) {
		super(raiz);
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
				throw new ExceptionNodo("El nodo est� repetido");
		}
		return r;
		
	}
	
	
	public void deleteNodo(E llave) throws ExceptionNodo{
		//Buscar n en raiz
		raiz=deleteNodo(llave, raiz);
	}
	
	public NodoB<E> deleteNodo(E llave, NodoB<E> r) throws ExceptionNodo{
		if (r==null)
			throw new ExceptionNodo("El nodo no se encuentra");
		else{
			if (llave.compareTo(r.getLlave())<0)
				r.setHijoIzq(deleteNodo(llave,r.getHijoIzq()));
			else
				if (llave.compareTo(r.getLlave())>0)
					r.setHijoDer(deleteNodo(llave,r.getHijoDer()));
				else{					
					//Caso 3					
					if (r.getHijoDer()!=null && r.getHijoIzq()!=null){
						NodoB<E> antecesor=buscarAntecesor(r);
						r.setLlave(antecesor.getLlave());
						r.setHijoIzq(deleteNodo(antecesor.getLlave(), r.getHijoIzq()));
					}else 
						//Caso 2 o Caso 1
						if (r.getHijoDer()!=null){
							r=r.getHijoDer();
						}else
							r=r.getHijoIzq();
				}		
		}
		return r;
	}
	
	
	public NodoB<E> buscarAntecesor(NodoB<E> n) throws ExceptionNodo{
		return (n.getHijoIzq()==null)? null:buscarMax(n.getHijoIzq());
			//throw new ExceptionNodo("Error en algoritmo, el nodo no tiene antecesor");
	}
	
	public NodoB<E> buscarMax(NodoB<E> n) throws ExceptionNodo{
		return (n.getHijoDer()==null)? n: buscarMax(n.getHijoDer());
			
	}
	
	
	public NodoB<E> buscarSucesor(NodoB<E> n) throws ExceptionNodo{
		if (n.getHijoDer()==null)
			throw new ExceptionNodo("Error en algoritmo, el nodo no tiene predecesor");
		return buscarMin(n.getHijoDer());
	}
	
	
	public NodoB<E> buscarMin(NodoB<E> n) throws ExceptionNodo{
		return (n.getHijoIzq()==null)? n:buscarMin(n.getHijoDer());
			
	}
	

	public NodoB<E> buscar(E llave) throws ExceptionNodo{
		return buscar(llave, raiz);
	}
	
	public NodoB<E> buscar(E llave, NodoB<E> r) throws ExceptionNodo{
		if (r==null)
			throw new ExceptionNodo("El nodo no existe");
		if (llave.compareTo(r.getLlave())<0)
			return buscar(llave, r.getHijoIzq());
		if (llave.compareTo(r.getLlave())>0)
			return buscar(llave, r.getHijoDer());
		return r;
	}
	
	public int altura (){
		return (raiz!=null)?raiz.altura():-1;	
	}
	

	public ABB<E> crearArbolPre(ArrayList<E> pre){
		NodoB<E> r=crearArbolPre(pre, 0, pre.size()-1);
		ABB<E> a= new ABB<E>(r);
		return a;
	}
	
	public NodoB<E> crearArbolPre(ArrayList<E> pre, int inicio, int fin){
		if (inicio<=fin){
			NodoB<E> r=new NodoB<E>(pre.get(inicio));
			int indexMenor=inicio+1;
			int indexMayor=inicio;
			while(indexMayor<=fin && pre.get(indexMayor).compareTo(pre.get(inicio))<=0) 
				indexMayor++;
			if (indexMenor<=fin && pre.get(indexMenor).compareTo(pre.get(inicio))<0)
				r.setHijoIzq(crearArbolPre(pre, indexMenor, indexMayor-1));
			if (indexMayor<=fin && pre.get(indexMayor).compareTo(pre.get(inicio))>0)
				r.setHijoDer(crearArbolPre(pre, indexMayor, fin));			
			return r;
		}
		return null;

		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)  {
/*	NodoB<Integer> n1 = new NodoB<Integer>(1);
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
		a.inorden();
		System.out.println();
		try {
			System.out.println(a.buscar(3));
		} catch (ExceptionNodo e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	*/
		
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
		ABB<Integer> a= new ABB<Integer>(n5);				
		try {
			a.insertNodo(n2);
			a.insertNodo(n3);
			a.insertNodo(n1);
			a.insertNodo(n9);
			a.insertNodo(n7);
			a.insertNodo(n8);
			a.insertNodo(n6);
			a.insertNodo(n4);
			a.insertNodo(n10);

			
		} catch (ExceptionNodo e) {
			System.out.println(e.getMessage());
		}
		
		ABB<Integer> a2= new ABB<Integer>(n1);
		System.out.println(a2.altura());
		
	/*	Integer[] li=new Integer[]{5, 2, 1, 3, 4, 9, 7, 6, 8, 10};
		ArrayList<Integer> l= new ArrayList<Integer>(Arrays.asList(li));
		ABB<Integer> arbol=new ABB<Integer>(null);
		ABB<Integer> newarbol=arbol.crearArbolPre(l);
		newarbol.preorden();
		newarbol.inorden();*/
		
		
	}

}
