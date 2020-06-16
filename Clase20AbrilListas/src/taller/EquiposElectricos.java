package taller;

import java.util.Date;

public class EquiposElectricos implements Comparable<EquiposElectricos> {
	
	private Date fechaLlegada;
	private String tipo,owner;
	
	
	public EquiposElectricos(Date fechaLlegada, String tipo, String owner) {
		super();
		this.fechaLlegada = fechaLlegada;
		this.tipo = tipo;
		this.owner = owner;
	}
	
	@Override
	public int compareTo(EquiposElectricos e1) {
		if(tipo.equals("Salud") && !e1.getTipo().equals("Salud")) {
			return -1;
		}else if(!tipo.equals("Salud") && e1.getTipo().equals("Salud")) {
			return 1;
		}else {
			return fechaLlegada.compareTo(e1.getFechaLlegada());
		}
		
	}

	@Override
	public String toString() {
		//return "Equipo: [tipo:"+tipo+"\tdueño: "+owner+" ]";
		return "Equipo: [ "+" tipo: "+tipo+" dueño: "+owner+" ]";
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public String getTipo() {
		return tipo;
	}
}
