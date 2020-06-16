package modelo;

public class SQLHelper {
	 
	final String tablaLibro="libro";
	final String tablaBoleta="boleta";
	final String bd="use sql9322078;";
   
    //Cambiar consultas
    public String addBoleta() {
    	 return "INSERT INTO "+tablaBoleta+" (usuario,cedula,codigolibro,libro,fechaprestamo,fechadevolucion,estado) VALUES (?,?,?,?,?,?,?);";
    }
    
    public String buscarUltimoCodigo() {
    	return "SELECT MAX(codigoboleta) FROM "+tablaBoleta;
    }
    
    public String buscarLibro(int isbn) {

    	return "SELECT * FROM "+tablaLibro+" WHERE codigo = '"+isbn+"';";
    }
    public String buscarBoleta(int codBoleta) {

    	return "SELECT * FROM "+tablaBoleta+" WHERE codigoboleta = '"+codBoleta+"';";
    }
    
    public String prestarLibroTL(int isbn) {
    	 return "UPDATE "+tablaLibro+" SET disponibilidad=0 WHERE codigo= '"+isbn+"';";
    }
    public String prestarLibroTB(int isbn,int codigoBoleta) {
   	 return "UPDATE "+tablaBoleta+" SET estado=1 WHERE codigoboleta= '"+codigoBoleta+"' AND codigolibro= '"+isbn+"' ;";
   }
    
    public String devolverLibroTL(int isbn) {
    	return "UPDATE "+tablaLibro+" SET disponibilidad=1 WHERE codigo= '"+isbn+"';";
    }
    public String devolverLibroTB(int isbn,int codigoboleta) {
    	return "UPDATE "+tablaBoleta+" SET estado=0 WHERE codigoboleta= '"+codigoboleta+"' AND codigolibro='"+isbn+"';";
    }
    
    

}
