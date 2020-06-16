
package Avion;

public class Avion {
	
	private double capCarga,combustMax,consumo;
	private int horasVuelo;
	private String modelo,aerolinea,matricula;
	private boolean planVuelo,metar,notam,pesoBalance,brujula,altimetro,extintores,equipoOxigeno,equipoEmergencia;
	private double nivAceite;
	public Avion(double capCarga, double combustMax, double consumo, int horasVuelo,String matricula ,String modelo, String aerolinea,double nivAceite) {
		super();
		this.nivAceite=nivAceite;
		this.capCarga = capCarga;
		this.combustMax = combustMax;
		this.consumo = consumo;
		this.horasVuelo = horasVuelo;
		this.modelo = modelo;
		this.aerolinea = aerolinea;
		this.matricula=matricula;
	
	}
	
	
	
	public Avion() {
		super();
	}



	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getCapCarga() {
		return capCarga;
	}
	public void setCapCarga(double capCarga) {
		this.capCarga = capCarga;
	}
	public double getCombustMax() {
		return combustMax;
	}
	public void setCombustMax(double combustMax) {
		this.combustMax = combustMax;
	}
	public double getConsumo() {
		return consumo;
	}
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}
	public int getHorasVuelo() {
		return horasVuelo;
	}
	public void setHorasVuelo(int horasVuelo) {
		this.horasVuelo = horasVuelo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}
	public boolean isPlanVuelo() {
		return planVuelo;
	}
	public void setPlanVuelo(boolean planVuelo) {
		this.planVuelo = planVuelo;
	}
	public boolean isMetar() {
		return metar;
	}
	public void setMetar(boolean metar) {
		this.metar = metar;
	}
	public boolean isNotam() {
		return notam;
	}
	public void setNotam(boolean notam) {
		this.notam = notam;
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
	public double getNivAceite() {
		return nivAceite;
	}
	public void setNivAceite(double nivAceite) {
		this.nivAceite = nivAceite;
	}

	
	
}