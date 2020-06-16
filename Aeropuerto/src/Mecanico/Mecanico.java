package Mecanico;
	
	import Persona.Persona;
import excepcion.ENoFecha;

import javax.swing.JOptionPane;

import Aeropuerto.Vuelo;
	import Avion.Avion;
	
public class Mecanico {

	private Persona persona;
	private Vuelo vuelo;
	private Avion avion;
	private boolean pesoBalance, brujula, altimetro, extintores, equipoOxigeno, equipoEmergencia;
	private double aceite;
	
	public Mecanico(Vuelo vuelo) {
		super();
		this.vuelo = vuelo;
		avion=vuelo.getAvion();
	}
	

	public boolean validacion() {
		return (pesoBalance&&brujula&&altimetro&&extintores&&equipoOxigeno&&equipoEmergencia&&aceite()&&pesoAdecuado());
	}
	
	public boolean aceite() {
		if ((aceite<=avion.getNivAceite()*1.1)&&(aceite>=avion.getNivAceite()*0.9)) {
			return true;
		}
		return false;
	}
	
	public double pesoCombustible() {
		long diferencia=0;
		try {
			diferencia = vuelo.getHoraLlegada().getTime() - vuelo.getHoraSalida().getTime();
		} catch (ENoFecha e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		long hours = diferencia / (60 * 60 * 1000) % 24;
		return avion.getConsumo()*hours;
	}

	public boolean pesoAdecuado() {
		if((pesoCombustible()<=avion.getCombustMax())&&(pesoCombustible()+1)<=(avion.getCapCarga()+avion.getCombustMax())) {
			return true;
		}
		return false;
	}
	
	
	
	public Vuelo getVuelo() {
		return vuelo;
	}


	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}


	public Avion getAvion() {
		return avion;
	}


	public void setAvion(Avion avion) {
		this.avion = avion;
	}


	public boolean isPesoBalance() {
		return pesoBalance;
	}
	public void setPesoBalance(boolean pesoBalance) {
		this.pesoBalance = pesoBalance;
	}
	public boolean isBrujula() {
		return brujula;
	}
	public void setBrujula(boolean brujula) {
		this.brujula = brujula;
	}
	public boolean isAltimetro() {
		return altimetro;
	}
	public void setAltimetro(boolean altimetro) {
		this.altimetro = altimetro;
	}
	public boolean isExtintores() {
		return extintores;
	}
	public void setExtintores(boolean extintores) {
		this.extintores = extintores;
	}
	public boolean isEquipoOxigeno() {
		return equipoOxigeno;
	}
	public void setEquipoOxigeno(boolean equipoOxigeno) {
		this.equipoOxigeno = equipoOxigeno;
	}
	public boolean isEquipoEmergencia() {
		return equipoEmergencia;
	}
	public void setEquipoEmergencia(boolean equipoEmergencia) {
		this.equipoEmergencia = equipoEmergencia;
	}
	public double getAceite() {
		return aceite;
	}
	public void setAceite(double aceite) {
		this.aceite = aceite;
	}
		
}
