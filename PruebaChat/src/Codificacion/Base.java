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
public class Base {
    
    private Convertidor convertir = new Convertidor();
    private Utilidades util = new Utilidades();
    
    public String obtenerBaseFinal(String mensaje, String base){
        String respuesta ="";
        if(util.isNumeric(base)){
            int baseFinal = Integer.parseInt(base); 
            //Vector que contiene el areglo de los numeros del mensaje
            long [] a1 =convertir.obtenerArregloNum(mensaje);
            
            //Metodo que obtiene la base en la que esta escrito el mensaje
            long baseInicio = convertir.obtenerBaseOrigen(a1);
            
            //Vector que tiene la base de inicio elebado a la posicion
            long[] a2 =convertir.vectorBase(a1, baseInicio);
            
            //El valor en base 10
            long multi = convertir.multiplicarVectores(a1, a2);
            
            //Guarda el mensaje en desorden
            convertir.obtenerBaseFinal(baseFinal, multi);
            
            //Ordena el resultado del vector
            String[] a3 = convertir.ordenarBaseFin(convertir.getResiduo());
        
            respuesta =convertir.resultadoBases(a3);
            
            
        }else{
            respuesta= "La base no es un numero, vuelva a intentarlo";
        }
        
        return respuesta;
    }
    
}
