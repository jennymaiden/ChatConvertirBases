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
public class Utilidades {
    
    /**Metodo para validar si un chat es un numero o una letra
     @param  caracter
     @return boolean */
    public static boolean isNumeric(char cadena){
	try {
            Integer.parseInt(Character.toString(cadena));
            
            return true;
	} catch (NumberFormatException nfe){
            System.out.println("Error no es un numero:...."+nfe.getMessage());
            return false;
	}
    }
    
    /**
     Convertir de letra a numero
     @param  caracter
     @return int numero**/
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
}
