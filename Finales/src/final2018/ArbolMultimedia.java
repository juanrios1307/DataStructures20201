package final2018;

import java.util.*;
import arbolBinarioF2019.*;

public class ArbolMultimedia {
	
	private ArrayList<AVL<Multimedia>> hijoPelicula;
	private ArrayList<AVL<Multimedia>> hijoDocumental;
	private ArrayList<AVL<Multimedia>> hijoSerie;
	
	public LinkedList<Multimedia> peliculasGenero(String genero){
		
		return hijoPelicula.get(1).preordenList();
	}
	
	
}
