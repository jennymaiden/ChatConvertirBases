/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertorbases;

/**
 *
 * @author carolina
 */
public class Control {
    
    private String residuo = "";
    
    /**
     Convertir de letra a numero**/
    public int convertirLetraNumero(char letra){
        int valor =0;
        switch (letra){
            case 'A':
                valor =10;
                break;
            case 'B':
                valor =11;
                break;
            case 'C':
                valor=12;
                break;
            case 'D':
                valor=13;
                break;
            case 'E':
                valor=14;
                break;
            case 'F':
                valor=15;
                break;
            case 'G':
                valor=16;
                break;
            case 'H':
                valor=17;
                break;
            case 'I':
                valor=18;
                break;
            case 'J':
                valor=19;
                break;
            case 'K':
                valor=20;
                break;
            case 'L':
                valor=21;
                break;
            case 'M':
                valor=22;
                break;
            case 'N':
                valor=23;
                break;
            case 'O':
                valor=24;
                break;
            case 'P':
                valor=25;
                break;
            case 'Q':
                valor=26;
                break;
            case 'R':
                valor=27;
                break;
            case 'S':
                valor=28;
                break;
            case 'T':
                valor=29;
                break;
            case 'U':
                valor=30;
                break;
            case 'V':
                valor=31;
                break;
            case 'W':
                valor=32;
                break;
            case 'X':
                valor=33;
                break;
            case 'Y':
                valor=34;
                break;
            case 'Z':
                valor=35;
                break;
        }
        
        return valor;
    
    }
    
    /**Metodo para convertir de numero a letra
     @param int numero
     @retum char caracter**/
    public char convertirNumeroLetra(int numero){
        char valor = 0;
        switch (numero){
            case 10:
                valor ='A';
                break;
            case 11:
                valor ='B';
                break;
            case 12:
                valor='C';
                break;
            case 13:
                valor='D';
                break;
            case 14:
                valor='E';
                break;
            case 15:
                valor='F';
                break;
            case 16:
                valor='G';
                break;
            case 17:
                valor='H';
                break;
            case 18:
                valor='I';
                break;
            case 19:
                valor='J';
                break;
            case 20:
                valor='K';
                break;
            case 21:
                valor='L';
                break;
            case 22:
                valor='M';
                break;
            case 23:
                valor='N';
                break;
            case 24:
                valor='O';
                break;
            case 25:
                valor='P';
                break;
            case 26:
                valor='Q';
                break;
            case 27:
                valor='R';
                break;
            case 28:
                valor='S';
                break;
            case 29:
                valor='T';
                break;
            case 30:
                valor='U';
                break;
            case 31:
                valor='V';
                break;
            case 32:
                valor='W';
                break;
            case 33:
                valor='X';
                break;
            case 34:
                valor='Y';
                break;
            case 35:
                valor='Z';
                break;
        }
        return valor;
    }
    
    private static boolean isNumeric(char cadena){
	try {
            Integer.parseInt(Character.toString(cadena));
            
            return true;
	} catch (NumberFormatException nfe){
            
            return false;
	}
}
    /**
     Obtener el numero**/
    public int[ ] vectorNumeros(String numero){ 
        //Separa por caracter
        char[ ] caracteres = numero.toCharArray();
        //System.out.println("***Cadena lenght;:..."+numero.length());
        int[ ] arreglo = new int[numero.length()];
        //System.out.println("numero de caracteres::......"+caracteres.length);
        for(int i =0; i < caracteres.length; i++){
            //System.out.println("Caracter es:....."+Character.toString(caracteres[i]));
            //validar si es numero o letra
            if(isNumeric(caracteres[i])){
                arreglo[i]= Integer.parseInt(Character.toString(caracteres[i]));
                
            }else{
                //es letra
                arreglo[i] = convertirLetraNumero(caracteres[i]);
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
            //System.out.println("Multiplicacion base::...."+vectorB[i]);
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
       //System.out.println("Las bases que llegan son::..."+baseFinal+" - "+base10);
        int [] arreglo = dividirRC(base10,baseFinal);
        
    
        int cociente = arreglo[0];
        int residuo = arreglo[1];
   
        
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
            System.out.println("******+++:...."+vObjeto[i]);
            int numero = Integer.parseInt(vObjeto[i]);
            if(numero >9){
                respuesta +=convertirNumeroLetra(numero);
            }else{
                respuesta+=""+numero;
            }
        }
        return respuesta;
    }
}
