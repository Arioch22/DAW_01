package huevoSorpresa;
public class HuevoSorpresa_Arrevola_Diez_Ruben_2122 {

    private int unidades;//número de huevos que quedan 
    private double precio;//precio actual de un huevo sorpresa
    private String sorpresa;//nombre de la sorpresa que incluye huevo sorpresa
    private double precio_max;//precio máximo que puede tener un huevo sorpresa
    
    
/*Constructor por defecto*/
public HuevoSorpresa_Arrevola_Diez_Ruben_2122(){}


/*Constructor por parámetros*/
public HuevoSorpresa_Arrevola_Diez_Ruben_2122(int unidades, double precio, String sorpresa, double precio_max){
    this.unidades=unidades;
    this.precio=precio;
    this.sorpresa=sorpresa;
    this.precio_max=precio_max;
}


/*Método que devuelve el número de huevos sorpresa que tiene la tienda*/
public int obtenerUnidades(){return this.unidades;}

/*Método que devuelve el precio que tiene cada huevo sorpresa*/
public double obtenerPrecio(){return this.precio;}


/* Método que devuelve la sorpresa que tiene el huevo*/
    public String obtenerSorpresa() {
        return sorpresa;
    }

/* Método que permite modificar la sorpresa del huevo*/
    public void modificarSorpresa(String sorpresa) {
        this.sorpresa = sorpresa;
    }
 

/*Método que permite modificar el número de huevos sorpresa que tiene la tienda*/
public void modificarUnidades(int unidades){this.unidades=unidades;}


/*Método que permite sacar huevos sopresa si se tiene suficiente dinero y hay 
suficientes huevos sorpresas, este método se probará con JUnit*/
public void sacarHuevosSorpresas(int unidades, double dinero) throws Exception{
   if (dinero <= 0) {
   	throw new Exception("Se necesita una cantidad de dinero positiva");
        }
   if (dinero <(unidades * precio)) {
   	throw new Exception("No tiene suficiente dinero");
        }
   if (unidades<= 0){
        throw new Exception("Es necesario indicar una cantidad positiva de huevos sorpresa");
    }
    if(this.unidades<=unidades){
        throw new Exception("No hay suficientes huevos sorpresa en la tienda");
    }
    this.modificarUnidades(this.obtenerUnidades()-unidades);
}


/*Método que permite aumentar el precio de venta de un huevo sorpresa, suma al precio actual el aumento 
que se indica siempre que no se sobrepase el precio máximo de venta, este método se probará con JUnit*/
public void aumentarPrecio(double aumento) throws Exception{
    if(aumento <= 0) {
        throw new Exception("El aumento debe ser positivo");
    }
    if(precio_max<precio + aumento ){
        throw new Exception("No se puede superar el precio máximo");
    }
    precio=precio + aumento;
}
}