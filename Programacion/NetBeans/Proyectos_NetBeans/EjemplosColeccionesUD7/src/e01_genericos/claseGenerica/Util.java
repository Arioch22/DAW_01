
package e01_genericos.claseGenerica;

/**
 *
 * @author Trassierra
 */

public class Util<T> {
    T t1;
    public void invertir(T[] array) {       // invierte un array de cualquier cosa
        for (int i = 0; i < array.length / 2; i++) {
            t1 = array[i];  
            array[i] = array[array.length - 1 - i]; 
            array[array.length - 1 - i] = t1; 
        }
    }
}

