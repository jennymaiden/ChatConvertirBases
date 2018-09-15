/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertorbases;

/**
 *
 * @author Carolina
 */
public class PruebaBase {
    
    private String [] abecedario = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private int tamanioABC = abecedario.length;
    private String residuo = "";
    
    
    public long [] obtenerArregloNum(String msg){
        char[ ] caracteres = msg.toCharArray();
        int tamanio = caracteres.length;
        long [] vector = new long[tamanio];
        System.out.println("El vector que llega es");
        for(int i =0; i<tamanio;i++){
            char aux = caracteres[i];
            System.out.print("["+aux+"]");
            for(int j=0; j< tamanioABC; j++){
                String auxABC = abecedario[j];
                if(String.valueOf(aux).equals(auxABC)){
                    vector[i] = j;
                }
            }
        }
        System.out.println("");
        
        return vector;
    }
    
    public long obtenerBaseOrigen(long [] vectorAux){
       
        long numeromayor=0;
        
        for(int i=0; i<vectorAux.length ; i++){
            // System.out.println(nombres[i] + " " + sueldos[i]);
            if(vectorAux[i]>numeromayor){ // 
                numeromayor = vectorAux[i];
            }
        }
        
        numeromayor = numeromayor+1;
        
        return numeromayor;
    }
    
    
    /***
     contador de las bases*/
    public long[ ] vectorBase(int auxTam, long baseOrigen){
        
        long [] vectorB = new long[auxTam];
        for(int i =0; i < auxTam; i++){
            vectorB[i] = (long) Math.pow(baseOrigen, i);
            //System.out.println("Multiplicacion base::...."+vectorB[i]);
        }
        
        return vectorB;
    }
    
    
    /**
     multiplicar los dos bectores retorna en base 10**/
    public long multiplicarVectores(long [] vNumero, long[] vBase){
        
        long [] multiplicacion = new long[vNumero.length];
        int contador = vNumero.length -1;//3
        long sumatoria=0;
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
    public long[] dividirRC(long dividendo, int divisor){
       
        long [] respuesta = new long[2]; //Primera posicion el cociente,- Segunda posicion el residuo
        respuesta[0] = dividendo/divisor;
        respuesta[1] =dividendo%divisor;
        
        return respuesta;
    }
    
    
    /**
     obtener el residuo de las diviciones para convertir a la base final**/
    public void obtenerBaseFinal(int baseFinal, long base10){
       //System.out.println("Las bases que llegan son::..."+baseFinal+" - "+base10);
        long [] arreglo = dividirRC(base10,baseFinal);
        
    
        long cociente = arreglo[0];
        long residuo = arreglo[1];
   
        
        if(cociente > baseFinal){
            
            if(this.getResiduo().equals("")){
                setResiduo(""+residuo) ;
            }else{
                setResiduo(this.getResiduo()+"-"+residuo) ;
            }
            
            
            obtenerBaseFinal(baseFinal,cociente);
            //residuo = residuo+"-"+arreglo[1];
            //System.out.println("El residuo:..."+residuo+" variable:.."+arreglo[1]);
           
        }else{
            //System.out.println("El cociente es menor que base");
            if(this.getResiduo().equals("")){
                setResiduo(residuo+"-"+cociente) ;
            }else{
                setResiduo(this.getResiduo()+"-"+residuo+"-"+cociente) ;
            }
            
        }
        
    }
    
    
    public String getResiduo(){
        return this.residuo;
    }
    
    public void setResiduo(String residuo){
        this.residuo= residuo;
    }
    
    /**Metodo para ordenar la base que obtuvimos*/
    public String[] ordenarBaseFin(String bases){
        String [] vector = bases.split("-");
        String [] vRespuesta = new String[vector.length]; 
        int tamanio= vector.length;
        int contador = 1;
       
        for(int i =0; i<vector.length; i++){
          
            vRespuesta[tamanio -contador] = ""+vector[i];
            contador++;
            
        }
        
        return vRespuesta;
    }
    
    
    public String resultadoBases(String[] vObjeto){
        String respuesta ="";
        //System.out.println("Tamaño respuesta:...."+vObjeto.length);
        for(int i=0; i< vObjeto.length; i++){
            //System.out.println("******+++:...."+vObjeto[i]);
            //String aux1=vObjeto[i];
            int numero = Integer.parseInt(vObjeto[i]);
            respuesta +=abecedario[numero];
            
          
        }
        return respuesta;
    }
    
    //*************************************
    
    public String [] obtenerRandom(int auxTam){
        
        
        String [] vAux = new String [auxTam];
        for(int i =0; i< auxTam; i++){
            int numero = (int) (Math.random() * 35)+1;
            //System.out.println("El numero random fue:..."+numero);
            vAux[i] = abecedario[numero];
        }
        
        return vAux;
    }
    
}
