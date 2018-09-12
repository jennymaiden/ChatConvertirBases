/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codificacion;

/**
 *
 * @author Carolina
 */
public class Convertidor {
    
    private String residuo = "";
    private Utilidades util = new Utilidades();
    /**Metodo para obtener la cadena de caracteres y separarlas por char*/
    public int[ ] vectorNumeros(String numero){ 
        //Separa por caracter
        char[ ] caracteres = numero.toCharArray();
        //System.out.println("***Cadena lenght;:..."+numero.length());
        int[ ] arreglo = new int[numero.length()];
        System.out.println("numero de caracteres::......"+caracteres.length);
        for(int i =0; i < caracteres.length; i++){
            System.out.println("Caracter es:....."+Character.toString(caracteres[i]));
            //validar si es numero o letra
            if(util.isNumeric(caracteres[i])){
                arreglo[i]= Integer.parseInt(Character.toString(caracteres[i]));
                
            }else{
                //es letra
                arreglo[i] = util.convertirLetraNumero(caracteres[i]);
            }
        }
        return arreglo;
    }
    
    /***
     contador de las bases*/
    public int[ ] vectorBase(int[] numeros, int baseOrigen){
        
        int [] vectorB = new int[numeros.length];
        for(int i =0; i < numeros.length; i++){
            vectorB[i] = (int) Math.pow(baseOrigen, i);
            System.out.println("Multiplicacion base::...."+vectorB[i]);
        }
        
        return vectorB;
    }
    
    /**
     multiplicar los dos bectores retorna en base 10**/
    public int multiplicarVectores(int [] vNumero, int[] vBase){
        
        int [] multiplicacion = new int[vNumero.length];
        int contador = vNumero.length -1;//3
        int sumatoria=0;
        for(int i = 0; i< vNumero.length; i++){
            
            multiplicacion[i] = vNumero[i]*vBase[contador];
                contador --; 
        }
        for(int i=0; i < multiplicacion.length; i++){
            sumatoria = sumatoria+multiplicacion[i];
        }
        
        return sumatoria;
        
    }
    
   /**
    Divicion retornar el reciduo y el cociente**/
    public int[] dividirRC(int dividendo, int divisor){
       
        int [] respuesta = new int[2]; //Primera posicion el cociente,- Segunda posicion el residuo
        respuesta[0] = dividendo/divisor;
        respuesta[1] =dividendo%divisor;
        
        return respuesta;
    }
    
    /**
     obtener el residuo de las diviciones para convertir a la base final**/
    public void obtenerBaseFinal(int baseFinal, int base10){
       System.out.println("Las bases que llegan son::..."+baseFinal+" - "+base10);
        int [] arreglo = dividirRC(base10,baseFinal);
        
        System.out.println("El cociente es:..."+arreglo[0]);
        int cociente = arreglo[0];
        int residuo = arreglo[1];
        System.out.println("El residuo es:..."+arreglo[1]);
        
        if(cociente > baseFinal){
            System.out.println("El cociente es mayor que base");
            setResiduo(this.getResiduo()+"-"+residuo) ;
            
            obtenerBaseFinal(baseFinal,cociente);
            //residuo = residuo+"-"+arreglo[1];
            //System.out.println("El residuo:..."+residuo+" variable:.."+arreglo[1]);
           
        }else{
            System.out.println("El cociente es menor que base");
            
            setResiduo(this.getResiduo()+"-"+residuo+"-"+cociente) ;
            //this.residuo = this.residuo+"-"+dividirRC(arreglo[0],baseFinal)[1];
            //System.out.println("Ultimo:...."+dividirRC(arreglo[0],baseFinal)[1]);
        }
        
        
    }
    
    public String getResiduo(){
        return this.residuo;
    }
    
    public void setResiduo(String residuo){
        this.residuo= residuo;
    }
}
