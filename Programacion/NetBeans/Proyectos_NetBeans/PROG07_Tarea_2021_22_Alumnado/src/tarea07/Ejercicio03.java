package tarea07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.TreeMap;

/** Ejercicio 3. Un color por día
 * @author profe
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        final int NUM_DIAS = 5;
        TreeMap<LocalDate, String> mapaTiempoColor = new TreeMap<>();
        LocalDate fecha = LocalDate.of(2022, 03, 01);
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("ASIGNACIÓN DE COLORES: UN COLOR DIFERENTE POR CADA FECHA");
        System.out.println("--------------------------------------------------------");
        // No hay entrada de datos pues la estructura se rellena elementos aleatorios
        
        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
        
            for (int i = 0; i < NUM_DIAS; i++) {
                
                    mapaTiempoColor.put(fecha.plusDays(i), Utilidades.colorAleatorio());
                }
                
            
           
            
        
        
        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        System.out.printf( "Contenido final del mapa de colores organizado por fechas:\n");

        for (LocalDate key : mapaTiempoColor.keySet()) {
            System.out.println("Fecha " + key.format(formatoFecha) + ": " + mapaTiempoColor.get(key));
        }
    }

}
