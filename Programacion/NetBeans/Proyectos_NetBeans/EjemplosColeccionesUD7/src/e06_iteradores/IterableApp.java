package e06_iteradores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Ejemplo de uso de la interfaz Iterable
 *
 * @author Trassierra
 */
public class IterableApp {

    public static void main(String[] args) {
        Random r = new Random();
        
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            lista.add( r.nextInt(100) );
        }
        System.out.println("Contenido inicial de la lista " + lista ); // se ha mostrado desde su toString (sin usar iteradores ni nada)
        
        Iterator<Integer> it = lista.iterator();  // se instancia un iterador para recorrer la lista
        while (it.hasNext()) {  // mientras haya siguiente elemento
            Integer t = it.next();  // se lee el siguiente elemento (next devuelve el tipo de dato al que apunta)
            if (t % 2 == 0) {
                System.out.println("Se eliminará el elemento " + t + " ya que es par");
                it.remove();  // se elimina el elemento en el que está posicionado el iterador en ese momento
            }
        }
        System.out.print("El contenido final de la lista es: ");
        it = lista.iterator(); // se vuelve a obtener un iterador (para que vuelva al principio)
        while (it.hasNext()) {
            Integer t = it.next();
            System.out.print(t);
            if(it.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("");
        
    }
}
