package retosProjectEuler;

public class Project011Largest4Adjacent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String grid[][]= new String[20][20];
		llenarArray(grid);
		
		int gridN[][]=new int[20][20];
		int verifySum[]=new int[20];

		for (int i = 0; i < gridN.length; i++) {
			for (int j = 0; j < gridN.length; j++) {
				gridN[i][j]=Integer.parseInt(grid[i][j]);
			}
		}
		
		for (int i = 0; i < gridN.length; i++) {
			verifySum[i]=hallarSumaAncho(gridN, i);
			System.out.println("Pos: "+i+" :: "+verifySum[i]+" --- "+hallarSumaAncho(gridN, i));
		}
		
		System.out.println("Mayor producto ancho: "+verificarMayorSuma(verifySum));
		
		System.out.println("\n\n +++++++++++++++++++++++++++++++++++++++++++++");
		
		for (int i = 0; i < gridN.length; i++) {
			verifySum[i]=hallarSumaLargo(gridN, i);
			System.out.println("Pos: "+i+" :: "+verifySum[i]+" --- "+hallarSumaLargo(gridN, i));
		}
		
		System.out.println("Mayor producto largo: "+verificarMayorSuma(verifySum));
		
		
		
	}
	
	public static int hallarSumaAncho(int[][] array,int pos) {
		int producto=1,granProducto=0;
		for (int i = 0; i < array.length-3; i++) {
			for (int j = i; j < i+4; j++) {
				producto*=array[pos][j];
				//System.out.print("arr["+pos+"]["+j+"] = "+array[pos][j]+" -- ");
				
			}
			if(producto>granProducto) {
				granProducto=producto;
				//System.out.println("granS: "+granProducto);
			}else {
				//System.out.println();
			}
			producto=1;
		}
		
		return granProducto;
	}
	
	public static int hallarSumaLargo(int[][] array,int pos) {
		int producto=1,granProducto=0;
		for (int i = 0; i < array.length-3; i++) {
			for (int j = i; j < i+4; j++) {
				producto*=array[j][pos];
				//System.out.print("arr["+j+"]["+pos+"] = "+array[j][pos]+" -- ");
				
			}
			if(producto>granProducto) {
				granProducto=producto;
				//System.out.println("granS: "+granProducto);
			}else {
				//System.out.println();
			}
			producto=1;
		}
		
		return granProducto;
	}
	
	
	public static int verificarMayorSuma(int[] array) {
		int s=0;
		for (int i = 0; i < array.length; i++) {
			if(array[i]>s) {
				s=array[i];
			}
		}
		
		return s;
	}
	
	public static void llenarArray(String[][] grid) {
			
		
		String a1="08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08";
		String a2="49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00";
		String a3="81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65";
		String a4="52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91";
		String a5="22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80";
		String a6="24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50";
		String a7="32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70";
		String a8="67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21";
		String a9="24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72";
		String a10="21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95";
		String a11="78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92";
		String a12="16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57";
		String a13="86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58";
		String a14="19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40";
		String a15="04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66";
		String a16="88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69";
		String a17="04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36";
		String a18="20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16";
		String a19="20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54";
		String a20="01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
		
		
		grid[0]=a1.split(" ");
		grid[1]=a2.split(" ");
		grid[2]=a3.split(" ");
		grid[3]=a4.split(" ");
		grid[4]=a5.split(" ");
		grid[5]=a6.split(" ");
		grid[6]=a7.split(" ");
		grid[7]=a8.split(" ");
		grid[8]=a9.split(" ");
		grid[9]=a10.split(" ");
		grid[10]=a11.split(" ");
		grid[11]=a12.split(" ");
		grid[12]=a13.split(" ");
		grid[13]=a14.split(" ");
		grid[14]=a15.split(" ");
		grid[15]=a16.split(" ");
		grid[16]=a17.split(" ");
		grid[17]=a18.split(" ");
		grid[18]=a19.split(" ");
		grid[19]=a20.split(" ");
	}

}
