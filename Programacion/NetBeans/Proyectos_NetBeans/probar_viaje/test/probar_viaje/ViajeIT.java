/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package probar_viaje;

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
public class ViajeIT {

    public ViajeIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //test válido, hay 54 plazas disponibles y se reservan 20, quedarían 34
   @Test
    public void testReservarValido() throws Exception {

        System.out.println("Reservar un valor válido");
        int cantidad = 20;
        Viaje instance = new Viaje("Córdoba-Madrid", "Córdoba", "Madrid", 54, 54, 1);
        instance.reservar(cantidad);
        assertTrue(instance.consultar_plazas_disp() == 34);

    }

    //no podemos reservar un número negativo de plazas
    @Test
    public void testReservarNoValido() throws Exception {

        //System.out.println("Reservar un valor no válido");
        int cantidad = 55;
        Viaje instance = new Viaje("Córdoba-Madrid", "Córdoba", "Madrid", 54, 54, 1);
        try {
            instance.reservar(cantidad);
            fail("Intento de reservar -10 plazas");
        } catch (Exception e) {
            System.out.println(e);
            //assertTrue(instance.consultar_plazas_disp() == 54);
            assertEquals(instance.consultar_plazas_disp(), 54);

        }

    }

    //no se pueden anular 11 plazas cuando hay reservadas 10 (54-44)
    @Test
    public void testAnular_reservaNoValida() throws Exception {
        System.out.println("Anular reserva no válido");
        int cantidad = 11;
        Viaje viaje = new Viaje("Córdoba-Madrid", "Córdoba", "Madrid", 54, 44, 1);
        try {
            viaje.anular_reserva(cantidad);
            fail("Intento de anular 11 plazas cuando solo hay 10 reservadas");
        } catch (Exception e) {
            System.out.println(e);
            assertTrue(viaje.consultar_plazas_disp() == 44);

        }

    }
    
    /*@Test
    public void testReservar() throws Exception{
        int cantidad = 10;
        Viaje instance = new Viaje("córdoba-málaga", "córdoba", "málaga", 200, 100, 16);
        
        try{
            
        }catch(Exception e){
            assertTrue (instance.consultar_plazas_disp() == cantidad);
            System.out.println(e);
            
        }
    }*/
    
    
    

}
