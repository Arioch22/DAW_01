/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author arioch
 */
public class Pruebas_Math {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int aleatorio;
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, j = 0, k = 0, l = 0, m = 0, n = 0, o = 0, p = 0, q = 0, r = 0, s = 0, t = 0, u = 0, v = 0, w = 0, x = 0, y = 0, z = 0;
        
        for (int i = 0; i < 100000; i++) {
        aleatorio = (int) Math.floor(Math.random()*21)-7;
            
        
        if (aleatorio%2 == 0 && (aleatorio > 0 || aleatorio < 0)){
            //System.out.println("El número " +aleatorio +" es par");
             }else if (aleatorio == 0){
               // System.out.println("El número es cero");
                    }else {
                           // System.out.println("El número " +aleatorio + " es impar");
                            }
        switch (aleatorio){
            case -7: 
                a ++;
                break;
            case -6:
                b ++;
                break;
            case -5:
                c ++;
            break;
            case -4:
                d ++;
            break;
            case -3:
                e ++;
            break;
            case -2:
                f ++;
            break;
            case -1:
                g ++;
            break;
            case 0:
                h ++;
            break;
            case 1:
                j ++;
            break;
            case 2:
                k ++;
            break;
            case 3:
                l ++;
            break;
            case 4:
                m ++;
            break;
            case 5:
                n ++;
            break;
            case 6:
                o ++;
            break;
            case 7:
                p ++;
            break;
            case 8:
                q ++;
            break;
            case 9:
                r ++;
            break;
            case 10:
                s ++;
            break;
            case 11:
                t ++;
            break;
            case 12:
                u ++;
            break;
            case 13:
                v ++;
            break;
                
        }
        }   
        System.out.println("El número -7 ha salido: " +a);
        System.out.println("El número -6 ha salido: " +b);
        System.out.println("El número -5 ha salido: " +c);
        System.out.println("El número -4 ha salido: " +d);
        System.out.println("El número -3 ha salido: " +e);
        System.out.println("El número -2 ha salido: " +f);
        System.out.println("El número -1 ha salido: " +g);
        System.out.println("El número  0 ha salido: " +h);
        System.out.println("El número  1 ha salido: " +j);
        System.out.println("El número  2 ha salido: " +k);
        System.out.println("El número  3 ha salido: " +l);
        System.out.println("El número  4 ha salido: " +m);
        System.out.println("El número  5 ha salido: " +n);
        System.out.println("El número  6 ha salido: " +o);
        System.out.println("El número  7 ha salido: " +p);
        System.out.println("El número  8 ha salido: " +q);
        System.out.println("El número  9 ha salido: " +r);
        System.out.println("El número 10 ha salido: " +s);
        System.out.println("El número 11 ha salido: " +t);
        System.out.println("El número 12 ha salido: " +u);
        System.out.println("El número 13 ha salido: " +v);
        
        
        
        
        
        
    }
    
}
