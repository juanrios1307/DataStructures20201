package arbolBinarioF2019;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ArbolB<E extends Comparable<E>> {

	protected NodoB<E> raiz;

	public NodoB<E> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoB<E> raiz) {
		this.raiz = raiz;
	}	
	
	public void preorden(){
		preorden(raiz);
		System.out.println();
	}
	
	public void preorden(NodoB<E> r){
		if (r!=null){
			System.out.print(r.getLlave()+" ");
			preorden(r.getHijoIzq());
			preorden(r.getHijoDer());
		}	
	}
	
	
	public LinkedList<E> preordenList(){
		LinkedList<E> list=new LinkedList<E>();
		preordenList(raiz, list);
		return list;
	}
	
	public void preordenList(NodoB<E> r, LinkedList<E> list){
		if (r!=null){
			list.add(r.getLlave());
			preordenList(r.getHijoIzq(),list);
			preordenList(r.getHijoDer(),list);
		}	
	}
	
	
	public void inorden(){
		inorden(raiz);
	}
	
	public void inorden(NodoB<E> r){
		if (r!=null){
			inorden(r.getHijoIzq());
			//System.out.print(r.getLlave()+ " ");
			System.out.print(r+ " ");
			inorden(r.getHijoDer());
		}	
	}
	
	public ArrayList<E> inordenA(){
		ArrayList<E> a=new ArrayList<E>();
		return inordenA(raiz, a);
	}
	public ArrayList<E> inordenA(NodoB<E> r, ArrayList<E> a){
		if (r!=null){
			inordenA(r.getHijoIzq(), a);
			a.add(r.getLlave());
			inordenA(r.getHijoDer(),a);
			return a;
		}
		return a;
	}
	
	public void postorden(){
		postorden(raiz);
	}
	
	public void postorden(NodoB<E> r){
		if (r!=null){
			postorden(r.getHijoIzq());
			postorden(r.getHijoDer());
			System.out.print(r.getLlave()+ " ");
		}	
	}
	
	public ArbolB(NodoB<E> raiz) {
		super();
		this.raiz = raiz;
	}
	

	public ArrayList<NodoB<E>> unarios(){
		ArrayList<NodoB<E>> lista=new ArrayList<NodoB<E>>();
		unarios(getRaiz(),lista);
		return lista;
	}
	
	public void unarios(NodoB<E> r,ArrayList<NodoB<E>> list){
		if (r!=null){
			if((r.getHijoDer() != null && r.getHijoIzq()==null) || (r.getHijoDer()==null && r.getHijoIzq() !=null)) {
				list.add(r);
			}
			unarios(r.getHijoIzq(),list);
			unarios(r.getHijoDer(),list);
		}	
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodoB<Integer> n10 = new NodoB<Integer>(10);
		NodoB<Integer> n7 = new NodoB<Integer>(7);
		NodoB<Integer> n15 = new NodoB<Integer>(15);
		NodoB<Integer> n5 = new NodoB<Integer>(5);
		NodoB<Integer> n9 = new NodoB<Integer>(9);
		NodoB<Integer> n12 = new NodoB<Integer>(12);
		NodoB<Integer> n6 = new NodoB<Integer>(6);
		NodoB<Integer> n13 = new NodoB<Integer>(13);
		NodoB<Integer> n14 = new NodoB<Integer>(14);
		NodoB<Integer> n16 = new NodoB<Integer>(16);
		NodoB<Integer> n11 = new NodoB<Integer>(11);
		n15.setHijoIzq(n12);
		n7.setHijoIzq(n5);
		n7.setHijoDer(n9);
		n10.setHijoIzq(n7);
		n10.setHijoDer(n15);
		n9.setHijoDer(n6);
		n12.setHijoDer(n13);
		n13.setHijoDer(n16);
		n13.setHijoIzq(n14);
		n14.setHijoIzq(n11);
		
		ArbolB<Integer> a= new ArbolB<Integer>(n10);
		a.preorden();
		
		System.out.println(a.unarios());
		
//		System.out.println("Inorden:");
//		a.inorden();
//		System.out.println();
//		System.out.println("Postorden:");
//
//		a.postorden();
		
		
	}

}
