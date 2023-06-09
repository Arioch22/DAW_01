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
public class PentagonoRegular implements Poligono {
    
    private final int NUMERO_LADOS;
    private double ladoSize;

    PentagonoRegular (double ladoSize) throws IllegalArgumentException {
        this.NUMERO_LADOS = 5;
        if (ladoSize <= 0){
            throw new IllegalArgumentException("El tamaño de los lados no puede ser 0 o negativo");
        }
        this.ladoSize = ladoSize;
    }
    
    @Override
    public double getArea() {
        return ladoSize * ladoSize * 1.72;
    }

    @Override
    public int getLados() {
        return NUMERO_LADOS;
    }

    @Override
    public double getPerimetro() {
        return ladoSize * NUMERO_LADOS;
    }
    
}
