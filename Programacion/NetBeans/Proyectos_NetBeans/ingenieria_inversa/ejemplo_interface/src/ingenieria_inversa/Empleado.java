package ingenieria_inversa;

public abstract class Empleado implements PorPagar {

    private String nombre;
    private String apellido;
    private String nss;

    public Empleado(String nombre, String apellido, String nss) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nss = nss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String toString() {
        return String.format("%s %s\nnúmero seguridad social: %s",
                getNombre(), getApellido(), getNss());
    }

}
