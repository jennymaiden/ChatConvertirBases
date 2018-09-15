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
public class ConvertorBases {

    public static String mensaje = "12345";
    public static int baseOrigen=30;
    public static int baseFinal=10;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Control obj = new Control();
        int[] vNumeros = obj.vectorNumeros(mensaje);
        //System.out.println("El vector numero es:...."+vNumeros.toString());
        int[] vBase = obj.vectorBase(vNumeros, baseOrigen);
        
        int base10 = obj.multiplicarVectores(vNumeros, vBase);
        //System.out.println("SUMA BASE 10:....."+base10);

        int [] dividir = obj.dividirRC(2, baseFinal);
        //System.out.println("Prueba de dividir:....Cociente: "+dividir[0]+" *** residuo:..."+dividir[1]);
        
        obj.obtenerBaseFinal(baseFinal, base10);
        //System.out.println("Objeto respuesta:....."+obj.getResiduo());
        //System.out.println("---------------");
        String [] vObjeto = obj.ordenarBaseFin(obj.getResiduo());
        //System.out.println("*++**"+vObjeto.length);
        String resAux =obj.resultadoBases(vObjeto);
        System.out.println("El número "+mensaje+" escrito en base "+baseOrigen+" es igual a "+resAux+" en base "+baseFinal+" .");
        */
        
        PruebaBase auxObj = new PruebaBase();
        mensaje= mensaje.toUpperCase();
        System.out.println("EL mansaje:..."+mensaje);
        long [] a1 =auxObj.obtenerArregloNum(mensaje);
        System.out.println("EL vector en numeros:...");
        for(int i=0; i< a1.length; i++){
            
            System.out.print("["+a1[i]+"]");
        }
        String [] abcDesorganizado = auxObj.obtenerRandom(a1.length);
        System.out.println("");
        System.out.println("El vector desorganizado es");
        for(int i =0; i<abcDesorganizado.length;i++){
            System.out.print("["+abcDesorganizado[i]+"]");
        }
        System.out.println();
        long base = auxObj.obtenerBaseOrigen(a1);
        System.out.println("La base en la que esta es:::..."+base);
        System.out.println("*************************");
        long[] a2 =auxObj.vectorBase(a1.length, base);
        System.out.println("EL vector base quedo con estas valores::");
        for(int i=0; i< a1.length; i++){
            
            System.out.print("["+a2[i]+"]");
        }
        System.out.println();
        long multi = auxObj.multiplicarVectores(a1, a2);
        
        auxObj.obtenerBaseFinal(baseFinal, multi);
      
        //System.out.println("---------------");
        String[] a3 = auxObj.ordenarBaseFin(auxObj.getResiduo());
        
        String resAux =auxObj.resultadoBases(a3);
        System.out.println("El número "+mensaje+" escrito en base "+base+" es igual a "+resAux+" en base "+baseFinal+" .");
    }
    
    //http://cursos-para-educar.me/utilidades/bases
}
