/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasdelecturas;

/**
 *
 * @author arioch
 */
//Ejemplo de try with resources
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class pruebasdelecturas {

    public static void main(String[] args) {     
 
//       Scanner sc = new Scanner(System.in);
//        String cadena;
//        String direccionArchivo;
//        System.out.println("Introduce dirección del archivo");
//        direccionArchivo = sc.nextLine();
//        File archivo = new File (direccionArchivo);
//        
//        
//        
//        if (!archivo.exists()) {
//        
//            PrintWriter archivo = new PrintWriter("/home/arioch/Escritorio/datos.txt"));              
//            System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
//            cadena = sc.nextLine();
//            while (!cadena.equalsIgnoreCase("FIN")) {                                                             
//                salida.println(cadena);
//                cadena = sc.nextLine();
//            }
//           
//        }
//        
////        else if{
////        try { //try with resources
////             PrintWriter salida = new PrintWriter(fw)) {
////             System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");                         
////             cadena = sc.nextLine();
////             while (!cadena.equalsIgnoreCase("FIN")) {
////                     salida.println(cadena);
////                     cadena = sc.nextLine();
////             }
////        } catch (IOException ex) {
////            System.out.println(ex.getMessage());                                                                  
////        }
////        }
//    }
//    }

 File f = new File("/home/arioch/Escritorio/datos.txt");
        String cadena;
        Scanner entrada = null;
  
        try {
            entrada = new Scanner(f);         //se crea un Scanner asociado al fichero
            while (entrada.hasNext()) {       //mientras no se alcance el final del fichero                       
                cadena = entrada.nextLine();  //se lee una línea del fichero
                System.out.println(cadena);   //se muestra por pantalla                                           
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally{
            entrada.close();                                                                                      
        }  
    }
}

