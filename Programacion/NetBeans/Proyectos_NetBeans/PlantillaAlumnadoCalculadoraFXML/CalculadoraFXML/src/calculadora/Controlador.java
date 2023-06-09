package calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * El controlador se encarga de responder a los eventos que causa el usuario
 * invocando las peticiones al modelo cuando se hace alguna solicitud sobre la
 * información (por ejemplo, en este caso cuando el usuario pulse en el botón 
 * de igual para calcular la expresión).
 * 
 * @author 
 */
public class Controlador implements Initializable {

    private Label labPantalla;
    
    @FXML
    private TextField entrada;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

	/**
     * Ventanita para mostrar mensajes de error
     * @param error 
     */
    private void mostrarError(String error) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Hay un error.");
            alert.setContentText(error);
            alert.setHeaderText(null);
            alert.showAndWait();
            entrada.setText("");
    }    

    @FXML
    private void botonesCalculadora(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String nuevaEntrada = entrada.getText() + btn.getText();
        entrada.setText(nuevaEntrada);
    }

    @FXML
    private void borrarTodo(ActionEvent event) {
        entrada.setText("");
    }

    @FXML
    private void borrarUltimo(ActionEvent event) {
        entrada.end();
        entrada.deletePreviousChar();
    }

    @FXML
    private void validar(ActionEvent event) {
        String result = Modelo.evaluar(entrada.getText());
        if ("Error".equals(result)) {
            result = "Error.";
            mostrarError(result);
        }else if("regex".equals(result)){
            result= "Operación no valida.";
            mostrarError(result);
        }else {
            entrada.setText(result +"");
        }
        
    }

    @FXML
    private void raizCuadrada(ActionEvent event) {
        String resultado = Modelo.raizCuadrada(entrada.getText());
        

        if ("Error".equals(resultado)) {
            resultado="Error.";
            mostrarError(resultado);
        }else if ("regex".equals(resultado)){
            resultado="Operación no valida.";
            mostrarError(resultado);
        }else{
            entrada.setText(resultado);}
    }

    
}
