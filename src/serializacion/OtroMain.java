/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializacion;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.READ;

/**
 *
 * @author vicente
 */
public class OtroMain {
    public static void main (String[] args){
        Persona p1 = new Persona("Vicente", "López", 17); //a la vieja usanza
        var p2 = new Persona("Antonio", "Sánchez", 47);
        var p3 = new Persona("Felisa", "Martín", 65);
        var p4 = new Persona("María", "Rodríguez", 14);
        var errores = false;
        
        try (var fos = new ObjectOutputStream(Files.newOutputStream(Path.of("prueba.dat"), CREATE))) {
            fos.writeObject(p1);
            fos.writeObject(p2);
            fos.writeObject(p3);
            fos.writeObject(p4);
            fos.flush();
        } catch (IOException ex) {
            System.err.println("Error escribiendo. Abortamos ejecución.");
            errores = true;
        }
        
        
        if(errores==false){
            try (var fis = new ObjectInputStream(Files.newInputStream(Path.of("prueba.dat"), READ))) {
                try {
                    System.out.println(((Persona)fis.readObject()).getNombre());
                    System.out.println(((Persona)fis.readObject()).getNombre());
                    System.out.println(((Persona)fis.readObject()).getNombre());
                    System.out.println(((Persona)fis.readObject()).getNombre());

                } catch (ClassNotFoundException ex) {
                    System.err.println("Error leyendo. Abortamos ejecución.");
                } catch (EOFException ex) {
                    System.err.println("Hemos llegado al final del fichero.");
                }

            } catch (IOException ex) {
                System.err.println("Error escribiendo. Abortamos ejecución.");
                errores = true;
            }   
        }
        
        //Esto ya no tiene nada que ver con la serialización de objetos
        //Listemos por consola todas las propiedades del sistema
        var properties = System.getProperties();
        //Volvemos a usar funciones anónimas para evitar código verborreico
        properties.forEach((k, v) -> System.out.println(k + "=" + v));
                
    }
    
}
