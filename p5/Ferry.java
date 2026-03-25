package p5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Ferry {
	private List<Step> path; //variable para guardar el camino seleccionado
    private int boatlenght;//Longitud de los carriles del barco    
    private List<Integer> vehicles;
    private boolean[][] matrix ; //matriz con las posibles soluciones
    private int[] sumLenghtV;

    public Ferry(int boatlenght, List<Integer> vehicles){
        this.boatlenght=boatlenght;
        this.vehicles=vehicles;
        this.matrix= new boolean[vehicles.size()+1][boatlenght+1];
        this.sumLenghtV= new int[vehicles.size()+1];

        sumLenghtV[0]=0;

        for (int i = 1; i < sumLenghtV.length; i++) {
            sumLenghtV[i]=sumLenghtV[i-1] + vehicles.get(i-1);
        }

    }

    public void run(){
        //Caso base de la matriz
        matrix[0][0]=true;

        for (int i = 1; i < vehicles.size()+1; i++) {
            for (int j = boatlenght; j >= 0; j--) {
                if(!matrix[i-1][j]){
                    continue;
                }
                //meter coche en babor
                if(j+vehicles.get(i-1)<= boatlenght){
                    matrix[i][j+vehicles.get(i-1)]=true;
                }

                //meter cohe en      estribor
                if(sumLenghtV[i] - j<= boatlenght){
                    matrix[i][j]=true;
                }
            }
        }
       
        this.path = new ArrayList<Step>();
        
    }

    public static void main(String[] arg){
        List<Integer> listaV= Arrays.asList(4,3,5,2,2);
        Ferry ferry = new Ferry(10, listaV);
        ferry.run();
        
    }
    /**
    * Devuelve el numero máximo de vehiculos posibles
    * l (siendo l < boatlength) con dp[i][l] = true. es el maximo número de coches que pueden entrar.
    */
    public int getMaximumNumberOfVehicles() {
    	  for (int i = vehicles.size(); i >= 0; i--) {
    	        for (int l = 0; l <= boatlenght; l++) {
    	            if (matrix[i][l]) {
    	                return i;
    	            }
    	        }
    	    }
    	    return 0;
    }

    public void printData() {
    		System.out.printf("Length of parallel lanes for starboard and port on the ferry: %d\n", boatlenght);
    		System.out.printf("The vehicles have the following lengths:\n");
    		for (int i = 0; i < vehicles.size(); i++) {
    			System.out.printf("\tVehicle %d: %d\n", i+1, vehicles.get(i));
    		}
    	}
    	
    	
    public void printPossibleAssignation() {
    		boolean found = false;
    		System.out.printf("\nPossible assignation:\n");
    		for (int i = getMaximumNumberOfVehicles(); i > 0; i--) {
    			//si found es true -> rompo la ejecución
    			//para cada p de la longitud del barco
    			//		si found es true -> rompo la ejecución
    			//		si dp[i][p-v(i)] es true -> found = true; llamo a processAssignation()
    		}
    	}

    private void processAssignation(int i, int l) {
    	// if ((i == 0) && (l == 0)) { // llamo a printPath y acabo la ejecución (return)
    		
    	//if (dp[i-1][l]) {
    	//		añado al path (path.addFirst) un nuevo Step llamado estribor; llamo a processAssignation(i-1, l);

    		
    	// if (dp[i-1][l-vehicles.get(i-1)]) {
    	//		añado al path (path.addFirst) un nuevo Step llamado babor; llamo a processAssignation(i-1, l-vehicles.get(i-1));


    	}
    	
    public void printSolutionTable() {
    	System.out.printf("\nTable with calculations:\n");
    		
    	System.out.printf("%4s", "V/L");
    	for (int i = 0; i <= boatlenght; i++) {
    		System.out.printf("%4d", i);	
    	}
    	System.out.printf("\n");
    		
    	for (int i = 0; i <= vehicles.size(); i++) {
    		System.out.printf("%4d", i);
    		for (int l = 0; l <= boatlenght; l++) {
    			if (matrix[i][l]){				
    				System.out.printf("%4s", "T");
    			}
    			else{ 
    					System.out.printf("%4s", "F");
    				}
    			}
    			System.out.printf("\n");
    		}
    	}


    private void printPath() {
    	int portLength = 0;
    	int starboardLength = 0;
    	for (var step : path) {		
    		if (step.movement().equals("babor")){
    			portLength += vehicles.get(step.vehicle()-1);
    		}
    		else{
    			starboardLength += vehicles.get(step.vehicle()-1);
    		}
    		System.out.printf("Vehicle %d (length %d) -- From (%d, %d) -- To (%d, %d) -- Position: %s -- Port lengh: %d -- Starboard length: %d\n", 
    				step.vehicle(), vehicles.get(step.vehicle()-1),
    				step.previousI(), step.previousL(),
    				step.currentI(), step.currentL(), 
    				step.movement(), portLength, starboardLength);
    	}
    }


    //este fragmento de código va a continuación del } que cierra la clase Ferry

    	
    record Step(int previousI, int previousL, 
    		int currentI, int currentL, 
    		int vehicle, String movement) {}


    
}


