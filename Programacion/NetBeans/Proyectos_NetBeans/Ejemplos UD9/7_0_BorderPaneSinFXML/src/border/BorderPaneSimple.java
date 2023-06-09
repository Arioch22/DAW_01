/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package border;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Peimera BorderPane sin FXML
 * @author Profesor
 */
public class BorderPaneSimple extends Application {
    
    @Override
    public void start(Stage primaryStage) {
 
        BorderPane border = new BorderPane();
        Label toppanetext = new Label("Título de página");
        border.setTop(toppanetext);
        Label centerpanetext = new Label ("Datos por aquí");
        border.setCenter(centerpanetext);
              
        StackPane root = new StackPane();
        root.getChildren().add(border);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Borderpane simple");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args) ;
    }
    
}
