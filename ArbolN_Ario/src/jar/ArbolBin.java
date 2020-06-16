package jar;

public class ArbolBin<E> {
	NodoJ raiz;

	public NodoJ getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoJ raiz) {
		this.raiz = raiz;
	}

	public void primSol(NodoJ nodo, int litO, int litO2) {
		if (nodo.estado1[0].getEstado() == litO ) {
		} else {
			nodo.operadores(nodo.estado1[0], nodo.estado1[1]);
			primSol(nodo.getHijoIzq(), litO, litO2);
			primSol(nodo.getHermano(), litO, litO2);
		}
	}

	public void secSol(NodoJ nodo) {

		nodo.operadores(nodo.estado1[0], nodo.estado1[1]);
		if (nodo.getHijoIzq() == null || nodo.getHermano()==null) {
		} else {
			secSol(nodo.getHijoIzq());
			secSol(nodo.getHermano());
		}

	}

	public void print(NodoJ nodo) {
		if (nodo.getHijoIzq() == null) {
		} else {
			System.out.println("m");
			System.out.println("jarra1  :" + nodo.estado1[0].getEstado() + "jarra2 :" + nodo.estado1[1].getEstado() + "accion  :"
					+ nodo.accion(nodo.getAux()));
			print(nodo.getHijoIzq());
			print(nodo.getHermano());
		}
	}

	public static void main(String[] args) {
		Jarras j4 = new Jarras(4);
		Jarras j3 = new Jarras(3);
		Jarras[] jar = new Jarras[2];
		jar[0] = j4;
		jar[1] = j3;
		NodoJ n1 = new NodoJ(jar);
		ArbolBin<Integer> ar = new ArbolBin<Integer>();
		ar.setRaiz(n1);
		 ar.primSol(ar.raiz, 2,0);
		//ar.secSol(ar.raiz);
		ar.print(ar.raiz);

	}
}
