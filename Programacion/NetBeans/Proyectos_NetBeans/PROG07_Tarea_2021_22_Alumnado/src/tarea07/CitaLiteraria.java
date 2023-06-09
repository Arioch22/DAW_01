package tarea07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase CitaLiteraria
 * @author profe
 */
public class CitaLiteraria {
    private final String texto;
    private final List<String> obras;
    
    /** Constructor
     * 
     * @param texto Conteindo de la cita literaria (texto)
     * @param obras Títulos de las obras donde aparece esa cita literaria
     */
    public CitaLiteraria (String texto, String ... obras) {
        this.texto= texto;
        this.obras= new LinkedList<>();
        this.obras.addAll(Arrays.asList(obras));
    }
    
    /**
     * Obtiene el texto de la cita literaria.
     * @return Texto de la cita literaria.
     */
    public String getTexto() {
        return this.texto;
    }
    
    /**
     * Obtiene la cantidad de obras en las que la cita aparece
     * @return cantidad de obras en las que la cita aparece
     */
    public List getUsos() {
        return this.obras;
    }

    /**
     * Obtiene una representació textual de la cita literaria.
     * Aparece encerrada entre llaves ({...}). El primer elemento será el contenido
     * o texto de la cita entre comillas. El resto de elementos, encerrados en unos 
     * corchetes, y separados por comas, serán los títulos de las obras en las que 
     * aparece esa cita.
     * @return una representación textual de la cita literaria.
     */
    @Override
    public String toString() {
        return String.format ("{\"%s\", %s}", 
                this.getTexto(),
                this.getUsos());
    }        
}
    

