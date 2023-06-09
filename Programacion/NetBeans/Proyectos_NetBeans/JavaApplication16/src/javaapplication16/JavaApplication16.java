/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication16;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author arioch
 */
public class JavaApplication16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena ="9+1/2";
        Object evaluacion;
        Pattern pat = Pattern.compile("^[-+]?[\\d]+(\\.\\d+)?([-+/*]+[\\d]+((\\.\\d+)?))*$");
        
        Matcher mat = pat.matcher(cadena);
        

        if (mat.find()) {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");

            // Se intenta evaluar la expresión contenida en la variable cadena
            try {
                evaluacion = engine.eval(cadena);
                System.out.println("El resultado es: "+evaluacion);

            } catch (ScriptException ex) {
                evaluacion = "Error";
            }
        }
    
    }
}
