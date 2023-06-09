/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea07;

/**
 * Clase Utilidades
 * @author profe
 */
public class Utilidades {

    private static String[] arrayColores = {"NGR", "BLA", "ROJ", "VER", "AZL", "AMR"};

    /** Devuelve un texto de tres letras que representa un color aleatorio.
     * 
     * @return un texto de tres letras que representa un color aleatorio
     */
    public static String colorAleatorio() {
        
        int aleatorio = (int) (Math.random() * arrayColores.length);
        return arrayColores[aleatorio];
    }
    

}
