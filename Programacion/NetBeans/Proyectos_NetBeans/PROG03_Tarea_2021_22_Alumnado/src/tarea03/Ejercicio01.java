package tarea03;


import java.time.LocalDate;
import java.time.Month;
import libtarea3.CuentaBancaria;
// Incluir el resto de los imports que se necesiten


/**
 * Ejercicio 1: Uso de cuentas bancarias.
 * @author Manuel Monterroso Flores
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // 1. Declaración de tres variables referencia a objetos instancia de la clase CuentaBancaria
        
        LocalDate fechaError = LocalDate.of(2027, 9, 1);
        CuentaBancaria cuentaPrivada;
        CuentaBancaria cuentaConjunta;
        CuentaBancaria cuentaFamiliar;
        
      
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // En realidad no hay entrada de datos como tal dado que la información 
        // de entrada es fija y siempre la misma
        System.out.println("USANDO CUENTAS BANCARIAS");
        System.out.println("------------------------");
        System.out.printf ("Fecha actual: %s\n", LocalDate.now());
        System.out.println();
        

        // 2.- Instanciación de tres objetos CuentaBancaria

        System.out.println("Creación de cuentas (constructores)");
        System.out.println("-----------------------------------");
        
        /*CuentaPrivada
        
        CuentaConjunta 
        
        CuentaFamiliar.*/

        // 2.1.- Intento de crear una cuenta con fecha no válida (hay gestionar la posible excepción)
        try {
            //CuentaBancaria cuentaPrivada = new CuentaBancaria (CuentaBancaria.DEFAULT_SALDO , fechaError);
            cuentaPrivada = new CuentaBancaria (CuentaBancaria.DEFAULT_SALDO, fechaError);
        System.out.println(cuentaPrivada);}
        catch (java.lang.IllegalArgumentException ex){
            System.out.println("Intentando crear una cuenta privada con una fecha no válida");
            System.out.println("Error: " +ex.getMessage());
            
        }
        

        
        // 2.2.- Intento de crear una cuenta con saldo no válido (hay gestionar la posible excepción)
        try {
            cuentaPrivada = new CuentaBancaria (-200);
        }
        catch (java.lang.IllegalArgumentException ex) {
            System.out.println("");
            System.out.println("Intentando crear una cuenta privada con un saldo no válido");
            System.out.println("Error: " +ex.getMessage());
        }
        
        // 2.3.- Creación de una cuenta válida usando el constructor de tres parámetros
        System.out.println("");
        System.out.println("Creando cuenta privada válida con un constructor con tres parámetros...");
        cuentaPrivada = new CuentaBancaria (1000,LocalDate.of(2021, Month.JULY, 01), -200);
        System.out.println("Cuenta Privada creada: " +cuentaPrivada.toString());

        
        // 2.4.- Creación de una cuenta válida usando el constructor de dos parámetros   
        System.out.println("");
        System.out.println("Creando cuenta conjunta válida usando un constructor con dos parámetros...");
        cuentaConjunta = new CuentaBancaria (200, LocalDate.of(2021, Month.JULY, 01));
        System.out.println("Cuenta conjunta creada: " +cuentaConjunta.toString());
        
        // 2.5.- Creación de una cuenta válida usando el constructor sin parámetros        
        System.out.println("");
        System.out.println("Creando cuenta familiar válida usando un constructor sin parámetros...");
        cuentaFamiliar = new CuentaBancaria ();
        System.out.println("Cuenta Familiar creada: " +cuentaFamiliar.toString());

                
        
        //----------------------------------------------
        //       Procesamiento + Salida de Resultados
        //----------------------------------------------
        // Dado que se va a ir mostrando información de salida a la vez que 
        // se van realizando operaciones, podemos considerar en este caso
        // que el procesamiento y la salida de resultado van unidos y "mezclados"
        
        // 3.- Obtención de información de la cuenta privada
        System.out.println("");
        System.out.println("Prueba de los getters de la cuenta privada");
        System.out.println("------------------------------------------");
        System.out.println("Id: " +cuentaPrivada.getId());
        System.out.println("Cuenta creación: " +cuentaPrivada.getFechaCreacion());
        System.out.println("Límite descubierto: " +cuentaPrivada.getLimiteDescubierto());
        System.out.println("Está embargada: " +cuentaPrivada.isEmbargada());
        System.out.println("Está en descubierto: " +cuentaPrivada.isDescubierta());
        System.out.println("Número de días que lleva la cuenta abierta: " +cuentaPrivada.getDiasCuenta());
        
        // 4.- Realización de operaciones sobre las cuentas
        System.out.println("");
        System.out.println("Realización de operaciones sobre las cuentas");
        System.out.println("--------------------------------------------");
        System.out.println("Ingresamos 100 euros en la cuenta familiar...");
        cuentaFamiliar.ingresar(100);
        System.out.println("Extraemos 100 euros de la cuenta conjunta...");
        cuentaConjunta.extraer(100);
        System.out.println("Transferimos 1100 euros de la cuenta privada a la familiar...");
        cuentaPrivada.transferir(1100, cuentaFamiliar);
        
        // 5.- Estado final de las cuentas
        System.out.println("");
        System.out.println("Estado final de las cuentas");
        System.out.println("---------------------------");
        System.out.println("Estado final de la cuenta privada:  " +cuentaPrivada.toString());
        System.out.println("Estado final de la cuenta conjunta: " +cuentaConjunta.toString());
        System.out.println("Estado final de la cuenta familiar: " +cuentaFamiliar.toString());
    }
    
}
