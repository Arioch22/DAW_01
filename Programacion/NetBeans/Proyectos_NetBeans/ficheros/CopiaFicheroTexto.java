package ficheros;

import java.io.*;

public class CopiaFicheroTexto {

    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("Debe usarse: java "
                    + "CopiaFicheroTexto <origen> <destino>");
        } else {
            try {
                FileReader flE = new FileReader(args[0]);
                BufferedReader fE = new BufferedReader(flE);

                FileWriter flS = new FileWriter(args[1]);
                BufferedWriter fS = new BufferedWriter(flS);

                String texto = "";
                while (texto != null) {
                    texto = fE.readLine();
                    if (texto != null) {
                        fS.write(texto);
                        fS.newLine();
                    }
                }
                System.out.println("Creado: " + args[1]);
                fS.close();
            } catch (IOException e) {
                System.out.println("Error en la lectura "
                        + "o escritura de ficheros");
            }
        }
    }
}
