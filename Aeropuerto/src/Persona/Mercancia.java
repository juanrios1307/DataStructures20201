package Persona;
import java.io.*;

public class Mercancia implements Serializable {

	private String lote;
	private boolean legal;
	private double peso;
	
	public boolean isLegal() {
		return legal;}
	public double getPeso() {
		return peso;}
	public String getLote() {
		return lote;}
	
	public Mercancia(String lote, boolean legal, double peso) {
		super();
		this.lote = lote;
		this.legal = legal;
		this.peso = peso;
	}
	public Mercancia(boolean legal, double peso) {
		super();
		this.legal = legal;
		this.peso = peso;
	}
	
	public Mercancia() {
		
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	

}
