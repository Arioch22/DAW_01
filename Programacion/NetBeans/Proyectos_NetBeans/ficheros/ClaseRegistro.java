package ficheros;

public class ClaseRegistro {

    private String nombre;
    private int edad;
    private double peso;

    ClaseRegistro(String nom, int nEdad, double nPeso) {
        nombre = nom;
        edad = nEdad;
        peso = nPeso;
    }

    public String muestraRegistro() {
        return nombre + " " + edad + " " + peso;
    }

    public String dameNombre() {
        return nombre;
    }
}
