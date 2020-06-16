package final2017;

public class Mano {
	
	
	private double peso;
	
	public Mano(double peso) {
		super();
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Mano [peso=" + peso + "]";
	}
	
	
	
}
