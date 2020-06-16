package solucion;

public class PiezaMetalica extends Pieza {

	public PiezaMetalica(int codigo, String descripcion, double peso) {
		super(codigo, descripcion, peso);
	}

	public double calcularCosto() {
		return 2.8*peso+56;
	}

}
