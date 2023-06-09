/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio03;

/**
 *
 * @author alumno
 */
public class Rectangulo implements Poligono {
    
    private final int NUMERO_LADOS;
    private double base;
    private double altura;
    
    Rectangulo (double base, double altura) throws IllegalArgumentException{
        this.NUMERO_LADOS = 4;
        if (base <= 0){
            throw new IllegalArgumentException("La base no puede ser 0 o negativa");
        }
        if (altura <= 0){
            throw new IllegalArgumentException("La altura no puede ser 0 o negativa");
        }
        
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double getArea() {
        return base * altura;
    }

    @Override
    public int getLados() {
        return NUMERO_LADOS;
    }

    @Override
    public double getPerimetro() {
        return (base * 2) + (altura * 2);
    }
    
}
