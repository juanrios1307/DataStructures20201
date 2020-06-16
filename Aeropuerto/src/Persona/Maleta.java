package Persona;

import java.io.Serializable;

public class Maleta implements Serializable {
	
	private Mercancia[] mercancias;
	private double peso;

	
	public Mercancia[] getMercancias() {
		return mercancias;}
	public double getPeso() {
		return peso;}

	public Maleta(Mercancia[] mercancias, double peso) {
		this.mercancias = mercancias;
		this.peso = peso;}
	
	public double calcularPeso() {
		for(int i = 0;i < mercancias.length; i++) {
			peso += mercancias[i].getPeso();}
		return peso;}	
	
}
