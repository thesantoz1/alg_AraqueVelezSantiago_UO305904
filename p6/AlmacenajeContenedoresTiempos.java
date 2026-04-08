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
    	int n = Integer.parseInt(args[0]);
    	for (int i = 0; i < 10; i++) {
    		Scanner sc = new Scanner(new FileReader("src/p6/test0"+i+".txt"));
    		int capacidadC= sc.nextInt();
    		sc.nextLine();
    		String[] conjuntoStrings= sc.nextLine().split(" ");
    		Integer[] conjuntoS = new Integer[conjuntoStrings.length];

    		for(int j=0;j< conjuntoS.length; j++){
    			conjuntoS[j]= Integer.parseInt(conjuntoStrings[j]);
    		}
    		long t1 = System.currentTimeMillis();
    		for(int k=0;k<n;k++) {
    			AlmacenajeContenedores sol = new AlmacenajeContenedores(capacidadC,conjuntoS);
        		sol.resolve();
    		}
    		long t2 = System.currentTimeMillis();
    		long tiempo= t2-t1;
    		System.out.println("para el test " + i + "Tiempo :" + tiempo + " ms");
    		

		}
       

    }

    

   
    
}

