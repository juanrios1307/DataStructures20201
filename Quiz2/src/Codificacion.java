import java.util.*;

public class Codificacion {
    
	public Queue<Character> stringQueue(String s){
        Queue<Character> q=new LinkedList<Character>();
        for (int i=0;i<s.length();i++)
            q.add(s.charAt(i));
        return q;
    }
    

    public String codificarClave(String mensaje, int[] clave) {
        ArrayList<String> msg=new ArrayList<String>();
        
        while(mensaje.length()>0 ) {
            
            if(mensaje.length()>clave.length ) {
                msg.add(mensaje.substring(0, clave.length));
                mensaje=mensaje.substring(clave.length);
            }else {
                msg.add(mensaje.substring(0, mensaje.length()));
                mensaje=mensaje.substring(mensaje.length());
            }         
        }
        
        String cod="";
        
        try {
            for(int i=0;i<clave.length;i++){
                for(int k=0;k<msg.size();k++){
                    if(msg.get(k).length()>clave[i]) {
                        cod+=msg.get(k).charAt(clave[i]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	
        return cod;

    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String mensaje= in.nextLine();
        String line= in.nextLine();
        String[] n=line.split(",");
        int[] clave=new int[n.length];
        for(int i=0;i<clave.length;i++){
            clave[i]=Integer.parseInt(n[i]);
        }
        
        Codificacion cod=new Codificacion();
        String codigo=cod.codificarClave(mensaje, clave);
        System.out.println(codigo);
    }

}