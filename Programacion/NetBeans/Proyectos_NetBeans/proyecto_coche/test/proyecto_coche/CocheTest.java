/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyecto_coche;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyecto_coche.Coche;

/**
 *
 * @author arioch
 */
public class CocheTest {
    //static Coche instance;
    
    public CocheTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        //instance = new Coche("Seat", "Tarraco");

    }
    
    @AfterClass
    public static void tearDownClass() {
    }

   
    @Test
    public void testRecorre() {

       // System.out.println("prueba del método recorre");  
        Coche instance = new Coche("Seat", "Tarraco");

        int valorEsperado = 10;
        int kmActuales = 10;

        instance.recorre(kmActuales);
        //assertTrue("Se han introducido " + kmActuales + " kms y se esperaban " + valorEsperado + " kms.", valorEsperado == instance.getKilometraje());
        assertEquals(valorEsperado, instance.getKilometraje());
    }
    
    @Test
    public void testCosteTotal() {
        //test en el que se comprueba con valores correcto que funcione el código y de correcto
        System.out.println("Test costeTotal con valores correctos para entrar por el if");
        Coche instance = new Coche("Seat", "Tarraco");
        int num_viajes = 2;
        int kmActuales = 600;
        instance.recorre(kmActuales);
        int expResult = 600;
        
        int result = instance.costeTotal(num_viajes);
        assertEquals("El coste total de este núnero de viaje/s " +num_viajes +" ha sido de " + result,expResult, result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCosteTotal2() {
        //test en el que se comprueba con valores incorrector que funcione el código y de error
        System.out.println("Test costeTotal con valores para entrar por el else");
        Coche instance = new Coche("Seat", "Tarraco");
        int num_viajes = 2;
        int kmActuales = 1200;
        instance.recorre(kmActuales);
        int expResult = 3000;
        
        int result = instance.costeTotal(num_viajes);
        assertEquals("El coste total de este núnero de viaje/s " +num_viajes +" ha sido de " + result +".",expResult, result);
        //fail("Viajes o Km introduzos no corresponden.");
    }
}
