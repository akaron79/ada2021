/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializacion;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vicente
 */
public class MainSerializacion {
    
    public static void main (String[] args) {
        
        var errores = false;
        Persona p1 = new Persona("Vicente", "López", 17); //a la vieja usanza
        var p2 = new Persona("Antonio", "Sánchez", 47);
        var p3 = new Persona("Felisa", "Martín", 65);
        var p4 = new Persona("María", "Rodríguez", 14);
        var p5 = new Persona("Ambros", "Lila", 65);
        
        
        //Código moderno porque usamos:
        //    - try-with-resources: directamente cierra el Stream cuando se acabe de usar.
        //    - var para evitar repetir clases en las declaraciones
        //    - las clases Path y Files de java.nio
        
        
        var prop = new Properties();   
        try {
            prop.load(Files.newInputStream(Path.of("config.properties")));
        } catch (IOException ex) {
            System.err.println("No se pudo abrir el fichero de properties");
        }
        
        var fileName = prop.getProperty("filePath");
        
        try (var fos = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(Path.of(fileName))))){               
            fos.writeObject(p1);
            fos.writeObject(p2);
            fos.writeObject(p3);
            fos.writeObject(p4);
            fos.writeObject(p5);
            
            fos.flush(); //forzamos el vaciado del buffer a disco. Si no lo ponemos, el flush se hace automáticamente al cerrar el flujo.
            
        } catch (IOException ex) {
            System.err.println("Error en escritura de fichero");
            //Esto tiene un inconveniente: si llego aquí no sé si es 
            //porque ha petado la instanciación del stream o porque ha
            //petado algún write.
            //Lo fino es hacer dos try y que cada cual controle lo suyo
            errores = true;
        }
   
        //Código clásico equivalente
//        ObjectOutputStream fos = null;
//        try {               
//            fos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("personas.bin")));
//            
//            fos.writeObject(p1);
//            fos.writeObject(p2);
//            fos.writeObject(p3);
//            fos.writeObject(p4);
//            fos.flush(); //forzamos el vaciado del buffer a disco. Si no lo ponemos, el flush se hace automáticamente al cerrar el flujo.
//            
//        } catch (IOException ex) {
//            System.err.println("Error en escritura de fichero");
//            //Esto tiene un inconveniente: si llego aquí no sé si es 
//            //porque ha petado la instanciación del stream o porque ha
//            //petado algún write.
//            //Lo fino es hacer dos try y que cada cual controle lo suyo
//        } finally {
//            if (fos!=null) try {
//                fos.close();
//            } catch (IOException ex) {
//                System.err.println("Error en el cierre del fichero");
//            }
//        }
        
        //Ahora vamos a leer de disco
        if(errores==false){
            //Entonces, lee
            try (var fis = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(Path.of("personas.bin"))))){
               //System.out.println(((Persona) fis.readObject()).getNombre());
               while(true) {
                   try {
                       System.out.println(((Persona) fis.readObject()).getNombre());
                   } catch (EOFException ex){
                       break;
                   }
               }
               
               
            } catch (IOException ex) {
                System.err.println("No se ha podido leer el fichero.");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainSerializacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else System.err.println("No hay nada que leer");

       
    
        
    }
}
