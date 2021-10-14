/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author vicente
 */
public class LecturaStreamBinario {
    
     public static void main (String [] args) {
        
        int byteLeido = 0;
        FileInputStream fis = null;
        try {
           fis = new FileInputStream("hola_LATIN1.txt");
           while((byteLeido = fis.read()) != -1){
               
               
               
               System.out.println(byteLeido);
               
           }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(LecturaStreamText.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("El fichero no se ha encontrado.");
        } catch (IOException ex) {
            System.out.println("Error de lectura.");
        } catch (Exception ex) {
            System.out.println("Ha habido un fallo general (Un null pointer exception?).");
        } finally {
            try {
                if(fis != null) fis.close();
            } catch (IOException ex) {
                //Logger.getLogger(LecturaStreamText.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Error al cerrar el flujo asociado al fichero.");
  
            }
        } 
    
    }   
    
}
