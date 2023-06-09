package examenfeb;


import java.util.Arrays;

/**
 *   Programa
 */

    public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int[] arrayEnteros1= {1, 8, 3, 1, 3, 7, 5, 2, 4, 6 };
        int[] arrayEnteros2= {3, 4, 5, 6, 2, 5, 1, 7, 5, 5 };
        
        
     
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("EJERCICIO DE ARRAYS");
        System.out.println("-------------------");
        System.out.printf ("Array 1:         %s\n", Arrays.toString(arrayEnteros1));
        System.out.printf ("Array 2:         %s\n", Arrays.toString(arrayEnteros2));

        
        
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        int suma1 = 0;
        int suma2 = 0;
        int suma3 = 0;
        int[] paso;
        paso = new int[arrayEnteros1.length];
        int[] arrayResultado;
        arrayResultado = new int[arrayEnteros1.length];

        for (int i = 0; i < arrayEnteros1.length; i++) {
            suma1 += arrayEnteros1[i];

        }
        for (int i = 0; i < arrayEnteros2.length; i++) {
            suma2 += arrayEnteros2[i];
        }
        for (int i = 0; i < 10; i++) {

            if (i == 0) {
                arrayResultado[i] = suma1;

            } else if (i == 9) {
                arrayResultado[i] = suma2;

            } else if (arrayEnteros1[i] > arrayEnteros2[i]) {

                arrayResultado[i] = arrayEnteros1[i];

            } else if (arrayEnteros2[i] > arrayEnteros1[i]) {
                arrayResultado[i] = arrayEnteros2[i];
            }

        }
        
        for (int i = 0; i < arrayResultado.length; i++) {
            
            suma3 += arrayResultado[i];
            
        }
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
        System.out.println ();
	System.out.println ("RESULTADO");
	System.out.println ("---------");
        System.out.println(Arrays.toString(arrayResultado));
        System.out.println("Suma del array resultado: " +suma3);
       
        
    }
    
}