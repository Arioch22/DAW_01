
package tarea04;

import java.util.Arrays;


/**
 * Ejercicio 4. ¡Línea!
 * @author Manuel Monterroso Flores
 */

public class Ejercicio04 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        
        // 1.- Declaración del array que representa las bolas que han salido hasta el momento
        int [] numeros = {1, 2, 5, 10, 11, 12, 14, 15, 22, 55, 56, 57, 59, 60, 61, 66, 78, 89, 90};

        // 2.- Declaración del array bidimensional "irregular" de números enteros para representar el cartón
        int [][] carton = {
                 {1,  2, 5, 9},
                 {11,15},
                 {22,29},
                 {34},
                 {47,49},
                 {55,59,60},
                 {61},
                 {71,75},
                 {88,90},
                };
        
        

        // Variables de salida
        // 3.- Declaración del array unidimensional que almacenará los resultados
        String [] resultados;
        int contadorLineas = 0;
        

        
        // Variables auxiliares
        int lineaNumero = 0;
        int lineaLinea = 0;
        int contador = 0;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("BUSCADOR DE LÍNEAS EN UN CARTÓN DE BINGO");
        System.out.println("----------------------------------------");

        // 4.- Mostramos por pantalla el contenido del cartón
        System.out.println("Cartón: " +Arrays.deepToString(carton));


        // 5.- Mostramos por pantalla la lista de bolas
        System.out.println("Números que ya han salido: " +Arrays.toString(numeros) + "\n");

        
        //----------------------------------------------
        //                   Procesamiento 
        //---------------------------------------------- 
        // 6.- Reservamos espacio para el array de resultados (sin usar un literal)
        
        resultados = new String [carton.length];

        // 7.- Recorremos cada fila del cartón
        
            // 7.1.- Para cada fila, recorremos todos los números que contenga


                // 7.2.- Comprobamos si cada número ha salido o no (habrá que recorrer la lista de bolas que ya han salido)
                //       Si han salido todos, se marcará esa fila como "línea" en el array de resultados


                // 7.3.- Si no han salido todos, se marcará es fila como "no" en el array de resultados
                
                
            for (int m = 0; m < carton.length; m++) {
                contador = 0;
                for (int i = 0; i < carton[m].length; i++) {
                    /*al ir recorriendo el array introducimos cada posición vamos acumulando cada línea dentro de una variable entera,
                    que luego se resetea al terminar de recorrer cada fila.*/
                    lineaNumero =carton[m][i];
                    //System.out.println(carton[0][i]);
                    
                    for (int j = 0; j < numeros.length; j++) {
                        //Aqui vamos recorriendo la línea e introducimos cada posición del array dentro de una vasriable entera.
                        lineaLinea = numeros[j];
                        //con este if lo que conseguimos es que por cada fila del carton y recorriendo los números salidos ver cuantos números han salido de esta.
                        if (lineaNumero == lineaLinea) {
                            contador ++;
                        }
                    }
                }
                //con este if lo que hacemos es saber si han salido todos los números de cada fila para poder cantar línea y sino pues declarar que no.
                if (contador == carton[m].length) {
                    contadorLineas ++;
                    resultados[m] = "linea";
                    
                }else{
                    //System.out.println("No es linea");
                    resultados[m] = "no";
                }
            }
            
            
            
                    
        
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("Resultado de la búsqueda de líneas en el cartón de bingo:");
        
        // 8.- Mostramos por pantalla el array de resultados y cuántas líneas han salido
        System.out.println(Arrays.toString(resultados));
        System.out.println("Número de líneas obtenidas: " +contadorLineas);

        

        
    }      
}
