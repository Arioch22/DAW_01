package examenfeb;

/**
 * Clase que modela un estudiante considerando su nombre, nota media numérica 
 * real y número de notas que se tienen en cuenta para calcular esa nota media
 * 
 * @author Profesor
 */
public class Estudiante {
   
    // Atributos
    private static String nombre;
    private static double notaMedia;
    private static int numNotas;

    public static String getNombre() {
        return nombre;
    }

    public static double getNotaMedia() {
        return notaMedia;
    }

    public static int getNumNotas() {
        return numNotas;
    }
    

    // Constructores
    
    public Estudiante (String nombre, double notaMedia, int numNotas)throws IllegalArgumentException{
        
        if(notaMedia < 0 || numNotas < 0){
            throw new IllegalArgumentException(String.format("Datos iniciales erróneos"));
        }
        this.nombre = nombre;
        this.notaMedia = notaMedia;
        this.numNotas = numNotas;
    }




    // Métodos
    public boolean actualizarNotaMedia(double nuevaNota){
        if (nuevaNota >= 0) {
            return true;
            
        }else{
            return false;
        }
    }
    
    public char calificaionMedia(){
        if(this.notaMedia >= 9){
            return 'A';
        }else if (this.notaMedia >= 8){
            return 'B';
        }else if (this.notaMedia >= 7){
            return 'C';
        }else if (this.notaMedia >= 6){
            return 'D';
        }else if (this.notaMedia >= 5 ){
            return 'E';
        }else{
            return 'F';
        }
        
    }
    
    @Override
    public String toString(){
        return String.format("{Estudiante: %d, nota media: %d, número de notas: %d}",
                this.nombre,this.notaMedia,this.numNotas);
    }
    
    
    

    /**
     * @param args the command line arguments
     */
        //----------------------------------------------
        //   PROGRAMA DE PRUEBA DE LA CLASE ESTUDIANTE
        //----------------------------------------------
    public static void main(String[] args) {
        
        System.out.println("PROGRAMA DE PRUEBA DE LA CLASE ESTUDIANTE");
        System.out.println("-----------------------------------------");

                
       

    }

  
    
}
