package p6;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlmacenajeContenedoresTiempos {
   
    public static void main (String[] args) throws FileNotFoundException{
    	for (int i = 0; i < 10; i++) {
    		Scanner sc = new Scanner(new FileReader("test0"+i+".txt"));
    		int capacidadC= sc.nextInt();
    		sc.nextLine();
    		String[] conjuntoStrings= sc.nextLine().split(" ");
    		Integer[] conjuntoS = new Integer[conjuntoStrings.length];

    		for(int j=0;j< conjuntoS.length; j++){
    			conjuntoS[j]= Integer.parseInt(conjuntoStrings[j]);
    		}
    		
    		AlmacenajeContenedores sol = new AlmacenajeContenedores(capacidadC,conjuntoS);
    		long t1 = System.currentTimeMillis();
    		sol.resolve();
    		long t2 = System.currentTimeMillis();
    		long tiempo= t2-t1;
    		System.out.println("para el test " + i + "Tiempo :" + tiempo + " ms");

		}
       

    }

    

   
    
}

