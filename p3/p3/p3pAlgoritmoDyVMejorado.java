package p3;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
public class p3pAlgoritmoDyV {
	
	public static void main (String[] arg) 
	{
//		 if (arg.length == 0) {
//		       System.out.println("Debe pasar un fichero como argumento");
//		      return;
//		    }

		 String nombreFichero = "files/32.txt";
		 List<Punto>puntos = new ArrayList<Punto>();
		 FileUtil.loadFile(nombreFichero, puntos);
		 List<Punto> resultados= puntosMasCercanos(puntos);
		 System.out.println("Puntos mas cercanos " + resultados.get(0) + " " + resultados.get(1));
		 System.out.println("Distancia mas proxima : "  + resultados.get(0).CalcularDistanciaCon(resultados.get(1)));;
	
		}

	public static List<Punto> puntosMasCercanos(List<Punto> puntos) {
		puntos.sort(Comparator.comparing(Punto::getPuntoX));
		return puntosMasCercanosRec(puntos);
		
	}

	private static List<Punto> puntosMasCercanosRec(List<Punto> puntos){
		
	
    int n = puntos.size();
	if(n<=2){
		Punto punto1=puntos.get(0);
		Punto punto2=puntos.get(1);
		List<Punto> puntosMinimos= new ArrayList<Punto>();
		puntosMinimos.add(punto1);
		puntosMinimos.add(punto2);
		return puntosMinimos;
	}

    int mitad = n/2;

    List<Punto> izquierda = puntos.subList(0, mitad);
    List<Punto> derecha = puntos.subList(mitad, n);


    List<Punto> minIzq = puntosMasCercanosRec(new ArrayList<Punto>(izquierda));
    List<Punto> minDerecha = puntosMasCercanosRec(new ArrayList<Punto>(derecha));
    List<Punto> minCentro = puntosMasCercanosRec(puntos.subList(mitad-1, mitad+1));

    
    return minDist(minIzq,minDerecha,minCentro);
}

	private static List<Punto> minDist( List<Punto>a, List<Punto> b, List<Punto> c) {
		double distMinIzq = a.get(0).CalcularDistanciaCon(a.get(1));
	    double distMinDer = b.get(0).CalcularDistanciaCon(b.get(1));
	    double distMinCentro = c.get(0).CalcularDistanciaCon(c.get(1));
	    if (distMinIzq<distMinDer && distMinIzq<distMinCentro) return a;
		else 
			if (distMinDer<distMinIzq && distMinDer<distMinCentro) return b;
			else return c;

}
	}

	

	
	
		
	
	