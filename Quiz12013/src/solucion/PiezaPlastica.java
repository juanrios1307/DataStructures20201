package solucion;

public class PiezaPlastica extends Pieza {

	public PiezaPlastica(int codigo, String descripcion, double peso) {
		super(codigo, descripcion, peso);
	}


	public double calcularCosto() {
		return 1.3*peso+30;
	}
	
	
}
