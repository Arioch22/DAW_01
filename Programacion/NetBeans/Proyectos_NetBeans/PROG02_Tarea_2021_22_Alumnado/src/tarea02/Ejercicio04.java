package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 4: puntuación de un texto.
 *
 * @author Manuel Monterroso Flores
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        //Valor de las consonantes y de las vocales
        final int VOCALES = 1;
        final int XYZ_MINUSCULAS = 2;
        final int X_MAYUSCULA = 5;
        final int RESTO_CONSONANTES = -1;
        
        // Variables de entrada
        String texto;
        int multiplicador;
                
        // Variables de salida
        int resultado;

        // Variables auxiliares
        int contador = 0;
        char letra;

        // Clase Scanner para petición de datos
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("VALOR DE UN TEXTO");
        System.out.println("------------------");
        
        do {
            System.out.println("Introduzca el texto a puntuar mayor de 5 letras:");
            texto= teclado.next();
        } while (texto.length() < 5);

        do {
            System.out.println("Introduce el multiplicador entre 1 y 3");
            multiplicador= teclado.nextInt();
        } while (multiplicador < 1 || multiplicador > 3);

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        for (int i = 0; i < texto.length(); i++) {
            letra = texto.charAt(i);
            /*Tras sacar con el for letra a letra esta se va comprobando con un switch para que 
            dependiendo de la letra se valla añadiendo a un contador para luego multiplicarlo*/
            switch (letra) {
                case 'a': case 'e': case 'i': case 'o': case 'u': case 'A': case 'E': case 'I': case 'O': case 'U':
                    contador += VOCALES;
                break;
                    case 'x': case 'y': case 'z':
                        contador += XYZ_MINUSCULAS;
                    break;
                        case 'X':
                        contador += X_MAYUSCULA;
                        break;
                default: 
                   contador += RESTO_CONSONANTES;
            }
            
        }
        resultado = contador * multiplicador;
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("El valor del texto es: " + (resultado));
    }
}
