package conversionTiempo;

public class Milisegundos {
	
	private int mili;
	private int aux;
	
	public Milisegundos(int mili) {
		this.mili=mili;
	}
	
	public int getMili() {
		return mili;
	}

	public void setMili(int mili) {
		this.mili = mili;
	}

	public void conversionTotal() {		
		if(mili%3600000 == 0) {
			convHora(mili%3600000);
		}else  {
			aux=mili-(convHora(mili%3600000)*3600000);
			if(aux%60000 == 0) {
				convMin(aux);
			}else {
				aux-=convMin(aux)*60000;
				if(aux%1000 == 0) {
					convSeg(aux);
				}else {
					aux-=convSeg(aux)*1000;
					if(aux%100 == 0) {
						convCent(aux);
					}else {
						aux-=convCent(aux)*100;
						System.out.println("MiliSegundos: "+aux);
					}
				}
			}	
		}
	}
	
	private int convHora(int residuo) {
		System.out.println("HORAS: "+(mili-residuo)/3600000);
		return (mili-residuo)/3600000;
	}
	
	private int convMin(int sinHoras) {
		System.out.println("Minutos: "+(sinHoras-(sinHoras%60000))/60000);
		return (sinHoras-(sinHoras%60000))/60000;
	}
	
	private int convSeg(int sinMinutos) {
		System.out.println("Segundos: "+(sinMinutos-(sinMinutos%1000))/1000);
		return (sinMinutos-(sinMinutos%1000))/1000;
	}
	
	private int convCent(int res) {
		System.out.println("Centesimas: "+(res-(res%100))/100);
		return (res-(res%100))/100;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Milisegundos ml=new Milisegundos(134000);
		ml.conversionTotal();
		

	}

}
