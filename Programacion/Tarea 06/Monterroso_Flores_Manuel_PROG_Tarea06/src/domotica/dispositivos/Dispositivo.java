package domotica.dispositivos;

/**
 * Clase Dispositivo. Representa un dispositivo domótico genérico. Contendrá información relativa a su identificación única, una descripción y su ubicación en la vivienda.
 *
 * @author Manuel Monterroso Flores
 * 
 * 
 */
public abstract class Dispositivo extends java.lang.Object {

    private String descripcion;
    private int ubicacion;
    private int id;

    /**
     * variable para ir acumulando los dispositivos que se van creando para luego pasarlos a ID
     */
    protected static int contador=1;

    /**
     * Constructor de dispositivo domótico
     * @param descripcion descripcion del dispositivo
     * @param ubicacion ubicación (número de habitación) del dispositivo
     * @throws IllegalArgumentException - si el número de habitación no es válido
     */
    public Dispositivo(String descripcion, int ubicacion) throws IllegalArgumentException {
        if (ubicacion < 1 || ubicacion > 5) {
            throw new IllegalArgumentException(String.format("Número de Ubicación incorrecto: %d", ubicacion));
        }
        this.descripcion=descripcion;
        this.ubicacion=ubicacion;
        id=contador;
    }

    /**
     * Obtiene el id del dispositivo
     * @return id del dispositivo
     */
    public int getId() {
        return this.id;
    }

    /**
     * Obtiene el descripcion del dispositivo
     * @return descripcion del dispositivo
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Obtiene la ubicación del dispositivo
     * @return ubicación del dispositivo
     */
    public int getUbicacion() {
        return this.ubicacion;
    }

    /**
     * Devuelve una cadena que representa el estado de la bombilla de forma textual.
     * @return cadena que representa el estado de la bombilla de forma textual
     */
    @Override
    public String toString() {
        return String.format("tipo:%-11s id:%d descripción:\"%s\" ubicacion:%d",
                this.getClass().getSimpleName(), this.id, this.descripcion, this.ubicacion);
    }
}
