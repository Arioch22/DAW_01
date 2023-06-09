
package ed_ejemplo_junit;

//import java.util.ArrayList;
import ed_ejemplo_junit.Calculadora;
import java.util.Arrays;
//import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Anabel
 */
@RunWith(value=Parameterized.class)
public class CalculadoraParametroTest {
    
    /*Arrays.asList: devuelve una lista de tamaño fijo respaldada por el 
    array especificado.
    getData(): el nombre de este método puede ser cualquiera.
    Object[][]: array bidimensional
    */
    
    @Parameters
    public static Iterable<Object[]> getData(){
        /*List<Object[]> obj=new ArrayList<>();
        obj.add(new Object[]{3,1,4});
        obj.add(new Object[]{2,3,5});
        obj.add(new Object[]{3,3,6});
        return obj;*/
        return Arrays.asList(new Object[][]{
            {3,1,4},{2,3,5},{3,3,7}
        });
    }
    
    
    private int a;
    private int b;
    private int exp;
    
    //Esta clase tiene que contener un constructor que es llamado por JUnit
    public CalculadoraParametroTest(int a, int b, int exp){
        this.a=a;
        this.b=b;
        this.exp=exp;
    }
    
    //se prueba el método add() con el conjunto de valores especificado arriba.
    @Test
    public void testAdd(){
        Calculadora calc=new Calculadora();
        int result=calc.add(a,b);
        assertEquals(exp,result);
    }
    
}
