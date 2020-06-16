package cuerpo;

public class Cuerpo {
	private double espacio;
	private double tiempo;
	
	public Cuerpo() {
		
	}
	
	
	public double getEspacio() {
		return espacio;
	}

	public void setEspacio(double espacio) {
		this.espacio = espacio;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	
	public double velocidad() {
		return espacio/tiempo;
	}
}
