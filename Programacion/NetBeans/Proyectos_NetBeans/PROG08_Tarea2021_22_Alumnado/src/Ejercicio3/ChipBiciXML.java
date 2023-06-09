package Ejercicio3;

import java.io.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.DOMImplementation;

public class ChipBiciXML {

    /**
     * Ruta del archivo donde se lee y escribe la colección de objetos ChipBici
     */
    private String rutaArchivo;
    /**
     * Objeto Xstream que permite la L/E con archivos XML
     */
    private XStream xstream;
    // 1. iniciando el serializador
        XStream xstreamer = new XStream(new DomDriver());
    /**
     * Método constructor
     * @param nombreArchivo
     */
    public ChipBiciXML(String nombreArchivo) {
        super();
        this.rutaArchivo = nombreArchivo;
        xstream = new XStream();
        //Permite asignar privilegios para poder operar con los archivos XML
        xstream.allowTypesByWildcard(new String[] { 
            "Ejercicio3.**",
            "com.mydomain.utilitylibraries.**"
        });
    }

    /**
     * Método que escribe, en un archivo binario, una colección de objetos ChipBici serializables.
     * @param bicis Lista de objetos ChipBici serializables para almacenar en el archivo binario.
     */
    public void escribir(List bicis) {

        try ( PrintWriter writer = new PrintWriter(rutaArchivo);) {
            xstream.toXML(bicis, writer);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
    }
        
    /**
     * Método que lee, desde un archivo binario, una colección de objetos ChipBici serializados.
     * @return Lista de objetos ChipBici que estaba almacenada en el archivo binario.
     */
    public List leer(){
        
        ArrayList<String> listaSalida = new ArrayList<>();
        String xml = "";
        String cadena = "";
        
        
        try(BufferedReader brArchivo = new BufferedReader(new FileReader(rutaArchivo));) {
            xml = brArchivo.readLine();
            //pasamos cada línea del archivo XML al String cadena y luego lo vamos acumulando en el String xml
            while ((cadena = brArchivo.readLine()) != null) {
                xml = xml + "\n" + cadena;
            }
            brArchivo.close();

            //Procesamos el String xml para pasarlo a formato normal y luego lo vamos añadiendo a la lista.
            listaSalida = (ArrayList<String>) xstream.fromXML(xml);

        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } catch (IOException i) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }
        
        return listaSalida;
        
    }
}

