/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba_taquilla;

/**
 *
 * @author Anabel
 */
public class Taquilla {

    private String nombre;
    private double precio;
    private int aforo;
    private int aforo_disponible;

    /* Constructor sin argumentos */
    public Taquilla() {
    }
    //Constructor con parámetro para iniciar todas las propiedades de la clase Taquilla

    public Taquilla(String nom, double prec, int plaz, int plazas_disp) {
        this.nombre = nom;
        this.precio = prec;
        this.aforo = plaz;
        this.aforo_disponible = plazas_disp;
    }

    // Método que me devuelve el aforo disponibles en cada momento
    public int consultar_aforo_disp() {
        return aforo_disponible;
    }

    /* Método para reservar una entrada. Modifica el aforo disponible. */
    public void reservar_entrada(int cantidad) throws Exception {
        if (cantidad == 0) {
            throw new Exception("No se pueden reservar 0 entradas");
        }

        /* Comprueba si la cantidad que se intenta reservar es 0 y de ser así lanza una
Excepción para avisar de que no se puede y se termine la ejecución */
        if (cantidad > this.aforo_disponible) {
            throw new Exception("No hay suficiente aforo");
        }
        
       this.aforo_disponible-= cantidad;//this.aforo_disponible=this.aforo_disponible-cantidad;
        /* En caso de que la cantidad sea
mayor que el aforo disponible y superior a 0 se disminuirá el aforo disponible la
cantidad reservada */
    }
}


