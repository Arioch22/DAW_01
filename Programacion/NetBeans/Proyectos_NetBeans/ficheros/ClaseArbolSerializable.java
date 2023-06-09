package ficheros;

import java.io.*;

public class ClaseArbolSerializable implements Serializable {

    private String nombreVulgar;
    private String nombreCientifico;
    private transient double alturaMedia;

    ClaseArbolSerializable(String nombre) {
        this.nombreVulgar = nombre;
    }

    public void ponNombreCientifico(String nombre) {
        this.nombreCientifico = nombre;
    }

    public void ponAlturaMedia(double altura) {
        alturaMedia = altura;
    }

    public String muestraArbol() {
        return nombreVulgar + " "
                + nombreCientifico + " " + alturaMedia;
    }
}
