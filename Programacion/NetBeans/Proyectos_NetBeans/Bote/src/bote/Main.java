/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bote;

/**
 *
 * @author ozymandias
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bote titan;
        int centilitros=300;
        int centimos=200;
        int metros=2;
        
        titan=new Bote(300,10,"verde",2,500);
        /*Vamos a pintar 2 metros, como hay sufuiciente pintura la operación tendrá éxito y se
        descontran 20 centilitros del contenido del bote quedan 280cl*/
        try {
            System.out.println("Vamos a pintar");
            titan.pintar(metros);
            System.out.println("En el bote quedan "+titan.getContenido()+" centilitros");
        } catch (Exception e) {
            System.out.println("Error al pintar");
        }
        /*Vamos a intentar añadir 300 centilitros al bote, como se supera la capacidad saltará
        una excepción y no se modificará el contenido del depósito que seguirá siendo 280cl*/
        try {
            System.out.println("Vamos a rellenar el bote");
            titan.rellenar(centilitros, centimos);
            System.out.println("Recarga realizada, ahora tiene "+titan.getContenido()+" centilitros en el bote");
        } catch (Exception e) {
            System.out.println("Error al rellenar el bote, el contenido sigue siendo: "+titan.getContenido());
            
        }
    }
    
}
