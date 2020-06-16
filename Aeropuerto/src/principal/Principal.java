package principal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import Aeropuerto.*;
import Avion.*;
import Interfaces.*;
import Persona.*;
import tiquetes.*;
import Mecanico.*;




public class Principal {
	
	public static Aeropuerto datosPrueba() {
		Persona[] p=new Persona[15];
		Piloto[] pil=new Piloto[15];
		Mercancia[] m=new Mercancia[15],m2=new Mercancia[2];
		Maleta[] maleta=new Maleta[2];
		
		for (int i = 0; i < m2.length; i++) {
			m2[i]=new Mercancia(true, 5);
		}
		
		for (int i = 0; i < maleta.length; i++) {
			maleta[i]=new Maleta(m2, 10);
		}
		
		for (int i = 0; i < m.length; i++) {
			m[i]=new Mercancia(true, 10);
			p[i]=new Persona("Juan"+i, "14789"+(i-1), "Colombia", (int)(Math.random()*100)+1, i%2==0?true:false, maleta);
			pil[i]=new Piloto("Juan"+i, "14789"+(i-1), "Colombia", (int)(Math.random()*100)+1, false, maleta, "QWERTY45"+i);
 		}
		
		Avion[] avCarga=new Carga[10];
		Avion[] avComercial=new Comercial[10];
		Avion[] avion= new Avion[avCarga.length+avComercial.length];
		
		
		
	
		
		for (int i = 0; i < avCarga.length; i++) {
			avCarga[i]=new Carga(100, 100, 10, 1,"AD45QW"+i ,"av15", "Avianca",1);
			avComercial[i]=new Comercial(200, 100, 10, 4,"SDF78F"+i ,"air34", "Viva",1, 100);
		}
		
		for (int i = 0; i < avCarga.length; i++) {
			avion[i]=avCarga[i];
		}
		
		for (int i = avCarga.length; i < avion.length; i++) {
			avion[i]=avComercial[i-10];
		}

		Vuelo[] vueloLlegada=new Vuelo[10];
		Vuelo[] vueloSalida=new Vuelo[10];
		
		Date horaSalida=new Date(),horaLlegada=new Date();
		
		Tiquete[] t=new Tiquete[10];
		Mercancia[] merca=new Mercancia[10];
		
		for (int i = 0; i < t.length; i++) {
			merca[i]=new Mercancia("heroina", true, (int)(Math.random()*50));
			t[i]=new Tiquete(horaLlegada, 6+i, 'A', 1, "4569", horaSalida, "turista", 50, vueloSalida[i], p[i],p[i].getDocumento());
		}
		
		for (int i = 0; i < vueloSalida.length; i++) {
			vueloLlegada[i]=new Vuelo("AV"+((int)(Math.random()*8999)+1000),(int)(Math.random()*8999)+1000, 2589, (int) (Math.random()*6),horaSalida, horaLlegada, avCarga[i], pil[i], pil[i+1]);
			vueloSalida[i]=new Vuelo("AV"+((int)(Math.random()*8999)+1000),((int)(Math.random()*8999)+1000), 8520+i,(int) (Math.random()*6), horaSalida, horaLlegada, avComercial[i], pil[i], pil[i+1]);
		}
		p[5]=new Persona("Juan Se", "AS54641Q", "Colombia", (int)(Math.random()*100)+1,false, maleta);
		merca[5]=new Mercancia("heroina", true, (int)(Math.random()*50));
		t[5]=new Tiquete(horaLlegada, 6, 'A', 1, "4569", horaSalida, "turista", 50, vueloSalida[5], p[5],p[5].getDocumento());
		
		
		for (int i = 0; i < vueloSalida.length; i++) {	
			
			for (int j = 0; j < merca.length; j++) {
				
				vueloSalida[i].addTiquete(t[j]);
				vueloSalida[i].addMercancia(merca[i]);
				vueloLlegada[i].addMercancia(merca[j]);
			}
		}
		
		Aeropuerto a=new Aeropuerto(vueloLlegada,vueloSalida,avion,pil);
		return a;
	}
	
	
	public static void main(String[] args) {
		Aeropuerto a=datosPrueba();
		
		
		InterfazPedidoVuelo menu=new InterfazPedidoVuelo(a);
		menu.setVisible(true);
		}
	}


