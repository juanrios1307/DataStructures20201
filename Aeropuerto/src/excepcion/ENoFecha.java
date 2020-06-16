package excepcion;

public class ENoFecha extends Exception{
	public ENoFecha(String msg) {
		System.err.println(msg);
	}
}
