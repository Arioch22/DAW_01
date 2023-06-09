package e04_listas.ej1;

import java.util.Arrays;
import java.util.List;

/**
 * Ejemplo de uso de los métodos de List<E>
 *
 * @author Trassierra
 */
public class ListApp {

    public static void main(String[] args) {

        // Una de las formas más sencillas de obtener una lista
        List<String> lista = Arrays.asList("Uno", "Dos", "Tres", "Cinco", "Seis");
                                            //0     //1   //2
         // Uso posicional de la lista
        // Los índices comienzan en 0

        // Obtener el elemento en la posición 2 (tercer elemento)
        String tercerElemento = lista.get(2);
        System.out.println("El tercer elemento es : "  + tercerElemento);
        
        // Iterar sobre los elementos
        for(String x: lista)
        	System.out.print(x + " ");

    }



}
