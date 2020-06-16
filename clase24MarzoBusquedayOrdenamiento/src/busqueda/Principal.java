package busqueda;

import java.util.Arrays;

public class Principal {
	
	public static void main(String[] args) {
		int[] lista= {2,3,6,5,6,7};
		System.out.println(busquedaCercanaRec(lista, 4,0,0));
	}
	
	
	public static int busquedaSecRec(Comparable[] ps, Comparable p3,int i){
		if(ps[i]==p3) {
			return i;
		}
		if(i>=ps.length-1) {
			return -1;
		}else {
			i++;
			return busquedaSecRec(ps, p3, i);
		}
	
	}
	public static int busquedaCercanaRec(int[] ps, int p3,int j,int posCercana){
		if(p3==ps[j])
			return j;
		if(j>=ps.length-1)
			return posCercana;
		else {
			int min=Math.abs(p3-ps[0]);
			if(Math.abs(p3-ps[j])< min && p3>ps[j]) {
				min=Math.abs(p3-ps[j]);
				posCercana=j;
			}
			j++;
			return busquedaCercanaRec(ps, p3, j++,posCercana);
		}	
	}
	
	
	public static int busquedaCercana(int[] ps, int p3){
		int min=Math.abs(p3-ps[0]);
		int posCercana=0;
		for (int j = 0; j < ps.length; j++) {
			if(Math.abs(p3-ps[j])< min && p3>ps[j]) {
				min=Math.abs(p3-ps[j]);
				posCercana=j;
			}
		}
		return posCercana;
	}
	
	
	public static int busquedaBinRecursivaCercana(int[] a,int valor, int inicio,int fin){
		int medio;
		if (inicio >= fin)
			return a[inicio]<=(valor)? inicio :-1;
		else {
			medio=(inicio+fin)/2;
			if (a[medio]==(valor))
				return medio;
			else{
				if (a[medio]>(valor))
					return busquedaBinRecursivaCercana(a,valor, inicio,medio-1);
				else
					return busquedaBinRecursivaCercana(a, valor,medio+1,fin);
			}
		}
	}	
	
	/*Buscar un elemento, no en todo el arreglo, sino a partir de un
índice determinado*/
	public static int busqueda(int i,int j,Comparable[] ps, Comparable p3){
		
		while ( i>=0 && i<=j && j<ps.length && ps[i].compareTo(p3)!=0) i++ ;
		return(i==j) ? -1: i;
	}
	
	
	/*Si el elemento no se encuentra devolver el más próximo a él
(hágalo con una lista de enteros*/
	
	
	public static int mayor(Comparable [] a){
		int indm=0;
		for (int i=1; i<a.length; i++){
			if (a[indm].compareTo(a[i])<0) {
				indm=i;
			}
		}
		return indm;
	}
	
	public static int busqueda(Comparable[] ps, Comparable p3){
		int i=0;
		while ( i<ps.length && ps[i].compareTo(p3)!=0) i++ ;
		return(i==ps.length) ? -1: i;
	}

	/*Metodo de insercion directa donde la busqueda binaria va a buscar el indice donde insertar
	 *metodo que va a tener la parte que buscara donde insertar */ 
	
	public static int busquedaBinIterativa(Comparable[] a, Comparable valor){
		int inicio=0;
		int fin=a.length-1;
		int medio;
		while (inicio<=fin){
			medio=(inicio+fin)/2; // posición media
			if (a[medio].compareTo(valor)==0){ // búsqueda satisfactoria
				return medio;
			}
			else{ // actualización de los límites
				if (a[medio].compareTo(valor)>0)
					fin=medio-1;
				else
					inicio=medio+1;
			}
		}
		return -1; // no se encontró el elemento
	}
	
	public static void insertionSort(Comparable[] lista) {
		for (int i = 1; i < lista.length; i++) {
			int j=i;
			Comparable<Comparable> tmp=lista[i];
			while(j>0 && tmp.compareTo(lista[j-1])<0) {
				lista[j]=lista[j-1];
				j--;
			}
			lista[j]=tmp;
			System.out.println("Pos a insertar: "
			+busquedaBinRecursiva(Arrays.copyOf(lista, i), tmp,0,i-1)+" num: "+tmp);	
		}
	}
	
	public static int busquedaBinRecursiva(Comparable[] a,Comparable valor, int inicio,int fin){
		int medio;
		if (inicio >= fin)
			return a[inicio].compareTo(valor)==0 ? inicio : -1;
		else {
			medio=(inicio+fin)/2;
			if (a[medio].compareTo(valor)==0)
				return medio;
			else{
				if (a[medio].compareTo(valor)>0)
					return busquedaBinRecursiva(a,valor, inicio,medio-1);
				else
					return busquedaBinRecursiva(a, valor,medio+1,fin);
			}
		}
	}
	
	
}
