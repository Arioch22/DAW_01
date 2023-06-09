
package ed_ejemplo_junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({ed_ejemplo_junit.CalculadoraTest.class,  ed_ejemplo_junit.CalculadoraParametro2Test.class})
//@Suite.SuiteClasses({ed_ejemplo_junit.CalculadoraTest.class,  ed_ejemplo_junit.CalculadoraParametro2Test.class, ed_ejemplo_junit.TestSuite1.class})
//Se puede enlazar con el otro Suite creado
public class TestSuite2 {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
