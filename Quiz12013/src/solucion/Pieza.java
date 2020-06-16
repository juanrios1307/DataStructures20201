package solucion;

public abstract class Pieza {
	protected int codigo;
	protected String descripcion;
	protected double peso;
		
	public Pieza(int codigo, String descripcion, double peso) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.peso = peso;
	}
	
	public Pieza(int codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public double getPeso() {
		return peso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public abstract double calcularCosto();
	
}
