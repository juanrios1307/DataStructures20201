import java.util.ArrayList;
import java.util.Scanner;

class ExceptionNodo extends Exception{
    public ExceptionNodo(String s){
        super(s);
    }
}

class Nodo<E extends Comparable<E>> {
    protected E llave;
    protected Nodo<E> hijoIzq;
    protected Nodo<E> hijoDer;
    protected Nodo<E> padre;

    public Nodo(E llave) {
        this.llave = llave;
        padre=null;
        hijoIzq=null;
        hijoDer=null;
    }

    public Nodo(E llave, Nodo<E> hijoIzq, Nodo<E> hijoDer, Nodo<E> padre) {
        super();
        this.llave = llave;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
        this.padre = padre;
    }


    public E getLlave() {
        return llave;
    }


    public void setLlave(E llave) {
        this.llave = llave;
    }


    public Nodo<E> getHijoIzq() {
        return hijoIzq;
    }


    public void setHijoIzq(Nodo<E> hijoIzq) {
        if (hijoIzq!=null){
            hijoIzq.setPadre(this);
        }
        this.hijoIzq = hijoIzq;
    }


    public Nodo<E> getHijoDer() {
        return hijoDer;
    }


    public void setHijoDer(Nodo<E> hijoDer) {
        if (hijoDer!=null){
            hijoDer.setPadre(this);
        }
        this.hijoDer = hijoDer;
    }

    public Nodo<E> getPadre() {
        return padre;
    }

    public void setPadre(Nodo<E> padre) {
        this.padre = padre;
    }
    
    @Override
    public String toString() {
        String HI=(hijoIzq==null)? "null":hijoIzq.getLlave().toString();
        String HD=(hijoDer==null)? "null":hijoDer.getLlave().toString();
        return ((Comparable<E>)llave).toString()+ "("+HI+","+HD+")";
    }


}


public class ArbolB<E extends Comparable<E>> {

    protected Nodo<E> raiz;
    
    public ArbolB() {
        this.raiz = null;
    }
    
    public ArbolB(Nodo<E> raiz) {
        super();
        this.raiz = raiz;
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }    
    
    public void preorden(){
        preorden(raiz);
        System.out.println();
    }
    
    public void preorden(Nodo<E> r){
        if (r!=null){
            System.out.print(r.getLlave()+" ");
            preorden(r.getHijoIzq());
            preorden(r.getHijoDer());
        }    
    }
    
    
    public ArrayList<E> preordenList(){
        ArrayList<E> list=new ArrayList<E>();
        preordenList(raiz, list);
        return list;
    }
    
    public void preordenList(Nodo<E> r, ArrayList<E> list){
        if (r!=null){
            list.add(r.getLlave());
            preordenList(r.getHijoIzq(),list);
            preordenList(r.getHijoDer(),list);
        }    
    }
    
    
    public void inorden(){
        inorden(raiz);
    }
    
    public void inorden(Nodo<E> r){
        if (r!=null){
            inorden(r.getHijoIzq());
            System.out.print(r+ " ");
            inorden(r.getHijoDer());
        }    
    }
    
    public void postorden(){
        postorden(raiz);
    }
    
    public void postorden(Nodo<E> r){
        if (r!=null){
            postorden(r.getHijoIzq());
            postorden(r.getHijoDer());
            System.out.print(r.getLlave()+ " ");
        }    
    }
    
    public void insertNodo(Nodo<E> n) throws ExceptionNodo{
        raiz=insertNodo(n, raiz);
    }

    protected Nodo<E> insertNodo(Nodo<E> n, Nodo<E> r) throws ExceptionNodo {
        if (r==null){
            r=n;
        }else{
            if (n.getLlave().compareTo(r.getLlave())<0)
                r.setHijoIzq(insertNodo(n,r.getHijoIzq()));
            if (n.getLlave().compareTo(r.getLlave())>0)
                r.setHijoDer(insertNodo(n,r.getHijoDer()));
            if (n.getLlave().compareTo(r.getLlave())==0)
                throw new ExceptionNodo("El nodo está repetido");
        }
        return r;
        
    }
    
    public int cantHojas(){
        
        return cantHojas(raiz);
    
    }
    
    public int cantHojas(Nodo<E> n){
        if (n == null) {
        	return 0;
        }
        if(n.getHijoDer()==null && n.getHijoIzq()==null) {
        	return 1;
        }else {
        	return cantHojas(n.getHijoDer())+cantHojas(n.getHijoIzq());
        }
        
            
    }
    
    
    
    //Haga las funciones que necesite

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String line= in.nextLine();
        String[] n=line.split(",");
        ArbolB<Integer> arbol = new ArbolB<Integer>();
        if (n[0].compareTo("")!=0)
            for(int i=0;i<n.length;i++){
                Integer number=Integer.parseInt(n[i]);
                try {
                    Nodo<Integer> nodo=new Nodo<Integer>(number);
                    arbol.insertNodo(nodo);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println(e.getMessage());
                }
            }
        System.out.print(arbol.cantHojas());
        
    }
}