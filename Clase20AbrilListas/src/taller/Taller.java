package taller;
import java.util.*;
public class Taller {
	public static void main(String[] args) {
		ordenAdd();
	}
	public static void ordenAdd(){
		String[] tipos= {"Salud","Tecnología","Electronicos","Domestico"};
		String[] owners= {"Juan","Camilo","Andres","Pedro"};
		Random r=new Random();
		
		Date[] f=new Date[100];
		EquiposElectricos[] ep=new EquiposElectricos[100];
		for (int i = 0; i < ep.length; i++) {
			f[i]=new Date();
			f[i].setTime(r.nextInt(100)+1);
			ep[i]=new EquiposElectricos(f[i],tipos[r.nextInt(4)],owners[r.nextInt(4)]);
		}
		
		Date f1=new Date();
		Date f2=new Date();
		Date f3=new Date();
		f1.setTime(10);
		EquiposElectricos ee2 = new EquiposElectricos(f2,"tecno","carlos");
		EquiposElectricos ee1 = new EquiposElectricos(f1, "Salud", "Juan");
		EquiposElectricos ee3 = new EquiposElectricos(f3,"Salud","pedro");
		EquiposElectricos ee4 = new EquiposElectricos(f2,"metal","Andres");
		
		PriorityQueue<EquiposElectricos> pq=new PriorityQueue<EquiposElectricos>();
		
		pq.add(ee4);
		pq.add(ee1);
		pq.add(ee2);
		pq.add(ee3);
		//pq.addAll(Arrays.asList(ep));
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}