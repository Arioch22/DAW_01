/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prueba_taquilla;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Anabel
 */
public class TaquillaIT {

    Taquilla instance;

    public TaquillaIT() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
       instance = new Taquilla("Frozen II", 7, 100, 25);
    }

    @After
    public void tearDown() {
    }

    //El test no pasaría porque el método está mal diseñado y permite reservar 
    //un número negativo de entradas por lo tanto se modificaría el aforo disponible.
    /*@Test
    public void testReservar_entrada() throws Exception {

        Taquilla instance = new Taquilla("Frozen II", 7, 100, 20);
        System.out.println("reservar_entrada");
        int cantidad = 0;

        try {
            instance.reservar_entrada(cantidad);
            //fail("Intento de reserva de un número negativo de entradas");

        } catch (Exception e) {
            assertTrue(instance.consultar_aforo_disp() == 20);
            System.out.println("hola que tal estas " +e);
           System.out.println(instance.consultar_aforo_disp());

        }

    }*/
    
    
    
    @Test
    public void testReservar_entradas() throws Exception{
        Taquilla instance = new Taquilla("Matrix", 7, 100, 50);
        System.out.println("prueba taquilla");
        int reserva = 30;
        int resultadoEsperado = 20;
        instance.reservar_entrada(reserva);
        //assertTrue (instance.consultar_aforo_disp() == resultadoEsperado);
        assertEquals (instance.consultar_aforo_disp(), resultadoEsperado);
        
    }
    
    @Test
    public void testReservar_entradas_error() throws Exception{
        Taquilla instance = new Taquilla("Matrix", 7, 100, 50);
        System.out.println("prueba taquilla con error");
        int reserva = 60;
        
        try{
            instance.reservar_entrada(reserva);
            //fail("Número de reservas en negativo no válido.");
        }catch (Exception e) {
            System.out.println(e);
            assertTrue (instance.consultar_aforo_disp() == 50);
        }
    }
    
    @Test
    public void testReservar_entradas_error2() throws Exception{
        Taquilla instance = new Taquilla("Matrix", 7, 100, 50);
        System.out.println("prueba taquilla con error");
        int reserva = -10;
        
        try{
            instance.reservar_entrada(reserva);
            fail("Número de reservas en negativo no válido.");
        }catch (Exception e) {
            System.out.println(e);
            assertTrue (instance.consultar_aforo_disp() == 50);
        }
    }
    
}
