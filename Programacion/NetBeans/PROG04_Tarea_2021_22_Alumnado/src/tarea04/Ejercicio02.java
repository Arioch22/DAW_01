package tarea04;

import java.util.Arrays;

/**
 * Ejercicio 2. Reconocimiento de palíndromos.
 * @author Manuel Monterroso Flores
 */

public class Ejercicio02 {
    
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        
        // Variables de entrada
        
        // 1.- Declaración del array de objetos String de entrada
        // (Textos "Reconocer", "AMANECER", "Esto no es un palindromo",
        //    "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
        //    "A man a plan and a canal, Panama", "No deseo ese don..."
        final String [] PALABRASPARAANALIZAR = {"Reconocer", "AMANECER", "Esto no es un palindromo", "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama", 
            "A man a plan and a canal, Panama", "No deseo ese don..."};

        // Variables de salida
        // 2.- Declaración de un array de boolean para los resultados
        boolean [] verdaderoFalso;
        
        // Variables auxiliares
        String palabra;
        String palabraInvertida;
        char letra;

        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("RECONOCIMIENTO DE PALÍNDROMOS");
        System.out.println("-----------------------------");

        // 3.- Reservamos espacio para el array de resultados (procura no usar un literal)
        verdaderoFalso = new boolean [PALABRASPARAANALIZAR.length];
        
        // 4.- Mostramos el array de textos por pantalla
        for (int i = 0; i < PALABRASPARAANALIZAR.length; i++) {
            System.out.println("-Texto " +(i+1) +": "  +PALABRASPARAANALIZAR[i]);
            
        }

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 5.- Recorremos de nuevo el array de textos

         // 5.1.- Para cada texto comprobamos si es palíndromo
           // Habrá que "limpiar" los textos de espacios y signos de puntuación

           // 5.2.- Si se trata de un palíndromo, se almacena el valor true en el
           // array de salida. Si no, se almacena false
           
           for (int i = 0; i < PALABRASPARAANALIZAR.length; i++) {
               //con esta expresión regular eliminamos todo lo que sean letras.
               palabra = PALABRASPARAANALIZAR[i].replaceAll("[^a-zA-Z]", "");
               //reinicio de la variable.
               palabraInvertida= "";
               
               /*en este for recorremos de manera inversa cada palabra del array descomponoiendola letra a letra con la opción Char
               y luego acumulandolas en un String.*/
               for (int j = palabra.length()-1; j >=0; j--) {
                   letra = palabra.charAt(j);
                   palabraInvertida += letra;
                }
               
               //aqui tras realizar la comprobación de si la frase y su forma invertida son iguales guardamos la solución dentro del array de salida.
               verdaderoFalso[i] = palabra.equalsIgnoreCase(palabraInvertida);
           }  
            
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADOS OBTENIDOS");
        System.out.println("--------------------");
        
        // 6.- Mostramos por pantalla el array de resultados
        System.out.println("Palíndromos encontrados: " +Arrays.toString(verdaderoFalso));
    }
}