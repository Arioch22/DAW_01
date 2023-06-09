/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bote;

/**
 *
 * @author ozymandias
 */
public class Bote {
    private int contenido;//Centilitros de pintura disponibles en el bote
    private int centilitros_metro;//Centrilitros necesarios para pintar un metro cuadrado
    private String color;//Color de la pintura
    int precio;//Precio en céntimos del centilitro de pintura
    private int capacidad;//Número máximo de centilitros que caben en el bote
    
    /*Constructor por defecto*/
    public Bote(){}
    
    /*Constructor por parámetros*/
    public Bote(int contenido, int centilitros_metro, String color,int precio, int capacidad){
    this.contenido=contenido;
    this.centilitros_metro=centilitros_metro;
    this.color=color;
    this.precio=precio;
    this.capacidad=capacidad;
    }

    /**
     * Método que devuelve el contenido en centilitros del bote
     */
    public int getContenido() {
        return contenido;
    }

    /**
     * Método que modifica los centilitros que contiene el bote de pintura.
     */
    public void setContenido(int contenido) {
        this.contenido = contenido;
    }
    
    /**
     * Método que permite pintar una superficie, es necesario que haya suficiente pintura en el bote
     * y que la superficie que se va a pintar sea positiva
     */
    public void pintar(int metros) throws Exception{
        if(metros*this.centilitros_metro>this.contenido)
            throw new Exception("No hay pintura suficiente para pintar esa superficie");
        if(metros<=0)
            throw new Exception("No tiene sentido pintar una superficie que no sea positiva");
        this.contenido=this.contenido - (metros*this.centilitros_metro);
    }
    
    /**
     * Método que permite aumentar el contenido del bote de pintura, es necesario que la cantidad
     * que se quiere añadir y el dinero con que se va a pagar sean positvos, además el dinero debe
     * ser suficiente para pagar la cantidad que se va a añadir
     */
    public void rellenar(int centilitros, int centimos) throws Exception{
        if (centimos<=0){
        throw new Exception("Se necesita una cantidad positiva de dinero");
    }
    if (centilitros<=0){
        throw new Exception("Los centilitros deben ser positivos");
    }
    
    if (this.contenido + centilitros > capacidad) {
            throw new Exception("No se puede superar la capacidad del bote");
        }
    if (centimos < centilitros * precio){
            throw new Exception("No tiene dinero suficiente");
    }
    this.contenido=this.contenido+centilitros;
    }
   
    
    
    
}
