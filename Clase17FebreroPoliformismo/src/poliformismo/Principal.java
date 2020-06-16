package poliformismo;

public class Principal {
	public static void main(String[] args) {
		
		/*Persona p=new Persona();
		
		p.saludar();
		p.saludar("Juan");*/
		
		Estudiante e=new Estudiante();
		e.saludar();
		
		metodo1(e);
		
	}
	
	public static void metodo1(Persona p) {
		System.out.println(p.getNombre());
		
		if(p instanceof Estudiante)
			System.out.println(((Estudiante) p ).getNumMaterias());
	}
	
	
}
