package tarea07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/** Ejercicio 4. Clasificación de coincidentes
 * @author profe
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        final int CANTIDAD_COLORES = 15;
        
        List<String> lista1=new ArrayList<>();
        List<String> lista2=new ArrayList<>();
        HashMap<String, List<Integer>> mapaLista=new HashMap<>();

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("CLASIFICACIÓN DE COINCIDENTES");
        System.out.println("-----------------------------");
        // No hay, pues se usa un número fijo de elementos aleatorios

        // Rellenamos la lista con aleatorios hasta que haya CANTIDAD_NUMEROS
        do {
            lista1.add(Utilidades.colorAleatorio());

        } while (lista1.size() < CANTIDAD_COLORES);

        do {
            lista2.add(Utilidades.colorAleatorio());

        } while (lista2.size() < CANTIDAD_COLORES);
        
        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------
        
        for (int i = 0; i < lista1.size(); i++) {
            if (lista1.get(i).equals(lista2.get(i))) {

                if (!mapaLista.containsKey(lista1.get(i))) {

                    mapaLista.put(lista1.get(i), new LinkedList<>());
                    mapaLista.get(lista1.get(i)).add(i);

                } else {
                    mapaLista.get(lista1.get(i)).add(i);
                }
            }
        }
        
        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        
        System.out.println("\n1. Contenido inicial de la lista1: " +lista1.toString());
        System.out.println("2. Contenido inicial de la lista2: " +lista2.toString());
        
        System.out.println("\n" +mapaLista);
        
    }

}
