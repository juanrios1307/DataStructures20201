package complejidad;

public class Complejidad {
	
	public static int sumaSubsecuenciaMaxima(int[] arr) {
		int sumActual=0,sumaMax=0,ini=0,fin=0;
		
		for (int i=0,j=0; j < arr.length; j++) {
					
			sumActual+=arr[j];
			
			if(sumActual>sumaMax) {
				sumaMax=sumActual;
				ini=i;
				fin=j;
				
			}else if(sumActual<0) {
				i=j+1;
				sumActual=0;
			}
			
		}
		System.out.println(ini+" - "+fin);
		return sumaMax;
	}
	
	public static int subsecuenciaSumaMaxima ( int [] a)
	{
		int sumaActual = 0;
		int sumaMax = 0,secIni,secFin;
		for ( int i =0, j = 0; j<a.length; j++)
		{
			sumaActual += a[j];
			if (sumaActual > sumaMax)
			{
				sumaMax = sumaActual;
				secIni = i;
				secFin = j;
			}
			else if(sumaActual < 0)
			{
				i = j + 1;
				sumaActual = 0;
			}
		}
		return sumaMax;
	}
	
	public static int sumaMaximaSinNegativos (int[] arr) {
		int sumAct=0,sumaMax=0;
		
		for (int i = 0; i < arr.length; i++) {
			sumAct+=arr[i];
			
			if(sumAct>sumaMax) {
				sumaMax=sumAct;
				
			} 
			
			if(arr[i]<0) {
				sumAct=0;
			}
			
		}
		
		return sumaMax;
	}

	
	public static void main(String[] args) {
		int[] arr= {5,-2,1,30,4,-1,2,5,1,5,-8};
		
		System.out.println(sumaSubsecuenciaMaxima(arr));
		System.out.println(sumaMaximaSinNegativos(arr));
		
		
	}
}
