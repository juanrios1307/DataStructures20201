package jar;

public class Jarras {
	private int cap;
	private int estado;

	public int getCap() {
		return cap;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Jarras(int cap) {
		this.cap = cap;
		this.estado = 0;

	}
}
