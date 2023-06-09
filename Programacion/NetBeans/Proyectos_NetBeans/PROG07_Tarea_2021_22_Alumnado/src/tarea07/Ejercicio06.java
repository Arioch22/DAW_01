package tarea07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/** Ejercicio 6. Ordenación de citas literarias
 * @author profe
 */
public class Ejercicio06{

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("ORDENACIÓN DE CITAS LITERARIAS");
        System.out.println("------------------------------");

        // Rellenamos la lista con las citas literarias
        CitaLiteraria cita1 = new CitaLiteraria("Soy el mejor en morir en la escena", "Libro 1");
        CitaLiteraria cita2 = new CitaLiteraria("El mundo acaba hoy", "Libro 1", "Libro 2");
        CitaLiteraria cita3 = new CitaLiteraria("Silba una vez y vendré siempre", "Libro 3", "Libro 4", "Libro 5");
        CitaLiteraria cita4 = new CitaLiteraria("Un invitado invita a cien");

        ArrayList<CitaLiteraria> listaLiteraria = new ArrayList<>();

        listaLiteraria.add(cita1);
        listaLiteraria.add(cita2);
        listaLiteraria.add(cita3);
        listaLiteraria.add(cita4);

        // Mostramos el contenido inicial de la lista
        for (int i = 0; i < listaLiteraria.size(); i++) {
            System.out.println(listaLiteraria.get(i));
        }

        //----------------------------------------------
        //     Procesamiento + Salida de resultados
        //----------------------------------------------
        // Ordenación de la lista por texto de la cita (alfabético) y la mostramos por pantalla
        System.out.println("\nOrdenación de la lista por texto de la cita (alfabético):");
        Collections.sort(listaLiteraria, new ComparadorCitasPorTexto());

        for (int i = 0; i < 4; i++) {

            System.out.print((i + 1) + ". ");

            System.out.println(listaLiteraria.get(i));

        }

        // Ordenación de la lista por longitud de la cita y la mostramos por pantalla
        System.out.println("\nOrdenación de la lista por longitud de la cita:");
        Collections.sort(listaLiteraria, new ComparadorCitasPorLongitud());

        for (int i = 0; i < 4; i++) {

            System.out.print((i + 1) + ". ");

            System.out.println(listaLiteraria.get(i));

        }

        // Ordenación de la lista por número de obras en las que aparece la cita y la mostramos por pantalla
        System.out.println("\nOrdenación de la lista por número de obras en las que aparece la cita:");
        Collections.sort(listaLiteraria, new ComparadorCitasPorNumObras());

        for (int i = 0; i < 4; i++) {

            System.out.print((i + 1) + ". ");

            System.out.println(listaLiteraria.get(i));

        }
    }

}


class ComparadorCitasPorNumObras implements Comparator<CitaLiteraria> {

    @Override
    public int compare(CitaLiteraria cita1, CitaLiteraria cita2) {

        int num;

        if (cita1.getUsos().size() < cita2.getUsos().size()) {

            num = -1;

        } else if (cita1.getUsos() == cita2.getUsos()) {

            num = 0;

        } else {

            num = 1;
        }

        return num;
    }
}

class ComparadorCitasPorLongitud implements Comparator<CitaLiteraria> {

    @Override
    public int compare(CitaLiteraria cita1, CitaLiteraria cita2) {

        int num;

        if (cita1.getTexto().length() < cita2.getTexto().length()) {

            num = -1;

        } else if (cita1.getTexto().length() == cita2.getTexto().length()) {

            num = 0;

        } else {

            num = 1;

        }

        return num;
    }
}

class ComparadorCitasPorTexto implements Comparator<CitaLiteraria> {

    @Override
    public int compare(CitaLiteraria cita1, CitaLiteraria cita2) {

        
            return cita1.getTexto().compareToIgnoreCase(cita2.getTexto());
    }
}

            


