package examenfeb;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *   Programa para analizar códigos de productos
 */
    public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        
        String palabra ="";
        int calculo = 0;
        char letra;
        String salida = "";
        String [] cadena;
        String [] calculoLetra;


        // Variables de entrada
        String[] productos= {"SP1234A", "aM5544I", "AO5925N", "O26232A", "AT5425G", 
            "SM4285J", "sp1599A", "SP12341B", "SP111C"};        
        
      //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("EJERCICIO DE ANÁLISIS DE CÓDIGOS DE PRODUCTOS INFORMÁTICOS");
        System.out.println("----------------------------------------------------------");
        System.out.printf ("Se analizarán los siguientes códigos de producto: \n%s\n",
                Arrays.toString(productos));
        System.out.println();
        
        calculoLetra = new String [productos.length];
        
        Pattern p = Pattern.compile("[AaSs]{1}[TtPpMm]{1}[0-9]{4}[A-J]{1}");
        
        for (int r = 0; r < 9; r++) {
            Matcher m = p.matcher(productos[r]);
            //calculo = 0;
            if (m.matches()) {

                for (int i = 0; i < productos[r].length(); i++) {
                    palabra = productos[r].replaceAll("[^0-9]", "");
                    //System.out.println(palabra);
                    calculo = 0;
                    }
                    for (int j = 0; j < palabra.length(); j++) {
                        letra = palabra.charAt(j);
                        //System.out.println(letra);
                        int iTest = Character.getNumericValue(letra);
                        //calculo = 0;
                        calculo += iTest;
                        }
                    break;
                    
                }else{
                    
                        System.out.println("no válido");
                    
                }
            System.out.println(calculo);
            //System.out.println(salida);
            }
        }
        
        
       
       
  
        
    }
    