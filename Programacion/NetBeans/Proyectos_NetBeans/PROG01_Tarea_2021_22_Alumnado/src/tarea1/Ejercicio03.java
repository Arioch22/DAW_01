
package tarea1;

import java.util.Scanner;

/**
 * An�lisis de un n�mero.
 * 
 * @author Manuel Monterroso Flores
 */
public class Ejercicio03 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaraci�n de variables 
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

        // Clase Scanner para petici�n de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("AN�LISIS DE UN N�MERO");
        System.out.println("---------------------");
        System.out.println("Introduzca n�mero entero para su analisis:");
        numeroIntroducido = teclado.nextInt();
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // C�lculo de los resultados l�gicos
        // primeros creamos una variable para calcular si el n�mero es m�ltiplo de 3.
        int division = numeroIntroducido%3;
        // creamos condici�n para saber si el n�mero introducido es distinto de cero.
        cero = numeroIntroducido != CERO;
        // creamos condici�n para saber si el n�mero introducido es negativo ya que todo n�mero inferior al cero es negativo.
        negativo = numeroIntroducido < CERO;
        // creamos condici�n para saber si el n�mero introducido es mayor o igual que 0 o menor o igual que 10.
        entre = numeroIntroducido >= CERO & numeroIntroducido <= DIEZ;
        // creamos condici�n para saber si el n�mero introducido es mayor que cero (por tanto positivo), 
        // si es menor que veinte y si el resto de su divi�n por tres sea igual que cero.
        multi = numeroIntroducido > CERO && numeroIntroducido < VEINTE && division == CERO;
        

        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("El n�mero es distinto de cero: " +cero);
        System.out.println("El n�mero es negativo: " +negativo);
        System.out.println("El n�mero est� entre cero y diez: " +entre);
        System.out.println("El n�mero es m�ltiplo de tres, positivo y menor que veinte: " +multi);
    }    
}
