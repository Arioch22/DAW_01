/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author arioch
 */
public class JavaApplication12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        		 //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int TAMANO_ENCABEZADO = -16;
        final int CANTIDAD_ELEMENTOS_ENCABEZADO = 6;
        final String[] ENCABEZADO = {"Nombre y apellidos","DNI","Nota teoría","Nota práct.","Nota final","Nota acta"};
        final String SEPARADOR_TEXTO = ";";
        final String RUTA_LISTADO_ALUMNOS = String.format("recursos%slistadoAlumnos.txt",File.separatorChar);
        final String RUTA_COEFICIENTES = String.format("recursos%scoeficientes.txt",File.separatorChar);
        final String RUTA_ACTA = String.format("recursos%sacta.txt",File.separatorChar);
        
        

        // Variables de entradat
        BufferedReader listadoAlumnos = null,coeficientes = null;
        
        
       
        
        // Variables de salida
        BufferedWriter acta = null;
        
        // Variables auxiliares
        double notaFinalAlumno;
        double[] coeficienteDatos = new double[5];
        String[] contenidoLineaDocumentos;

        int numero = 1000000000;
        System.out.println("Prueba impresion de un millon: " +numero);
   
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        
        
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        //capturamos las posibles excepciones
        try{
            //inicializamos los objetos BufferedReader pasando como parametro un nuevo objeto FileReader pasando a ese nuevo objeto la ruta del fichero
            listadoAlumnos = new BufferedReader(new FileReader(RUTA_LISTADO_ALUMNOS));
            coeficientes = new BufferedReader(new FileReader(RUTA_COEFICIENTES));
            
            //inicializamos un nuevo objeto BufferedWriter pasando como parametro un nuevo objeto FileWriter pasando a ese nuevo objeto la ruta del fichero a escribir
            acta = new BufferedWriter(new FileWriter(RUTA_ACTA));
            
            //leemos la linea del fichero coeficientes y dividimos la cadena en un array usando el metodo split y como delimitador ;
            contenidoLineaDocumentos = coeficientes.readLine().split(SEPARADOR_TEXTO);
            
   
            //recorremos el array coeficienteDatos
            for(int i=0;i<coeficienteDatos.length;i++){
                //almacenamos los valores en el array contenidoLineaDocumentos en el array coeficienteDatos convirtiendolos en double
                coeficienteDatos[i] = Double.parseDouble(contenidoLineaDocumentos[i]);
            }

            

            //recorremos el array CANTIDAD_ELEMENTOS_ENCABEZADO donde guardamos el encabezado del fichero que queremos escribir
            for(int i=0;i<CANTIDAD_ELEMENTOS_ENCABEZADO;i++){
                /* escribimos el encabezado en nuestro fichero con los espacios correspondientes usando String.format
                   la primera columna debe ser mas grande asi que multiplicamos TAMANO_ENCABEZADO * 2
                */
                acta.write(String.format(String.format("%%%ds",(i==0)?TAMANO_ENCABEZADO*2:TAMANO_ENCABEZADO),ENCABEZADO[i]));
            }
            
            //empezamos una nueva linea en el fichero
            acta.newLine();
            //seguimos ejecutando el bucle mientras el stream este listo para leerse(si esta vacio no lo esta)
            while(listadoAlumnos.ready()){
                // dividimos la linea en un array String separandola por ; usando el metodo split
                contenidoLineaDocumentos = listadoAlumnos.readLine().split(SEPARADOR_TEXTO);
                
                //recorremos el array contenidoLineaDocumentos
                for(int i=0;i<contenidoLineaDocumentos.length;i++){
                    /* escribimos la informacion en nuestro fichero con los espacios correspondientes usando String.format
                       la primera columna debe ser mas grande asi que multiplicamos TAMANO_ENCABEZADO * 2
                    */
                    acta.write(String.format(String.format("%%%ds",(i==0)?TAMANO_ENCABEZADO*2:TAMANO_ENCABEZADO ),(i<contenidoLineaDocumentos.length/2)?contenidoLineaDocumentos[i]:Double.parseDouble(contenidoLineaDocumentos[i])));
                }
                /* calculamos la notaFinal usando el metodo calcularNotaFinal pasando como parametros
                   -nota parte teorica -> posicion 2 del array contenidoLineaDocumentos
                   -nota parte practica -> posicion 3 del array contenidoLineaDocumentos
                   -porcentaje parte teorica -> posicion 0 del array coeficienteDatos
                   -porcentaje parte practica -> posicion 1 del array coeficienteDatos
                */
                notaFinalAlumno = calcularNotaFinal(Double.parseDouble(contenidoLineaDocumentos[2]),Double.parseDouble(contenidoLineaDocumentos[3]),coeficienteDatos[0],coeficienteDatos[1]);
                //escribimos la nota final en nuestro fichero con su tamano correspondiente usando String.Format
                acta.write(String.format(String.format("%%%ds",TAMANO_ENCABEZADO ), notaFinalAlumno));
                
                /* escribimos en nuestro fichero nota acta que la obtenemos usando el metodo calcularNotaActa pasando como parametros
                   -nota final alumno -> notaFinalAlumno
                   -nota minima para estar aprobado -> posicion 2 del array coeficienteDatos
                   -nota minima para sacar notable -> posicion 3 del array coeficienteDatos
                   -nota minima para sacar sobresaliente -> posicion 4 del array coeficienteDatos
                */
                acta.write(String.format(String.format("%%%ds",TAMANO_ENCABEZADO ), calcularNotaActa(notaFinalAlumno,coeficienteDatos[2],coeficienteDatos[3],coeficienteDatos[4])));
                
                // si el Stream sigue listo para seguir leyendose se crea nueva linea en el documento
                if(listadoAlumnos.ready())
                    acta.newLine();
            }
            
            
            
       coeficientes.close();
            
        //capturamos las posibles excepciones de IO tambien captura las excepciones FileNotFound
        }catch(IOException e){
            System.out.println(String.format("Error de Entrada/Salida: %s",e.getMessage()));
        }finally{
            //cerramos el fichero
            
              try{  if (coeficientes != null) coeficientes.close();
                if (listadoAlumnos != null) listadoAlumnos.close();
                if (acta != null) acta.close();
              }catch(IOException e){
                System.out.println(String.format("Error cerrando el documento: %s",e.getMessage()));
            }
           
        }
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
        System.out.println ();
	System.out.println ("Archivos cerrados y procesamento finalizado");
	System.out.println ("---------");
        
        
        System.out.println ();
	System.out.println ("Fin del programa.");
    }
    
    /**
     * 
     * @param notaT Nota de teoría que ha obtenido el alumno.
     * @param notaP Nota de las prácicas del alumno.
     * @param cT Coeficiente de lo que puntúa la teoría.
     * @param cP Coeficiente de lo que puntúan las prácticas.
     * @return Nota final del alumno.
     */
    public static double calcularNotaFinal(double notaT, double notaP, double cT, double cP){
        return (notaT*cT)/100 + (notaP*cP)/100;
    }
    
    /**
     * 
     * @param nota Nota final de un alumno.
     * @param aprobado Valor umbral entre el suspenso y el aprobado.
     * @param notable Valor umbral entre el aprobado y el notable.
     * @param sobresaliente Valor umbral entre el notable y el sobresaliente.
     * @return Nota del acta (Suspenso, Aprobado, Notable o Sobresaliente).
     */
    public static String calcularNotaActa(double nota, double aprobado, double notable, double sobresaliente){
        if(nota<aprobado)
            return "Suspenso";
        else if(nota<notable)
            return "Aprobado";
        else if(nota<sobresaliente)
            return "Notable";
        else
            return "Sobresaliente";
 }
    
}
