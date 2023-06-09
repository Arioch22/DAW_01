package domotica;

import domotica.dispositivos.Activable;
import domotica.dispositivos.Bombilla;
import domotica.dispositivos.Cerradura;
import domotica.dispositivos.Dispositivo;

/**
 * Clase CasaDomotica. Representa una vivienda domótica con un conjunto de dispositivos domóticos de distintos tipos.
 *
 * @author Manuel Monterroso Flores
 * 
 */
public class CasaDomotica extends java.lang.Object {
    
    Dispositivo [] arrayDispositivos;
    String propietarios;
    String descripcion;

    /**
     * Constructor para una vivenda domótica.
     *
     * @param propietario propietario de la vivienda
     * @param descripcion descripción de la vivienda
     * @param dispositivos lista variable de dispositivos domóticos integrados en la vivienda
     */
    public CasaDomotica​(String propietario, String descripcion, Dispositivo... dispositivos) {
        
        this.propietarios = propietario;
        this.descripcion = descripcion;
        this.arrayDispositivos = new Dispositivo[dispositivos.length];

        for (int i = 0; i < dispositivos.length; i++) {
            
            this.arrayDispositivos[i] = dispositivos[i];
           
        }
    }

    /**
     * Obtiene el número de dispositivos integrados en la vivienda.
     *
     * @return número de dispositivos integrados en la vivienda
     */
    public int getNumDispositivos() {
        
        return arrayDispositivos.length;
    }
    
    /**
     * Obtiene el número de dispositivos de tipo Bombilla integrados en la vivienda.
     *
     * @return número de bombiilas instaladas en la vivienda
     */
    public int getNumBombillas() {

        int bombillasAuxiliar = 0;

        for (int i = 0; i < arrayDispositivos.length; i++) {

            if (arrayDispositivos[i] instanceof Bombilla) {

                bombillasAuxiliar++;
            }
        }

        int numeroBombillas = bombillasAuxiliar;

        return numeroBombillas;
    }
    
    /**
     * Obtiene el número de dispositivos de tipo Cerradura integrados en la vivienda.
     *
     * @return número de cerraduras instaladas en la vivienda
     */ 
    public int getNumCerraduras(){

        int nCerradurasAux = 0;

        for (int i = 0; i < arrayDispositivos.length; i++) {

            if (arrayDispositivos[i] instanceof Cerradura) {

                nCerradurasAux++;
            }
        }

        int nCerraduras = nCerradurasAux;
        return nCerraduras;
    }
    
    /**
     * Cierra todas las cerraduras de la casa que estén aún sin cerrar.
     *
     * @return el número de cerraduras que se han activado (cerrado)
     */
    public int cerrarCerraduras() {
         int nCerraduras = 0;

        for (int i = 0; i < arrayDispositivos.length; i++) {

            if (arrayDispositivos[i] instanceof Cerradura && ((Cerradura) arrayDispositivos[i]).getEstado() !=true) {

                ((Cerradura) arrayDispositivos[i]).on();
                
                nCerraduras++;
            }
        }
        return nCerraduras;
    }
     
    /**
     * Activa todos los dispositivos de la casa que estén aún sin activar.
     *
     * @return el número de dispositivos que se han activado

     */
    public int activarDispositivosActivables() {
        int nDispositivosActivables = 0;
        
        for (int i = 0; i < arrayDispositivos.length; i++) {
            if (arrayDispositivos[i] instanceof Activable && ((Activable)  arrayDispositivos[i]).getEstado() !=true) {
                ((Activable) arrayDispositivos[i]).on();
                nDispositivosActivables++;

            }

        }
        return nDispositivosActivables;
    }
    
    /**
     * Mensaje con la info completa de la casa y de sus habitaciones.
     * @return mensaje completo
     */
    @Override
    public String toString() {
          StringBuilder salidaCajon = new StringBuilder();
//        StringBuilder primeraParteMensaje = new StringBuilder();
//        
//        
//        primeraParteMensaje.append(String.format("Casa DomMonterroso_Flores_Manuel_PROG_Tarea06Monterroso_Flores_Manuel_PROG_Tarea06ótica \n Propietario: %s \n Descripción: %s \n\n", this.propietarios, this.descripcion));
//        primeraParteMensaje.append(String.format("+-------------------------------------------------------+\n"));
//        StringBuilder segundaParteMensaje = new StringBuilder();
//        for (int i = Domotica.MIN_UBICACION; i <= Domotica.MAX_UBICACION; i++) {
//            segundaParteMensaje.append(String.format("Estancia: %d \n \n", i));
//            for (int j = 0; j < arrayDispositivos.length; j++) {
//                if (arrayDispositivos[j].getUbicacion() == i) {
//                    segundaParteMensaje.append(String.format(arrayDispositivos[j].toString() + "\n"));
//                }
//            }
//            segundaParteMensaje.append(String.format("----------------------------------------\n"));
//            
//        }
//        return primeraParteMensaje.toString() + segundaParteMensaje.toString();

        salidaCajon.append(String.format("+-------------------------------------------------------------------------------------+\n"
                + "|Casa Domótica                                                                        |\n"
                + "|Propietario: %-72s|\n"
                + "|Descripción: %-72s|\n", this.propietarios, this.descripcion));
        for (int i = Domotica.MIN_UBICACION; i <= Domotica.MAX_UBICACION; i++) {
            salidaCajon.append(String.format("+-------------------------------------------------------------------------------------+\n"
                    + "|Estancia: %s                                                                          |\n"
                    + "|                                                                                     |\n", i));
            for (int j = 0; j < arrayDispositivos.length; j++) {
                if (arrayDispositivos[j].getUbicacion() == i) {
                    salidaCajon.append(String.format("|%-85s|\n", arrayDispositivos[j].toString()));

                }
            }
        }
        salidaCajon.append(String.format("+-------------------------------------------------------------------------------------+\n"));
        return salidaCajon.toString();
    }
}
