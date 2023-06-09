package tarea04;

import java.util.Arrays;

/**
 * Ejercicio 5. Sopa de letras.
 *
 * @author Marina Garrido Morán
 */
public class Ejercicio05 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        // 1.- Declaración del array unidimensional que contiene la listra de palabras para buscar
        String[] listaPalabrasDeseadas = {"Hola", "sol", "AMOR", "ARA", "Casa", "dos"};

        // 2.- Declaración del array bidimensional que representa la sopa de letras
        char[][] sopaDeLetras = {{'H', 'J', 'S', 'O', 'L'}, {'O', 'E', 'C', 'A', 'U'}, {'L', 'Y', 'K', 'D', 'A'}, {'A', 'A', 'M', 'O', 'R'}, {'V', 'C', 'A', 'S', 'A'}};
        // Variables de salida
        // 3.- Declaración del array unidimensional que almacena los resultados
        String[] resultado;
        int contadorPalabrasEncontradas = 0;

        // Variables auxiliares
        String palabraHorizontal;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("BUSCADOR DE PALABRAS EN HORIZONTAL");
        System.out.println("----------------------------------");

        // 4.- Mostramos por pantalla el contenido de la sopa de letras en forma de tabla
        for (int fila = 0; fila < sopaDeLetras.length; fila++) {
            for (int columna = 0; columna < sopaDeLetras[fila].length; columna++) {
                System.out.print(sopaDeLetras[fila][columna] + " ");
            }
            System.out.println();
        }

        // 5.- Mostramos por pantalla la lista de palabras
        System.out.println("Lista de palabras de prueba:");
        System.out.println(Arrays.toString(listaPalabrasDeseadas));

        //----------------------------------------------
        //  Procesamiento (implementado por los alumnos)
        //----------------------------------------------
        // 5.- Reservamos espacio para el array de resultados (sin usar un literal)
        resultado = new String[listaPalabrasDeseadas.length];

        // 7.- Exploramos la sopa de letras para buscar horizontalmente cada una de las palabras de la lista
        // 7.1.- Recorremos la lista de palabras
        //Bucle para las palabrasDeseadas
        for (int indicePalabraDeseada = 0; indicePalabraDeseada < listaPalabrasDeseadas.length; indicePalabraDeseada++) {
            //Bucle para la fila de la sopa de letras
            for (int f = 0; f < sopaDeLetras.length; f++) {
                palabraHorizontal = Arrays.toString(sopaDeLetras[f]).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
                // 7.2.- Para cada palabra, la buscamos horizontalmente (en cada fila de la sopa)
                //Si la palabra horizontal coincide con la palabra deseada de nuestra lista(true)
                //generamos otro bucle para ver en que columna esta nuestra palabra
                if (palabraHorizontal.contains(listaPalabrasDeseadas[indicePalabraDeseada].toUpperCase())) {
                    //Bucle para la columna de la sopa de letras
                    for (int c = 0; c < sopaDeLetras[f].length; c++) {
                        if (listaPalabrasDeseadas[indicePalabraDeseada].equalsIgnoreCase(palabraHorizontal.substring(c, sopaDeLetras.length))) {
                            //añadimos a nuestro array el valor de la fila y la columna
                            resultado[indicePalabraDeseada] = "fila " + f + " columna " + c;
                            contadorPalabrasEncontradas++;//+1 a nuestro contador de palabras
                            break;
                        }
                    }
                }
            }
            //cambiamos los null que tenga dentro del array de 'resultado' por 'no'
            if (resultado[indicePalabraDeseada] == null) {
                resultado[indicePalabraDeseada] = "no";
            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");

        // 8.- Mostramos por pantalla el array de resultados y cuántas palabras se han encontrado
        System.out.println("Resultado de la búsqueda horizontal:");
        System.out.println(Arrays.toString(resultado));
        System.out.println("Número de palabrasa encontradas: " + contadorPalabrasEncontradas);
    }
}
