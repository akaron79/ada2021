/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author vicente
 */
public class VisorHexConsola {

    private static final int C_BASE = 16;
    private static final String C_HEX_DIGIT = "0123456789ABCDEF";
    private static final char C_HEX_DIGIT_ARR[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    protected BufferedInputStream bis;
    protected int byteActual;
        
    public VisorHexConsola(String fileName){
        
        byteActual = 0;
        bis = null;
        
        try {
            bis = new BufferedInputStream(new FileInputStream(fileName));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VisorHexConsola.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean leeSiguienteByte() {
        try {
            byteActual = bis.read();
        } catch (IOException ex) {
            Logger.getLogger(VisorHexConsola.class.getName()).log(Level.SEVERE, null, ex);
            byteActual = -1;
        }
            if(byteActual == -1) return false;
            else return true;
       
        
    }
    
    public void imprimeByteActual(){
        System.out.print(C_HEX_DIGIT.charAt(byteActual/C_BASE)); //Primer nibble
        System.out.print(C_HEX_DIGIT.charAt(byteActual%C_BASE)); //Segundo nibble
        //System.out.print(C_HEX_DIGIT_ARR[byteActual%C_BASE]);
    }
    
    public void cierraStream() {
        if(bis != null) try {
            bis.close();
        } catch (IOException ex) {
            Logger.getLogger(VisorHexConsola.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        String fileName = "textoUTF8.txt";
        VisorHexConsola vhc = new VisorHexConsola(fileName);
        
        while(vhc.leeSiguienteByte()) vhc.imprimeByteActual();
        
    }
    
}
