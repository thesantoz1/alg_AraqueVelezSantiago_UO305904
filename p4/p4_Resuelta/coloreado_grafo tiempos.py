import json
import time

from auxiliar import dibujar_mapa_coloreado, generar_mapa_grafo


def realizar_voraz(grafo):
    colors = [
        "red", "blue", "green",
        "yellow", "orange", "purple",
        "cyan", "magenta", "lime"
    ]

    resu_map = {}

    for nodo, vecinos in grafo.items():

        colores_disponibles = colors.copy()

        
        if nodo == "0":
            resu_map[nodo] = colors[0]
            continue

        
        for vecino in vecinos:
            color_vecino = resu_map.get(str(vecino))
            if color_vecino in colores_disponibles:
                colores_disponibles.remove(color_vecino)


        if colores_disponibles:
            resu_map[nodo] = colores_disponibles[0]

    return resu_map

if __name__ == "__main__":
    i=8
    mapa = generar_mapa_grafo(i)
    while(i<128000):
       
        t1= time.perf_counter()
        solucion = realizar_voraz(mapa["grafo"])
        t2= time.perf_counter()
        tiempo=(t2-t1)*1000
        print(f"El tiempo para {i} nodos es de {tiempo} miliseg")
        i=i*2
    

    

    if solucion:
        print("Solución encontrada:", solucion)
        dibujar_mapa_coloreado(mapa, solucion)
        with open('sols/solucion.json', 'w') as f:
            json.dump(solucion, f)
            f.close()
    else:
        print("No se encontró solución.")

