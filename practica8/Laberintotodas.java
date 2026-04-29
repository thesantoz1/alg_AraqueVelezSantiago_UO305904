package p8;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Laberintotodas {
    int[][] matrizLaberinto;
    List<List<Integer>> soluciones = new ArrayList<List<Integer>>();
    int posicionfinalx;
    int posicionfinaly;
    int posicionInicialx;
    int posicionInicialy;
    int filas;
    int columnas;
    public Laberintotodas(int[][] laberinto , int posicionInicial, int posicionfinal){
        this.matrizLaberinto=laberinto;
        filas= matrizLaberinto.length;
        columnas= matrizLaberinto[0].length;
        posicionInicialx=posicionInicial/columnas;
        posicionInicialy=posicionInicial%columnas;
        posicionfinalx=posicionfinal/columnas;
        posicionfinaly=posicionfinal%columnas;


    }

    public void resolve(){
        backTracking(posicionInicialx,posicionInicialy);
    }

    private void backTracking(int fila, int columna ) {
        if(fila==posicionfinalx && columna==posicionfinaly){
        	matrizLaberinto[fila][columna]=2;
           soluciones.add(construirSolucion(matrizLaberinto));
            return;
        }

        if(!isPosValida(fila,columna)){
            return;
        }
        // avanzo 
        matrizLaberinto[fila][columna]=2;
        backTracking(fila +1, columna);
        backTracking(fila -1, columna);
        backTracking(fila , columna +1);
        backTracking(fila , columna-1);
        // retrocedo
        matrizLaberinto[fila][columna]=0;

        

        


        }

        
    private boolean isPosValida(int fila, int columna) {
        if((fila>=0 && fila<filas) && (columna>=0 && columna<columnas) && matrizLaberinto[fila][columna]==0 ){
            return true;
        }
        return false;
    }



    private List<Integer> construirSolucion(int[][] matrizLaberinto2) {
        List<Integer> solucion = new ArrayList<>();
        for (int i = 0; i < filas; i++) {
            for (int j=0; j< columnas; j++) {
                solucion.add(matrizLaberinto2[i][j]);
            }
        }
        return solucion;
    }
    
    public static void main(String args[]) {
    	String ruta = "src/p8/caso1.txt";
        List<int[]> filasList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // 1. Limpiar espacios extra y trocear por espacios (o comas)
                String[] partes = linea.trim().split("\\s+"); 
                
                // 2. Convertir el array de Strings a un array de int
                int[] fila = new int[partes.length];
                for (int i = 0; i < partes.length; i++) {
                    fila[i] = Integer.parseInt(partes[i]);
                }
                
                // 3. Añadir la fila a nuestra lista
                filasList.add(fila);
            }

            // 4. Convertir la List<int[]> a un array bidimensional int[][]
            int[][] matrizFinal = filasList.toArray(new int[0][]);

            // Verificación
            
            printearMatriz(matrizFinal);
            
            Laberintotodas laberintotodas= new Laberintotodas(matrizFinal, 0, 48);
            laberintotodas.resolve();
            for (List<Integer> soluciones: laberintotodas.soluciones) {
            	System.out.println(soluciones);
			}

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al procesar el fichero: " + e.getMessage());
        }
        
    }

	private static void printearMatriz(int[][] matrizFinal) {
		for (int i = 0; i < matrizFinal.length; i++) {
			for (int j = 0; j < matrizFinal[0].length; j++) {
				System.out.print(matrizFinal[i][j]);
			}
			System.out.println();
		}
	}
}
