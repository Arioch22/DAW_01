/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package huevoSorpresa;

import static junit.framework.TestCase.fail;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ruben
 */
public class HuevoSorpresa_Arrevola_Diez_Ruben_2122Test {

    public HuevoSorpresa_Arrevola_Diez_Ruben_2122Test() {
    }

    /**
     * Test sacarHuevosSorpresas con valores validos. Intentamos sacar 3 huevos
     * con 20€ de dinero. Al ser el valor de los huevos 2€ debería fucnioanr
     * bien y dejar el número de unidades en 17.
     */
    @Test
    public void testSacarHuevosSorpresasValidoV1() throws Exception {
        System.out.println("Test SacarHuevoSorpresa con valores validos.");
        int unidades = 3;
        double dinero = 20;
        try {
            HuevoSorpresa_Arrevola_Diez_Ruben_2122 miHuevo = new HuevoSorpresa_Arrevola_Diez_Ruben_2122(20, 2, "SORPRESA", 3);
            miHuevo.sacarHuevosSorpresas(unidades, dinero);
            assertEquals(17, miHuevo.obtenerUnidades());
        } catch (Exception e) {
            /* no debería saltar ninguna excepción en este caso, 
            por lo que si lo hace es porque algo no está bien y el test debería fallar */
            fail("Se ha producido una excepción no esperada: " + e);
        }

    }

    /**
     * Test sacarHuevosSorpresas con valores validos. Intentamos sacar 3 huevos
     * con 6€ de dinero. Al ser el valor de los huevos 2€ debería funcionar bien
     * y dejar el número de unidades en 17.
     */
    @Test
    public void testSacarHuevosSorpresasValidoV2() throws Exception {
        System.out.println("Test SacarHuevoSorpresa con valores validos.");
        int unidades = 3;
        double dinero = 6;
        try {
            HuevoSorpresa_Arrevola_Diez_Ruben_2122 miHuevo = new HuevoSorpresa_Arrevola_Diez_Ruben_2122(20, 2, "SORPRESA", 3);
            miHuevo.sacarHuevosSorpresas(unidades, dinero);
            assertEquals(17, miHuevo.obtenerUnidades());
        } catch (Exception e) {
            /* no debería saltar ninguna excepción en este caso, 
            por lo que si lo hace es porque algo no está bien y el test debería fallar */
            fail("Se ha producido una excepción no esperada: " + e);
        }

    }

    /**
     * Test sacarHuevosSorpresas con valores validos. Intentamos sacar 20 huevos
     * con 50€ de dinero. Al ser el valor de los huevos 2€ debería funcionar
     * bien y dejar el número de unidades en 0.
     */
    @Test
    public void testSacarHuevosSorpresasValidoV3() throws Exception {
        System.out.println("Test SacarHuevoSorpresa con valores validos.");
        int unidades = 20;
        double dinero = 50;
        try {
            HuevoSorpresa_Arrevola_Diez_Ruben_2122 miHuevo = new HuevoSorpresa_Arrevola_Diez_Ruben_2122(20, 2, "SORPRESA", 3);
            miHuevo.sacarHuevosSorpresas(unidades, dinero);
            assertEquals(0, miHuevo.obtenerUnidades());
        } catch (Exception e) {
            /* no debería saltar ninguna excepción en este caso, 
            por lo que si lo hace es porque algo no está bien y el test debería fallar */
            fail("Se ha producido una excepción no esperada: " + e);
        }

    }

    /**
     * Test sacarHuevosSorpresas con valores invalidos. Dinero introducido
     * negativo o 0. Intentamos sacar 3 huevos con -20€ de dinero. Debe saltar
     * la excepción. Con esta prueba comprobamos que el método
     * sacarHuevoSorpresa no acepta números negativos ni 0.
     */
    @Test
    public void testSacarHuevosSorpresasDineroNegativo() throws Exception {
        System.out.println("Test SacarHuevoSorpresa con dinero negativo.");
        int unidades = 3;
        double dinero = -20;
        HuevoSorpresa_Arrevola_Diez_Ruben_2122 miHuevo = new HuevoSorpresa_Arrevola_Diez_Ruben_2122(20, 2, "SORPRESA", 3);
        try {
            miHuevo.sacarHuevosSorpresas(unidades, dinero);
            fail("Intento de sacar huevo sorpresa con dinero negativo");
        } catch (Exception e) {
            System.out.println(e);
            assertEquals(20, miHuevo.obtenerUnidades());
        }

    }

    /**
     * Test sacarHuevosSorpresas con valores invalidos. Dinero introducido
     * Insuficiente. Intentamos sacar 3 huevos con 2€ de dinero. Debe saltar la
     * excepción. Con esta prueba comprobamos que el método sacarHuevoSorpresa
     * no acepta comprar con menos dinero del necesario.
     */
    @Test
    public void testSacarHuevosSorpresasDineroInsuficiente() throws Exception {
        System.out.println("Test SacarHuevoSorpresa con dinero insuficiente.");
        int unidades = 3;
        double dinero = 2;
        HuevoSorpresa_Arrevola_Diez_Ruben_2122 miHuevo = new HuevoSorpresa_Arrevola_Diez_Ruben_2122(20, 2, "SORPRESA", 3);
        try {
            miHuevo.sacarHuevosSorpresas(unidades, dinero);
            fail("Intento de sacar huevo sorpresa con dinero insuficiente.");
        } catch (Exception e) {
            System.out.println(e);
            assertEquals(20, miHuevo.obtenerUnidades());
        }

    }

    /**
     * Test sacarHuevosSorpresas con valores invalidos. Numero de Huevos
     * negativo o 0. Intentamos sacar -3 huevos con 20€ de dinero. Debe saltar
     * la excepción. Con esta prueba comprobamos que el método
     * sacarHuevoSorpresa no acepta comprar un número negativo de huevos ni 0.
     */
    @Test
    public void testSacarHuevosSorpresasHuevosNegativos() throws Exception {
        System.out.println("Test SacarHuevoSorpresa con número de huevos negativo.");
        int unidades = -3;
        double dinero = 20;
        HuevoSorpresa_Arrevola_Diez_Ruben_2122 miHuevo = new HuevoSorpresa_Arrevola_Diez_Ruben_2122(20, 2, "SORPRESA", 3);
        try {
            miHuevo.sacarHuevosSorpresas(unidades, dinero);
            fail("Intento de sacar un número negativo de huevo sorpresa.");
        } catch (Exception e) {
            System.out.println(e);
            assertEquals(20, miHuevo.obtenerUnidades());
        }

    }

    /**
     * Test sacarHuevosSorpresas con valores invalidos. Numero de Huevos
     * superior al número de huevos guardados. Intentamos sacar 30 huevos con 100€ de dinero, cuando solo hay 20 huevois en stock.
     * Debe saltar la excepción. Con esta prueba comprobamos que el método
     * sacarHuevoSorpresa no acepta comprar un número mayor de huevos que hay en stock.
     */
    @Test
    public void testSacarHuevosSorpresasHuevosInsuficientes() throws Exception {
        System.out.println("Test SacarHuevoSorpresa con huevos insuficientes.");
        int unidades = 30;
        double dinero = 100;
        HuevoSorpresa_Arrevola_Diez_Ruben_2122 miHuevo = new HuevoSorpresa_Arrevola_Diez_Ruben_2122(20, 2, "SORPRESA", 3);
        try {
            miHuevo.sacarHuevosSorpresas(unidades, dinero);
            fail("Intento de sacar demasiados huevo sorpresa.No hay suficientes.");
        } catch (Exception e) {
            System.out.println(e);
            assertEquals(20, miHuevo.obtenerUnidades());
        }

    }

}
