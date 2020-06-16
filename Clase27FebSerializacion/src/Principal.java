import java.io.*;
public class Principal {

	public static void main(String[] args) {
	/*	// TODO Auto-generated method stub
		Persona p1=new Persona("Juan", 18);
		
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\jergf\\Downloads\\Proyectos lenguajes made in windows\\EstructurasDeDatos\\Clase27FebSerializacion\\ficheros\\f.txt",false));
			
			writer.append(p1.getNombre()+"\n");
			writer.append(p1.getEdad()+"\n");
			
			writer.close();
		
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		try {
			BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\jergf\\Downloads\\Proyectos lenguajes made in windows\\EstructurasDeDatos\\Clase27FebSerializacion\\ficheros\\f.txt"));
			
			String st,nombre="";
			int i=0,edad=0;
			
			while((st=br.readLine()) != null) {
				if(i==0) {
					nombre=st;
				}else if(i==1) {
					edad=Integer.parseInt(st);
				}
				
			}
			Persona p2=new Persona(nombre,edad);
			System.out.println(p2.getEdad());
			System.out.println(p2.getNombre());
			
		} catch (Exception e) {
			
		}*/
		
		
		Persona p1=new Persona("Sebas",18);
		
		try {
			FileOutputStream fileout=new FileOutputStream("C:\\Users\\jergf\\Downloads\\Proyectos lenguajes made in windows\\EstructurasDeDatos\\Clase27FebSerializacion\\ficheros\\persona1.ser");
			ObjectOutputStream out=new ObjectOutputStream(fileout);
			out.writeObject(p1);
			
			out.close();
			fileout.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Persona p=null;
		try {
			FileInputStream fileIn =new FileInputStream("C:\\Users\\jergf\\Downloads\\Proyectos lenguajes made in windows\\EstructurasDeDatos\\Clase27FebSerializacion\\ficheros\\persona1.ser");
			ObjectInputStream in =new ObjectInputStream(fileIn);
			p=(Persona) in.readObject();
			System.out.println(p.getNombre()+"\n"+p.getEdad());
			in.close();
			fileIn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
