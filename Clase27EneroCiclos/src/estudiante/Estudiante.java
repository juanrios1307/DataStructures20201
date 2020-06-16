package estudiante;

public class Estudiante {
	
	//static para que la variable o metodo no sea
	//solo usada en el objeto sino en toda la clase
	public static int numEstudiante;
	
	//final para declarar constantes
	public final int matricula;
	
	
	public Estudiante(int matricula) {
		this.matricula=matricula;
		numEstudiante++;
	}
	
	public int getNumEstudiante() {
		return numEstudiante;
	}
	
	public static void main(String[] args) {
		Estudiante e1=new Estudiante(1026);
		System.out.println(e1.getNumEstudiante());
		Estudiante e2=new Estudiante(5289);
		System.out.println(e2.getNumEstudiante());
		Estudiante e3 =new Estudiante(7456);
		System.out.println(e3.getNumEstudiante());
		
		System.out.println(Estudiante.numEstudiante);
	}
	

}
