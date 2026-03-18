package algstudent.s4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ColoreoGrafo {
    private static String[] colors = {"red", "blue", "green",
    "yellow", "orange", "purple", "cyan", "magenta", "lime"};


    public static Map<String, String> realizarVoraz(Map<String,List<String>> grafo) {
        Map<String,String> resuMap= new HashMap<String,String>();
        
        for (Map.Entry<String, List<String>> entry : grafo.entrySet()) {
        
        String nodo = entry.getKey().toString();
        List<String> vecinos = entry.getValue();
        List<String> coloresDispoStrings = new ArrayList<>(Arrays.asList(colors));
        if (nodo.equals("0")) {
            resuMap.put(nodo, colors[0]);
            continue;
        }

        for (Object vecino : vecinos) {
            String value= vecino.toString();
           String color = resuMap.get(value);

            if (color != null) {
                coloresDispoStrings.remove(color);
            }
        }
    

        resuMap.put(nodo, coloresDispoStrings.get(0));
    

    }

        return resuMap;
    }

}
