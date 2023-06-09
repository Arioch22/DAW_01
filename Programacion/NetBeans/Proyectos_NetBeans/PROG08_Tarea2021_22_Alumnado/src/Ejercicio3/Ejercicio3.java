/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Programa para trabajar con archivos XML.
 * @profesorado
 */
public class Ejercicio3 {
    
    /**
    * Método principal.
    */
    public static void main(String args[]){
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        String ruta = System.getProperty("user.dir") + "/recursos/BDBicis.xml";
        List<ChipBici> misBicis=null;
        ChipBiciXML bd = null;
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
        
        bd = new ChipBiciXML(ruta);
        
        System.out.printf("He creado y almaceno en el archivo %d bicis.\n",misBicis.size());
        System.out.println("LISTADO DE BICIS GUARDADAS EN FICHERO:");
        System.out.println(misBicis.toString().replace("[", "").replace("]", "").replace(", {", "{").replace("}", "}\n"));
        

        bd.escribir(misBicis);

          
        misBicis.add(new ChipBici());
        misBicis.add(new ChipBici());
        
        System.out.printf("Ahora inserto 2 bicis más. Tengo ahora %d bicis.\n",misBicis.size());
        System.out.println("LISTADO DE BICIS GUARDADAS EN EL ARRAYLIST:");
        System.out.println(misBicis.toString().replace("[", "").replace("]", "").replace(", {", "{").replace("}", "}\n"));
        
        bicisBD=null;

        bicisBD = bd.leer();
 
        System.out.printf("Leo del archivo %d bicis.\n",bicisBD.size());
        System.out.println("LISTADO DE BICIS GUARDADAS EN FICHERO:");
        System.out.println(bicisBD.toString().replace("[", "").replace("]", "").replace(", {", "{").replace("}", "}\n"));
    }
}
