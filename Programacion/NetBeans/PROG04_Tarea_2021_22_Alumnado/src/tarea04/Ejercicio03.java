package tarea04;

import java.util.Arrays;


/**
 * Ejercicio 3. Inversión de palabras.
 * @author Manuel Monterroso Flores
 */

public class Ejercicio03 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        // 1.- Declaración del array de objetos String de entrada
        // (Textos "Reconocer", "AMANECER", "Esto no es un palindromo",
        //    "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
        //    "A man a plan and a canal, Panama", "No deseo ese don..."
        final String [] PALABRASPARAANALIZAR = {"Reconocer", "AMANECER", "Esto no es un palindromo", "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama", 
            "A man a plan and a canal, Panama", "No deseo ese don..."};
        

        // Variables de salida
        // 2.- Declaración de un array de String para los resultados
        String [] resultados;

        
        
        // Variables auxiliares
        String [] palabras;
        StringBuilder reverse;
        String acumular2 = "";
        String pasoMedio = "";

        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("INVERSIÓN DE PALABRAS");
        System.out.println("---------------------");


        // 3.- Reservamos espacio para el array de resultados (procura no usar un literal)
        resultados = new String [PALABRASPARAANALIZAR.length];

        
        
        // 4.- Mostramos el contenido del array de textos por pantalla
        // colocando cada texto en una línea diferente
        for (int i = 0; i < PALABRASPARAANALIZAR.length; i++) {
            System.out.println("-Texto " +(i+1) +": "  +PALABRASPARAANALIZAR[i]);
        }


        
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 5.- Recorremos el array de textos.
        // Para cada texto:
        //   5.1.- obtenemos cada palabra del texto;
        //   5.2.- invertimos cada palaba del texto;
        //   5.3.- almacenamos cada palabra invertida separadas por espacios en una misma cadena.
        //         Esa cadena de palabras invertidas se almacenará en el array de resultados
            
            for (int i = 0; i < PALABRASPARAANALIZAR.length; i++) {
                //volcamos el array principal en otro para poder trabajar sin tener que modificalo,
                resultados[i] = PALABRASPARAANALIZAR[i];
                //en el array volcado del principal con una expresión regular le eliminamos todos los signos de puntuación y espacios no necesarios.
                resultados[i] = resultados[i].replaceAll("[^a-zA-Z]", " ").replaceAll("  ", " ").trim();
                
            }
            
            for (int i = 0; i < resultados.length; i++) {
                //recorremos el array para ir poniendo frase por frase en un String y luego dividirla e introducir cada trozo dentro de un array
                acumular2 ="";
                pasoMedio = resultados[i];
                palabras = pasoMedio.split("\\s");
                
                
                for (int j = 0; j < palabras.length; j++) {
                    
                    /*aquí introducimos en el StringBuilder palabra a palabra que hay dentro del array que hemos creado en el paso anterior, para luego
                    volcarlo en un String ya dado la vuelta con la instrucción reverse y una vez dado la vuelto lo vamos acumulando en otro String,
                    que luego lo iremos volcando en el array de salida.*/
                    reverse = new StringBuilder (palabras[j]);
                    reverse.reverse().toString();
                    acumular2 += reverse + " ";
                   // System.out.println(acumular2);
                    
                }
            //eliminas el espacio del final además de volcar las frases.    
            resultados[i] = acumular2.trim();    
            
        }
            
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADOS OBTENIDOS");
        System.out.println("--------------------");
        
        // 6.- Mostdramos los resultado por pantalla.
        // Recorremos el array de textos y para cada texto:
        //   6.1. Mostramos el texto original 
        //   6.2. Mostramos el texto con las palabras invertidas
        
        for (int i = 0; i < resultados.length; i++) {
            
            System.out.println("Texto " +(i+1) +": " +'"' +PALABRASPARAANALIZAR[i] +'"' );
            System.out.println("Palabra invertida: " +'"' +resultados[i] +'"' +"\n");
            
        }
        
    }
}