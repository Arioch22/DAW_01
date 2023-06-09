package calculadora;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 
 * @author 
 */
public class Modelo {
    
    
    /**
     * Evaluar la cadena que se pasa como parámetro
     * @param cadena String con la expresión a evaluar
     * @return Una cadena con el resultado o bien null si la cadena recibida
     *         como parámetro no era válida
     */
    public static String evaluar(String cadena) {
        Object evaluacion;
        //dejo la opción en la expresión de poner solo un número para el tema por ejemplo de la raiz cuadrada.
        Pattern pat = Pattern.compile("^[-+]?[\\d]+(\\.\\d+)?([-+/*]?[\\d]+((\\.\\d+)?))*$");
        Matcher mat = pat.matcher(cadena);
        
        if(!mat.matches()){
            return "regex";
        }else if (mat.matches()) {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");

            // Se intenta evaluar la expresión contenida en la variable cadena
            try {
                evaluacion = engine.eval(cadena);
                
                return evaluacion.toString();

            } catch (ScriptException ex) {
                evaluacion = "Error";
                Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
                return evaluacion.toString();
            }
        }
        return null;
    }

    /**
     * Evalúa la expresión pasada en text y posteriormente realiza la raíz
     * cuadrada dicha expresión
     *
     * @param texto Presunta expresión a calcular la raíz
     * @return Cadena de caracteres con el resultado del cálculo o bien null si
     * la expresión que se pasó no era válida
     */
    static String raizCuadrada(String text) {
        
        String evaluar = Modelo.evaluar(text);
        if("Error".equals(evaluar)){
            return "Error";
        }else if("regex".equals(evaluar)){
            return "regex";
        }else{
        Double numero = Double.valueOf(evaluar);
        numero = Math.sqrt(numero);

        return numero.toString();
        }
    }

}
