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
            System.out.println("---------------------------------------------------");
            int baseFinal = Integer.parseInt(base); 
            //Vector que contiene el areglo de los numeros del mensaje
            long [] a1 =convertir.obtenerArregloNum(mensaje);
            System.out.println("EL vector en numeros:...");
            for(int i=0; i< a1.length; i++){

                System.out.print("["+a1[i]+"]");
            }
            //Funcion para desorganizar el abecedario
            String [] abcDesorganizado = convertir.obtenerRandom(a1.length);
            System.out.println("");
            System.out.println("El vector desorganizado es");
            for(int i =0; i<abcDesorganizado.length;i++){
                System.out.print("["+abcDesorganizado[i]+"]");
            }
            System.out.println();
            
            //Metodo que obtiene la base en la que esta escrito el mensaje
            long baseInicio = convertir.obtenerBaseOrigen(a1);
            System.out.println("La base en la que esta escrita el mensaje es:::..."+baseInicio);
            System.out.println("*************************");
            //Vector que tiene la base de inicio elebado a la posicion
            long[] a2 =convertir.vectorBase(a1, baseInicio);
            System.out.println("EL vector base quedo con estas valores::");
            for(int i=0; i< a1.length; i++){

                System.out.print("["+a2[i]+"]");
            }
            System.out.println();
        
            //El valor en base 10
            long multi = convertir.multiplicarVectores(a1, a2);
            
            //Guarda el mensaje en desorden
            convertir.obtenerBaseFinal(baseFinal, multi);
            
            //Ordena el resultado del vector
            String[] a3 = convertir.ordenarBaseFin(convertir.getResiduo());
        
            respuesta =convertir.resultadoBases(a3)+"("+base+")";
            System.out.println("El número "+mensaje+" escrito en base "+baseInicio+" es igual a "+respuesta+" en base "+base+" .");
            System.out.println("---------------------------------------------------");
        }else{
            respuesta= "La base no es un numero, vuelva a intentarlo";
        }
        
        return respuesta;
    }
    
    public void inicializarComponente(){
        convertir.setResiduo("");
    }
    
}
