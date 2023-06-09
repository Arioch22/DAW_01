package tarea1;

/**
 * Provincias de Andalucía.
 * @author Nombre alumno/a
 */
public class Ejercicio01 {
    
    // Definición del enum
    public enum Provincias {ALMERIA,CADIZ,CORDOBA,GRANADA,HUELVA,JAEN,MALAGA,SEVILLA};

    
    // Programa principal
    public static void main(String[] args) {
        
        Provincias cordoba = Provincias.CORDOBA;
        Provincias almeria = Provincias.ALMERIA;
        Provincias cadiz = Provincias.CADIZ;
        Provincias granada = Provincias.GRANADA;
        Provincias huelva = Provincias.HUELVA;
        Provincias jaen = Provincias.JAEN;
        Provincias malaga = Provincias.MALAGA;
        Provincias sevilla = Provincias.SEVILLA;
             
        System.out.println ("PROVINCIAS DE ANDALUCÍA");
        System.out.println ("-----------------------");
        System.out.println ("01 - " + almeria);
        System.out.println ("02 - " + cadiz);
        System.out.println ("03 - " + cordoba);
        System.out.println ("04 - " + granada);
        System.out.println ("05 - " + huelva);
        System.out.println ("06 - " + jaen);
        System.out.println ("07 - " + malaga);
        System.out.println ("08 - " + sevilla);
           
        
        // Vamos mostrando cada uno de los posibles valores del enum
        // (no hace falta estructurar el programa en entrada/procesamiento/salida)

    }
    
}
