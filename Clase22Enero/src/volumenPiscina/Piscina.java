package volumenPiscina;

public class Piscina {
	
	private double a,b,c;
			
	public Piscina(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double volumenMetroCubico() {
		return a*b*c;
	}
	
	public double volumenHectoLitro() {
		return volumenMetroCubico()*10;
	}


	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Piscina p=new Piscina(50, 25, 2);
		
		System.out.println("Volumen en Hectolitro : "+p.volumenHectoLitro());
		System.out.println("Volumen en m^3 : "+p.volumenMetroCubico());
	}

}
