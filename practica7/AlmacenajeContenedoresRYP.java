package p7;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlmacenajeContenedoresRYP {
    private int capacidadC;
    private Integer[] conjuntoS;
    private static int mejorK;
    private List<List<Integer>> mejorDistribucion = new ArrayList<List<Integer>>();


    public AlmacenajeContenedoresRYP(int capacidadC, Integer[] conjuntoS) {
        this.capacidadC=capacidadC;
        this.conjuntoS=conjuntoS;
        Arrays.sort(this.conjuntoS, Collections.reverseOrder());
        this.mejorK = conjuntoS.length;
        
       
    }
    private void backTracking( int indexObject , List<List<Integer>> contenedores , int sumaRestamte){
       //lower bound
       // nª minimo teorico de contenedores adicionales necesarios
       int lowerboud= (sumaRestamte +capacidadC-1)/capacidadC;

       
        //Caso Base : todos los objetos colocados
        
        if(indexObject==conjuntoS.length){
            if(mejorDistribucion.size() < mejorK){
                mejorDistribucion=crearCopia(contenedores);
                mejorK = mejorDistribucion.size();
            }
            
            return;
        }

        //Podamos si : size de contenedores + los posibles necesarios adicionales > mejorK => Paramos
        if(contenedores.size() +lowerboud>=mejorK){
            return;
        }



        //Probar  meter en contenederosExistentes
        for (int i = 0; i < contenedores.size(); i++) {
            if(sum(contenedores.get(i))+ conjuntoS[indexObject]<= capacidadC){
                //Avanzar : colocar en un contenedeor
                contenedores.get(i).add(conjuntoS[indexObject]);
                backTracking(indexObject + 1 , contenedores,sumaRestamte-conjuntoS[indexObject]);
                //Retroceder-
                contenedores.get(i).remove(contenedores.get(i).size()-1);
            }
            
        }
        
        List<Integer> nuevoContenedro= new ArrayList<Integer>();
        
        
        //Avanzo
        contenedores.add(nuevoContenedro);
        nuevoContenedro.add(conjuntoS[indexObject]);
        
        backTracking(indexObject + 1 , contenedores,sumaRestamte-conjuntoS[indexObject]);
        nuevoContenedro.remove(conjuntoS[indexObject]);
        contenedores.removeLast();
            
    }

    private List<List<Integer>> crearCopia(List<List<Integer>> contenedores) {
        List<List<Integer>> copia = new ArrayList<List<Integer>>();
        for (List<Integer> i : contenedores) {
            copia.add(new ArrayList<Integer>(i));
        }
        return copia;
    }

    private Integer sum(List<Integer> list) {
        Integer sumAcc=0;
        for (int i = 0; i < list.size(); i++) {
            sumAcc=sumAcc+ list.get(i);
        }
        return sumAcc;
    }
    public static void main (String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new FileReader("src/p7/test09.txt"));
        int capacidadC= sc.nextInt();
        String[] conjuntoStrings= sc.nextLine().split(" ");
        Integer[] conjuntoS = new Integer[conjuntoStrings.length];

        for(int i=0;i< conjuntoS.length; i++){
             conjuntoS[i]= Integer.parseInt(conjuntoStrings[i]);
        }
        AlmacenajeContenedoresRYP sol = new AlmacenajeContenedoresRYP(capacidadC,conjuntoS);
        sol.resolve();
        System.out.println(mejorK);
        

    }

    int sumaTotalS(){
        int suma=0;
        for (int i = 0; i < conjuntoS.length; i++) {
          
                suma+= conjuntoS[i];
        }
        return suma;
    }
    void resolve() {
        ArrayList<List<Integer>> contenedores=new ArrayList<>();
        backTracking(0, contenedores,sumaTotalS());
        
    }
	public int getBinsNeededSolution() {
		return mejorK;
	}

   
    
}

