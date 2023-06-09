package tarea04;

import java.util.Arrays;

/**
 * Ejercicio 5. Sopa de letras.
 * @author Manuel Monterroso Flores
 */

public class Ejercicio05 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        // 1.- Declaración del array unidimensional que contiene la listra de palabras para buscar
        
        String lista [] = {"Hola", "sol", "AMOR", "ARA", "Casa", "dos"};

        // 2.- Declaración del array bidimensional que representa la sopa de letras
        
        char sopaLetras [][] = {
            {'H','J','S','O','L'},
            {'O','E','C','A','U'},
            {'L','Y','K','D','A'},
            {'A','A','M','O','R'},
            {'V','C','A','S','A'},
        };
        
        // Variables de salida
        // 3.- Declaración del array unidimensional que almacena los resultados
        String resultados [];
        int contador = 0;


        // Variables auxiliares
        String filaSopa = "";
        String palabraLista = "";
        

        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("BUSCADOR DE PALABRAS EN HORIZONTAL");
        System.out.println("----------------------------------");
        
        // 4.- Mostramos por pantalla el contenido de la sopa de letras en forma de tabla
        System.out.println("Sopa de letras.");
        for (int i = 0; i < sopaLetras.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < sopaLetras[i].length; j++) {
                System.out.print(sopaLetras[i][j] +" ");
                
            }
        }
        
        // 5.- Mostramos por pantalla la lista de palabras
        System.out.println("\n\nLista de palabras de prueba:");
        System.out.println(Arrays.toString(lista));


        //----------------------------------------------
        //  Procesamiento (implementado por los alumnos)
        //----------------------------------------------
        // 5.- Reservamos espacio para el array de resultados (sin usar un literal)
        resultados = new String [lista.length];
        
        // 7.- Exploramos la sopa de letras para buscar horizontalmente cada una de las palabras de la lista
        
            // 7.1.- Recorremos la lista de palabras

            
            // 7.2.- Para cada palabra, la buscamos horizontalmente (en cada fila de la sopa)
            
            
            for (int i = 0; i < lista.length; i++) {
                palabraLista = lista[i];
                
                    for (int j = 0; j < sopaLetras.length; j++) {
                        filaSopa = "";
                    
                         for (int k = 0; k < sopaLetras[j].length; k++) {
                            //vamos añadiendo cada char de cada línea de la sopa a un String que se resetea cuando se ha completado la fila completa.
                            filaSopa += sopaLetras[j][k];
                        
                        }
                    /*para comprobar sin problemas si la palabra de la lista esta dentro de la sopa de letras ponemos tanto la fila de la sopa como la palabra en minúsculas
                    y luego con la instrucción contains comprobamos si la palabra de la lista esta en la fila de la sopa de letras.*/
                    if (filaSopa.toLowerCase().contains(palabraLista.toLowerCase())) {
                            //System.out.println(filaSopa.length());
                            resultados[i] = "Fila: " +j +" columna: " + (filaSopa.toLowerCase().indexOf(palabraLista.toLowerCase()));
                            contador ++;
                            //creamos break para que cuando encuentre una coincidencia deje de seguir buscando.
                            break;
                            
                    }
                        
                    
                    //para que los casos que no se encuentra la palabra con esta acción hacemos que los espacios en blanco del array se rellenen con la palabra "no".
                    resultados[i] = "no";

                    }
            }
                       
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        
        // 8.- Mostramos por pantalla el array de resultados y cuántas palabras se han encontrado
        System.out.println(Arrays.toString(resultados));
        System.out.println("Número de palabras encontradas: " +contador);
        
        
    }
}
