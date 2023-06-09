
package ed_ejemplo_junit;

import ed_ejemplo_junit.Calculadora;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value=Parameterized.class)
public class CalculadoraParametro2Test {
    
    @Parameters
    public static Iterable<Object[]> getData(){
        /*List<Object[]> obj=new ArrayList<>();
        obj.add(new Object[]{3,1,4});
        obj.add(new Object[]{2,3,5});
        obj.add(new Object[]{3,3,6});
        return obj;*/
        return Arrays.asList(new Object[][]{            
            {20,10,2},{40,-2,-20},{5,2,2}
                //Era {20,10,1}, lo hemos corregido a {20,10,2}
        });
    }
    
    
    private int a;
    private int b;
    private int exp;
    
    public CalculadoraParametro2Test(int a, int b, int exp){
        this.a=a;
        this.b=b;
        this.exp=exp;
    }
    
    @Test
    public void testDiv(){
        Calculadora calc=new Calculadora();
        int result=calc.div(a,b);
        assertEquals("Error en la división", exp, result);
    }
    
}

