package arbol;

public class NodoB<E extends Comparable<E>>{

	 private E llave;
	 private NodoB<E> hijoIzq;
	 private NodoB<E> hijoDer;

 
	 public NodoB(E data) {
		 this.llave = data;
	 }
	 
	 public NodoB(E data, NodoB<E> left, NodoB<E> right) {
		super();
		this.llave = data;
		this.hijoIzq = left;
		this.hijoDer = right;
	}

	 
	 public NodoB<E> getHijoIzq() {
		return hijoIzq;
	}

	public void setHijoIzq(NodoB<E> left) {
		this.hijoIzq = left;
		
	}

	public NodoB<E> getHijoDer() {
		return hijoDer;
	}

	public void setHijoDer(NodoB<E> right) {
		this.hijoDer = right;
	}
	
	public int getAltura() {
		return getAltura(this);
	}
	
	private int getAltura(NodoB<E> n) {
		if(n ==null) {
			return -1;
		}else {
			return 1+mayor(getAltura(n.getHijoDer()),getAltura(n.getHijoIzq()));
		}
	}
	
	private int mayor(int n1,int n2) {
		return n1>n2?n1:n2;
	}
	
	 public E getLlave() {
	 return llave;
	 }
	 
	 public void setLlave(E data) {
	 this.llave = data;
	 }
	 
	 

	@Override
	public String toString() {
		String hijoI=this.getHijoIzq()==null?"null":this.getHijoIzq().getLlave().toString();
		String hijoD=this.getHijoDer()==null?"null":this.getHijoDer().getLlave().toString();
		return "dato: "+getLlave()+" hi: "+hijoI+" hd: "+hijoD;
	}

	
	 
	
	 
}
