package ejercicio04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * Dada la clase Persona que se te da ya en el ejercicio (atributos: nombre,
 * edad). Crear una lista enlazada LinkedList Rellenar la lista con los
 * siguintes valores (ver la hoja de examen). Recorrer la lista de modo que si
 * la edad de la persona es mayor o igual que 18, añada una línea en el fichero
 * de texto adultos.txt y si es menor añada una línea en el fichero de texto
 * jovenicos.txt
 *
 *
 * @author
 */
public class Ejercicio04 {

    public static void main(String[] args) throws IOException {

        System.out.println("-- De Lista a fichero de TEXTO --");
        System.out.println("---------------------------------");

        LinkedList<Persona> lista = new LinkedList<>();

        lista.add(new Persona("Arturo", 25));
        lista.add(new Persona("Diana", 24));
        lista.add(new Persona("Vicente", 7));
        lista.add(new Persona("Carlos", 3));
        lista.add(new Persona("Ada", 49));
        
        // Para mostrar la salida al igual que está en el examen
        lista.forEach(persona -> {
            System.out.println(persona.toString());
        });

        try ( FileWriter adultos = new FileWriter(System.getProperty("user.dir") + "/recursos/adultos.txt");  
              PrintWriter escribirAdultos = new PrintWriter(adultos, true); 
              FileWriter jovenes = new FileWriter(System.getProperty("user.dir")+"/recursos/jovenicos.txt"); 
              PrintWriter escribirJoven = new PrintWriter(jovenes, true)) {
            
            lista.forEach(persona -> {
                if (persona.getEdad() >= 18){
                    escribirAdultos.println(persona.toString());
                }else{
                    escribirJoven.println(persona.toString());
                }
                
            });
        } catch (IOException e) {
            System.out.println("Error al escribir los datos en el archivo adultos.txt");
        }
    }

}
