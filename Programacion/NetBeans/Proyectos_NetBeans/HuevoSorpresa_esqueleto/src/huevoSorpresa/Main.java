/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huevoSorpresa;

import java.util.Scanner;

/**
 *
 * @author sonia
 */
public class Main {
     public static void main(String[] args) {
        HuevoSorpresa_esqueleto miHuevoSorpresa;
        float monedero=10;
        
        miHuevoSorpresa = new HuevoSorpresa_esqueleto(20,1,"Peppa Pig",2);
        try 
        {
            System.out.println("Sacar Huevos Sorpresa");
            System.out.println("Indica el número de huevos a sacar:");
            Scanner s = new Scanner(System.in);

        int num = s.nextInt();
            miHuevoSorpresa.sacarHuevosSorpresas(num, monedero);
            monedero=monedero-num;
            System.out.println("Le quedan: " + monedero +"€");
        } catch (Exception e)
        {
            System.out.print("Fallo al intentar sacar Huevos Sorpresa" + e);
        }
        
    }
}
