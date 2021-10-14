/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 *
 * @author vicente
 */
public class LecturaStreamText  {
    public static void main (String [] args) {
        
        int caracter;
        FileReader fr = null;
        try {
           fr = new FileReader("hola_LATIN1.txt", StandardCharsets.UTF_8);
           while((caracter = fr.read()) != -1){
               System.out.print((char) caracter);
           }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(LecturaStreamText.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("El fichero no se ha encontrado.");
        } catch (IOException ex) {
            System.err.println("Error de lectura.");
        } catch (Exception ex) {
            System.err.println("Ha habido un fallo general (Un null pointer exception?).");
        } finally {
            try {
                if(fr != null) fr.close();
            } catch (IOException ex) {
                //Logger.getLogger(LecturaStreamText.class.getName()).log(Level.SEVERE, null, ex);
               System.err.println("Error al cerrar el fichero.");
  
            }
        }
    }   
}
