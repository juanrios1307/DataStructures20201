package final2017;

import java.util.ArrayList;

public class Caja {
	
	private String codigo;
	private double pesoTotal=0;
	private ArrayList<Mano> manos;
	
	public Caja(String codigo) {
		super();
		this.codigo = codigo;
		manos=new ArrayList<Mano>();
	}
	

	@Override
	public String toString() {
		return "Caja [codigo=" + codigo + ", pesoTotal=" + pesoTotal + "]";
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public ArrayList<Mano> getManos() {
		return manos;
	}

	public void setManos(ArrayList<Mano> manos) {
		this.manos = manos;
	}
	
	
	
}
