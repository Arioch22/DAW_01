package tarea07;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/** Ejercicio 2. Búsqueda de coincidentes
 * @author profe
 */
public class Ejercicio02 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        final int CANTIDAD_COLORES = 10;
        ArrayList<String> lista1=new ArrayList<>();
        ArrayList<String> lista2=new ArrayList<>();
        ArrayList<String> listaEliminados=new ArrayList<>();
        ArrayList<Integer> listaPosicion=new ArrayList<>();
        LinkedHashSet<String> conjuntoFinal=new LinkedHashSet<>();
        
        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("\nBÚSQUEDA DE COINCIDENTES");
        System.out.println("------------------------");
        // No hay, pues se usa un número fijo de elementos aleatorios

        // Rellenamos la lista con aleatorios hasta que haya CANTIDAD_NUMEROS
        do {
            lista1.add(Utilidades.colorAleatorio());

        } while (lista1.size() < CANTIDAD_COLORES);

        do {
            lista2.add(Utilidades.colorAleatorio());

        } while (lista2.size() < CANTIDAD_COLORES);
        
        System.out.println("\n1. Contenido inicial de la lista1: " +lista1.toString());
        System.out.println("2. Contenido inicial de la lista2: " +lista2.toString());

        
        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------
       

        for (int i = 0; i < CANTIDAD_COLORES; i++) {
            if (lista1.get(i).equals(lista2.get(i))) {
                listaEliminados.add(lista1.get(i));
                listaPosicion.add(i);
                conjuntoFinal.add(lista1.get(i));
                lista1.set(i, "---");
                lista2.set(i, "---");

            }
         }
        
        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        
        System.out.println("\n1. Contenido final de la lista1: " +lista1.toString());
        System.out.println("2. Contenido final de la lista2: " +lista2.toString());
        System.out.println("3. Contenido final de la lista de colores eliminados: " +listaEliminados);
        System.out.println("4. Contenido final de la lista de posiciones eliminadas: " +listaPosicion);
        System.out.println("5. Contenido final del conjunto de colores eliminados: " +conjuntoFinal);
        
    }

}
