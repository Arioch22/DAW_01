package tarea1;

/**
 * Trayecto en dos etapas.
 * 
 * @author Manuel Monterroso Flores
 */
import java.util.Scanner;

public class Ejercicio04 {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        final float MITAD=(float) 0.5;
        final float CUARTO=(float) 0.25;
        

        // Variables de entrada
        float combustibleInicio;
       

        
        // Variables de salida
        float ida;
        float vuelta;
        float combustibleResto;

                
        // Variables auxiliares
        float gastoTotal;

        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
                
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("TRAYECTO EN DOS ETAPAS");
        System.out.println("----------------------");
        System.out.println("Introduzca cantidad combustible en depósito: ");
        combustibleInicio = teclado.nextFloat();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //calculo del consumo del primero trayecto que es del 50%
        ida = combustibleInicio*MITAD;
        //calculo del consumo del segundo trayecto, que es del resto tras el primer viaje, y calculando el 25%.
        vuelta = ida * CUARTO;
        //Aqui calculamos los litros que se han gastado en los dos viajes.
        gastoTotal = ida + vuelta;
        //Calculo del combustible que queda en el deposito tras los dos viajes realizados.
        combustibleResto = combustibleInicio - gastoTotal;
        
        
        
        
        
        
        //----------------------------------------------    
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("El combustible gastado en el viaje de ida ha sido de "+ida);
        System.out.println("El combustible gastado en el viaje de vuelta ha sido de "+vuelta);
        System.out.println("El combustible que queda en el deposito es de " +combustibleResto);
    }    
}
