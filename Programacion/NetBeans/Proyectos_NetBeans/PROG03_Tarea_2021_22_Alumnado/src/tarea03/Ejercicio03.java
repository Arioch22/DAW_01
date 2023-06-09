package tarea03;

// Incluir los imports que se necesiten

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;




/**
 * Ejercicio 3: Horario de clases.
 *
 * @author Manuel Monterroso Flores
 */
public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes

        // Variables de entrada
        int introduccionHoras = 24, introduccionMinutos = 60;
        long resultado;

        // Variables de salida
        
        String textoSalida = "";

        // Variables auxiliares
        

        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("HORARIO DE CLASES");
        System.out.println("-----------------");

        // 1. Creación de un objeto de la clase LocalTime con la primera hors de clase (08:00)
        LocalTime horaInicio = LocalTime.of(8,00,00);
        
        // 2. Lectura por teclado y comprobación de hora y minuto
        System.out.println("Introducción del horario que desea comprobar: \n");
        
        
        // 2.1. Leer y comprobar la hora (debe estar entre 0 y 23)
        do{
            try{
                System.out.println("Introduzca hora (00 - 23): ");
                introduccionHoras = teclado.nextInt();
            }
                catch(java.util.InputMismatchException ex){
                    //System.out.println(ex);
                    System.out.println("Error de lectura: no es un número entero válido.");
                    teclado.nextLine();//Limpiamos buffer de entrada
                }
        }while (introduccionHoras < 0 || introduccionHoras > 23);

        
        
        // 2.2.  Leer y comprobar el minuto (entre 0 y 59)
        do{
            try{
                System.out.println("Introduzca minutos (00 - 59): ");
                introduccionMinutos = teclado.nextInt();
            }
            catch(java.util.InputMismatchException ex){
                System.out.println("Error de lectura: no es un número entero válido.");
                teclado.nextLine();//Limpiamos buffer de entrada
            }
        }while (introduccionMinutos < 00 || introduccionMinutos > 59);

        // 3. Creación de objeto LocalTime a partir de los datos leídos por teclado
        
        LocalTime horaIntroducida = LocalTime.of(introduccionHoras, introduccionMinutos);
        System.out.println("");
        System.out.println("Hora introducida: " +horaIntroducida);

        
        //----------------------------------------------
        //               Procesamiento 
        //----------------------------------------------
        // 4. Obtener el rango en el que se encuentra la hora a partir de los dos objetos LocalTime
        if (horaIntroducida.isBefore(horaInicio)){
            resultado = horaIntroducida.until(horaInicio, ChronoUnit.MINUTES);
            textoSalida = "Aún no ha comenzado la jornada. Faltan " +resultado +" minutos para comenzar."; 
            
        }   else if (horaIntroducida.isBefore(horaInicio.plusHours(2))){
                    textoSalida = "Programación.";
                    
            }   else if (horaIntroducida.isBefore(horaInicio.plusHours(4))){
                        textoSalida = "Sistemas Informáticos.";
                        
                }   else if (horaIntroducida.isBefore(horaInicio.plusHours(6))){
                        textoSalida = "Entornos de Desarrollo.";
                        
                    }   else {
                                resultado = horaInicio.plusHours(6).until(horaIntroducida, ChronoUnit.MINUTES);
                                textoSalida = "La joranada ya ha finalizado. Han pasado " +resultado +" minutos desde el fin.";
                        
                        }
            

        //----------------------------------------------
        //            Salida de resultados 
        //----------------------------------------------
        // 5. Mostrar la hora y introducida y los resultados obtenidos
        System.out.println("Clase correspondiente: " +textoSalida);

    }

}
