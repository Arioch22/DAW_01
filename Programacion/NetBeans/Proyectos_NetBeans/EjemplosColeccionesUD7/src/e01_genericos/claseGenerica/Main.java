package e01_genericos.claseGenerica;

import java.util.Arrays;

/**
 *
 * @author Trassierra
 */
public class Main {

    public static void main(String[] args) {

        Integer[] numeros = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(numeros));
        
        Util<Integer> u = new Util<>();
        u.invertir(numeros);
        
        System.out.println(Arrays.toString(numeros));
        
        
        String[] textos = ("¡Hola a todos/as! ¿Qué tal estáis?").split(" ");
        
        System.out.println(Arrays.toString(textos));
        
        Util<String> us = new Util<>();
        us.invertir(textos);
        
        System.out.println(Arrays.toString(textos));
        
    }
}
