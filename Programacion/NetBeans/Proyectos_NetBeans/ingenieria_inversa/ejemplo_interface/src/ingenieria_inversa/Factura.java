package ingenieria_inversa;

public class Factura implements PorPagar {

    private String numeroPieza;
    private String descripcionPieza;
    private int cantidad;
    private double precioPorArticulo;

    // constructor con cuatro argumentos
    public Factura(String pieza, String descripcion, int cuenta, double precio) {
        numeroPieza = pieza;
        descripcionPieza = descripcion;
        setCantidad(cuenta); // valida y almacena la cantidad
        setPrecioPorArticulo(precio); // valida y almacena el precio por artículo
    } // fin del constructor de Factura con cuatro argumentos

    // establece el número de pieza
    public void setNumeroPieza(String pieza) {
        numeroPieza = pieza;
    } // fin del método establecerNumeroPieza

    // obtener número de pieza
    public String getNumeroPieza() {
        return numeroPieza;
    } // fin del método obtenerNumeroPieza

    // establece la descripción
    public void setDescripcionPieza(String descripcion) {
        descripcionPieza = descripcion;
    } // fin del método establecerDescripcionPieza

    // obtiene la descripción
    public String getDescripcionPieza() {
        return descripcionPieza;
    } // fin del método obtenerDescripcionPieza

    // establece la cantidad
    public void setCantidad(int cuenta) {
        cantidad = (cuenta < 0) ? 0 : cuenta; // cantidad no puede ser negativa
    } // fin del método establecerCantidad

    // obtener cantidad
    public int getCantidad() {
        return cantidad;
    } // fin del método obtenerCantidad

    // establece el precio por artículo
    public void setPrecioPorArticulo(double precio) {
        precioPorArticulo = (precio < 0.0) ? 0.0 : precio; // valida el precio
    } // fin del método establecerPrecioPorArticulo

    // obtiene el precio por artículo
    public double getPrecioPorArticulo() {
        return precioPorArticulo;
    } // fin del método obtenerPrecioPorArticulo
    // devuelve representación String de un objeto Factura

    public String toString() {
        return String.format("%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f",
                "factura", "numero de pieza", getNumeroPieza(), getDescripcionPieza(),
                "cantidad", getCantidad(), "precio por articulo", getPrecioPorArticulo());
    } // fin del método toString

    // método requerido para realizar el contrato con la interfaz PorPagar
    public double obtenerMontoPago() {
        return getCantidad() * getPrecioPorArticulo(); // calcula el costo total
    } // fin del método obtenerMontoPago

}
