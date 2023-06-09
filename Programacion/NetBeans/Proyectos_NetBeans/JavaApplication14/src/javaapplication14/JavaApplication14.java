/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication14;

import java.text.DecimalFormat;

/**
 *
 * @author arioch
 */
public class JavaApplication14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String valor = "456.2665252525";
        
        Double v = Double.valueOf(valor);
        DecimalFormat mf = new DecimalFormat();
        mf.setMinimumFractionDigits(5);
        
        System.out.println(mf.format(v));
    }
    
}
