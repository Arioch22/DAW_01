package Ejercicio2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChipBiciIO{

    /**
     * Ruta del archivo donde se lee y escribe la colección de objetos ChipBici
     */
    private final String rutaArchivo;

    /**
     * Método constructor
     * @param archivo Ruta del archivo donde se lee y escribe la colección de objetos ChipBici
     */
    public ChipBiciIO(String archivo) {
        this.rutaArchivo = archivo;
    }
 
    /**
     * Método que lee, desde un archivo binario, una colección de objetos ChipBici serializados.
     * @return Lista de objetos ChipBici que estaba almacenada en el archivo binario.
     */
    public List leer() {
        ArrayList<ChipBici> listaSalida = new ArrayList<>();

        try ( ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream(rutaArchivo));) {
            listaSalida = ((ArrayList<ChipBici>) leyendoFichero.readObject());
            leyendoFichero.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return listaSalida;
    }

    /**
     * Método que escribe, en un archivo binario, una colección de objetos
     * ChipBici serializables.
     *
     * @param bicis Lista de objetos ChipBici serializables para almacenar en el
     * archivo binario.
     */
    public void escribir(List bicis) {

        try ( ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(rutaArchivo));) {
            // Escribo el array en el fichero
            ficheroSalida.writeObject(bicis);

            // Cerramos el fichero
            ficheroSalida.flush();
            ficheroSalida.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException i) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }
    }
}
    

