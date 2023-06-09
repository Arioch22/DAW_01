package e01_genericos.metodosGenericos;

/**
 *
 * @author Trassierra
 */
public class Main {

    public static void main(String[] args) {

        Integer[] a = {0, 1, 2, 3, 4};
        Integer[] b = {0, 1, 2, 3, 4, 5, 6, 7};
        Double[] c = { 0d, 1d, 2d };
        String [] textos = {"hola", "adios"};
        String [] textos2 = {"asdfasdfshola", "adios"};
        
        Persona [] personas = { new Persona("Ana", 22), new Persona("Carlos", 33) };
        
        System.out.println("Llamada al método normal: " + Util.compararTamano((Object[]) a, (Object[]) b)); 
        System.out.println("Llamada al método normal: " + Util.compararTamano(a, b)); 
        
        System.out.println("Llamada al método genérico de un tipo: " + UtilGenerica.<Integer>compararTamano (a, b) ); 
        
        System.out.println("Llamada al método genérico de dos tipos: " + UtilGenerica.<String>compararTamano (textos,textos2) ); 
        
        System.out.println("Llamada al método genérico de dos tipos: " + UtilGenerica2.<Double,String>compararTamano (c, textos) ); 
        System.out.println("Llamada al método genérico de dos tipos: " + UtilGenerica2.<String,Persona>compararTamano (textos, personas) ); 
    }
    
    
}
