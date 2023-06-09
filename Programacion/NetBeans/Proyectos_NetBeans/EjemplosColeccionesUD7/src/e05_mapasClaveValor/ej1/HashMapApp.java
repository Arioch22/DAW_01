package e05_mapasClaveValor.ej1;

import e05_mapasClaveValor.model.Producto;

import java.util.HashMap;
import java.util.Map;

/**
 * Ejemplo de uso de la implementación HashMap<K,V>
 *
 * @author Trassierra
 */
public class HashMapApp {

    public static void main(String[] args) {

        // HashMap tiene unos constructores muy parecidos a HashSet
        Map<String, Producto> hashMap = new HashMap<>();

        // Insertamos varios productos
        Producto pc = new Producto("PC000123", "Ordenador portátil", 800.0f);
        Producto pc2 = new Producto("PC000234", "Ordenador compacto", 400.0f);
        
        hashMap.put("PC000123", pc);
        hashMap.put("PC000234", pc2);
        
        hashMap.put("COMPGAM012", new Producto("COMPGAM012", "Auriculares gamer", 75.56f));
        hashMap.put("MON274K034", new Producto("MON274K034", "Monitor 27 4K", 325.67f));

        // Si insertamos una referencia que ya existe, simplemente reemplaza el valor
        hashMap.put("MON274K034", new Producto("MON274K034", "Monitor 29 4K", 380.0f));
        
        
        // Se puede insertar un valor sí o solo sí la clave no está insertada,
        // y si lo está, nos devuelve el valor antiguo. En otro caso devuelve nulo
        Producto monitor = hashMap.putIfAbsent("MON274K034", new Producto("MON274K034", "Monitor 27 4K", 450.0f));

        
        if ( monitor == null ) /// se inserto
        {
            System.out.println("El producto se insertó correctamente\n\n");
        }
        else /// no se pudo insertar
        {
            System.out.println("No se insertó, el producto ya estaba en el map con estos datos: " + monitor +"\n\n");
        }
        
        // Se puede comprobar si se contiene alguna clave, o algún valor.
        if (hashMap.containsKey("PC000123")) {
            System.out.println("El Map contiene la clave");
        }

        if (hashMap.containsValue(pc)) {
            System.out.println("El Map contiene el valor de la instancia " + pc );
        }

        // La forma tradicional de recorrerla es mediante un bucle for-each sobre las claves
        for (String key : hashMap.keySet()) {
            System.out.printf( "%s : %s\n", key , hashMap.get(key));
        }
        
        /// otro tipo de recorrido 
        System.out.printf( "\n\nOtro tipo de recorrido sobre el map (usando entrySet):\n");
        for (Map.Entry<String, Producto> elemento: hashMap.entrySet())
        {
            System.out.printf("%s : %s\n",elemento.getKey(),elemento.getValue());
        }
        
        
        
        
    }
}
