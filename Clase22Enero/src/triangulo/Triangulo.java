package triangulo;
public class Triangulo {
	private double lado1,lado2,lado3;

	
	
	public Triangulo(double lado1, double lado2, double lado3) {
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
		
		System.out.println(esValido()?"":"El triangulo no es valido");
		
	}
	
	public Triangulo() {
		
	}



	public double getLado1() {
		return lado1;
	}
	
	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}
	
	public double getLado2() {
		return lado2;
	}
	
	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}
	
	public double getLado3() {
		return lado3;
	}
	
	public void setLado3(double lado3) {
		this.lado3 = lado3;
	}
	
	public double perimetro() {
		return lado1+lado2+lado3;
	}
	
	public double area() {
		double s=perimetro()/2;
		return Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
	}
	
	public char clasify() {
		
		return (lado1==lado2 && lado2==lado3)?'q' 
				: (lado1==lado2 || lado1==lado3 || lado2==lado3)? 'i':'e';
	}
	
	public boolean esValido() {
		return lado1+lado2 > lado3 && lado1+lado3 > lado2 && lado2+lado3 > lado1;
		
	}
	
	public static void main(String[] args) {
		Triangulo t=new Triangulo(5,4,8);
		System.out.println("El area es: "+t.area());
		System.out.println("El perimetro es: "+t.perimetro());
		System.out.println("El triangulo es "+t.clasify());
		
	}
}
