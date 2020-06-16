package solucion;

public class PiezaMixta extends Pieza {
	
	private Pieza[] piezas;
	
	public PiezaMixta(int codigo, String descripcion, Pieza[] piezas) {
		super(codigo, descripcion);
		this.piezas=piezas;
		calcularPeso();
		
	}

	public double calcularCosto() {
		double costo=0;
		for (int i = 0; i < piezas.length; i++) {
			costo += piezas[i].calcularCosto();
		}
		return costo;
	}
	
	private void calcularPeso() {
		for (int i = 0; i < piezas.length; i++) {
			peso += piezas[i].getPeso();
		}
	}
	
}
