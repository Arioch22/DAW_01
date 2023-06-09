
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author arioch
 */
public class Ejercicio_3_3 {

    public static void main(String[] args) {
        // Clase Scanner para peticiÃ³n de datos de entrada
        Scanner teclado = new Scanner(System.in);

        int noContestadas;
        float acertadas=-1f, falladas=-1f;
        float acertadas2, falladas2, nota;

        final int PREGUNTASEXAMEN = 20;

        while ((acertadas < 0 || falladas < 0) || ((acertadas%1) > 0 || (falladas%1) > 0)) {
            System.out.println("Ingresa el número de preguntas acertadas");
            acertadas = teclado.nextFloat();
            System.out.println("Ingresa el número de preguntas falladas");
            falladas = teclado.nextFloat();
            
        }
        
        
            noContestadas = (int) (PREGUNTASEXAMEN - (acertadas + falladas));
            
            if (noContestadas < 0) {
                System.out.println("Error en la introducción de datos.");
            } else {

                falladas2 = (falladas * 0.25f);
                acertadas2 = (acertadas * 0.5f);
                nota = acertadas2 - falladas2;
                //System.out.println("esta es tu nota: " + nota);

                if (nota <= 0) {
                    System.out.println("Su nota cualitativa es INSUFICIENTE");
                    System.out.println("Su puntuación ha sido de 0");

                } else if (nota > 0 && nota < 5) {
                    System.out.println("Su nota cualitativa es de INSUFICIENTE");
                    System.out.println("Su puntuación ha sido de " + nota);
                } else if (nota >= 5 && nota < 6) {
                    System.out.println("Su nota cualitatica es de SUFICIENTE");
                    System.out.println("Su puntuación ha sido de: " + nota);
                } else if (nota >= 6 && nota < 7) {
                    System.out.println("Su nota cualitatica es de BIEN");
                    System.out.println("Su puntuación ha sido de: " + nota);
                } else if (nota >= 7 && nota < 9) {
                    System.out.println("Su nota cualitativa es de NOTABLE");
                    System.out.println("Su puntuación ha sido de: " + nota);
                } else if (nota >= 9 && nota <= 10) {
                    System.out.println("Su nota cualitativa es de SOBRESALIENTE.");
                    System.out.println("Su puntuación ha sido de " + nota);
                }
            }
        }

    }
