package tarea05;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *Clase que representa un <strong>microdispositivo de bicicleta</strong> que se acopla a las bicis de alquiler de un establecmiento deportes de ocio y aventura.
 * <p>
 * Los objetos de esta clase permiten almacenar y gestionar información sobre la versión de firmware en el chip de la bici, así como fecha y hora del alquiler actual de la bici, si es que está alquilada, datos sobre distancia recorrida, fecha del último alquiler, etc.
 * <p>
 * La clase también dispone de información general independiente de los objetos concretos que se hayan creado. Es el caso de:
 * <ul>
 * <li><strong>número total de chips</strong> insertados hasta el momento o lo que es lo mismo, <strong>número total de bicis;</strong></li>
 * <li><strong>número de bicis alquiladas</strong> en el momento actual, o</li>
 * <li><strong>distancia global</strong> recorrida por todas las bicis.</li>
 * </ul>
 * @author Manuel_Monterroso_Flores
 */
public class ChipBici {

    //atributos clase variables
    private static int totalBicis = 0;
    private static int bicisAlquiladas = 0;
    private static double totalKmRecorridos = 0;
    
    //atributos clase constantes

    /**
     *Máximo trayecto permitido para realizar a una bici: {@value MAX_DISTANCIA_TRAYECTO} km.
     */
    public static final double MAX_DISTANCIA_TRAYECTO = 140;

    /**
     *Mínima versión del firmware permitida: {@value MIN_VERSION}.
     */
    public static final int MIN_VERSION = 1;

    /**
     *Máxima versión del firmware permitida: {@value MAX_VERSION}.
     */
    public static final int MAX_VERSION = 10;

    /**
     *Mínima revisión del firmware permitida: {@value MIN_REVISION}.
     */
    public static final int MIN_REVISION = 0;

    /**
     *Máxima revisión del firmware permitida: {@value MAX_REVISION}.
     */
    public static final int MAX_REVISION = 9;

    /**
     *Valor por omisión para la versión del firmware: {@value DEFAULT_VERSION}.
     */
    public static final int DEFAULT_VERSION = 1;

    /**
     *Valor por omisión para la revisión del firmware: {@value DEFAULT_REVISION}.
     */
    public static final int DEFAULT_REVISION = 0;

    /**
     *Mínima fecha de adquisición permitida: 15/06/2020.
     */
    public static final LocalDate MIN_FECHA_ADQUISICION = LocalDate.of(2020, 6, 15);
    //procedemos a formatear tanto la salida de fecha como la de hora para que sean como pide la tarea.

    /**
     *Para poner en orden la fecha.
     */
    private static final DateTimeFormatter FECHA_ESP = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     *Para poner en orden la fecha y la hora.
     */
    private static final DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");

    //atributos objetos constantes
    private final int numSerie;
    private final LocalDate fechaAdquisicionBicis;
    
    //atrributos objetos variables
    private int version;
    private int revision;
    private boolean alquilada;
    private double kmTotalesBici;
    private LocalDateTime fechaInicioAlquiler;
    private double kmRecorridosActualAlquiler;
    private LocalDateTime fechaInicioUltimoAlquiler;
    private LocalDateTime fechaFinUltimoAlquiler;
    private double kmRecorridoUltimoAlquiler;
    
    //Constructor con 3 parámetros

    /**
     *Constructor basado en la fecha de adquisición de la bici, así como en la versión y la revisión del firmware (v.r). 
     *Crea un nuevo objeto ChipBici con la versión y revisión de firmware y la fecha de adquisición indicadas. 
     *<strong>La versión</strong> debe estar entre ChipBici.MIN_VERSION y ChipBici.MAX_VERSION. <strong>La revisión</strong> debe estar entre ChipBici.MIN_REVISION y ChipBici.MAX_REVISION. 
     *<strong>La fecha de adquisición</strong> no puede ser anterior a ChipBici.MIN_FECHA_ADQUISICION ni posterior a la fecha actual.
     * @param fechaAdquisicion fecha de adquisición de la bici
     * @param version versión del firmware
     * @param revision revision del firmware
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     */
    public ChipBici (LocalDate fechaAdquisicion, int version, int revision) throws IllegalArgumentException{
    
        if( fechaAdquisicion == null || fechaAdquisicion.isBefore(MIN_FECHA_ADQUISICION) || fechaAdquisicion.isAfter(LocalDate.now()) ){
            throw new IllegalArgumentException(String.format("Fecha incorrecta: %s", (fechaAdquisicion == null) ? null : fechaAdquisicion.format(FECHA_ESP)));
        }
        
        if( version < MIN_VERSION || version > MAX_VERSION ){
            throw new IllegalArgumentException(String.format("Versión incorrecta: %d", version));
        }
        if( revision < MIN_REVISION || revision > MAX_REVISION ){
            throw new IllegalArgumentException (String.format("Revision incorrecta: %d", revision));
        }
        
        this.fechaAdquisicionBicis = fechaAdquisicion;
        this.fechaInicioUltimoAlquiler = null;
        this.fechaFinUltimoAlquiler = null;
        this.version = version;
        this.revision = revision;
        this.alquilada = false;
        this.kmTotalesBici = 0;
        this.kmRecorridosActualAlquiler = 0;
        this.fechaInicioAlquiler = null;
        this.kmRecorridoUltimoAlquiler = 0;
        
        //Aqui asignamos el número de serie de la Bici y creamos el contador para saber la cantidad de bicis que poseemos.
        ChipBici.totalBicis++;
        this.numSerie = ChipBici.totalBicis;
    }
    
    //Constructor con 2 parámetros: versión y revisión

    /**
     *Constructor basado en la versión y la revisión del firmware (v.r). 
     *Crea un nuevo objeto ChipBici con la versión y revisión de firmwareindicadas. 
     *<strong>La versión</strong> debe estar entre ChipBici.MIN_VERSION y ChipBici.MAX_VERSION. 
     *<strong>La revisión</strong> debe estar entre ChipBici.MIN_REVISION y ChipBici.MAX_REVISION.
     * @param version versión del firmware
     * @param revision revision del firmware
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     */
    public ChipBici(int version, int revision) throws IllegalArgumentException {
        
        this(LocalDate.now(), version, revision);
    }
    
    // Constructor sin parámetros

    /**
     *Constructor sin parámetros. Crea un nuevo objeto ChipBici con la fecha actual como fecha de adquisición y con los valores por omisión para la versión y la revisión.
     */
    public ChipBici() {
        
        this(LocalDate.now(), ChipBici.DEFAULT_VERSION, ChipBici.DEFAULT_REVISION);
    }
    
    //Constructor fábrica
    
    /**
     * Método "fábrica" creador de un array de objetos ChipBici. Crea un array de referencias a objetos ChipBici con los parámetros por omisión. El tamaño del array será indicado por el parámetro cantidad.
     * @param totalBicis tamaño del array a devolver
     * @return array de referencias a objetos ChipBici
     * @throws IllegalArgumentException si la cantidad es inferior a 1
     */
    public static ChipBici[] crearArrayChipBici(int totalBicis) throws IllegalArgumentException {
       
        if (totalBicis <1) {
            throw new IllegalArgumentException(String.format("Cantidad no válida: %d", totalBicis));
        }
        
        ChipBici[] arrayChipBici = new ChipBici[totalBicis];
        for (int i = 0; i < totalBicis; i++) {
            arrayChipBici[i] = new ChipBici();
        }
        return arrayChipBici;
    }

    /**
     *Obtiene el número de serie de la bici.
     * @return número de serie de la bici
     */
    public String getNumSerie() {
        return String.valueOf(numSerie);
    }

    /**
     *Obtiene la fecha de adquisición de la bici.
     * @return fecha de adquisición de la bici
     */
    public LocalDate getFechaAdquisicion() {
        return this.fechaAdquisicionBicis;
    }

    /**
     *Obtiene la versión del firmware instalado en el chip de la bici.
     * @return versión del firmware del chip de la bici
     */
    public int getVersion() {
        return this.version;
    }
    
    /**
     *Obtiene la revisión del firmware instalado en el chip de la bici.
     * @return revisión del firmware del chip de la bici
     */
    public int getRevision(){
        return this.revision;
    }

    /**
     *Obtiene la versión y revisión del firmware simultáneamente.
     * @return cadena de caracteres con la versión y revisión del firmware instalado en el chip. Formato "versión.revisión"
     */
    public String getVersionRevision() {
        return String.format(version + "." +revision);
    }

    /**
     *Indica si la bici está alquilada.
     * @return si la bici está alquilada o no
     */
    public boolean isAlquilada() {
        return this.alquilada;
    }

    /**
     *Obtiene el total de kilómetros recorridos hasta el momento por la bici.
     * @return kilómetros recorridos hasta el momento.
     */
    public double getKilometrosTotales() {
        return this.kmTotalesBici;
    }

    /**
     *Obtiene la fecha y hora del alquiler actual de la bici, si es que está alquilada. Si la bici no está alquilada, devolverá null.
     * @return fecha y hora del alquiler actual. Si no está alquilada devuelve null.
     */
    public LocalDateTime getRegistroInicioAlquilerActual() {
        return this.fechaInicioAlquiler;
    }
    
    /**
     *Obtiene los kilómetros recorridos hasta el momento por la bici durante el alquiler actual, si es que está alquilada. Si la bici no está alquilada, devolverá 0.
     * @return kilómetros recorridos durante el alquiler actual. Si no está alquilada devuelve 0.
     */
    public double getKilometrosRecorridosAlquilerActual(){
        return this.kmRecorridosActualAlquiler;
    }
    
    /**
     *Obtiene la fecha y hora de inicio del último alquiler de la bici (anterior al actual, si es que estuviera alquilada). Si todavía no ha llegado finalizar ningún alquiler (aún no ha sido alquilada y devuelta), será null.
     * @return fecha y hora de inicio del último alquiler.
     */
    public LocalDateTime getRegistroInicioUltimoAlquiler(){
        return this.fechaInicioUltimoAlquiler;
    }
    
    /**
     *Obtiene la fecha y hora de fin del último alquiler de la bici (anterior al actual, si es que estuviera alquilada). Si todavía no ha llegado finalizar ningún alquiler (aún no ha sido alquilada y devuelta), será null.
     * @return fecha y hora de fin del último alquiler.
     */
    public LocalDateTime getRegistroFinUltimoAlquiler(){
        return this.fechaFinUltimoAlquiler;
    }
    
    /**
     *Obtiene el total de kilómetros recorridos por la bici durante el último alquiler. Si todavía no ha llegado finalizar ningún alquiler (aún no ha sido alquilada y devuelta), será 0.
     * @return kilómetros recorridos durante el último alquiler.
     */
    public double getKilometrosRecorridosUltimoAlquiler(){
        return this.kmRecorridoUltimoAlquiler;
    }

    /**
     *Obtiene la cantidad de chips (y por tanto de bicis) creados hasta el momento.
     * @return cantidad de bicis registradas
     */
    public static int getNumBicis() {
        return ChipBici.totalBicis;
    }
    
    /**
     *Obtiene la cantidad de bicis alquiladas en ese momento.
     * @return cantidad de bicis alquiladas
     */
    public static int getNumBicisAlquiladas() {
        return ChipBici.bicisAlquiladas;
    }

    /**
     *Obtiene el total de kilómetros recorridos entre todas las bicis hasta el momento.
     * @return total de kilómetros recorridos entre todas las bicis hasta el momento
     */
    public static double getKilometrosTodasLasBicis() {
        return ChipBici.totalKmRecorridos;
    }

    /**
     *Pasa el estado de la bici a "alquilada". Si ya está alquilada no se puede volver a alquilar.
     * @throws IllegalStateException si ya está alquilada
     */
    public void alquilar () throws IllegalStateException{
        if(alquilada == true){
         throw new IllegalStateException(String.format("Bici ya alquilada"));
        }
        this.alquilada = true;
        ChipBici.bicisAlquiladas++;
        this.fechaInicioAlquiler = LocalDateTime.now();
        
    }
    
    /**
     *Pasa el estado de la bici a "no alquilada". Si no está alquilada no puede llevarse a cabo esta operación.
     * @throws IllegalStateException si ya está alquilada
     */
    public void devolver () throws IllegalStateException{
        
        if (alquilada == false){
            throw new IllegalStateException(String.format("Bici no alquilada"));
        }
        this.alquilada = false;
        ChipBici.bicisAlquiladas--;
        this.fechaInicioUltimoAlquiler = fechaInicioAlquiler;
        this.fechaInicioAlquiler = null;
        this.fechaFinUltimoAlquiler = LocalDateTime.now();
        //al devolver la bici reiniciamos contador de km recorridos del anterior alquiler para ponerle los de este alquilar
        this.kmRecorridoUltimoAlquiler = 0;
        this.kmRecorridoUltimoAlquiler  = this.kmRecorridosActualAlquiler;
        //al devolver la bici pones a cero el contador de los Km recorridos
        this.kmRecorridosActualAlquiler = 0;
        
    }
    
    /**
     *Recorre un trayecto de una determinada distancia con la bici. No se puede superar la máxima ditancia permitida por trayecto. No se permiten distancias negativas. Sí se permite la distancia 0.
     * @param kmRecorridosActualAlquiler longitud del trayecto (en kilómetros)
     * @return la cantidad de kilómetros que se llevan recorridos con el alquiler actual
     * @throws IllegalStateException si la bici no está alquilada
     * @throws IllegalArgumentException si la distancia no es válida
     */
    public double recorrerTrayecto (double kmRecorridosActualAlquiler) throws IllegalStateException, IllegalArgumentException{
        if (alquilada == false){
            throw new IllegalStateException(String.format("Bici no alquilada"));
        }
        else if (kmRecorridosActualAlquiler < 0 || kmRecorridosActualAlquiler > MAX_DISTANCIA_TRAYECTO){
            throw new IllegalStateException(String.format("Distancia incorrecta %.2f", kmRecorridosActualAlquiler));
        }else{
        
        this.kmRecorridosActualAlquiler += kmRecorridosActualAlquiler;
        this.kmTotalesBici = this.kmRecorridosActualAlquiler + this.kmRecorridoUltimoAlquiler;
        ChipBici.totalKmRecorridos += kmRecorridosActualAlquiler;
        return this.kmRecorridosActualAlquiler;
        }
    }
    
    /**
     *Recorre la máxima distancia que se puede recorrer en un trayecto con la bici.
     * @return la cantidad de kilómetros que se llevan recorridos con el alquiler actual
     * @throws IllegalStateException si la bici no está alquilada
     */
    public double recorrerTrayecto() throws IllegalStateException{
        return this.recorrerTrayecto(ChipBici.MAX_DISTANCIA_TRAYECTO);
        //return kmRecorridosActualAlquiler;
    }
    
    /**
     * Lleva a cabo una actualización del firmware del chip. Siempre debe de ser un upgrade, es decir, debe ser a una revisión superior válida de la versión actual o bien a cualquier revisión válida de una versión superior. Si la bici está alquilada no se permite la actualización.
     * @param version versión de actualización
     * @param revision revisión de actualización
     * @throws IllegalStateException si la bici está alquilada
     * @throws IllegalArgumentException si la versión o revisión es incorrecta o bien no es un upgrade
     */
    public void actualizarFirmware (int version, int revision) throws IllegalStateException, IllegalArgumentException{
        if (alquilada == true){
            throw new IllegalArgumentException(String.format("No se puede actualizar el firmware a una bici alquilada"));
        }else if (ChipBici.MAX_VERSION < version || ChipBici.MAX_REVISION < revision){
            if(ChipBici.MAX_VERSION < version){
                throw new IllegalStateException (String.format("Versión incorrecta: %d", version));
            }else if(ChipBici.MAX_REVISION < revision){
                throw new IllegalStateException (String.format("Revision incorrecta: %d", revision));
            }
        
        }else if (ChipBici.MIN_VERSION > version || ChipBici.MIN_REVISION > revision){
            if(ChipBici.MIN_VERSION > version){
                throw new IllegalStateException (String.format("Versión incorrecta: %d", version));
            }else if(ChipBici.MIN_REVISION > revision){
                throw new IllegalStateException (String.format("Revision incorrecta: %d", revision));
            }
        
        }else if ((this.version > version && this.revision >= revision) || (this.version > version && this.revision < revision) || (this.version == version && this.revision > revision) || (this.version == version && this.revision == revision)){
           throw new IllegalStateException (String.format("Es necesario actualizar a una versión superior a la actual: %d.%d <= %d.%d", version, revision, this.version, this.revision));
        }
        this.version = version;
        this.revision = revision;
        
    }
    
    /**
     * Lleva a cabo una actualización del firmware del chip. Solo se indica la versión. La revisón será la 0. Siempre debe de ser un upgrade, es decir, debe ser a versión superior válida a la versión actual. Si la bici está alquilada no se permite la actualización.
     * @param version versión de actualización
     * @throws IllegalStateException si la bici está alquilada
     * @throws IllegalArgumentException  si la versión o revisión es incorrecta o bien no es un upgrade
     */
    public void actualizarFirmware (int version) throws IllegalStateException, IllegalArgumentException{
        
        this.actualizarFirmware(version,ChipBici.DEFAULT_REVISION);
        
    }
    
    /**
     *Resetea el chip a los valores de fábrica. Solo puede ser reseteado si la bici no está alquilada. El firmware volverá a la versión por omisión. Se perderán todos los registros de alquileres, incluyedo cualquier fecha y dato kilométrico. Tan solo se mantendrán el número de serie y la fecha de adquisición.
     * @throws IllegalStateException si la bici está alquilada
     */
    public void reset () throws IllegalStateException{
         if (alquilada == true){
            throw new IllegalStateException(String.format("No se puede resetear un chip bici que esté alquilada"));
        }
        
        this.fechaInicioUltimoAlquiler = null;
        this.fechaFinUltimoAlquiler = null;
        this.alquilada = false;
        this.kmTotalesBici = 0;
        this.kmRecorridosActualAlquiler = 0;
        this.fechaInicioAlquiler = null;
        this.kmRecorridoUltimoAlquiler = 0;
        this.version = ChipBici.MIN_VERSION;
        this.revision = ChipBici.MIN_REVISION;
    }
    
    /**
     * Devuelve una cadena que representa el estado de un objeto ChipBici. El resultado devuelto representará el estado del chip y tendrá la siguiente estructura:
     * <ol>
     * <li>un inicio de bloque o llave (carácter '{');</li>
     * <li>la etiqueta "NS: " junto con el número de serie ;</li>
     * <li>la etiqueta "fw: " y a continuación la versión y revisión del firmware;</li>
     * <li>si la bici está o no alquilada;</li>
     * <li>cantidad de kilómetros totales recorridos por la bici hasta el momento;</li>
     * <li>información sobre el alquiler actual: fecha de inicio del alquiler actual y kilómetros recorridos durante ese alquiler;</li>
     * <li>información sobre el último alquiler realizado: fechas de inicio y fin de ese alquiler y kilómetros realizados durante el mismo;</li>
     * <li>un fin de bloque o llave (carácter '}').</li>
     * </ol>
     * <p>
     * Un ejemplo de cadena devuelta podría ser:
     * <pre>{ NS: 33; 15/09/2021; fw: 2.1; no alquilada; 150,00 km totales; Alquiler actual: ---, 0,00 km; Último alquiler: 09/12/2021 12:33:36, 09/12/2021 22:02:57, 57,28 km }</pre>
     * donde podríamos observar la siguiente información:
     * <ul>
     * <li>el número de serie de la bici es 33;</li>
     * <li>la fecha de adquisición es el 15 de septiembre de 2021;</li>
     * <li>la versión y revisión del firmware es 2.1;</li>
     * <li>la bici no está alquilada en este momento;</li>
     * <li>la cantidad de kilómetros recorridos por la bici hasta el momento es de 150,00 kilómetros;</li>
     * <li>la información sobre el alquiler actual será nula: fecha "---" y kilómetros a cero, pues no está alquilada;</li>
     * <li>la información sobre el último alquiler completado será: los registros "09/12/2021 12:33:36" para el inicio y "09/12/2021 22:02:57" para el fin del alquiler junto con los 57,28 km realizados durante ese alquiler.</li>
     * </ul>
     * 
     * 
     * @return una cadena que representa el estado de un objeto microdispositivo ChipBici
     */
    @Override
    public String toString(){
        
        
        return String.format("{ NS: %d; %s; fw: %d.%d; %s; %.2f km totales; Alquiler Actual: %s, %.2f Km; Último alquiler: %s, %s, %.2f Km }", 
            this.numSerie,
            this.fechaAdquisicionBicis.format(FECHA_ESP),
            this.version, 
            this.revision,
            this.alquilada ? "alquilada" : "no alquilada", 
            this.kmTotalesBici, 
            this.fechaInicioAlquiler == null ? "---" : this.fechaInicioAlquiler.format(FORMATO_FECHA_HORA) , 
            this.kmRecorridosActualAlquiler, 
            this.fechaInicioUltimoAlquiler == null ? "---" : this.fechaInicioUltimoAlquiler.format(FORMATO_FECHA_HORA),
            this.fechaFinUltimoAlquiler == null ? "---" :  this.fechaFinUltimoAlquiler.format(FORMATO_FECHA_HORA),
            this.kmRecorridoUltimoAlquiler
            );
    }
}
