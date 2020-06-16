package Persona;

public class Piloto extends Persona{

	private String licencia;
	public Piloto(String nombre, String documento, String nacionalidad, int edad,boolean enfermo, String licencia) {
	super(nombre,documento, nacionalidad, edad,enfermo);
	this.licencia=licencia;
	}
	
	public Piloto(String nombre, String documento, String nacionalidad, int edad,boolean enfermo,Maleta[] maleta,String licencia) {
		super(nombre,documento, nacionalidad, edad,enfermo,maleta);
		this.licencia=licencia;
		}
	
	public String getLicencia() {
		return licencia;
	}
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	
	
	

}	

