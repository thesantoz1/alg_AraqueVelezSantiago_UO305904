package algstudent.s4;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DevoradorTiempos {
   public static void main (String[] arg) 
	{
		 
		 i=8;
		 while (i<128000) {
			JSONParser parser = new JSONParser();

		try (FileReader reader = new FileReader("grafo"+i+".json")) {

			JSONObject jsonObject = (JSONObject) parser.parse(reader);

			@SuppressWarnings("unchecked")

			Map<String, List<String>> grafo = (Map<String, List<String>>) jsonObject.get("grafo");

			t1 = System.currentTimeMillis (); 
			for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
			{ 
				Map<String, String> solucion = ColoreoGrafo.realizarVoraz(grafo);
			}
			
			t2 = System.currentTimeMillis ();

			System.out.println (" nodos ="+n+ "**TIEMPO="+(t2-t1)+"**nVeces="+nVeces);
	
	    
		 
		
		}
	}	
		
}
}
