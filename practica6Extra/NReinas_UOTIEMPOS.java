
import java.util.List;


/**
 * Implementaremos en esta clase una resolución para el Problema de las N-Reinas utilizando un algoritmo de Backtracking.
 * El objetivo es colocar N reinas en un tablero de ajedrez de NxN sin que ninguna se ataque entre sí; es decir, que no compartan fila, columna ni diagonal.
 * Vamos a evitar recorrer el tablero iterativamente para validar posiciones. 
 * En su lugar, vamos a registrar las columnas y diagonales que ya están bajo ataque utilizando tres arreglos booleanos: 
 * uno para las columnas, otro para las diagonales principales (de arriba a abajo, izquierda a derecha) y otro para las diagonales secundarias (de arriba a abajo, derecha a izquierda).
 */
public class NReinas_UOTIEMPOS {
    
    /**
     *  Método principal para ejecutar el programa
     *  @param args, el primer argumento es el valor de N, o se usará 4 por defecto.
     */ 
    public static void main(String[] args) {
        NReinas_UO algoritmo = new NReinas_UO();
        int n = args != null && args.length > 0 ? Integer.parseInt(args[0]) : 4; 
        long t1 = System.currentTimeMillis();
        for (int i = 2; i < 20; i++) {
            
            List<List<String>> resultado = algoritmo.resolverNReinas(i);
            long t2 = System.currentTimeMillis();
            long tiempo = t2-t1;
            System.out.println("El tiempo para resolver el problema de las n reinas en un tablero de " +i+ " es de " + tiempo);
            
        }
        
       
    }

}