package tarea02;

import java.util.Scanner;

/**
 *
 * Ejercicio 2: Análisis del año.
 * 
 * @author Manuel Monterroso Flores
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // para que sea facil cambiar el año actual creo esta constante.
        final int FECHA_ACTUAL = 2021;
        
        //variables de entrada
        int fechaIntroducida;
        
        //variables auxiliares
        int calculoFechaPasada = 0;
        
        //variables salida
        String fecha = "";
        
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ANÁLISIS DEL AÑO");
        System.out.println("----------------");
        System.out.println("Introduzca un año (entre 1801-2100):");
        fechaIntroducida = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        if (fechaIntroducida < 1801 || fechaIntroducida > 2100) {
            fecha = ("Fecha incorrecta, reinicie el programa");
            //aqui compruebo que el año introducido esté dentro de los parámetros
            
            } else if (fechaIntroducida <= 1900){
                calculoFechaPasada = FECHA_ACTUAL - fechaIntroducida;
                fecha = ("El año introducido es anterior al actual, han pasado " +calculoFechaPasada +" años \nEl año pertenece al siglo XIX");
                //como ya ha pasado el filtro de los parámetros para saber si el año introducido es del siglo XIX sólo tiene que ser igual o inferior al año 1900
                
                }else if (fechaIntroducida <= 2000){
                    calculoFechaPasada = FECHA_ACTUAL - fechaIntroducida;
                    fecha = ("El año introducido es anterior al actual, han pasado " +calculoFechaPasada +" años \nEl año pertenece al siglo XX");
                    /*al igual que con el siglo XIX solo hace falta para saber si es del siglo XX que séa igual o inferior al año 2000
                    ya que si fuera inferior al año 1901 entraría en la primera condición y no se ejecutaría las siguientes.*/
                    
                    }else if (fechaIntroducida < FECHA_ACTUAL){
                        calculoFechaPasada = FECHA_ACTUAL - fechaIntroducida;
                        fecha = ("El año introducido es anterior al actual, han pasado " +calculoFechaPasada +" años \nEl año pertenece al siglo XXI");
                        /*aqui para el cálculo del siglo XXI lo mismo que en los casos anteriores, pero hago un corte con la constante FECHA_ACTUAL
                        para que haga el calculo correcto de los años y no pueda salir negativo si se pone un año superior al actual.*/
                        
                        }else if (fechaIntroducida == FECHA_ACTUAL){
                            calculoFechaPasada = 0;
                            fecha = ("El año introducido coincide con el actual \nEl año pertenece al siglo XXI");
                            //aqui creo la excepción para el año que se haya puesto como ACTUAL.
                            }else{
                                calculoFechaPasada =   fechaIntroducida - FECHA_ACTUAL;
                                fecha = ("El año introducido es posterior al actual han pasado " +calculoFechaPasada +" años \nEl año pertenece al siglo XXI");
                                //como ya solo faltan las fechas desde la posterior de la ACTUAL hasta la fecha final de los parámetros introducidos lo meto todo en el else
                            }
                        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        //como en cada caso del condicional if he hecho que toda la información se meta en una variable, ahora solo hay que imprimir.
        System.out.println(fecha);
    }
}
