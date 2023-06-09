/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Programa para trabajar con archivos de texto.
 * @profesorado
 */
public class Ejercicio1 {
    
    /**
    * Método principal.
     * @param args
    */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final String RUTA_COEFICIENTES = System.getProperty("user.dir") + "/recursos/coeficientes.txt";
        final String RUTA_LISTADO = System.getProperty("user.dir") + "/recursos/listadoAlumnos.txt";
        final String SEPARADOR_TOKENIZER = ";" ;
        final int NUMERO_DECIMALES = 2;
        
        
        // Variables de entrada
        StringTokenizer stCoeficientes;
        StringTokenizer stListado;
        File coeficientes = new File(RUTA_COEFICIENTES);
        File listado = new File(RUTA_LISTADO);
        List<Double> listaCoeficientes = new ArrayList<>();
        List<String> listaAlumnos = new ArrayList<>();
        Scanner entrada = null;
        Scanner entradaListado = null;
        String cadena;
        String cadenaListado;

        // Variables de salida
        // Variables auxiliares
        
        //Para pasar cualquier double a string con el número de decimales deseados.
        DecimalFormat mf = new DecimalFormat();
        mf.setMinimumFractionDigits(NUMERO_DECIMALES);
        
        //Variables para el método imprimir acta Alumnos.
        int items = 6;
        int startIndex = 0;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        //Con el StringTokenizer dividimos el archivo por tokens por el separador y los escribimos dentro de una lista
        try {
            entrada = new Scanner(coeficientes);
            while (entrada.hasNext()) {
                cadena = entrada.nextLine();
                stCoeficientes = new StringTokenizer(cadena, SEPARADOR_TOKENIZER);
                while (stCoeficientes.hasMoreTokens()) {
                    listaCoeficientes.add(Double.parseDouble(stCoeficientes.nextToken()));

                }
            }
        } catch (FileNotFoundException e) {
            //System.out.println(e.getMessage());
            System.out.println("No se encuentra el archivo coeficientes.txt");
        }

        try {
            entradaListado = new Scanner(listado);
            while (entradaListado.hasNext()) {
                cadenaListado = entradaListado.nextLine();
                stListado = new StringTokenizer(cadenaListado, SEPARADOR_TOKENIZER);
                while (stListado.hasMoreTokens()) {
                    listaAlumnos.add(stListado.nextToken());
                }
            }
        } catch (FileNotFoundException ex) {
            //System.out.println(ex.getMessage());
            System.out.println("No se encuentra el archivo listadoAlumnos.txt");
        }

        for (int i = 2; i < listaAlumnos.size(); i = i + 6) {

            double nota;
            String notaTexto;

            /*En este paso sacamos la nota de la lista Alumnos que esta en String y la convertimos en double
            además para que la salida sea mas agradable a la vista convertimos el double de nuevo en String
            pero con dos decimales gracias al método DecimalFormat y lo usamos para sustituir el que esta en la lista
            sin el formato de dos decimales.*/
            String paso = listaAlumnos.get(i);
            double notaT = Double.valueOf(paso);
            //En la salida los decimales salen con "," como es norma en España pero si se quisiera con puntos
            //solo hace falta añadir .replace(",",".")
            String notaT2 = mf.format(notaT);
            listaAlumnos.remove(i);
            listaAlumnos.add(i, notaT2);

            //Aqui realizamos los mismos pasos que en el punto anterior para sacar la nota y formatearla.
            String paso2 = listaAlumnos.get(i + 1);
            double notaP = Double.valueOf(paso2);
            String notaP2 = mf.format(notaP);
            listaAlumnos.remove(i + 1);
            listaAlumnos.add(i, notaP2);

            //calculamos la nota final con el método incluido para ello.
            nota = calcularNotaFinal(notaT, notaP, listaCoeficientes.get(0), listaCoeficientes.get(1));

            //Pasamos la nota calculado a String y formateada con dos decimales.
            String notaEntero = mf.format(nota);

            //Calculamos la nota del acta gracias a la nota calculada en el paso anterior.
            notaTexto = calcularNotaActa(nota, listaCoeficientes.get(2), listaCoeficientes.get(3), listaCoeficientes.get(4));

            //Añadimos a la lista de Alumnos tanto su nota final como la nota del acta.
            listaAlumnos.add(i + 2, notaEntero);
            listaAlumnos.add(i + 3, notaTexto);
        }

        //Procedemos a crear el archivo para luego escribir en él la lista de Alumnos con todos los datos.
        try ( PrintWriter salida = new PrintWriter(System.getProperty("user.dir") + "/recursos/acta.txt")) {
            
            //Primero escribimos la línea fija con la descrición de que es cada dato.
            salida.println(String.format("%-31s%-22s%-27s%-29s%-30s%s", "Nombre y apellidos", "DNI", "Nota teoría", "Nota práctica", "Nota final", "Nota acta"));
            
            //Gracias al método imprimirAlumnos iremos escribiendo en el archivo línea a línea la info de cada alumno
            while (startIndex < listaAlumnos.size()) {
                imprimirAlumnos(listaAlumnos, startIndex, items, salida);
                startIndex += items;
            }
        } catch (FileNotFoundException e) {
            //System.out.println(e.getMessage());
            System.out.println("Archivo no encontrado o imposible de crear.");
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("Archivos cerrados y procesamento finalizado");
        System.out.println("---------");

        System.out.println();
        System.out.println("Fin del programa.");
    }

    /**
     *
     * @param notaT Nota de teoría que ha obtenido el alumno.
     * @param notaP Nota de las prácicas del alumno.
     * @param cT Coeficiente de lo que puntúa la teoría.
     * @param cP Coeficiente de lo que puntúan las prácticas.
     * @return Nota final del alumno.
     */
    public static double calcularNotaFinal(double notaT, double notaP, double cT, double cP) {
        //Modifico el método para que los resultados salgan con dos decimales.
        return Math.round(((notaT * cT) / 100.0 + (notaP * cP) / 100.0)*100.0)/100.0;
    }

    /**
     *
     * @param nota Nota final de un alumno.
     * @param aprobado Valor umbral entre el suspenso y el aprobado.
     * @param notable Valor umbral entre el aprobado y el notable.
     * @param sobresaliente Valor umbral entre el notable y el sobresaliente.
     * @return Nota del acta (Suspenso, Aprobado, Notable o Sobresaliente).
     */
    public static String calcularNotaActa(double nota, double aprobado, double notable, double sobresaliente) {
        if (nota < aprobado) {
            return "Suspenso";
        } else if (nota < notable) {
            return "Aprobado";
        } else if (nota < sobresaliente) {
            return "Notable";
        } else {
            return "Sobresaliente";
        }
    }
    
    /**
     * Método para imprimir por trozos determinados el ArrayList e imprimirlo con formato
     * @param lista Lista con toda la información de los alumnos
     * @param startIndex Número que indicará el inicio de lectura de la lista
     * @param items Número de items que se leera pora cada ciclo de la lista
     * @param salida Archivo donde se escribirá la información de cada Alumno
     */
    public static void imprimirAlumnos(List<String> lista, int startIndex, int items, PrintWriter salida) {
        if (lista != null && startIndex >= 0 && startIndex < lista.size()) {
            while (startIndex < lista.size() && items > 0) {
                salida.print(String.format("%-28s", lista.get(startIndex)));
                startIndex++;
                items--;
            }
            salida.print("\n");
        }
    }
}
