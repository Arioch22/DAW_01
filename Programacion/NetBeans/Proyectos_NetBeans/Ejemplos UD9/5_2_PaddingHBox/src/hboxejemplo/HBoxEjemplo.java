package hboxejemplo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Ejemplo de uso del layout HBox
 * @author Tomado y modificado ligeramente del libro: "JavaFX 9 by Example"
 */
public class HBoxEjemplo extends Application {
    
    @Override
    public void start(Stage stage) {
        
        Group root = new Group();
        Scene scene = new Scene(root, 800, 350);
        
        // pixels space between child nodes
        HBox hbox = new HBox(50);
        // The border is blue, dashed,
        // 0% radius for all corners,
        // a width of 10 pixels
        BorderStroke[] borderStrokes = new BorderStroke[] {
            new BorderStroke(Color.BLUE,
            BorderStrokeStyle.DASHED,
            new CornerRadii(0.0, true),
            new BorderWidths(10.0))
        };
        hbox.setBorder(new Border(borderStrokes));
        // padding between child nodes only
        hbox.setPadding(new Insets(10));
        // rectangles r1 to r4
        Rectangle r1 = new Rectangle(100, 100);
        Rectangle r2 = new Rectangle(200, 200);
        Rectangle r3 = new Rectangle(50, 200);
        Rectangle r4 = new Rectangle(200, 50);
        // margin of 20 pixels
        HBox.setMargin(r1, new Insets(20,20,20,20));
        hbox.getChildren().addAll(r1, r2, r3, r4);
        root.getChildren().add(hbox);
        // once shown display the dimensions all added up.
        stage.setOnShown((WindowEvent we) -> {
            System.out.println("hbox width " + hbox.getBoundsInParent().getWidth());
            System.out.println("hbox height " + hbox.getBoundsInParent().getHeight());
        });
        stage.setTitle("Ejemplo con HBox");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}