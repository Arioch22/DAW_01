/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.*;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

/**
 * Programa para trabajar con imágenes.
 * @profesorado
 */
public class Ejercicio4 {

    /**
    * Método principal.
    */
    public static void main(String[] args) throws IOException {
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        final String RUTA_FOTO = System.getProperty("user.dir") + "/recursos/foto.png";
        final String RUTA_FOTO2 = System.getProperty("user.dir") + "/recursos/foto2.png";


        // Variables de entrada
       
                
        // Variables de salida
            String salidaFotoPrimera = "";
            String salidaFotoSegunda = "";
        
        // Variables auxiliares
        int alto, ancho;
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        

            
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        try {
            BufferedImage brImagen = ImageIO.read(ImageIO.createImageInputStream(new FileInputStream(RUTA_FOTO)));
            alto = brImagen.getHeight();
            ancho = brImagen.getWidth();
            salidaFotoPrimera += "alto = " +alto + "\n";
            salidaFotoPrimera += "ancho = " +ancho +"\n\n";
            for (int i = 0; i < ancho; i++) {
                for (int j = 0; j < alto; j++) {
                    Color c = new Color(brImagen.getRGB(i,j));
                    if (c.getRed() == 255 && c.getGreen() == 255 && c.getBlue() == 255) {
                        salidaFotoPrimera += " ";
                        
                        
                    }else{
                        salidaFotoPrimera += "*";
                    }
                }
             salidaFotoPrimera += "\n";   
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException i) {
            System.out.println("Error: Fallo en la escritura en el fichero.");
        }
        
        try {
            BufferedImage brImagen = ImageIO.read(ImageIO.createImageInputStream(new FileInputStream(RUTA_FOTO2)));
            alto = brImagen.getHeight();
            ancho = brImagen.getWidth();
            salidaFotoSegunda += "alto = " +alto +"\n";
            salidaFotoSegunda += "ancho = " +ancho;
            for (int i = 0; i < ancho; i++) {
                for (int j = 0; j < alto; j++) {
                    Color c = new Color(brImagen.getRGB(i,j));
                    if (c.getRed() == 255 && c.getGreen() == 255 && c.getBlue() == 255) {
                        salidaFotoSegunda += " ";
                    }else{
                        salidaFotoSegunda += "*";
                    }
                }
             salidaFotoSegunda += "\n";   
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException i) {
            System.out.println("Error: Fallo en la escritura en el fichero.");
        }
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.print(salidaFotoPrimera);
        System.out.println("\n");
        System.out.print(salidaFotoSegunda);
         
        
        System.out.println ();
	System.out.println ("Archivo cerrado y procesamento finalizado");
	System.out.println ("---------");
        
        
        System.out.println ();
	System.out.println ("Fin del programa.");
    }
}
