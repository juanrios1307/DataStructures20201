package jar;

public class NodoBin<E> {
	NodoBin<E> padre;
	NodoBin<E> hijoIzq;
	NodoBin<E> hermano;
	protected E estado1;



	public NodoBin(E estado1) {
		this.estado1 = estado1;

	}

	public NodoBin<E> getPadre() {
		return padre;
	}

	public void setPadre(NodoBin<E> padre) {
		this.padre = padre;
	}

	public NodoBin<E> getHijoIzq() {
		return hijoIzq;
	}

	public void setHijoIzq(NodoBin<E> hijoIzq) {
		this.hijoIzq = hijoIzq;
	}

	public NodoBin<E> getHermano() {
		return hermano;
	}

	public void setHermano(NodoBin<E> hermano) {
		this.hermano = hermano;
	}

	public E getEstado1() {
		return estado1;
	}

	public void setEstado1(E estado1) {
		this.estado1 = estado1;
	}

}
