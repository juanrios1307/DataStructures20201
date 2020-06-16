package principal;

public  class Pieza {
	
	private int codigo, peso;
	private String descripcion;
	private int pPlastica, pMetalica;

	public Pieza(int codPieza) {
		this.codigo = codPieza;
		clasificarPieza();
	}


	public int getpPlastica() {
		return pPlastica;
	}

	public void setpPlastica(int pPlastica) {
		this.pPlastica = pPlastica;
	}

	public int getpMetalica() {
		return pMetalica;
	}

	public void setpMetalica(int pMetalica) {
		this.pMetalica = pMetalica;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double calcularCosto() {
		if (getDescripcion().equals("plastica")) {
			return 1.3*getPeso()+30;
		}else if(getDescripcion().equals("metalica")){
			return 2.8*getPeso()+56;
		}else if(getDescripcion().equals("mixta")) {
			return calcPiezaMixta();
		}else {
			return 0;
		}
	}
	
	public double calcPiezaMixta() {
			return (1.3*pPlastica+30)+(2.8*pMetalica+56);
	}
	
	public void clasificarPieza() {
		switch (codigo) {
		case 1:
			setDescripcion("plastica");
			setPeso(10);
			break;
		case 2:
			setDescripcion("metalica");
			setPeso(10);
			break;
		case 3:
			setDescripcion("mixta");
			setPeso(10);
			break;
		default:
			break;
		}
	}
	

	
}
