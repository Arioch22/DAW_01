package tarea1;

import java.util.Scanner;

/**
 * Cálculos aritméticos.
 * Escribe un programa en Java que solicite dos números reales y lleve a cabo los 
 * siguientes cálculos:
 *  1. el triple del primer número,
 *  2. la décima parte del segundo número,
 *  3. el cuadrado del doble del producto de ambos números,
 *  4. la mitad del cuadrado de la suma de ambos números.
 * 
 * @author Manuel Monterroso Flores
 */
public class Ejercicio02 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes

        
        // Variables de entrada
        float numero1,numero2,y,x;
        

        
        // Variables de salida
        
        

        
        // Variables auxiliares

        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CÁLCULOS ARITMÉTICOS");
        System.out.println("--------------------");
        System.out.println("Introduzca primer número: ");
        numero1 = teclado.nextFloat();
        System.out.println("Introduzca segundo número: ");
        numero2 = teclado.nextFloat();
    
        


        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        // Primer cálculo: triple del primer número
        float resultado1= (3 * numero1);
        
        // Segundo cálculo: décima parte del segundo número
        float resultado2= (numero2 / 10);

        // Tercer cálculo: cuadrado del doble del producto de ambos números
        float z = ((numero1 * numero2) * 2);
        float resultado3= (z * z);
        // Cuarto cálculo: mitad del cuadrado de la suma de ambos números
        float m = (numero1 + numero2);
        float resultado4 = ((m * m) / 2);
        
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println ();
        System.out.println("El triple del primer número es: " +resultado1);
        System.out.println("La décima parte del segundo número es: " +resultado2);
        System.out.println("El cuadrado del doble del producto de ambos números es: " +resultado3);
        System.out.println("La mitad del cuadrado de la suma de ambos números es: " +resultado4);
    }    
}