package domotica.dispositivos;

/**
 *
 * Interfaz Activable. Las clases que implementen esta interfaz representarán objetos que podrán activarse y desactivarse.
 * @author Manuel Monterroso Flores
 */
public interface Activable {

    /**
     *  Desactiva el elemento.
     * 
     * @throws IllegalStateException - si el elemento ya estaba desactivado
     *
     */
    public void off() throws IllegalStateException;

    /**
     * Activa el elemento.
     * @throws IllegalStateException - si el elemento ya estaba activado
     * 
     */
    public void on() throws IllegalStateException;

    /**
     *
     * Obtiene el estado del elemento. Si está activado será true. Si no lo está será false.
     * @return estado actual del elemento
     * 
     */
    public boolean getEstado();

}

