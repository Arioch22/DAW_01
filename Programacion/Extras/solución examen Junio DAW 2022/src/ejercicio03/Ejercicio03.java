package ejercicio03;

/**
 * Dado el interface Poligono crear dos clases: Rectangulo y PentagonoRegular
 * que implemente sus métodos. Completar el main usando los métodos para 
 * escribir los datos tal y como se ven en la ejecución de la hoja de examen, creando
 * un rectángulo de base 2.5 y altura 8.5, así como un pentágono regular de lado 6
 * 
 * @author portatil_profesorado
 */
public class Ejercicio03 {
    
    public static void main(String[] args) {
        
        // Crear rectángulo
        System.out.println("Crear un rectángulo de base 2.5 y altura 8.5") ;
        Rectangulo rectangulo = new Rectangulo(2.5, 8.5);
        
        System.out.printf("El número de lados del rectángulo es: %d\n", rectangulo.getLados());
        System.out.printf("El área del rectángulo es: %.2f\n", rectangulo.getArea());
        System.out.printf("El perímetro del rectángulo es: %.2f\n", rectangulo.getPerimetro());
		
	/** NOTA:  recuerda que el área de un pentágono regular es: lado multiplicado por lado multiplicado por 1.72 **/
        System.out.println("----------------------------------------------------------");
        System.out.println("Crear un pentágono regular de lado 6.0");
        PentagonoRegular pentagono = new PentagonoRegular(6.0);
        
        System.out.printf("El número de lados del pentágono es: %d\n", pentagono.getLados());
        System.out.printf("El área del pentágono es: %.2f\n", pentagono.getArea());
        System.out.printf("El perímetro del pentágono es: %.2f\n", pentagono.getPerimetro());
    }
    
}
