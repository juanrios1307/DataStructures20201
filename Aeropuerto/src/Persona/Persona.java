package Persona;
import java.io.*;
public class Persona implements Serializable {
		protected String nombre,documento,nacionalidad;
		protected int edad;
		protected boolean enfermo;
		protected Maleta[] maletas;

		public boolean isEnfermo() {
			return enfermo;
		}
		public String getNombre() {
			return nombre;
		}
		public String getDocumento() {
			return documento;
		}
		public String getNacionalidad() {
			return nacionalidad;
		}
		public int getEdad() {
			return edad;
		}
		public Maleta[] getMaletas() {
			return maletas;
		}
		
		public Persona(String nombre, String documento, String nacionalidad, int edad, boolean enfermo,	Maleta[] maletas) {
			this.nombre = nombre;
			this.documento = documento;
			this.nacionalidad = nacionalidad;
			this.edad = edad;
			this.enfermo = enfermo;
			this.maletas = maletas;
		}
		
		public Persona(String nombre, String documento, String nacionalidad, int edad, boolean enfermo) {
			super();
			this.nombre = nombre;
			this.documento = documento;
			this.nacionalidad = nacionalidad;
			this.edad = edad;
			this.enfermo = enfermo;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public void setDocumento(String documento) {
			this.documento = documento;
		}
		public void setNacionalidad(String nacionalidad) {
			this.nacionalidad = nacionalidad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		public void setEnfermo(boolean enfermo) {
			this.enfermo = enfermo;
		}
		public void setMaletas(Maleta[] maletas) {
			this.maletas = maletas;
		}
		
		
		
		
}
