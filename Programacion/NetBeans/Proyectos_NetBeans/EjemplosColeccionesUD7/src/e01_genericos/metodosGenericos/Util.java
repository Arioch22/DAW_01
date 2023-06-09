package e01_genericos.metodosGenericos;

/**
 *
 * @author Trassierra
 */
public class Util {

    public static String compararTamano(Object[] a, Object[] b) {
        System.out.println("\n\nNORMAL - uso array de Objects");

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        return (a.length - b.length) > 0 ? "El primer array tiene " + (a.length - b.length) + " elementos más que el segundo"
                : (a.length - b.length) == 0 ? "Los dos arrays tienen los mismos elementos"
                        : "El segundo array tiene " + (a.length - b.length) + " elementos más que el primero";
    }
}
