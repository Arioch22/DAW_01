/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Programa para trabajar con archivos binarios y objetos serializables.
 * @profesorado
 */
public class Ejercicio2 {
    
    /**
    * Método principal.
     * @param args
    */
    public static void main(String args[]){
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        String ruta = System.getProperty("user.dir") + "/recursos/BDBicis.txt";
        List<ChipBici> misBicis=null;
        ChipBiciIO bd = null;
        List bicisBD = null;
        
        // Variables de salida

        // Variables auxiliares
        
        //----------------------------------------------
        //                 Entrada de datos + Procesamiento + Salida 
        //----------------------------------------------
        misBicis = new ArrayList<>();
        misBicis.add(new ChipBici());
        misBicis.add(new ChipBici());
        misBicis.add(new ChipBici());
        
        bd = new ChipBiciIO(ruta);
        
        System.out.printf("He creado y almaceno en el archivo %d bicis.\n",misBicis.size());
        System.out.println("LISTADO DE BICIS GUARDADAS EN FICHERO:");
        System.out.println(misBicis.toString().replace("[", "").replace("]", "").replace(", {", "{").replace("}", "}\n"));
        
        bd.escribir(misBicis);
          
        misBicis.add(new ChipBici());
        misBicis.add(new ChipBici());
        
        System.out.printf("Ahora inserto 2 bicis más. Tengo ahora %d bicis.\n",misBicis.size());
        System.out.println("LISTADO DE BICIS GUARDADAS EN EL ARRAYLIST:");
        System.out.println(misBicis.toString().replace("[", "").replace("]", "").replace(", {", "{").replace("}", "}\n"));
        
        bicisBD = bd.leer();
        System.out.printf("Leo del archivo %d bicis.\n",bicisBD.size());
        System.out.println("LISTADO DE BICIS GUARDADAS EN FICHERO:");
        System.out.println(bicisBD.toString().replace("[", "").replace("]", "").replace(", {", "{").replace("}", "}\n"));
        
    }
}
