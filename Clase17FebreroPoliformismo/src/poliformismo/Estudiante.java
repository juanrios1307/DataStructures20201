package poliformismo;

public class Estudiante extends Persona{
	
	public void saludar() {
		super.saludar();
		System.out.println("Estudiante");
	}

	private int numMaterias;
	
	public int getNumMaterias() {
		return numMaterias;
	}

	@Override
	public void metodo2() {
		// TODO Auto-generated method stub
		
	}
}
