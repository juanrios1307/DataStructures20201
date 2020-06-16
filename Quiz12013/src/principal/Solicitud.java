package principal;
import java.util.*;
public class Solicitud extends Cliente{
	
	private int codigo,codPieza,cantidad;
	private String fecha;
	Scanner leer=new Scanner(System.in);
	
	Pieza pieza=new Pieza(codPieza);
	public Solicitud(int codigoCliente, int codigo,
			int codPieza, int cantidad) {
		super(codigoCliente);
		this.codigo = codigo;
		this.codPieza = codPieza;
		this.cantidad = cantidad;
		
		pieza.setCodigo(codPieza);
		if(codPieza==3) {
			System.out.println("La pieza está conformada por cuantas piezas plasticas?");
			pieza.setpPlastica(leer.nextInt());
			System.out.println("La pieza está conformada por cuantas piezas metalicas?");
			pieza.setpMetalica(leer.nextInt());
		}
		
		pieza.clasificarPieza();
		
	}
	
	
	public double costoSolicitudesCliente() {
		setCostoSolitudes(pieza.calcularCosto()*cantidad);
		return pieza.calcularCosto()*cantidad;
	}
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodPieza() {
		return codPieza;
	}

	public void setCodPieza(int codPieza) {
		this.codPieza = codPieza;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
}
