
package tarea1;

import java.util.Scanner;

/**
 * Análisis de un número.
 * 
 * @author Manuel Monterroso Flores
 */
public class Ejercicio03 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        final int CERO = 0;
        final int DIEZ = 10;
        final int VEINTE = 20;


        // Variables de entrada
        int numeroIntroducido;
        
        // Variables de salida
        boolean cero;
        boolean negativo;
        boolean entre;
        boolean multi;

        
        // Variables auxiliares

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ANÁLISIS DE UN NÚMERO");
        System.out.println("---------------------");
        System.out.println("Introduzca número entero para su analisis:");
        numeroIntroducido = teclado.nextInt();
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Cálculo de los resultados lógicos
        // primeros creamos una variable para calcular si el número es múltiplo de 3.
        int division = numeroIntroducido%3;
        // creamos condición para saber si el número introducido es distinto de cero.
        cero = numeroIntroducido != CERO;
        // creamos condición para saber si el número introducido es negativo ya que todo número inferior al cero es negativo.
        negativo = numeroIntroducido < CERO;
        // creamos condición para saber si el número introducido es mayor o igual que 0 o menor o igual que 10.
        entre = numeroIntroducido >= CERO & numeroIntroducido <= DIEZ;
        // creamos condición para saber si el número introducido es mayor que cero (por tanto positivo), 
        // si es menor que veinte y si el resto de su divión por tres sea igual que cero.
        multi = numeroIntroducido > CERO && numeroIntroducido < VEINTE && division == CERO;
        

        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("El número es distinto de cero: " +cero);
        System.out.println("El número es negativo: " +negativo);
        System.out.println("El número está entre cero y diez: " +entre);
        System.out.println("El número es múltiplo de tres, positivo y menor que veinte: " +multi);
    }    
}
