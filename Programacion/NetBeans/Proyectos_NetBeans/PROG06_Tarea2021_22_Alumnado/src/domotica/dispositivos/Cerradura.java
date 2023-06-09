package domotica.dispositivos;

/**
 * Clase Cerradura. Representa un mecanismo de cerradura domótica. Podrá estar abierta o cerrada.
 * 
 * @author Manuel Monterroso Flores
 * 
 */
public final class Cerradura extends Dispositivo implements Activable {
    
    private boolean estado;
//    private String descripcion;
//    private int ubicacion;
    
    /**
     *
     * @param descripcion descripción del dispositivo
     * @param ubicacion ubicación (número de habitación) del dispositivo
     */
    public Cerradura​(String descripcion, int ubicacion) {
        super(descripcion,ubicacion);
        //this(descripcion, ubicacion, false);
        Dispositivo.contador++;
    }
    
    /**
     * Constructor con tres parámetros.

     *
     * @param descripcion descripción del dispositivo
     * @param ubicacion ubicación (número de habitación) del dispositivo
     * @param estado estado inicial del dispositivo (cerradura abierta o cerrada)
     */
    public Cerradura​(String descripcion, int ubicacion, boolean estado) {
        //super(descripcion,ubicacion);
        this(descripcion,ubicacion);
        Dispositivo.contador++;
        this.estado = estado;
    }
    
    
    

    /**
     * Obtiene el estado actual de la cerradura. El valor true significa que la cerradura está cerrada. El valor false indica que está abierta.
     *
     * @return estado actual de la bombilla.
     */
    @Override
    public boolean getEstado() {
        return this.estado;
    }

    /**
     * Desactiva la cerradura (abre)
     *
     * @throws IllegalStateException - si la cerradura ya está abierta (desactivada)
     */
    @Override
    public void off() throws IllegalStateException {
        if (!estado) {
        throw new IllegalStateException(String.format("La cerradura ya esta abierta"));
        }
        else{
        this.estado = false;
        }
        
    }

    /**
     * Activa la cerradura (cierra)
     *
     * @throws IllegalStateException - si la cerradura ya está cerrada (activada)
     */
    @Override
    public void on() throws IllegalStateException {
        if (estado) {
        throw new IllegalStateException(String.format("La cerradura ya esta cerrada"));
        }
        else{
        this.estado = true;
        }
        
    }
    
    /**
     * Devuelve una cadena que representa el estado de la cerradura de forma textual.
     *
     * @return cadena que representa el estado de la cerradura de forma textual
     */
    @Override
    public String toString() {

        String cadena;

        String cadenaEstado = this.estado ? "cerrada" : "abierta";

        cadena = String.format(
                "Tipo: %s id: %d descripción: %s ubicación: %d estado: %s ",
                this.getClass().getSimpleName(),
                this.getId(),
                this.getDescripcion(),
                this.getUbicacion(),
                cadenaEstado);

        return cadena;

    }
}
