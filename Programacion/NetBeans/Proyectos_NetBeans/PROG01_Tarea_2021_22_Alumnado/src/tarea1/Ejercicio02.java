package tarea1;

import java.util.Scanner;

/**
 * C�lculos aritm�ticos.
 * Escribe un programa en Java que solicite dos n�meros reales y lleve a cabo los 
 * siguientes c�lculos:
 *  1. el triple del primer n�mero,
 *  2. la d�cima parte del segundo n�mero,
 *  3. el cuadrado del doble del producto de ambos n�meros,
 *  4. la mitad del cuadrado de la suma de ambos n�meros.
 * 
 * @author Manuel Monterroso Flores
 */
public class Ejercicio02 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaraci�n de variables 
        //----------------------------------------------

        // Constantes

        
        // Variables de entrada
        float numero1,numero2,y,x;
        

        
        // Variables de salida
        
        

        
        // Variables auxiliares

        
        // Clase Scanner para petici�n de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("C�LCULOS ARITM�TICOS");
        System.out.println("--------------------");
        System.out.println("Introduzca primer n�mero: ");
        numero1 = teclado.nextFloat();
        System.out.println("Introduzca segundo n�mero: ");
        numero2 = teclado.nextFloat();
    
        


        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        // Primer c�lculo: triple del primer n�mero
        float resultado1= (3 * numero1);
        
        // Segundo c�lculo: d�cima parte del segundo n�mero
        float resultado2= (numero2 / 10);

        // Tercer c�lculo: cuadrado del doble del producto de ambos n�meros
        float z = ((numero1 * numero2) * 2);
        float resultado3= (z * z);
        // Cuarto c�lculo: mitad del cuadrado de la suma de ambos n�meros
        float m = (numero1 + numero2);
        float resultado4 = ((m * m) / 2);
        
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println ();
        System.out.println("El triple del primer n�mero es: " +resultado1);
        System.out.println("La d�cima parte del segundo n�mero es: " +resultado2);
        System.out.println("El cuadrado del doble del producto de ambos n�meros es: " +resultado3);
        System.out.println("La mitad del cuadrado de la suma de ambos n�meros es: " +resultado4);
    }    
}