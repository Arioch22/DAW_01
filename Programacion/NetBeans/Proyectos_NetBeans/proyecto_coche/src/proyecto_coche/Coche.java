/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_coche;

/**
 *
 * @author Profesor
 */
public class Coche {

    private String marca;
    private String modelo;
    private int kilometraje;

    public Coche(String ma, String mo) {
        this.marca = ma;
        this.modelo = mo;
        this.kilometraje = 0;

    }

    public int getKilometraje() {
        return this.kilometraje;
    }

    public void recorre(int km) {
        if (km > 0) {
            this.kilometraje = km;
        }
    }

    public int costeTotal(int num_viajes) {
        int promedio;
        int precio = 0;
        promedio = this.kilometraje / num_viajes;
        if (promedio > 500) {
            precio = promedio * 5;
        } else {
            precio = promedio * 2;
        }

        return precio;
    }

}
