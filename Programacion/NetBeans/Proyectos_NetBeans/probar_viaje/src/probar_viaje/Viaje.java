/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package probar_viaje;

/**
 *
 * @author Anabel
 */
public class Viaje {

    private String nombre;
    private String origen;
    private String destino;
    private int plazas;
    private int plazas_disponibles;
    private double precio;

    /* Constructor sin argumentos */
    public Viaje() {
    }
// Constructor con parámetro para iniciar todas las propiedades de la clase viaje

    public Viaje(String nom, String orig, String dest, int plaz, int plazas_disp, double prec) {
        this.nombre = nom;
        this.origen = orig;
        this.destino = dest;
        this.plazas = plaz;
        this.plazas_disponibles = plazas_disp;
        this.precio = prec;
    }
// Método para asignar el nombre del viaje

    public void asignarNombre(String nom) {
        nombre = nom;
    }
// Método que me devuelve el nombre del viaje

    public String obtenerNombre() {
        return nombre;
    }
// Método que me devuelve las plazas que tiene el viaje

    public int consultar_plazas() {
        return plazas;
    }
// Método que me devuelve las plazas disponibles en cada momento

    public int consultar_plazas_disp() {
        return plazas_disponibles;
    }

    /* Métodos para reservar y anular plazas. Modifica las plazas disponibles.*/
    public void reservar(int cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("No se puede reservar un nº negativo de plazas");
        }
        if (cantidad > plazas_disponibles) {
            throw new Exception("No se pueden reservar más plazas de las que quedan disponibles");
        }
        plazas_disponibles = plazas_disponibles - cantidad;
    }

    public void anular_reserva(int cantidad) throws Exception {
        if (cantidad <= 0) {
            throw new Exception("No se puede anular una cantidad negativa de plazas");
        }
        if (consultar_plazas() < cantidad) {
            throw new Exception("No se pueden anular más plazas de las que hay");
        }
        if (cantidad > (consultar_plazas() - consultar_plazas_disp())) {
            throw new Exception("No se pueden anular más plazas de las que hay reservadas");
        }
        plazas_disponibles = plazas_disponibles + cantidad;
    }

}
