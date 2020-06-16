package tiquetes;

import java.util.Date;

import Aeropuerto.Vuelo;
import Persona.Persona;

public class Tiquete {
	
	private Date fechaCompra;
	private int numSilla;
	private char filaAsiento;
	private int grupoAbordaje;
	private String codigoReserva;
	private Date horaEnSala;
	private String clase;
	private double pesoEquipajePermitido;
	private Vuelo vuelo;
	private String documento;
	private Persona persona;
	
	public Date getFechaCompra() {
		return fechaCompra;
	}
	
	
	
	public Tiquete() {
		super();
	}
	
	public String getDocumento() {
		return documento;
	}



	public void setDocumento(String documento) {
		this.documento = documento;
	}



	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}



	public void setNumSilla(int numSilla) {
		this.numSilla = numSilla;
	}



	public void setFilaAsiento(char filaAsiento) {
		this.filaAsiento = filaAsiento;
	}



	public void setGrupoAbordaje(int grupoAbordaje) {
		this.grupoAbordaje = grupoAbordaje;
	}



	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}



	public void setHoraEnSala(Date horaEnSala) {
		this.horaEnSala = horaEnSala;
	}



	public void setClase(String clase) {
		this.clase = clase;
	}



	public void setPesoEquipajePermitido(double pesoEquipajePermitido) {
		this.pesoEquipajePermitido = pesoEquipajePermitido;
	}



	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}



	public void setPersona(Persona persona) {
		this.persona = persona;
	}



	public Tiquete(Date fechaCompra, int numSilla, char filaAsiento, int grupoAbordaje, String codigoReserva,
			Date horaEnSala, String clase, double pesoEquipajePermitido, Vuelo vuelo, Persona persona,String documento) {
		super();
		this.fechaCompra = fechaCompra;
		this.numSilla = numSilla;
		this.filaAsiento = filaAsiento;
		this.grupoAbordaje = grupoAbordaje;
		this.codigoReserva = codigoReserva;
		this.horaEnSala = horaEnSala;
		this.clase = clase;
		this.pesoEquipajePermitido = pesoEquipajePermitido;
		this.vuelo = vuelo;
		this.persona = persona;
		this.documento=documento;
	}
	
	
	public int getNumSilla() {
		return numSilla;
	}

	public char getFilaAsiento() {
		return filaAsiento;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public Persona getPersona() {
		return persona;
	}

	public int getGrupoAbordaje() {
		return grupoAbordaje;
	}

	public String getCodigoReserva() {
		return codigoReserva;
	}

	public Date getHoraEnSala() {
		return horaEnSala;
	}

	public String getClase() {
		return clase;
	}

	public double getPesoEquipajePermitido() {
		return pesoEquipajePermitido;
	}
	
	
}
