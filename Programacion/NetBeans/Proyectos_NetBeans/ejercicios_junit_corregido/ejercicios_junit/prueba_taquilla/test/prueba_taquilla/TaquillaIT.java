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
    @Test
    public void testReservar_entrada() throws Exception {

        Taquilla instance = new Taquilla("Frozen II", 7, 100, 25);
        System.out.println("reservar_entrada");
        int cantidad = -2;

        try {
            instance.reservar_entrada(cantidad);
            fail("Intento de reserva de un número negativo de entradas");

        } catch (Exception e) {
            assertTrue(instance.consultar_aforo_disp() == 25);
            System.out.println(e);

        }

    }
}
