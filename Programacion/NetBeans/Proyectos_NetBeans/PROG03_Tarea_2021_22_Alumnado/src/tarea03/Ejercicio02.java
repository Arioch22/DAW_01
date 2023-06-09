package tarea03;

// Incluir los imports que se necesiten

import libtarea3.Dado;



/**
 * Ejercicio 2: Lanzando los dados.
 * @author Manuel Monterroso Flores
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int carasAleatorias;
        Dado dado;

        // Variables de salida
        // (no hace falta ninguna)
        
        // Variables auxiliares


        System.out.println("LANZANDO LOS DADOS");
        System.out.println("------------------");
        System.out.println();

        //----------------------------------------------
        //               Análisis inicial
        //----------------------------------------------        
        // 1. Consulta de valores iniciales
        System.out.println("1.-CONSULTA INICIAL DE VALORES GLOBALES");
        System.out.println("---------------------------------------");
        System.out.println();
        
        // 1.1. Número total de dados creados
        System.out.println("Número de total de dados creados hasta el momento: " +Dado.getNumeroDadosCreados());
        
        // 1.2. Número total de lanzamientos
        System.out.println("Número de total de lanzamientos llevados a cabo hasta el momento: " +Dado.getNumeroLanzamientosGlobal());
        
        // 1.3. Consulta de los lanzamientos realizados (bucle desde 1 hasta el número de caras que se desea analizar)
        for (int i = 1; i < 5; i++) {
            System.out.println("Número de veces que se ha obtenido " +i +" :" +Dado.getNumeroVecesCaraGlobal(i));
        }


        
        //----------------------------------------------
        //      Creación y lanzamiento de dados
        //----------------------------------------------
        System.out.println();
        System.out.println("2.- CREACIÓN Y LANZAMIENTO DE DADOS");
        System.out.println("-----------------------------------");
        // 2.1. Intentos de creación 
        // Se intentan crear 10 dados que tengan aleatoriamente entre 0 y 8 caras (bucle)
        // Sólo algunas llamadas al constructor funcionarán y en esos casos es cuando se podrá lanzar el dado
        // Otras harán que salte una excepción IllegalArgumentException
        // Habrá que recogerla y mostrar el mensaje de error por pantalla
        System.out.println("");
        for (int i = 1; i <= 10; i++) {
            carasAleatorias = (int) Math.floor(Math.random() * 9);
            try{
                dado = new Dado(carasAleatorias);
                for (int j = 1; j <= carasAleatorias; j++) {
                    dado.lanzar();
                }
                
                System.out.println("Intento " +i +": Intentando crear dado aleatorio de  " +carasAleatorias +" caras. Correcto. Creado dado de " +carasAleatorias +" caras.");
                System.out.println("Lo lanzamos " +carasAleatorias +" veces: " +dado.getSerieHistoricaLanzamientos());
                System.out.println("Suma total de los lanzamientos del dado: " +dado.getSumaPuntuacionHistorica());
                
            }
                catch (java.lang.IllegalArgumentException ex){
                    System.out.println("Intento "+i +":" +" Intentando crear dado aleatorio de " +carasAleatorias +" caras. Error.  " +ex.getMessage());
                }
            
        }

        
        //----------------------------------------------
        //         Análisis de resultados finales
        //----------------------------------------------
        // 3. Análisis de resultados una vez realizados todos los lanzamientos
        System.out.println();
        System.out.println("3.-ANÁLISIS DE RESULTADOS FINALES");
        System.out.println("---------------------------------");

        // 3.1. Número total de dados creados
        System.out.println("Número de total de dados creados hasta el momento: " +Dado.getNumeroDadosCreados());
        
        
        // 3.2. Número total de lanzamientos
        System.out.println("Número de total de lanzamientos llevados a cabo hasta el momento: " +Dado.getNumeroLanzamientosGlobal());
        
        
        // 3.3. Análisis de los lanzamientos realizados (bucle desde 1 hasta el número de caras que se desea analizar)
        for (int i = 1; i < 5; i++) {
            System.out.println("Número de veces que se ha obtenido " +i +": " +Dado.getNumeroVecesCaraGlobal(i));
        }
    }
}
