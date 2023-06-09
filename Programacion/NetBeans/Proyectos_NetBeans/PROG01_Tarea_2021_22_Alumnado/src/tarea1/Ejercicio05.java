package tarea1;

import java.util.Scanner;

/**
 * Máquina expendedora de productos.
 * @author Manuel Monterroso Flores
 */
public class Ejercicio05 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        
        // Variables de entrada
        int dineroProducto;
        int dineroIntroducido;
        int dineroSobrante;
        int devolucionVeinte;
        int devolucionDiez;
        int devolucionCinco;
        int devolucionDos;
        int devolucionUno;
        int contador = 0;
        int vuelta;
        
        // Variables de salida
        
        // Variables auxiliares

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("MÁQUINA EXPENDEDORA DE PRODUCTOS");
        System.out.println("--------------------------------");
        System.out.println("¿Cuanto vale el producto? (en céntimos)");
        dineroProducto = teclado.nextInt();
        System.out.println("¿Cuanto dinero ha introducido? (en céntimos)");
        dineroIntroducido = teclado.nextInt();
        
               
                
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //calculamos la cantidad de dinero a devolver tras comprar el producto.
        vuelta = dineroProducto - dineroIntroducido;
        dineroSobrante = vuelta;
        
        /*calculamos en cada punto la cantidad de monedas de cada cambio para luego sumarlas en un contador (contador), y luego calculamos el resto
        para el siguiente cambio*/
        devolucionVeinte = dineroSobrante / 20;
        dineroSobrante = dineroSobrante%20;
        contador = contador += devolucionVeinte;
        
        devolucionDiez = dineroSobrante / 10;
        dineroSobrante = dineroSobrante%10;
        contador = contador += devolucionDiez;
        
        devolucionCinco = dineroSobrante / 5;
        dineroSobrante = dineroSobrante%5;
        contador = contador += devolucionCinco;
        
        devolucionDos = dineroSobrante / 2;
        dineroSobrante = dineroSobrante%2;
        contador = contador += devolucionDos;
        
        devolucionUno = dineroSobrante;
        contador = contador += devolucionUno;
        
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("La vuleta es " +vuelta);
        System.out.println("Devolución de 20 céntimos " +devolucionVeinte);
        System.out.println("Devolución de 10 céntimos " +devolucionDiez);
        System.out.println("Devolucion de 5 céntimos " +devolucionCinco);
        System.out.println("Devolución de 2 céntimos " +devolucionDos);
        System.out.println("Devolución de 1 céntimo " +devolucionUno);
        System.out.println("El número devultas son " +contador);
    }
    
}
