package principal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class abril23 {
	
	
	public static void main(String[] args) {
		ArrayList<String> lista=new ArrayList<String>();
		
        for (int i=0;i<100000;i++)
            lista.add("Juan");
        lista.add("Pedro");
        lista.add("Olga");
        lista.add("Miguel");
        lista.add("Antonio");
        lista.add("Luis");
		
        ArrayList<String> lista1 = (ArrayList<String>)lista.clone();
        long timeinicio=System.currentTimeMillis();

        for (Object s:lista1.toArray())
            if (((String)s).compareTo("Olga")==0)
                lista1.remove(s);
        long timefin=System.currentTimeMillis();
        System.out.println("ForEach-Array "+ (timefin-timeinicio));
        
        
        lista1 = (ArrayList<String>)lista.clone();
        ListIterator<String> it= lista1.listIterator();
        while(it.hasNext()){
            String s=it.next();
            if (s.compareTo("Olga")==0)
                lista.remove(s);
        }
        timefin=System.currentTimeMillis();
        System.out.println("Iterator-While "+ (timefin-timeinicio));
	}
}
