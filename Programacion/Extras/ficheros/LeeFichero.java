package ficheros;

import java.io.*;

public class LeeFichero {

    public static void main(String args[]) {
        String nombreF;
        InputStreamReader flujo1 = new InputStreamReader(System.in);
        BufferedReader t = new BufferedReader(flujo1);
        try {
            System.out.println("Nombre del fichero");
            nombreF = t.readLine();
            File canal1 = new File(nombreF);
            FileInputStream flujo2 = null;
            if (canal1.canRead()) {
                flujo2 = new FileInputStream(canal1);
                byte[] a = new byte[1];
                int nCaracteres;
                int i = 0;
                while ((nCaracteres = flujo2.read(a)) != -1) {
                    String c;
                    c = new String(a);
                    System.out.print(c);
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el fichero");
        }
    }
}
