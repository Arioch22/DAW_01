package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 3: Valor de un naipe en el juego del tute.
 * 
 * @author Manuel Monterroso Flores
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        //creo un valor contante para cada carta con valor, por si algún día se cambian las puntiaciones sea facil su cambio.
        final int VALOR_CERO = 0;
        final int VALOR_AS= 11;
        final int VALOR_TRES = 10;
        final int VALOR_SOTA = 2;
        final int VALOR_CABALLO = 3;
        final int VALOR_REY = 4;
        final int NAIPE_SIN_VALOR = -1;

        
        // Variables de entrada
        int valorCarta;
        
        // Variables de salida
        int valorFinal;

        // Variables auxiliares

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("VALOR DE UN NAIPE EN EL TUTE");
        System.out.println("----------------------------");
        System.out.println("Introduzca valor carta del 1 al 7 o del 10 al 12");
        valorCarta = teclado.nextInt();
                
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //como las cartas 2,4,5,6 y 7 tienen el mismo valor hago un conjunto con todos esos casos para ahorrar líneas de código
        switch (valorCarta){
            case 2: case 4: case 5: case 6: case 7:
              valorFinal = VALOR_CERO;
            break;
                case 1:
                    valorFinal = VALOR_AS;
                break;
                    case 3:
                        valorFinal = VALOR_TRES;
                    break;
                        case 10:
                            valorFinal = VALOR_SOTA;
                        break;
                            case 11:
                                valorFinal = VALOR_CABALLO;
                            break;
                                case 12:
                                  valorFinal = VALOR_REY;
                                break;
            default:
                //tras declarar todas las cartas que poseen valor, aqui declaro el resto de las cartas.
                valorFinal = NAIPE_SIN_VALOR;
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        //como he añadido el valor de la carta a una variable, ahora solo hay que imprimirla.
        System.out.println("EL valor del naipe es: " +valorFinal +" puntos.");
    }
}
