package e05_mapasClaveValor.ej3;

import e05_mapasClaveValor.model.Contacto;
import e05_mapasClaveValor.model.Producto;

import java.util.TreeMap;

/**
 * Ejemplo de uso de la clase TreeMap<K,V>
 *
 * @author Trassierra
 */
public class TreeMapApp {

    public static void main(String[] args) {

        
        
        
        
        // Instanciamos nuestro TreeMap
        TreeMap<String, Contacto> mapContactos = new TreeMap<>();

            Contacto c1 = new Contacto("García García", "José", "600123123", "jose.garcia@trassierra.com");

        // Añadimos algunos contactos
        Contacto[] arrayContactos = new Contacto[] {
          c1, 
          new Contacto("López Martínez", "Ana", "600456456", "ana.lopez@trassierra.com"),
          new Contacto("Castro Méndez", "Javier", "600789789", "javier.castro@trassierra.com"),
          new Contacto("Laínez Muñoz", "María", "698765432", "maria.lainez@trassierra.com")
        };

        for (Contacto contacto : arrayContactos) {
            mapContactos.put(contacto.getNombreApellidoKey(), contacto);
        }
        
        
        

        // Claves disponibles en el Mapa
        System.out.println("\n ----- Claves en el mapa ----- ");
	System.out.println(mapContactos.keySet() );
        
        
        
        // Si los obtenemos, nos aparecen en el orden de las claves, es decir, Apellido, Nombre

        System.out.println("\n ----- Lista de contactos (aparecen ordenados por la clave) ----- ");
        for (String contacto : mapContactos.keySet()) {
        	System.out.println(mapContactos.get(contacto).toString());
        }

        
        // Si añadimos un nuevo contacto, se inserta en orden
        Contacto nuevoContacto = new Contacto("Fernández Hernández", "Juan", "612345678", "juan.fernandez@trassierra.com");
        mapContactos.put(nuevoContacto.getNombreApellidoKey(), nuevoContacto);

        
        
        // Claves disponibles en el Mapa
        System.out.println("\n ----- Claves en el mapa ----- ");
	System.out.println(mapContactos.keySet() );
        
        
        
        
        System.out.println("\n ----- Lista de contactos (tras insertar se mantiene el orden) ----- ");
        // Si los volvemos a obtener todos, nos vuelven a aparecer en el orden natural de la clave

        for (String contacto : mapContactos.keySet()) {
        	System.out.println(mapContactos.get(contacto).toString());
        }
        
        
        
        System.exit(0);




    }


}
