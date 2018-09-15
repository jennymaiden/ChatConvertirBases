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
   
    
    public boolean validarBase(String base){
        boolean res = false;
        if(this.isNumeric(base)){
            int numero = Integer.parseInt(base);
            if(numero <=36 && numero >1){
                res = true;
            }
        
        }
        return res;
    }
}