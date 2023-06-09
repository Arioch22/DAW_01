package ejercicio02;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Dado un array de cadenas que suponen presuntas fechas que pueden ser válidas
 * o no, hacer un programa que recorra el array de cadenas. Para cada fecha, si
 * es válida debe introducir en el array resultado que es de tipo LocalDate, la
 * fecha correcta en esa posición. Si la cadena no es ua fecha válida, entonces
 * introducirá la fecha de hoy más el número de días correspondientes al
 * contador del bucle.
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");

        String[] arrayFechasCadenas = {"2018-10-30", "2019-20-23", "2022-03-17",
            "2021-11-30", "2022-01-33", "2022-02-29"};
        LocalDate[] resultado = new LocalDate[arrayFechasCadenas.length];

        for (int i = 0; i < resultado.length; i++) {
            try {
                resultado[i] = LocalDate.parse(arrayFechasCadenas[i], formatter);
            } catch (DateTimeParseException e) {
                resultado[i] = LocalDate.now().plusDays(i);
            }
        }

    }
}
