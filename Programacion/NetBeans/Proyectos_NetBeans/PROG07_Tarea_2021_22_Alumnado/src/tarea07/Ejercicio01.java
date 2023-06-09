package tarea07;

import java.util.HashSet;

/**
 * Ejercicio 1. Combinando colores.
 * @author Profe
 */
public class Ejercicio01 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        final int CANTIDAD_COLORES = 3;
        HashSet<String> conjunto1=new HashSet<>();
        HashSet<String> conjunto2=new HashSet<>();
        HashSet<String> listaUnion=new HashSet<>();
        HashSet<String> listaInterseccion=new HashSet<>();
        HashSet<String> listaDiferencia=new HashSet<>();

        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // No hay, pues se usa un número fijo de elementos aleatorios
        System.out.println("CONJUNTOS DE COLORES");
        System.out.println("--------------------");
        
        
        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        // Rellenamos los conjuntos con aleatorios hasta que haya CANTIDAD_NUMEROS
        
        do {
            conjunto1.add(Utilidades.colorAleatorio());

        } while (conjunto1.size() < CANTIDAD_COLORES);
        
        do {
            conjunto2.add(Utilidades.colorAleatorio());

        } while (conjunto2.size() < CANTIDAD_COLORES);

        
        // Cálculo de la Unión de los dos conjuntos 
        listaUnion.addAll(conjunto1);
        listaUnion.addAll(conjunto2);

        
        // Cálculo de la Intersección de los conjuntos
        listaInterseccion.addAll(conjunto1);
        listaInterseccion.retainAll(conjunto2);

        // Cálculo de la Diferencia de los conjuntos
        listaDiferencia.addAll(conjunto1);
        listaDiferencia.removeAll(conjunto2);

        
        //----------------------------------------------
        //              Salida de Resultados 
        //----------------------------------------------
        System.out.println("\nPrimer Conjunto de colores: " + conjunto1.toString());
        System.out.println("Segundo Conjunto de colores: " + conjunto2.toString());
        System.out.println("Union de conjuntos: " + listaUnion.toString());
        System.out.println("Intersección de conjuntos: " + listaInterseccion.toString());
        System.out.println("Diferencia de conjunto1 - conjunto2: " + listaDiferencia.toString());
    }
   
}
