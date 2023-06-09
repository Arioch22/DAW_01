package e07_algoritmos;

import e07_algoritmos.model.Producto;
import java.util.*;

/**
 * Uso de algunos algoritmos para colecciones
 *
 * @author Trassierra
 */
public class AlgoritmosColeccionesApp {

    public static void main(String[] args) {

        /**
         * ALGORITMOS DE ORDENACIÓN
         */

        // Definimos una lista de números
        List<Producto> listaProductos = new ArrayList<>(List.of(
                new Producto("PC000123", "Ordenador portátil", 800.0f),
                new Producto("PC000234", "Ordenador compacto", 400.0f),
                new Producto("COMPGAM012", "Auriculares gamer", 75.56f),
                new Producto("MON274K034", "Monitor 27 pulgadas 4K", 325.67f)
        ));

        listaProductos.add( new Producto("MSI0952", "Ordenador gaming", 999.95f ));
        
        
        
        System.out.println("------- ORDEN NORMAL, sin comparator ------------------------------------------------------");
        Collections.sort(listaProductos);
        
        for(Producto p: listaProductos)
        	System.out.println(p + " ");

        
        System.out.println("------- ORDEN por Código -------------------------------------------------------------------");
        Collections.sort(listaProductos, new ComparadorCodigo());

        for(Producto p: listaProductos)
        	System.out.println(p + " ");

        
        System.out.println("------- ORDEN por precio -------------------------------------------------------------------");
        Collections.sort(listaProductos, new ComparadorPrecio());

        for(Producto p: listaProductos)
        	System.out.println(p + " ");

        

        
        System.out.println("------- ORDEN por stock --------------------------------------------------------------------");
        Collections.sort(listaProductos, new ComparadorStock());

        for(Producto p: listaProductos)
        	System.out.println(p + " ");

        
        System.out.println("------- ORDEN por stock inverso -----------------------------------------------------------");
        Collections.sort(listaProductos, new ComparadorStock());
        Collections.reverse(listaProductos);

        for(Producto p: listaProductos)
        	System.out.println(p + " ");
        
        
    }



}

class ComparadorPrecio implements Comparator<Producto> {
    
    public int compare(Producto p1, Producto p2)
    {
        if(p1.getPrecio() > p2.getPrecio() ) return 1;
        else if(p1.getPrecio() < p2.getPrecio() ) return -1;
        else return 0;
    }
}

class ComparadorCodigo implements Comparator<Producto> {
    
    public int compare(Producto p1, Producto p2)
    {
        return p1.getReferencia().compareTo(p2.getReferencia());
    }
}


class ComparadorStock implements Comparator<Producto> {
    
    public int compare(Producto p1, Producto p2)
    {
        return p1.getStock() - p2.getStock();
    }
}