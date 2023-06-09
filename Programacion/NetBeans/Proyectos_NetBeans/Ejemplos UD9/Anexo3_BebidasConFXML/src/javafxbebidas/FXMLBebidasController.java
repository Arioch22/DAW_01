package javafxbebidas;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import static javafxbebidas.JavaFXBebidas.cargarLista;

/**
 * FXML Controller class. Clase destinada a actuar de controlador
 * del FXML llamado FXMLBebidas.fxml.
 *
 * @author Salvador Romero
 */
public class FXMLBebidasController implements Initializable {
    
    /**
     * Lista de bebidas. Lista que contendrá la lista de bebidas.
     */   
    private static ArrayList <Bebida> bebidas = new ArrayList() ;
    
    /**
     * ListView que contendrá una lista de bebidas.
     */
    @FXML private ListView listView;
    
    /**
     * TextField donde el usuario introducirá el nombre de la bebida.
     */
    @FXML private TextField nombre;
    
    /**
     * TextField donde el usuario introducirá el color de la bebida.
     */
    @FXML private TextField color;
    
    /**
     * TextField donde el usuario introducirá las unidades de la bebida.
     */
    @FXML private TextField unidades;

    /**
     * Boton guardar, usado para activar y desactivar el botón de guardar
     * cuando hay cambios o se han guardado.
     */
    @FXML private Button guardar;
    
    /**
     * Constructor del controlador. Será invocado antes de inyectar los controles
     * a sus correspondientes atributos privados (listView, nombre, color y 
     * unidades), por lo que todavía los controles TextField y ListView no se
     * pueden usar. Échale un vistazo al método initialize.
     */
    public FXMLBebidasController() {
    }
        
    
    /**
     * Manejador del evento añadir bebida a la lista. Este manejador
     * comprobaraá los parámetros, creará una instancia de bebida
     * y la introducirá en la lista, si esta previamente creada. 
     * Si la inserción fue correcta, activará el botón.
     * En cualquier caso mostrará un mensaje (Alert) con el resultado
     * de la operación.
     * @param event Evento de usuario.
     */
    @FXML
    protected void handleAddToListAction(ActionEvent event) {
        String msg ; 
        if (unidades.getText().matches("[0-9]+") && color.getText().length()>0 
                && nombre.getText().length()>0) {
            
            // Crear objeto bebida          
            Bebida oBebida = new Bebida(nombre.getText(), color.getText(), 
                    Integer.parseInt(unidades.getText()));
            
            if (estaEnlaLista(bebidas, nombre.getText(), color.getText())) {
                msg="Ya existe una bebida con el nombre y color indicados.";
            } else { 
                guardar.setDisable(false) ;
                bebidas.add(oBebida) ;
                
                // Añadir la cadena con los datos del objeto al listview
                listView.getItems().add(oBebida.toString());
                
                msg = "Bebida agregada correctamente.";
            }
                            
        } else
            msg = "Comprueba que el nombre, color y unidades sea correcto.";
        
        // Mostrar mensaje
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso.");
        alert.setContentText(msg);
        alert.setHeaderText(null);
        alert.showAndWait(); 
    }
    
    
    /**
     * Comprobar si en la lista de objetos bebida hay un elemento cuyo
     * nombre y color coincida con los parámetros enviados. 
     * Se empleará para evitar bebidas con el mismo nombre y color.
     * 
     * @param lista
     * @param nombre
     * @param color
     * @return 
     */
    private static boolean estaEnlaLista(ArrayList <Bebida> lista, String nombre,
            String color) {
        
        boolean resultado = false ;
        
        Iterator<Bebida> e = lista.iterator();
        
        while (e.hasNext()) {
            
            Bebida beb = e.next() ;
            
            String nom = beb.getNombre() ;
            String col = beb.getColor() ;
            //System.out.println(e.toString());
            // Si coincide el nombre
            if (nombre.equalsIgnoreCase(nom)) {
                if (color.equalsIgnoreCase(col)) {
                    resultado = true ;
                }
            }
            
        } 
        return resultado ;
    }
    
    
    /**
     * Manejador del evento borrar una bebida. Eliminará todas las bebidas 
     * seleccionadas de la lista (si las hay), pidiendo confirmación previa.
     * Si la eliminación fue correcta, se activará el botón de guardar.
     * En cualquier caso mostrará un mensaje (Alert) con el resultado
     * de la operación.
     * @param event Evento de usuario.
     */    
    @FXML
    protected void handleRemoveFromListAction(ActionEvent event) {
        
        List<Bebida> selectedItems = listView.getSelectionModel().getSelectedItems();
        if (selectedItems.size()>0) {
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminación de bebidas");
            alert.setHeaderText("¿Desea eliminar las bebidas seleccionadas?");
            alert.setContentText(String.format("Se han seleccionado %d bebidas, ¿qué desea hacer?",selectedItems.size()));
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK){
                
                int selectedIndex = listView.getSelectionModel().getSelectedIndex();
                  
                if (selectedIndex >= 0) {
                    listView.getItems().remove(selectedIndex);
                    bebidas.remove(selectedIndex);
                }
            } 
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso.");
            alert.setContentText("Debe seleccionar al menos una bebida.");
            alert.setHeaderText(null);
            alert.showAndWait();           
        }
        
    }
    
    /**
     * Manejador del evento guardar lista a disco. 
     * Este evento guardará la lista a disco, usando el método 
     * guardarArrayEnFichero de la clase JavaFXBebidas.
     * Si la operación fue bien, deshabilitará el botón guardar.
     * En cualquier caso mostrará un mensaje (Alert) con el resultado
     * de la operación.
     * @param event Evento de usuario.
     */
    @FXML
    protected void saveFromListAction(ActionEvent event) {
        String msg ;
        if (JavaFXBebidas.guardarArrayEnFichero(new ArrayList(bebidas))) {
            msg="Datos guardados correctamente.";
            guardar.setDisable(true);
        } else
            msg="Hubo un error al guardar los datos.";
        
        // Mostrar mensaje
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso.");
        alert.setContentText(msg);
        alert.setHeaderText(null);
        alert.showAndWait();  
    }
    
    /**
     * Inicializamos el recurso.Cuando este método se ejecuta los controles
     * TextField y ListView ya son accesibles porque ya se han inicializado.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Establecemos que los elementos de la lista son las bebidas
    //    listView.setItems(bebidas);
        
        //Indicamos que se podrán seleccionar más de un elemento
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        // Cargar la lista desde disco
      //  bebidas.setAll(JavaFXBebidas.cargarLista());
        
       // Cargar la lista desde disco
       bebidas = cargarLista() ;
       
        // Añadir los elementos recién cargados en la lista al listView
        for (Bebida bebida : bebidas) {
            listView.getItems().add(bebida.toString());
        }
        
        
                
        // Si la lista de bebidas está vacía, mostramos un mensaje, sino otro.
        String msg;
        if (bebidas.isEmpty()) {
            msg="No se cargaron datos previos en la aplicación.\n Fichero no encontrado o vacío.";            
        }
        else
            msg=String.format("Se han cargado %d bebidas de disco.",bebidas.size());
        
        // Mostrar mensaje
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso.");
        alert.setContentText(msg);
        alert.setHeaderText(null);
        alert.showAndWait();        
        
        guardar.setDisable(true);
                
    }    
    
}
