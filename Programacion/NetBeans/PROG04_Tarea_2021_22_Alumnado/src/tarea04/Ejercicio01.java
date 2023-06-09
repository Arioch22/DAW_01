package tarea04;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Ejercicio 1. Cálculo de puntuaciones.
 * @author Manuel Monterroso Flores
 */

public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes

        // Variables de entrada
        // 1.- Declaramos un array de objetos String (anotaciones) 
        // con el contenido que se nos pide en el enunciado
        final String [] PUNTUACIONESJUEGO = {"a", "a-b", "X-A", "O-O-B", "X--X", "O-X-", "-X-X", "O-X-O-X-O", "o", "O-o", "X", "o-x-o", "x", "x-x", "O-x-X", "X-X-X", "x-X-X-x"};

        // Variables de salida        
        int contadorValidas =0;
        int contadorIncorrectas = 0;

        
        // Variables auxiliares
        int contadorPuntuaciones = 0;
        char letra;


        //String elemento;
        StringBuilder salidaPuntuaciones=new StringBuilder ();


        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CÁLCULO DE PUNTUACIONES");
        System.out.println("-----------------------");
        
        // 2.- Mostramos por pantalla el contenido del array de anotaciones
        
        /*System.out.println("Estas son las anotaciones obtenidas. \n");
        for (int i = 0; i < 17; i++) {
            System.out.print(PUNTUACIONESJUEGO[i] +" ");
        }*/
        System.out.println("Anotaciones obtenidas de cada mano del juego:");
        System.out.println(Arrays.toString(PUNTUACIONESJUEGO));
                
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------

        // 3.- Recorremos cada elemento del array
 
        

            // 3.1.- Si el elemento "encaja" con el patrón (anotación válida), se calcula su puntuación
                // Para ello habrá que descomponer la anotación en cada uno de sus elementos,
                // calcular su valor y sumarlos.
            
                
            // 3.2.- Si no "encaja" con el patrón, la anotación será inválida y su puntuación -1

            
            // 3.3.- Las puntuaciones obtenidas se "acumulan" o "concatenan" separadaa por comas en un objeto de tipo StringBuilder
            
            //creamos expresión regular para comprobar que se cumplan las condiones para declarar la jugado correcta y si lo es puntuar.
            Pattern p=Pattern.compile("[xXoO](-[xXoO]){0,3}");
            for (int i = 0; i < 17; i++) {
                Matcher m=p.matcher(PUNTUACIONESJUEGO[i]);
                
                if (m.matches()) {
                    //tras comparar jugada por jugada si cumple la expresión regular aumentamos el contador de jugadas válidas y dejamos pasar al siguiente proceso esa jugada.
                    contadorValidas ++;
                    //reinicio del contador de puntuaciones.
                    contadorPuntuaciones = 0;
                    for (int j = 0; j < (PUNTUACIONESJUEGO[i].length()); j++) {
                        
                        //sacamos cada elemento individual de una jugada y con el switch comprobamos si es una x o X para aumentar el contador de puntuaciones.
                        letra = PUNTUACIONESJUEGO[i].charAt(j);
                        switch (letra){
                            case 'x': case 'X':
                            contadorPuntuaciones ++;
                            break;
                        } 
                }
                //tras conseguir las puntuaciones de una jugada las vamos añadiendo en este StringBuildes    
                salidaPuntuaciones.append(contadorPuntuaciones +", ");

                
                }else{
                    //si la jugada no coincide con la expresión añadimos -1 en el StringBuilder de la salida y aumentamos contador de jugadas no válidas.
                    salidaPuntuaciones.append("-1, ");
                    contadorIncorrectas ++;
                }
            }
            
            //eliminamos una de las comas que han salido duplicadas en el medio.
            salidaPuntuaciones.delete(salidaPuntuaciones.length()-2,salidaPuntuaciones.length()-1);
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\n");
        System.out.println("RESULTADO: PUNTUACIONES CALCULADAS");
        System.out.println("----------------------------------");

        // 4.- Mostramos por pantalla el resultado final
        
        // 4.1.- Lista completa de puntuaciones de cada mano
        System.out.println("Puntuaciones: " +salidaPuntuaciones);

        // 4.2.- Número de anotaciones válidas
        System.out.println("Número de anotaciones válidas: " +contadorValidas +".");
        
        // 4.3.- Número de anotaciones no válidas
        System.out.println("Número  de anotaciones inválidas " +contadorIncorrectas +".");
        
    }

}
