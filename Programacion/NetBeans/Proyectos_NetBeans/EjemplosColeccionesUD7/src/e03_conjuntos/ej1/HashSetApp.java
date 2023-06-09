package e03_conjuntos.ej1;

import java.util.*;

/**
 * Ejemplo de uso de la implementación HashSet
 *
 * @author Trassierra
 */
public class HashSetApp {

    public static void main(String[] args) {

        // Crea un HashSet con capacidad inicial para 16 elementos
        // y un factor de carga de 0.75
        // El factor de carga es a partir de que porcentaje de relleno
        // el hashset amplía su tamaño
        Set<String> hashSet = new HashSet<>();

        // En la línea anterior hemos podido apreciar:
        // - El uso de genéricos
        // - El operador diamond <> para tener una sentencia menos "verbose"
        hashSet.add("Cadena 1");
        hashSet.add("Cadena 2");
        // Los valores repetidos simplemente se descartan
        hashSet.add("Cadena 2"); // Valor repetido
        hashSet.add("Cadena 3");

        for (String s : hashSet) {
            System.out.println(s);
        }

        System.out.println("\n\n\n");

        // EJEMPLO DE APLICACIÓN: eliminación de duplicados en otra colección
        // Crearemos un HashSet (desordenado) a partir de otra colección 
        // Se eliminarán los duplicados que contenga (es un conjunto)
        Collection<String> palabrasDelQuijote = palabrasQuijote();      // no hay problema con las repetidas (todas las palabras)
        Set<String> quijoteHashSet = new HashSet<>(palabrasDelQuijote); // conjunto con las palabras anteriores (sin las repetidas)

        // Se puede comprobar si contiene algún elemento
        if (quijoteHashSet.contains("hidalgo")) {
            System.out.println("Contiene la palabra hidalgo");
        } else {
            System.out.println("No contiene la palabra hidalgo");
        }

        // Comparación de número de elementos
        System.out.println("Total de palabras en el 1º párrafo: " + palabrasDelQuijote.size()); // 216
        System.out.println("Palabras diferentes en el 1º párrafo: " + quijoteHashSet.size());   // 135

        // Imprimir todos los elementos del hashset
        System.out.println("\n");
        for (String palabra : quijoteHashSet) {
            System.out.println(palabra);
        }

    }

    public static Collection<String> palabrasQuijote() {
        String quijote = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza "
                + "en astillero, adarga antigua, rocín flaco y galgo corredor. Una olla de algo más vaca que carnero, salpicón las más noches, "
                + "duelos y quebrantos los sábados, lantejas los viernes, algún palomino de añadidura los domingos, consumían las tres partes de "
                + "su hacienda. El resto della concluían sayo de velarte, calzas de velludo para las fiestas, con sus pantuflos de lo mesmo, "
                + "y los días de entresemana se honraba con su vellorí de lo más fino. Tenía en su casa una ama que pasaba de los cuarenta, y "
                + "una sobrina que no llegaba a los veinte, y un mozo de campo y plaza, que así ensillaba el rocín como tomaba la podadera. "
                + "Frisaba la edad de nuestro hidalgo con los cincuenta años; era de complexión recia, seco de carnes, enjuto de rostro, gran "
                + "madrugador y amigo de la caza. Quieren decir que tenía el sobrenombre de Quijada, o Quesada, que en esto hay alguna diferencia "
                + "en los autores que deste caso escriben; aunque por conjeturas verosímiles se deja entender que se llamaba Quijana. Pero esto "
                + "importa poco a nuestro cuento: basta que en la narración no se salga un punto de la verdad.";
        quijote = quijote.toLowerCase().replace(".", "").replace(",", "");
        return Arrays.asList(quijote.split(" "));
    }
}
