package Avion;


public class Comercial extends Avion{

	private int numPasajeros;

	

	public Comercial(double capCarga, double combustMax, double consumo, int horasVuelo,String matricula ,String modelo,
			String aerolinea, double nivAceite, int numPasajeros) {
		super(capCarga, combustMax, consumo, horasVuelo,matricula ,modelo, aerolinea, nivAceite);
		this.numPasajeros = numPasajeros;
	}

	public int getNumPasajeros() {
		return numPasajeros;
	}

	public void setNumPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
	}




	

}
