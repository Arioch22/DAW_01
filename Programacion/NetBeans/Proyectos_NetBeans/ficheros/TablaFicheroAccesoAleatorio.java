package ficheros;

import java.io.*;

public class TablaFicheroAccesoAleatorio {

    private RandomAccessFile miTabla;
    private int numeroRegistros;
    private final int LONGITUD_REGISTRO = 52;
    private final int DESPLAZAMIENTO = 4;

    TablaFicheroAccesoAleatorio(String tabla) {
        try {
            miTabla = new RandomAccessFile(tabla, "rw");
            if (miTabla.length() == 0) {
                numeroRegistros = 0;
            } else {
                numeroRegistros = miTabla.readInt();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public int dameNumeroRegistros() {
        return numeroRegistros;
    }

    public ClaseRegistro leeRegistro(int nRegistro)
            throws IOException {
        String nombre = "";
        int edad;
        double peso;
        miTabla.seek((nRegistro - 1) * LONGITUD_REGISTRO + DESPLAZAMIENTO);
        for (int i = 0; i < 20; i++) {
            nombre += miTabla.readChar();
        }
        edad = miTabla.readInt();
        peso = miTabla.readDouble();
        return (new ClaseRegistro(nombre, edad, peso));
    }

    public void escribeRegistro(String nombre, int edad,
            double peso, int nRegistro) throws IOException {
        int longitud = nombre.length();
        miTabla.seek((nRegistro - 1) * LONGITUD_REGISTRO + DESPLAZAMIENTO);
        for (int i = 0; i < 20; i++) {
            if (i < longitud) {
                miTabla.writeChar(nombre.charAt(i));
            } else {
                miTabla.writeChar(' ');
            }
        }
        miTabla.writeInt(edad);
        miTabla.writeDouble(peso);
        numeroRegistros++;
    }

    public void cierraTabla() throws IOException {
        miTabla.seek(0);
        miTabla.writeInt(numeroRegistros);
        miTabla.close();
    }
}
