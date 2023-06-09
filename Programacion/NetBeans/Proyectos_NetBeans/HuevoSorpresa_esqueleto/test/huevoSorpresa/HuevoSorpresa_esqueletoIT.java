/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package huevoSorpresa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arioch
 */
public class HuevoSorpresa_esqueletoIT {
    
    public HuevoSorpresa_esqueletoIT() {
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

    /**
     * Test of sacarHuevosSorpresas method, of class HuevoSorpresa_esqueleto.
     */
    @Test
    public void testSacarHuevosSorpresas() throws Exception {
        /*System.out.println("sacarHuevosSorpresas");
        int unidades = 0;
        double dinero = 0.0;
        HuevoSorpresa_esqueleto instance = new HuevoSorpresa_esqueleto();
        instance.sacarHuevosSorpresas(unidades, dinero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
        
        HuevoSorpresa_esqueleto instance = new HuevoSorpresa_esqueleto(100, 1, "esqueleto", 2);
        int unidades = 20;
        double dinero = -4;
        int restEsperado = 80;
        
        try{
            instance.sacarHuevosSorpresas(unidades, dinero);
            //assertEquals (restEsperado, instance.obtenerUnidades());
            assertEquals (dinero, instance.obtenerPrecio());
            
        }catch (Exception e){
            
            System.out.println(e);
            
        }
        
    }

   
    
}
