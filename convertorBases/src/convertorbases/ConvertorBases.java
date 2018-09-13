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

    public static String mensaje = "TELEGRAFO";
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
        
        long [] a1 =auxObj.obtenerArregloNum(mensaje);
        for(int i=0; i< a1.length; i++){
            System.out.println("EL vector quedo con estas valores::");
            System.out.println("***..."+a1[i]);
        }
        
        long base = auxObj.obtenerBaseOrigen(a1);
        System.out.println("La base en la que esta es:::..."+base);
    }
    
    //http://cursos-para-educar.me/utilidades/bases
}
