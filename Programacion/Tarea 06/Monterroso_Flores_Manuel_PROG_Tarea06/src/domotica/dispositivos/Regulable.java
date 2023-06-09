package domotica.dispositivos;

/**
 * Interfaz Regulable. Las clases que implementen esta interfaz representarán objetos que permitirán regular su intensidad.
 *
 * @author Manuel Monterroso Flores
 * 
 */
public interface Regulable {
    
    /**
     * Incrementa el valor regulable del elemento (intensidad).
     * @return valor alcanzado tras la operación
     */
    public int up();

    /**
     * Decrementa el valor regulable del elemento (intensidad).
     * @return valor alcanzado tras la operación
     */
    public int down();

    /**
     * Obtiene el valor regulable del elemento (intensidad).
     * @return intensidad actual
     */
    public int getIntensidad();
    
}
