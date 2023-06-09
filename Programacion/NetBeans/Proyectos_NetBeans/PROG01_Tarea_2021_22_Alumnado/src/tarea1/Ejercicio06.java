package tarea1;

/**
 * Análisis de un texto.
 * 
 * @author Manuel Monterroso Flores
 */
import java.util.Scanner;

public class Ejercicio06 {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        final String PUNTOS = "...";
        
        // Variables de entrada
        int longitud;
        int letraBuscar;
        char primeraLetra;
        char ultimaLetra;
        String texto;
        String punto;
        boolean cincoCaracteres;
        boolean mayuscula;
        boolean minuscula;
        boolean puntosConsecutivos;
        
        // Variables de salida
        
        // Variables auxiliares
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ANÁLISIS DE UN TEXTO");
        System.out.println("--------------------");
        System.out.println("Introduzca texto a analizar:");
        texto = teclado.nextLine();
        System.out.println("El texto a analizar es: "+texto);
        
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        longitud = texto.length();
        cincoCaracteres = longitud > 5;
        primeraLetra = texto.charAt(0);
        //como al pasar a char el caracter podemos compararlo con el código Unicode con los vales de A (65) y Z (90).
        mayuscula = primeraLetra >= 65 && primeraLetra <= 90;
        ultimaLetra = texto.charAt(longitud-1);
        //como al pasar a char el caracter podemos conparlo con el código Unicode con los valores de a (97) y z (122).
        minuscula = ultimaLetra >= 97 && ultimaLetra <= 122;
        //por si escriben una palabra mas chica de tres caracteres y no de error hago este condicional, en donde si la longitud de
        //el texto es mayor que 3 devuelva longitud-3 y si es menos solo devuelva la longitud del texto.
        letraBuscar = (longitud >=3) ?  longitud -3  : longitud;
        punto = texto.substring(letraBuscar , longitud);
        puntosConsecutivos = punto.equals(PUNTOS);
        
        
        
        
                
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("¿El texto posee mas de 5 carácteres?: "+cincoCaracteres);
        System.out.println("¿Comienza el texto en mayúsuclas?: " +mayuscula);
        System.out.println("¿La última letra es en minúsculas?: " +minuscula);
        System.out.println("¿El texto termina con puntos suspensivos (...):? " +puntosConsecutivos);
    }    
}