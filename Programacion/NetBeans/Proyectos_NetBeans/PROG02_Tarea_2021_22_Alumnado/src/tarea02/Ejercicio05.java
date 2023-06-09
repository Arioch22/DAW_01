package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 5: construcción de cajas.
 * 
 * @author Manuel Monterroso Flores
 */
public class Ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        final String CRUZ = "+";
        final String LINEA = "-";
        final String BARRA = "|";
        final int NUM_MIN_FILAS = 2;
        final int NUM_MAX_FILAS = 10;
        final int NUM_MIN_COLUM = 2;
        final int NUM_MAX_COLUM = 10;
        //probando la salida por colores
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_PINK = "\u001B[32m";

        // Variables de entrada
        int columnas,filas,relleno;

        // Variables de salida
        String salida = "";
        String tipoRelleno = "";

        // Variables auxiliares
        
        
        // Clase Scanner para petición de datos
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CONSTRUCCIÓN DE CAJAS");
        System.out.println("---------------------");
        System.out.println();
        
        do {
            System.out.println("Introduzca números de filas entre 2 - 10");
            filas = teclado.nextInt();
            System.out.println();
        
        } while ((filas < NUM_MIN_FILAS || filas > NUM_MAX_FILAS));
        
        do {
            System.out.println("Introduzca números de columnas entre 2 - 10.");
            columnas = teclado.nextInt();
            System.out.println();
        
        } while (columnas < NUM_MIN_COLUM || columnas > NUM_MAX_COLUM);
        
        System.out.println("Si no desea el cajon relleno introduzca 0, sino cualquier número para rellenar la caja");
        relleno = teclado.nextInt();
        //Pongo un switch para poner otro tipo de condicional y no sean todos if/else.
        switch (relleno){
            case 0:
                tipoRelleno = "vacia";
            break;
            default:
                tipoRelleno = "rellena";
        }
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++){
                
                /*Tomo la tabla como si fuera una matriz considerando la esquina izquierda como el punto 0,0 y n -> filas M -> columnas
                por tanto en la primera condición declaro las cuatro esquinas para que se pinten las cruces, en la segunda condición
                declaro el rango de los laterales superiores e inferior que son del lateral izquierdo del 0,1 al 0,M-2 y del lateral derecho del n-1,1 al n-1,M-2
                y ya por último los laterales que serían del 1,0 al n-2,0 y el otro lateral que es 1,M-2 hasta n-2,M-2 */
                if ((i == 0 && j == 0) || (i == 0 && j == columnas-1) || (i == filas -1 && j == 0) || (i == filas-1 && j == columnas-1)){
                    salida += ANSI_RED + CRUZ;
                    }else if( (i == 0 && (j >0 && j < columnas - 1)) || (i == filas -1 && (j < columnas -1 && j > 0)) ){
                        salida += ANSI_RED + LINEA;
                            }else if (j == 0 && (i > 0 && i < filas -1) || (j == columnas -1 && (i > 0 && i < filas -1))){ 
                                    
                                salida +=  ANSI_RED + BARRA;
                            }
                else {
                    /*como ya solo falta por declarar el espacio interior de la caja creo un switch para que si en la introdución de datos
                    de la parte de relleno si se pone 0 se rellene con espacios y si se pone cualquier número, se rellene con el 
                    número de la fila*/
           
                    if (relleno == 0){
                        salida += " ";
                    }    
                    else {
                            salida += ANSI_PINK + i;
                    }
                }
                
            if (j == columnas -1) salida += "\n";
            /*para crear un salto de línea al final de cada columna lo hago con este condicional que hace que cuando se llegue al relleno del final de la línea o ultima posición
            de la columna realize el sato de línea.*/

            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println();
        System.out.println("Caja de tamaño " + filas + " x " + columnas + " y " + tipoRelleno);
        System.out.println();
        System.out.println(salida);
    }

}
