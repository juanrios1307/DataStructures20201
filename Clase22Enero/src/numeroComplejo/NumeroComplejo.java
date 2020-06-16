package numeroComplejo;

public class NumeroComplejo {

	private double parteImaginaria,parteReal;

	public double getParteImaginaria() {
		return parteImaginaria;
	}

	public void setParteImaginaria(double parteImaginaria) {
		this.parteImaginaria = parteImaginaria;
	}

	public double getParteReal() {
		return parteReal;
	}

	public void setParteReal(double parteReal) {
		this.parteReal = parteReal;
	}
	
	public double modulo() {
		return Math.sqrt(Math.pow(parteReal, 2)+Math.pow(parteImaginaria, 2));
	}
	
	public double argumento() {
		return Math.atan2(parteImaginaria, parteReal);
	}
	
	public void imprimirNumero() {
		System.out.println(parteReal+" + "+parteImaginaria+"i");
	}
	
	public static void main(String[] args) {
		NumeroComplejo nc=new NumeroComplejo();
		nc.setParteImaginaria(9);
		nc.setParteReal(4.5);
		
		nc.imprimirNumero();
		System.out.println("Modulo : "+nc.modulo());
		System.out.println("Arg: "+nc.argumento());
	}

}
