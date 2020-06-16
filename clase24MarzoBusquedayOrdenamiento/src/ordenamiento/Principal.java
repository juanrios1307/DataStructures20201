package ordenamiento;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Principal{

	public static void main(String[] args) {
		
		/*Comparable[] lista= {"Rumpa","Ashis","Samiha","Samara","Fahim"};
		Comparable[] lista2= {7,85,45,96,3,1,258,46,59};*/
		
		Comparable[] lp= llenarLista();
		printLista(lp);
		//printLista(mergeSort(lista));
		selectBubbleSort(lp,0,lp.length);
		printLista(lp);
		System.out.println();
		test();
		
	
	}
	
	//Llevar el min con selectSort y max con bubbleSort
	
	public static void selectBubbleSort(Comparable[] lista,int inicio,int fin) {
			if(inicio>=fin)
				return;
			else {
				int min=inicio;
				for (int j = inicio; j < fin-inicio-1; j++) {
					
					if(lista[j+1].compareTo(lista[j])<0) { //parte bubbleSort
						Comparable tmp=lista[j];
						lista[j]=lista[j+1];
						lista[j+1]=tmp;
					}
					
					
					if(lista[j].compareTo(lista[min])<0) { //parte selectSort
						min=j;
					}
	
				}
				Comparable tmp=lista[inicio]; //parte selectSort
				lista[inicio]=lista[min];
				lista[min]=tmp;
				
				selectBubbleSort(lista, inicio+1,fin--);
			}
	}
	
	public static void test() {
		Random r=new Random();
		for (int j = 0; j < 15; j++) {
			
			int n=r.nextInt(20)+1;
			Comparable[] l=new Comparable[n];
			for (int i = 0; i < n; i++) {
				l[i]=r.nextInt(1000);
			}
			printLista(l);
			selectBubbleSort(l, 0, l.length);
			printLista(l);
			System.out.println();
		}
	}
	
	public static void selectionSort(Comparable[] lista) {  
		
		for (int i = 0; i < lista.length; i++) {
			int min=i;
			for (int j = i+1; j < lista.length; j++) {
				if(lista[j].compareTo(lista[min])<0) {
					min=j;
				}
			}
			Comparable tmp=lista[i];
			lista[i]=lista[min];
			lista[min]=tmp;
		}

	}
	
	
	public static void bubbleSort(Comparable[] lista ) { 
		for (int i = 0; i < lista.length-1; i++) { //2  2N  (N-1)
			for (int j = 0; j < lista.length-1-i; j++) {  //2(N-1)  3(CVJ+N-1)    CVJ
				if(lista[j+1].compareTo(lista[j])<0) { //9CVJ
					Comparable tmp=lista[j];
					lista[j]=lista[j+1];
					lista[j+1]=tmp;
				}
			}//CVJ= (N-1)*N/2
		}
	}
	
	
	
	
	/*Time quickSort mergeSort*/
	public static void timeQM() {
		int N=50000;
        Random r=new Random();
        Integer[] lista=new Integer[N];
        for(int i=0;i<N;i++)
            //lista[i]=r.nextInt(2*N);
            lista[i]=N-i;
            //lista[i]=i;
        
        Integer[] listaTemp= Arrays.copyOf(lista, lista.length);
        long timeinicio;
        long timefin;
        
        try {
            listaTemp= Arrays.copyOf(lista, lista.length);
            timeinicio=System.currentTimeMillis();
            Comparable[] c=mergeSort(listaTemp);
            timefin=System.currentTimeMillis();
            System.out.println("MergeSort: "+ (timefin-timeinicio));
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        
        

        listaTemp= Arrays.copyOf(lista, lista.length);
        timeinicio=System.currentTimeMillis();
        quickSortR(listaTemp,0,listaTemp.length-1);
        timefin=System.currentTimeMillis();
        System.out.println("Quicksort: "+ (timefin-timeinicio));

        listaTemp= Arrays.copyOf(lista, lista.length);
        timeinicio=System.currentTimeMillis();
        quickSort(listaTemp);
        timefin=System.currentTimeMillis();
        System.out.println("Quicksort: "+ (timefin-timeinicio));
		
		
		
	}
	
	
	
	/*Merge sort toca hacerlo por divide y venceras con el método que recién creamos*/
	public static Comparable[] mergeSort(Comparable[] lista){
	    if(lista.length==1) {
	    	return lista;
	    }else {
	    	int mitad=(lista.length)/2;
	    	
	    	Comparable[] left=Arrays.copyOfRange(lista, 0, mitad);
	    	Comparable[] rigth=Arrays.copyOfRange(lista, mitad, lista.length);
			return merge(mergeSort(left),mergeSort(rigth));
	    }
	}
	
	public static Comparable[] merge(Comparable[] lista1, Comparable[] lista2) {
        
        Comparable[] result= new Comparable[lista1.length+lista2.length];
        int i=0,j=0;
       
        while (i<lista1.length && j<lista2.length)
            result[i+j]=(lista1[i].compareTo(lista2[j])<=0)? lista1[i++]:lista2[j++];
       
        for(int k=i;k<lista1.length;k++)
            result[k+j]=lista1[k];
       
        for (int k=j;k<lista2.length;k++)
            result[k+i]=lista2[k];
        return result;
    }
	
	private static void quickSort(Comparable[] a) {
		quickSort(a, 0, a.length-1);
	}
	
	private static void quickSortR(Comparable[] a, int inicio, int fin){
        Random r=new Random();
        if (fin <= inicio)
            return;
        else {//CAMBIO://El pivote se selecciona en una pocisión aleatoria
            int indexPivote=r.nextInt((fin-inicio))+inicio;
            //System.out.println("Pivote: "+ a[indexPivote]);
            Comparable pivote= a[indexPivote];
            int i = inicio-1;
            int j = fin+1; // //CAMBIO: Se cambia fin, para llamar con length-1
            Comparable temp;
            while (i< j) {//busca un elemento mayor que pivote, si no para en el pivote (el último)
                //CAMBIO: ADICIONAR i<fin y cambiar <0 por <=0 en ambos ciclos, para que salten el pivote
                while( i < fin &&  a[++i].compareTo(pivote)<=0);//se busca un elemento menor que el pivote, si no lo hay, para en el primero
                while( j > inicio && pivote.compareTo(a[--j])<=0 );
                if( i < j ){//se intercambian los elementos
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }//se sale del ciclo cuando la i>=j
            //La posición correcta del pivote depende de dónde quedaron la i y la j
            int partition=i;
            if (i>indexPivote)
                partition=j;   
            if (i>=indexPivote && j<=indexPivote)
                partition=indexPivote;
            else{
                temp=a[partition];
                a[partition]=a[indexPivote]; // cambio
                a[indexPivote]=temp;
            }
            //Ordenamiento.printLista(a);
            quickSortR( a, inicio, partition-1 );
            quickSortR( a, partition+1, fin );
        }
    }
	
	
	public static void quickSortRandom(Comparable[] lista,int inicio,int fin) {	
		if(fin<=inicio)
			return;
		else {
			//Random r=new Random();
			Random rand = new Random();
			int n = inicio + rand.nextInt(fin - inicio);
			
			Comparable pivot=lista[n],temp;
			int i=inicio;
			int j=fin-1;
			
			while(i<j) {
				
				while(i<fin && lista[i].compareTo(pivot)<0) {i++;} ;
				
				while(j>inicio && pivot.compareTo(lista[j])<0) {j--;} ;
				
						if(i<j ) {
							temp=lista[i];
							lista[i]=lista[j];
							lista[j]=temp;
						}
			}
			int partition=i;
			
			if(i>n) {
				partition=j;
			}else if(i>=n && j<=n) {
				partition=n;	
			
			}else {
				temp=lista[partition];
				lista[partition]=lista[n];
				lista[n]=temp;
			}
				
			
			if(partition!=0 && partition != fin) {
				quickSortRandom(lista, inicio, partition);
				quickSortRandom(lista, partition+1, fin);
			}else if(partition==0) {
				quickSortRandom(lista, partition+1, fin);
			}else if(partition==fin) {
				quickSortRandom(lista, inicio, partition);
			}
		
			
		}
	}
	
	private static void quickSort(Comparable[] a, int inicio, int fin){
		if (fin <= inicio)
			return;
		else {
			Comparable pivote = a[fin];
			int i = inicio-1;
			int j = fin;
			Comparable temp;
			while (i< j) {//busca un elemento mayor que pivote, si no para en el pivote
		
				while( a[++i].compareTo(pivote)<0);//se busca un elemento menor que el
				
				while( j > inicio && pivote.compareTo(a[--j])<0 );
					if( i < j ){//se intercambian los elementos
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					}
			}
			temp=a[i];
			a[i]=a[fin]; // el pivote está en fin
			a[fin]=temp;
			int partition=i;
			quickSort( a, inicio, partition-1 );
			quickSort( a, partition+1, fin );
			}
	}
	
	public static void personas() {
		Persona p1=new Persona(15, "Carlos", "m");
		Persona p2=new Persona(2, "Juan", "f");
		Persona p3=new Persona(20, "Juan", "m");
		Persona p4=new Persona(15, "Esteban", "m");
		Persona p5=new Persona(5, "Carlos", "m");
		Persona p6=new Persona(15, "Eliana", "f");
		Persona p7=new Persona(7, "Carlos", "m");
		Persona p8=new Persona(8, "Carlos", "m");
		Persona p9=new Persona(9, "Carlos", "m");
		Persona p10=new Persona(10, "Andres", "f");
		
        /*Persona p1= new Persona("Marcela", 24);
	    Persona p2= new Persona("Oscar", 21);
	    Persona p3= new Persona("Marcela", 20);
	    Persona p4= new Persona("Andrés", 26);
	    Persona p5= new Persona("Oscar", 30);
	    Persona p6= new Persona("Nadia", 21);*/
	    Persona[] listaP={p1,p2,p3,p4,p5,p6,p7,p8,p9,p10};

    	Persona[] listaTempP= Arrays.copyOf(listaP, listaP.length);
    	printLista(listaTempP);
    	System.out.println();
    	bubbleSort(listaTempP);
    	printLista(listaTempP);
    	
    	listaTempP= Arrays.copyOf(listaP, listaP.length);
    	System.out.println();
    	selectionSort(listaTempP);
    	printLista(listaTempP);
    	
    	listaTempP= Arrays.copyOf(listaP, listaP.length);
    	System.out.println();
    	insertionSort(listaTempP);
    	printLista(listaTempP);
		
	}
	
	
	public static void time() {

		
		try {
			Comparable[] lista=llenarLista();
			Comparable[] tmp=Arrays.copyOf(lista, lista.length);
			
			printLista(lista);
			
			bubbleSortDescent(lista);
			printLista(lista);
			
			lista=Arrays.copyOf(tmp, tmp.length);
			insertionSortDescent(lista);
			printLista(lista);
			
			lista=Arrays.copyOf(tmp, tmp.length);
			selectionSortDescent(lista);
			printLista(lista);
			
			System.out.println("b: "+lista[0]+" t: "+tmp[0]);
			long timeI=System.currentTimeMillis();
			
			bubbleSort(lista);
			long timeF=System.currentTimeMillis();
			System.out.println("Bubble: "+(timeF-timeI));
			
			lista=Arrays.copyOf(tmp, tmp.length);
			System.out.println("s: "+lista[0]+"t: "+tmp[0]);
			 timeI=System.currentTimeMillis();
			selectionSort(lista);
			 timeF=System.currentTimeMillis();
			System.out.println("Selec: "+(timeF-timeI));
			
			Comparable[] lista1=Arrays.copyOf(tmp, tmp.length);
			System.out.println("i: "+lista1[0]+"t:"+tmp[0]);
			 timeI=System.currentTimeMillis();
			insertionSort(lista1);
			 timeF=System.currentTimeMillis();
			System.out.println("Insert: "+(timeF-timeI));
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static Comparable[] llenarLista() {
		int N=21;
		Random r=new Random();
		Integer[] lista=new Integer[N];
		
		for (int i = 0; i < lista.length; i++) {
			lista[i]=r.nextInt(100);
			//lista[i]=N;
		}
		
		return lista;
	}
	
	public static void printLista(Comparable[] lista) {
		for(Comparable p:lista) 
			System.out.print(p+"\t");
		System.out.println();
	}
	
	public static void insertionSort(Comparable[] lista) { //Estable
		for (int i = 1; i < lista.length; i++) {
			int j=i;
			Comparable<Comparable<Comparable>> tmp=lista[i];
			while(j>0 && tmp.compareTo(lista[j-1])<0) {
				lista[j]=lista[j-1];
				j--;
			}
			
			lista[j]=tmp;
		}

	}
	
	public static void insertionSortDescent(Comparable[] lista) {
		for (int i = 1; i < lista.length; i++) {
			int j=i;
			Comparable<Comparable> tmp=lista[i];
			while(j>0 && tmp.compareTo(lista[j-1])>0) {
				lista[j]=lista[j-1];
				j--;
			}
			
			lista[j]=tmp;
		}

	}
	
	//Complejidad 
	
	public static void bubbleSortDescent(Comparable[] lista ) {
		for (int i = 0; i < lista.length-1; i++) {
			for (int j = 0; j < lista.length-1-i; j++) {
				if(lista[j].compareTo(lista[j+1])<0) {
					Comparable tmp=lista[j];
					lista[j]=lista[j+1];
					lista[j+1]=tmp;
				}
			}
		}
	} //Complejidad: 


	/* Modifique el algoritmo de selección directa para ordenar crecientemente 
     * los elementos  que se encuentran en las posiciones pares del arreglo y 
     * en orden decreciente los elementos que se encuentran en las posiciones impares 
     * del arreglo, manteniéndose en las posiciones pares e impares respectivamente.  */
	public static void selectionSortParImpar(Comparable[] lista) {  
		
		for (int i = 0; i < lista.length; i+=2) {
			int min=i;
			for (int j = i+2; j < lista.length; j+=2) {
				if(lista[j].compareTo(lista[min])<0) {
					min=j;
				}
			}
			Comparable tmp=lista[i];
			lista[i]=lista[min];
			lista[min]=tmp;
		}
		
		for (int i = 1; i < lista.length; i+=2) {
			int min=i;
			for (int j = i+2; j < lista.length; j+=2) {
				if(lista[j].compareTo(lista[min])>0) {
					min=j;
				}
			}
			Comparable tmp=lista[i];
			lista[i]=lista[min];
			lista[min]=tmp;
		}

	}
	
	
	public static void selectionSortDescent(Comparable[] lista) {
		
		for (int i = 0; i < lista.length; i++) {
			int max=i;
			for (int j = i+1; j < lista.length; j++) {
				if(lista[j].compareTo(lista[max])>0) {
					max=j;
				}
			}
			Comparable tmp=lista[i];
			lista[i]=lista[max];
			lista[max]=tmp;
		}

	}
}
