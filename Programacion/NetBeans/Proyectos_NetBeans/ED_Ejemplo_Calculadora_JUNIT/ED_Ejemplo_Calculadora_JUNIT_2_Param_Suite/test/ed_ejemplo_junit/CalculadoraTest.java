package ed_ejemplo_junit;

import ed_ejemplo_junit.Calculadora;
import java.io.IOException;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculadoraTest {

    static Calculadora instance;

    /*La variable estática en Java es una variable que pertenece a la clase y se inicializa solo una vez al inicio de la ejecución.

Es una variable que pertenece a la clase y no al objeto (instancia)
Las variables estáticas se inicializan solo una vez, al inicio de la ejecución. Estas variables se inicializarán primero, antes de la inicialización de cualquier variable de instancia
Una sola copia para ser compartida por todas las instancias de la clase*/

    public CalculadoraTest() {
    }

    //Se comporta como before pero solamente va a ejecutarse una vez (al principio de todo)
    @BeforeClass
    public static void setUpClass() {
        System.out.println("BeforeClass");
       instance = new Calculadora();
        //lo construye para poder utilizarlo, utilizando la palabra reservada new y el constructor de la clase
    }

    @AfterClass
    public static void tearDownClass() {//cerrar conexiones, liberar memoria
        System.out.println("AfterClass");
    }

    //Se va a ejecutar antes de cada prueba por cada método
    //Se va a ejecutar antes de método, porque en cada prueba se ejecutará/test de un método
    @Before
    //marca un método como método de inicialización de pruebas
    //se ejecuta para cada una de las pruebas, por ejemplo para inicializar variables
    public void setUp() {
        System.out.println("Before");
        instance.c();//el métoco c() resetea el valor de resultado (=0)
        //instance = new Calculadora();
    }

    @After
    public void tearDown() {
        System.out.println("After");
        //instance.c(); //también podríamos resetear la variable después de cada prueba
    }

    /**
     * Test del método add, de la clase Calculadora.
     */
    @Test
    public void testAdd_int_int() {
        System.out.println("testeo método add");
        //Para saber en qué orden están ejecutándose las pruebas unitarias de los métodos
        int a = 3;
        int b = 2;
//        Calculadora instance = new Calculadora();
        int expResult = 5;//almacena el resultado esperado
        int result = instance.add(a, b);
        assertEquals(expResult, result);//valida la igualdad de dos valores
        //determinan el éxito (devuelve resultado esperado) 
        //o fracaso (devuelve un resultado diferente) de una prueba
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test del método sub, de la clase Calculadora.
     */
    @Test
    public void testSub_int_int() {
        System.out.println("testeo método sub");
        int a = 6;
        int b = 2;
//        Calculadora instance = new Calculadora();
        int expResult = 4;
        int result = instance.sub(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of div method, of class Calculadora.
     */
//    @Test(expected=IOException.class)//Otro tipo de excepción, fallaría porque no es esta la que envía
    @Test
    //Le estoy indicando que este método que admite/espera una excepción
    public void testDiv() {
        System.out.println("testeo método div");
        int a = 5;
        int b = 0;
        //Aunque hemos creado la excepción dentro del método dividir
        //para lanzar una excepción cuando divida entre cero
        //El test da como failed
//        Calculadora instance = new Calculadora();
//        int expResult = 0;
//        int result = instance.div(a, b);
        instance.div(a, b);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Calculadora.
     */
    @Test
    public void testAdd_int() {
        System.out.println("add-método4");
        int v = 3;
//        Calculadora instance = new Calculadora();
        int expResult = 3;
        int result = instance.add(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of sub method, of class Calculadora.
     */
    @Test
    public void testSub_int() {
        System.out.println("sub-método5");
        int v = -2;
//        Calculadora instance = new Calculadora();
        int expResult = 2;
        int result = instance.sub(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of resultado method, of class Calculadora.
     */
    @Test
    public void testResultado() {
        System.out.println("resultado-método6");
//        Calculadora instance = new Calculadora();
        int expResult = 0;
        int result = instance.resultado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of c method, of class Calculadora.
     */
    @Test
    public void testC() {
        System.out.println("c-método7");
//        Calculadora instance = new Calculadora();
        instance.c();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of operacionOptima method, of class Calculadora.
     */
    @Test(timeout = 3000)
    //Si tarda más del tiempo establecido, falla. Si duerme 2000ms y tiene timeout de 100ms, falla
    //Se ha puesto a 3000 para que pase el test
    //ÚTIL: gestión de bucles infinitos
    //es una etiqueta para cada una de las pruebas unitarias
    public void testOperacionOptima() {
        System.out.println("operacionOptima-método8");
//        Calculadora instance = new Calculadora();
        instance.operacionOptima();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    //falla con assertSame, son el mismo objeto, pero la referencia a la que
    //apuntan en memoria es distinta.
    @Test
    public void testFechas() {
        System.out.println("Fechas");
        //Crea un objeto con la fecha actual
        Date date1 = new Date();
        Date date2 = new Date();
        assertSame(date1, date2);
        //assertEquals(date1,date2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
