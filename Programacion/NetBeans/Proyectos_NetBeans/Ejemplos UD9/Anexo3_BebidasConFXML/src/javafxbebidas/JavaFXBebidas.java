package javafxbebidas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * Clase principal para la gestión de bebidas. 
 * @author Profesor
 */
public class JavaFXBebidas extends Application {
    
    private TextField campoNombre ;
    private TextField campoColor ;
    private TextField campoUnidades ;
    
    // Declarar arraylist para almacenar los inmuebles
    private static ArrayList <Bebida> listaBeb = new ArrayList() ;
    
    @Override
    public void start(Stage primaryStage) {
     
        startConFXML(primaryStage);
        
    }

        
    public void startConFXML(Stage primaryStage) {

        //Obtenemos un recurso en el directorio de la clase actual.
        URL urlDelRecurso = getClass().getResource("FXMLBebidas.fxml");

        //Creamos una instancia de FXMLLoader para cargar el recurso dada su localización (URL)
        FXMLLoader loader = new FXMLLoader(urlDelRecurso);
        try {
            //Cargamos (loader.load()) el recurso / nodo contenedor.
            Parent root = loader.load();

            //Establecemos el nodo raiz de la escena como el contenedor anterior
            Scene scene = new Scene(root);

            //Establecemos la escena de este escenario como la anterior.
            primaryStage.setScene(scene);

            primaryStage.setTitle("Bebidas (usando FXML)");

            primaryStage.show();
        } catch (IOException ex) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Información.");
            alert.setContentText("No se pudo cargar la version que usa FXML.") ;
            alert.setHeaderText(null);
            alert.showAndWait() ; 
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    /**
     * Almacena el arraylist de inmuebles en el disco.
     * @param lista Arraylist a guardar en disco
     * @return true si se guarda el fichero sin error
     */
    public static boolean guardarArrayEnFichero(ArrayList<Bebida> lista) {
        boolean almacenado = false ; // Con esta variable devolverá true si todo
          //ha ido bien, y false en caso contrario.

        try {
            FileOutputStream fichero = new FileOutputStream(new File("bebidas.dat"));
            ObjectOutputStream ficheroSalida;
            ficheroSalida = new ObjectOutputStream(fichero);
            // Guardar la lista de objetos
            ficheroSalida.writeObject(lista) ;
                                   
            // Cerrar fichero
            ficheroSalida.close();

            // Indicamos que lo que hayacambiado se ha guardado
            almacenado = true;
                        
        } catch (FileNotFoundException fnfe) {
            System.err.println("Error: El fichero no existe." + fnfe.getMessage());     
        } catch (IOException ioe) {
            System.err.println("Falló la grabación de datos: "  + ioe.getMessage());
        }
        return almacenado ;
    }
    
    
    /**
     * Lee la información que contiene el archivo utilizando la clase
     * FileInputStream. Con el método readObject se carga la información en la
     * lista.
     * 
     * @return  El arraylist relleno con los inmuebles o vacío si no hay datos en 
     * el fichero.
     */
    public static ArrayList <Bebida> cargarLista() {

        ArrayList<Bebida> vector = new ArrayList();

        try {
            FileInputStream fichero =
                    new FileInputStream(new File("bebidas.dat"));
            
            // Comenzamos por el array de inmuebles.
            try (ObjectInputStream ficheroEntrada = new ObjectInputStream(fichero)) {
                // Leemos los datos en el mismo orden que los escribimos.
                // Comenzamos por el array de inmuebles.
                vector = (ArrayList<Bebida>) ficheroEntrada.readObject();
                
            }
            
        } catch (ClassNotFoundException cnfe) {
            System.err.println( "No se pudo acceder a la clase "
                    + "adecuada para revertir la Serialización al leer "
                    + "del fichero."  + cnfe.getMessage());
            
        } catch (FileNotFoundException fnfe) {
             System.err.println( "Error: El fichero no existe." +
                    fnfe.getMessage()); 
        } catch (IOException ioe) {
             System.err.println("Error de Entrada/Salida: "
                    + "falló la lectura del fichero. La aplicación sigue "
                    + "funcionando sin haber cargado los datos del archivo,"
                    + " para permitir crearlo de nuevo." + ioe.getMessage()); 
        }
        return vector;
    }
    
}