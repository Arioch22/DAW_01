
package ejercicio3_3;
/** Se nos plantea la posibilidad de hacer un programa que calcule la calificación de un examen a partir de las preguntas acertadas, 
falladas y no contestadas.
Implementa un programa en Java que calcule la nota de un examen de tipo test de 20 preguntas.
El programa debe solicitar por teclado dos números enteros: número de preguntas acertadas y número de preguntas falladas y 
a partir de ahí calcular la nota final teniendo en cuenta que cada fallo restará la mitad de un acierto, y que obviamente las preguntas 
sin contestar ni restarán ni sumarán. La nota final deberá estar entre 0 y 10. Si la suma del número de preguntas acertadas y el número 
de preguntas falladas supera el total de preguntas (20), entonces no se llevará a cabo ningún cálculo y se mostrará por pantalla 
el mensaje "Datos erróneos". Si los datos son correctos deberán entonces calcularse la calificación no numérica del examen y mostrarse 
por pantalla ambas calificaciones: la cuantitativa (numérica) y la cualtiativa (no numérica) */

import java.util.Scanner;

 // @author Guadalupe Cano Moyano
 
public class Ejercicio3_3 {

    
    public static void main(String[] args) {
        
    //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        final int TOTAL_PREGUNTAS;

        // Variables de entrada
       
        int preguntaAcertada, preguntaFallada, noContestada;
        
        
        
        // Variables de salida
        
        double fallo;
        double calificacionCuantitativa;
        String calificacionCualitativa="";
       

        // Variables auxiliares
        
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CALIFICACIÓN DEL EXAMEN");
        System.out.println("----------------------");
        System.out.println("Introduzca el número de preguntas acertadas ");
        preguntaAcertada=teclado.nextInt();
        System.out.println("Introduzca el número de preguntas falladas");
        preguntaFallada= teclado.nextInt();
        
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
       
        
        TOTAL_PREGUNTAS= preguntaAcertada+preguntaFallada;
        if (TOTAL_PREGUNTAS > 20){
            System.out.println("Datos erróneos");
        }   
        if (TOTAL_PREGUNTAS <= 20 && TOTAL_PREGUNTAS >0){
            fallo= preguntaFallada/2;
            calificacionCuantitativa=(preguntaAcertada - fallo)/2; 
        
        if (calificacionCuantitativa < 5)
            calificacionCualitativa="Suspenso";
        
        else if (calificacionCuantitativa < 6)
            calificacionCualitativa="Suficiente";
        else if (calificacionCuantitativa < 7)
            calificacionCualitativa="Bien";
        else if (calificacionCuantitativa < 9)
            calificacionCualitativa="Notable";
        else if (calificacionCuantitativa <=10)
            calificacionCualitativa="Sobresaliente";
        
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
        System.out.println ();
	System.out.println ("RESULTADO");
	System.out.println ("---------");
        System.out.println("La nota numérica total es " + calificacionCuantitativa);
        System.out.println("La nota cuantitativa total es " + calificacionCualitativa);
        
        
        System.out.println ();
	System.out.println ("Fin del programa.");
        
        } 
    }
}
    

