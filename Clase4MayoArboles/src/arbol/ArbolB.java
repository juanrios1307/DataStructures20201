package arbol;

import java.util.ArrayList;

public class ArbolB<E extends Comparable<E>> {
	
	NodoB<E> raiz ;
	
	public NodoB<E> getRoot() {
		return raiz;
	}

	public void setRoot(NodoB<E> root) {
		this.raiz = root;
	}

	public ArbolB(NodoB<E> root) {
		super();
		this.raiz = root;
	}

	public void preorden() {
		preorden(raiz);
		System.out.println();
	}
	
	
	public void preorden(NodoB<E> r) {
		if(r!=null) {
			System.out.print(r.getLlave()+"\t");
			preorden(r.getHijoIzq());
			preorden(r.getHijoDer());
		}
	}
	
	public ArrayList<NodoB<E>> preordenList() {
		ArrayList<NodoB<E>> llaves=new ArrayList<NodoB<E>>();
		preorden(raiz,llaves);
		return llaves;
	}
	
	public void preorden(NodoB<E> r,ArrayList<NodoB<E>> llaves) {
		if(r!=null) {
			System.out.print(r.getLlave()+"\t");
			llaves.add(r);
			preorden(r.getHijoIzq(),llaves);
			preorden(r.getHijoDer(),llaves);
		}
	}
	
	private void printTree(NodoB<E> node, String appender) {
		   System.out.println(appender + node.getLlave());
		   preordenList().forEach(each ->  printTree(each, appender + appender));
		 }
	
	public void inorden() {
		inorden(raiz);
		System.out.println();
	}
	
	public void inorden(NodoB<E> r) {
		if(r!=null) {
			inorden(r.getHijoIzq());
			System.out.print(r.getLlave()+"\t");
			inorden(r.getHijoDer());
		}
	}
	
	public void postorden() {
		postorden(raiz);
		System.out.println();
	}
	
	public void postorden(NodoB<E> r) {
		if(r!=null) {
			postorden(r.getHijoIzq());
			postorden(r.getHijoDer());
			System.out.print(r.getLlave()+"\t");
		}
	}
	

	
	public static void main(String[] args) {
        NodoB<Integer> n1 = new NodoB<Integer>(10);
        NodoB<Integer> n2 = new NodoB<Integer>(7);
        NodoB<Integer> n3 = new NodoB<Integer>(15);
        NodoB<Integer> n4 = new NodoB<Integer>(5);
        NodoB<Integer> n5 = new NodoB<Integer>(9);
        NodoB<Integer> n6 = new NodoB<Integer>(12);
        n3.setHijoIzq(n6);
        n2.setHijoIzq(n4);
        n2.setHijoDer(n5);
        n1.setHijoIzq(n2);
        n1.setHijoDer(n3);
        ArbolB<Integer> a= new ArbolB<Integer>(n1);
        System.out.println("Preorden:");
        a.preorden();

        a.printTree(n1, " ");
        
        System.out.println("Inorden: ");
        a.inorden();
        
        System.out.println("Postorden: ");
        a.postorden();
        
	}
	
}
