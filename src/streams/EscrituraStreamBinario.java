/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vicente
 */
public class EscrituraStreamBinario {
    
    public static void main (String args[]) {
        
        FileOutputStream fos = null;
        byte byteAEscribir = 0x42;
        
        byte bufferDeLaMuerte [] = {0x43, 0x42, 0x52, 0x52, 0x0F};
        String cadena = "¡Hola Mundón!";
        
        try {
            fos = new FileOutputStream("misdatos2.dat", true); //constructor (String ruta, boolean append)
            fos.write(byteAEscribir);
            fos.write(bufferDeLaMuerte);
            fos.write(cadena.getBytes("UTF-16BE"));
            //fos.write(cadena); // Eso no funciona en la clase OutputStream pero sí funciona en la Writer!!!
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(EscrituraStreamBinario.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error en la apertura del fichero.");
        } catch (IOException ex) {
            Logger.getLogger(EscrituraStreamBinario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           if(fos!=null) try {
               fos.close();
           } catch (IOException ex) {
               //Logger.getLogger(EscrituraStreamBinario.class.getName()).log(Level.SEVERE, null, ex);
               System.err.println("Error en el cierre del fichero.");
           } 
        }
    }
    
}
