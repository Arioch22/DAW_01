package javafxcomunicando;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Ejemplo para mostrar el paso de valores entre ventanas con JavaFX
 * campoTexto se crea en la venta principal, y como se ve en el código
 * se accede a él desde al ventana secundaria.
 * 
 * @author JJBH
 */
public class JavaFXComunicando extends Application {
    
    protected TextField campoTexto ;
    private Label etiqueta ;
        
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Principal");
        
        // Crear panel
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        
        // Crear escena
        Scene scene = new Scene(root, 700, 200);
        
        // Crear una etiqueta 
        etiqueta = new Label();
        etiqueta.setText("Pulse botón para seleccionar valor a pegar en el campo");
        
        // Crear un campo de texto
        campoTexto = new TextField();
        // Crear un botón
        Button boton = new Button("Pulsa para escoger un valor");
        // Cuando se pulse el botón se abrirá una ventana secundaria
        boton.setOnAction(eve-> new VentanaSecundaria(this));
            
        // Añadir el campo de texto al panel
        root.getChildren().addAll(etiqueta, campoTexto, boton);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    

    /**
     * Main para lanzar la aplicación.
     * @param args 
     */
    public static void main(String[] args) {   
        Application.launch(args);
    }


}

/**
 * Esta clase corresponde a la ventana secundaria que se abrirá cuando se pulse
 * el botón desde la ventana principal.
 * 
 * @author JJBH
 */
class VentanaSecundaria {
    
    /**
     * Constructor de la ventana secundaria. Recibe como parámetro el objeto
     * correspondiente a la ventana principal, que aprovechará para acceder
     * al campo texto de dicha ventana principal.
     * 
     * @param ventanaPrincipal Ventana principal.
     */
    VentanaSecundaria(JavaFXComunicando ventanaPrincipal) {
        
        // Crear un nuevo escenario
        Stage secunStage = new Stage();
        // Dar título
        secunStage.setTitle("Ventana secundaria");
        // Hacer la venta modal para evitar que se pueda volver a la principal
        // sinb cerrar ésta.
        secunStage.initModality(Modality.APPLICATION_MODAL);

        // Crear un panel para depositar los controles botón sobre él.
        FlowPane panel = new FlowPane();
        panel.setAlignment(Pos.CENTER);
        // Crear la escena pasándole el panel
        Scene scene = new Scene(panel, 290, 95);
        
        // Crear un botón que al pinchar establezca el valor "A" en el campo
        // de texto de la ventana principal, y luego cierre esta ventana 
        // secundaria
        Button boton = new Button("A");
        boton.setOnAction(eve->{
            ventanaPrincipal.campoTexto.setText("A");
            secunStage.close();
        });
        
        // Crear un botón que al pinchar establezca el valor "10" en el campo
        // de texto de la ventana principal, y luego cierre esta ventana 
        // secundaria
        Button boton2 = new Button("10");
        boton2.setOnAction(eve->{
            ventanaPrincipal.campoTexto.setText("10");
            secunStage.close();
        });
        
        // Crear un botón que al pinchar establezca el valor "##" en el campo
        // de texto de la ventana principal, y luego cierre esta ventana 
        // secundaria
        Button boton3 = new Button("##");
        boton3.setOnAction(e->{
            ventanaPrincipal.campoTexto.setText("##");
            secunStage.close();
        });  
        
        // Añadir los tres botones recién creados al panel
        panel.getChildren().addAll(boton, boton2, boton3);
        // Añadir la escena al escenario
        secunStage.setScene(scene);
        // Mostrar el escenario
        secunStage.show();
    }
    
}

