package e04_listas.ej3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Ejemplo de uso de los métodos de LinkedList<E>
 *
 * @author Trassierra
 */
public class LinkedListApp {

    public static void main(String[] args) {

        // LinkedList suele ser menos adecuado que ArrayList en la mayoría de los casos

        // Es adecuado si necesitamos insertar o eliminar elementos en medio de la
        // colección varias veces durante la ejecución (tiene mejor rendimiento)

        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("Uno", "Dos", "Tres"));

        for(ListIterator<String> listIterator = linkedList.listIterator(); listIterator.hasNext();) {
            listIterator.next();
            listIterator.add("Otro");
        }

        
        for(String e: linkedList)
        	System.out.print(e + " ");

    }
}
