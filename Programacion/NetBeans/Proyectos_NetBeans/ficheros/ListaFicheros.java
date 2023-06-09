package ficheros;

import java.io.File;

public class ListaFicheros {

    public static void main(String args[]) {
        File canal = new File("./src/ficheros/");
        File[] lista = canal.listFiles();
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
    }
}
