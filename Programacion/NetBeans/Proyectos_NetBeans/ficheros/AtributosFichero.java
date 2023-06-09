package ficheros;

import java.io.*;

public class AtributosFichero {

    public static void main(String args[]) {
        String nombreF;
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        try {
            System.out.println("Introduce el nombre del fichero");
            nombreF = teclado.readLine();
            File f = new File(nombreF);
            System.out.println("Nombre: " + f.getName());
            System.out.println("Camino: " + f.getPath());
            if (f.exists()) {
                System.out.println("El fichero existe");
                if (f.canRead()) {
                    System.out.println("Se puede leer");
                }
                if (f.canWrite()) {
                    System.out.println("Se puede modificar");
                }
                System.out.println("La longitud del fichero es:"
                        + f.length() + " bytes");
            } else {
                System.out.println("El fichero no existe.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
