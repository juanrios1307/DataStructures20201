package calificacion;

public class Calificacion {

	private double nota1,nota2,nota3;
	
	public Calificacion(double nota1, double nota2, double nota3) {
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}

	public double promedio() {
		return (nota1+nota2+nota3)/3;
		
	}
	
	public char evaluacion() {
		int promedio=(int)promedio();
		switch(promedio) {
			case 2:
				return 'M';
			case 3:
				return 'R';
			case 4:
				return 'B';
			case 5:
				return 'B';
			default: return '0';
		}	
	}
	
	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	public static void main(String[] args) {
		Calificacion e=new Calificacion(1,1,1);
		System.out.println(e.evaluacion());
		
	}
	
	
}
