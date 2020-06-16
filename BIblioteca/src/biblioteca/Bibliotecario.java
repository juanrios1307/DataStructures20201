package biblioteca;

import java.util.Calendar;
import java.util.Date;

import modelo.DAO;
public class Bibliotecario {
	
	private DAO dao=new DAO();
	
	 public boolean addBoleta(Boleta b) {
	    return dao.addBoleta(b);	
	 } 
	 public int buscarUltimoCodBoleta() {
		 return dao.buscarUltimoCodigoBoleta();
	 }
	 
	 public Libro buscarLibro(int isbn) {
		 return dao.buscarLibro(isbn);
	 }
	 public Boleta buscarBoleta(int codBoleta) {
		 return dao.buscarBoleta(codBoleta);
	 }
	 public boolean prestarLibro(int isbn,int codigoBoleta) {
		 return dao.prestarLibro(isbn,codigoBoleta);
	 }
	 public boolean devolverLibro(int isbn,int codigoBoleta) {
		 return dao.devolverLibro(isbn,codigoBoleta);
	 }
	 
	 public Date fechaEntrega(Date fecha){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fecha); // Configuramos la fecha que se recibe
			calendar.add(Calendar.DAY_OF_YEAR, 15);  // numero de días a añadir, o restar en caso de días<0
			return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
		
			 }

}
