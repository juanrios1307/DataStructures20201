package rectas;

public class Rectas {
	
	public double x,m,n;

	public Rectas(double m, double x, double n) {
		super();
		this.x = x;
		this.m = m;
		this.n = n;
	}

	public double valor() {
		return m*x+n;
	}
	
	public double interseccionX() {
		return -n/m;
	}
	
	public double interseccionY() {
		return n;
	}
	
	public double pendientePerpendicular() {
		return -1/m;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getM() {
		return m;
	}

	public void setM(double m) {
		this.m = m;
	}

	public double getN() {
		return n;
	}

	public void setN(double n) {
		this.n = n;
	}

	public static void main(String[] args) {
		Rectas r=new Rectas(2, 4, 5);
		System.out.println("Valor: "+r.valor());
		System.out.println("Intersección en Y : "+r.interseccionY());
		System.out.println("Intersección en X : "+r.interseccionX());
		System.out.println("Pendiente de una recta perpendicular: "+r.pendientePerpendicular());
	}
}
