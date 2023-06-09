package domotica.dispositivos;

/**
 * Clase Bombilla. Representa una lámpara domótica "inteligente". Permite la regulación de su intensidad.
 * 
 * @author Manuel Monterroso Flores
 */
public final class Bombilla extends Dispositivo implements Activable, Regulable  {
    
    private final static int MAX_INTENSIDAD = 10;
    private final static int MIN_INTENSIDAD = 0;
    private int nvm;
    private int intensidad;
    
    /**
     *
     * Constructor de la clase bombilla.
     * @param descripcion nombre del dispositivo
     * @param ubicacion ubicación (número de habitación) del dispositivo
     */
    public Bombilla​(String descripcion, int ubicacion){
        super(descripcion, ubicacion);
        Dispositivo.contador++;
        intensidad = MIN_INTENSIDAD;
        
    }

    /**
     * Obtiene el número de veces que la bombilla ha sido encendida.
     *
     * @return número de veces que la bombilla ha sido encendida
     */
    public int getNumVecesManipulada(){
        return nvm; //aqui se pone las veces que ha sido manipulado el objeto bombilla
    }

    /**
     * Obtiene el estado actual de la bombilla. El valor true significa que la bombilla está encendida (en cualquier intensidad menos la mínima).
     * El valor false que está apagada (mínima intensidad posible).
     *
     * @return estado actual de la bombilla.
     */
    @Override
    public boolean getEstado() {
        return intensidad != MIN_INTENSIDAD;
    }

    /**
     * Apaga la bombilla. Se establece su intensidad al valor mínimo.
     *
     * @throws IllegalStateException - si la bombilla ya está apagada
     */
    @Override
    public void off() throws IllegalStateException {
        if(!getEstado()){
        throw new IllegalStateException(String.format("La bombilla ya esta apagada"));
        }else{
        this.intensidad = MIN_INTENSIDAD;
        nvm++;
        }
        
    }

    /**
     * Enciende la bombilla. Se establece su intensidad al valor máximo.
     *
     * @throws IllegalStateException - si la bombilla ya está encendida
     */
    @Override
    public void on() throws IllegalStateException {
        if(getEstado()){
        throw new IllegalStateException(String.format("La bombilla ya esta encendida"));
        }else{
        this.intensidad = MAX_INTENSIDAD;
        nvm++;
        }
        
    }
    
    /**
     * Incrementa en un punto la intensidad lumínica de la bombilla. 
     * Si ya se ha alcanzado la intensidad máxima, se permanece en la intensidad máxima.
     *
     * @return intensidad alcanzada tras la operación.
     */
    @Override
    public int up() {
        if (this.intensidad < Bombilla.MAX_INTENSIDAD) {
            this.intensidad++;
            nvm++;
            
        }
        return this.intensidad;
    }

    /**
     * Decrementa en un punto la intensidad lumínica de la bombilla. 
     * Si ya se ha alcanzado la intensidad mínima, se permanece en la intensidad mínima.
     *
     * @return intensidad alcanzada tras la operación.
     */
    @Override
    public int down() {
        if (this.intensidad > Bombilla.MIN_INTENSIDAD) {
            this.intensidad--;
            nvm++;
            
        }
        return this.intensidad;
    }

    /**
     * Enciende la bombilla. Se establece su intensidad al valor máximo.
     *
     * @return intensidad actual del bombilla
     */
    @Override
    public int getIntensidad() {
        if (intensidad < MIN_INTENSIDAD || intensidad > MAX_INTENSIDAD){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return this.intensidad;
    }

    /**
     * Devuelve una cadena que representa el estado de la bombilla de forma textual.
     *
     * @return cadena que representa el estado de la bombilla de forma textual
     */
    @Override
    public String toString() {

        String cadena;

        String cadenaEstado = getEstado() ? "encendida" : "apagada";

        cadena = String.format("Tipo: %s  id: %d descripción: %s ubicación: %d estado: %s int: %d NVM: %d",
                this.getClass().getSimpleName(),
                this.getId(),
                this.getDescripcion(),
                this.getUbicacion(),
                cadenaEstado,
                this.intensidad,
                this.nvm);

        return cadena;

    }
}
