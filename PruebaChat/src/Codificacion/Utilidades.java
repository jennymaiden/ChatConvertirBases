/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codificacion;

/**
 *
 * @author fernando
 */
public class Utilidades {
    
    public  boolean isNumeric(String cadena){
	try {
            Integer.parseInt(cadena);
            
            return true;
	} catch (NumberFormatException nfe){
            
            return false;
	}
    }
}
