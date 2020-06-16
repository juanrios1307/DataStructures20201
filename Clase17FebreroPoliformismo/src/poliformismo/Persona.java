package poliformismo;

public abstract class Persona {
	private String nombre;
	
	

	public String getNombre() {
		return nombre;
	}

	public void saludar() {
		System.out.println("Hola");
	}
	
	public void saludar(String nombre) {
		System.out.println("Hola "+nombre);
	}
	
	public abstract void metodo2();
}
