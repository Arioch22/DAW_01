package tarea07;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/** Ejercicio 5. Clasificación de fechas por día de la semana
 * @author profe
 */
public class Ejercicio05 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int YEAR_MIN = 1900;
        final int YEAR_MAX = 2100;
        TreeMap<Month, Map<DayOfWeek, Set<LocalDate>>> calendario= new TreeMap<>();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner teclado = new Scanner(System.in);
        LocalDate fecha;
        int year;



        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("CLASIFICACIÓN DE FECHAS DE UN AÑO POR DÍA DE LA SEMANA");
        System.out.println("------------------------------------------------------");

        do {
            System.out.println("Introduzca año (1900-2100): ");
            year = teclado.nextInt();
        } while (year < YEAR_MIN || year > YEAR_MAX);

        fecha = LocalDate.of(year, 01, 01);

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------


        for (int i = 0; i < fecha.lengthOfYear(); i++) {
            fecha = fecha.plusDays(1);
            
            if(!calendario.containsKey(fecha.getMonth())){
                calendario.put(fecha.getMonth(), new TreeMap<>());
            }
            if (!calendario.get(fecha.getMonth()).containsKey(fecha.getDayOfWeek())) {
                calendario.get(fecha.getMonth()).put(fecha.getDayOfWeek(), new TreeSet<>());
                
            }
            
            calendario.get(fecha.getMonth()).get(fecha.getDayOfWeek()).add(fecha);
            
        }

        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        System.out.println("MUESTREO DE FECHAS");
        System.out.println("------------------");

        System.out.println();
        System.out.printf("Fechas de febrero que caen en lunes: \n");

        Iterator<LocalDate> it = calendario.get(Month.FEBRUARY).get(DayOfWeek.MONDAY).iterator();
        while (it.hasNext()) {
            System.out.println(it.next().format(formatoFecha));
        }

        System.out.println();
        System.out.printf("Fechas de marzo que caen en jueves: \n");

        Iterator<LocalDate> it2 = calendario.get(Month.MARCH).get(DayOfWeek.THURSDAY).iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next().format(formatoFecha));
        }

        System.out.println();
        System.out.printf("Fechas de diciembre que caen en domingo: \n");

        Iterator<LocalDate> it3 = calendario.get(Month.DECEMBER).get(DayOfWeek.SUNDAY).iterator();

        while (it3.hasNext()) {
            System.out.println(it3.next().format(formatoFecha));
        }
    }

}
