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
    
    
    public long [] obtenerArregloNum(String msg){
        char[ ] caracteres = msg.toCharArray();
        int tamanio = caracteres.length;
        long [] vector = new long[tamanio];
        
        for(int i =0; i<tamanio;i++){
            char aux = caracteres[i];
            for(int j=0; j< tamanioABC; j++){
                String auxABC = abecedario[j];
                if(String.valueOf(aux).equals(auxABC)){
                    vector[i] = j;
                }
            }
        }
        
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
        System.out.println("El long mayor fue:::..."+numeromayor);
        numeromayor = numeromayor+1;
        
        return numeromayor;
    }
    
    
    
}
