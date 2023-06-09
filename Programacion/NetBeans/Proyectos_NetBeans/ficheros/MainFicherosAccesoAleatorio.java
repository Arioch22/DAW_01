package ficheros;

import java.util.*;

public class MainFicherosAccesoAleatorio {

    public static void main(String argumentos[])
            throws Exception {
        Scanner sc = new Scanner(System.in);
        TablaFicheroAccesoAleatorio t = new TablaFicheroAccesoAleatorio("Datos.dir");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        System.out.print("Peso: ");
        double peso = sc.nextDouble();
        int nR = t.dameNumeroRegistros();
        nR++;
        t.escribeRegistro(nombre, edad, peso, nR);

        for (int i = 1; i <= nR; i++) {
            ClaseRegistro r = t.leeRegistro(i);
            System.out.println(r.muestraRegistro());
        }
        t.cierraTabla();
    }
}
