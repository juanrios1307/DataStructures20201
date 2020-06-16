package cuerpo;

public class CuerpoPrincipal {

	public static void main(String[] args) {
		Cuerpo c=new Cuerpo();
		c.setEspacio(150);
		c.setTiempo(15);
		double v=c.velocidad();
		System.out.println("Velocidad: "+v);
	}

}
