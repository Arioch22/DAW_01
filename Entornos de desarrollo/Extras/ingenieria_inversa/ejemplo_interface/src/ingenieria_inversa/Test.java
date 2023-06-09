package ingenieria_inversa;

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // crea array PorPagar con cuatro elementos
        PorPagar objetosPorPagar[] = new PorPagar[4];

        // llena el array con objetos que implementan la interfaz PorPagar
        objetosPorPagar[0] = new Factura("01234", "asiento", 2, 375.00);
        objetosPorPagar[1] = new Factura("56789", "llanta", 4, 79.95);
        objetosPorPagar[2] = new empleadoAsalariado("John", "Smith", "111-11-1111", 800.00);
        objetosPorPagar[3] = new empleadoAsalariado("Lisa", "Barnes", "888-88-8888", 1200.00);

        System.out.println("Facturas y Empleados procesados en forma polimórfica:\n");

        // procesa en forma genérica cada elemento en el array objetosPorPagar
        for (PorPagar porPagarActual : objetosPorPagar) {
            // imprime porPagarActual y su monto de pago apropiado
            System.out.printf("%s \n%s: $%,.2f\n\n", porPagarActual.toString(),
                    "pago vencido", porPagarActual.obtenerMontoPago());
        } // fin de for
    } // fin de main
}
