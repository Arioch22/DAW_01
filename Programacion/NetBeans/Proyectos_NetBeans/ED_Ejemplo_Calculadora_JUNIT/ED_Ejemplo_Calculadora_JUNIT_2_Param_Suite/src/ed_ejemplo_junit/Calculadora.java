
package ed_ejemplo_junit;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Calculadora {
    
    private int resultado;
    
    public Calculadora(){
        resultado = 0;
    }
    
    //realiza la suma de 2 números enteros
    public int add(int a, int b){
        resultado= a+b;
        return resultado;
    }
    
    //realiza la resta de 2 números enteros
    public int sub(int a, int b){
        resultado= a-b;
        return resultado;
    }
    
    //realiza la división entre 2 números enteros
    public int div(int a, int b){
        if(b==0){
            throw new ArithmeticException("No puedes dividir entre 0!!");
            //Aclara el error para que lo podamos localizar
        }
        resultado= a/b;
        return resultado;
    }
    
    //sumar v a resultado
    public int add(int v){
        resultado+=v;//resultado = resultado + v;
        return resultado;
    }
    //restar v a resultado
    public int sub(int v){
        resultado-=v;//resultado = resultado - v
        return resultado;
    }
    
    public int resultado(){
        return resultado;
    }
    
    public void c(){
        resultado=0;
    }
    
    public void operacionOptima(){
        try {
            Thread.sleep(2000);//Para que el hilo duerma 2000 milisegundos
        } catch (InterruptedException ex) {
            //Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
            //Mensaje del log de errores
        }
        //try - catch recorre las posibles excepciones que puedan ocurrir
        //En este caso, que despierten el hilo
    }
    
}
