package final2017;

import java.util.ArrayList;
import java.util.LinkedList;

public class Embalaje {
	
	
		private	ArrayList<Mano> listManoMaquina; 
		private ArrayList<Caja> listCajas;
		static final double MaxPeso=10;

		
		public Embalaje(ArrayList<Mano> listManoMaquina, ArrayList<Caja> listCajas) {
			super();
			this.listManoMaquina = listManoMaquina;
			this.listCajas = listCajas;
		}

		public void empacarCaja(String codigo){
			empacarCaja(seleccionarCaja(codigo));
		}
		
		public void empacarCaja(Caja caja) {
			if(caja.getPesoTotal()>=MaxPeso) {
				
			}else {
				caja.getManos().add(listManoMaquina.remove(seleccionMano(MaxPeso-caja.getPesoTotal())));
				caja.setPesoTotal(caja.getPesoTotal()+caja.getManos().get(caja.getManos().size()-1).getPeso());
				System.out.println(caja.getPesoTotal());
				
				empacarCaja(caja);
			}
		}
		
		public Caja seleccionarCaja(String cod) {
			for(int i=0;i<listCajas.size();i++) {
				if(listCajas.get(i).getCodigo().equals(cod)) {
					return listCajas.get(i);
				}
			}
			return null;
		}
		
		public int seleccionMano(double peso) {
			if(peso<=2) {
				int aux=0;
				for(int i=0;i<listManoMaquina.size();i++) {
					if(listManoMaquina.get(i).getPeso()==peso) {
						return i;
					}else if(listManoMaquina.get(i).getPeso()<peso) {
						if(listManoMaquina.get(i).getPeso()>listManoMaquina.get(aux).getPeso()) {
							aux=i;
						}
					}else {
						if(listManoMaquina.get(i).getPeso()<listManoMaquina.get(aux).getPeso()) {
							aux=i;
						}
					}
				}
				return aux;
				
			}else {
				return 0;
			}
			
		}
		
		
		public ArrayList<Mano> getListManoMaquina() {
			return listManoMaquina;
		}

		public void setListManoMaquina(ArrayList<Mano> listManoMaquina) {
			this.listManoMaquina = listManoMaquina;
		}

		public ArrayList<Caja> getListCajas() {
			return listCajas;
		}

		public void setListCajas(ArrayList<Caja> listCajas) {
			this.listCajas = listCajas;
		}

		public static void main(String[] args) {
			Mano m4=new Mano(8);
			Mano m5=new Mano(5);
			Mano m1=new Mano(1.8);
			Mano m2=new Mano(2.5);
			Mano m3=new Mano(2);
			
			
			Caja c=new Caja("2345");
			
			ArrayList<Mano> manos=new ArrayList<Mano>();
			ArrayList<Caja> cajas=new ArrayList<Caja>();
			
			manos.add(m4);
			manos.add(m5);
			manos.add(m1);
			manos.add(m2);
			manos.add(m3);
			
			System.out.println(manos);
			
			cajas.add(c);
			
			Embalaje e=new Embalaje(manos, cajas);
			
			e.empacarCaja("2345");
			System.out.println(e.getListCajas().get(0).getManos());
			System.out.println("Manos sobrantes:");
			System.out.println(e.getListManoMaquina());
			
		}
		
		
		
		
		
		
		
		
		
}	