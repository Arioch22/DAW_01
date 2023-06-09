package calculadora;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author 
 */
public class Calculadora extends Application {
    
    @Override
    public void start(Stage stage) {   
        
        Parent root;
        try {
            
            // El contenido del archivo FXML se carga dentro de un contenedor 
            // (será un AnchorPane como se ve dentro del fichero fxml) que se 
            // almacena en la variable root. Dicho contenedor será el 
            // contenedor principal de los elementos gráficos de la aplicación,
            // y por ello en la línea siguiente se le asigna a la escena (Scene)
            // de la ventana de la aplicación.
            root = FXMLLoader.load(getClass().getResource("MiVistaFXML.fxml"));
            Scene scene = new Scene(root);
            // Se asigna la escena al escenario
            stage.setScene(scene);
            // Se aigna el título  (Indicar título)
            stage.setTitle(" ");
            // Se muestra el escenario
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}