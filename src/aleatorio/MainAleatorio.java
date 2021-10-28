/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aleatorio;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vicente
 */
public class MainAleatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       var personas = new ArrayList<Persona>();
       
       personas.add(new Persona("Sabina", "Rato", 65));
       personas.add(new Persona("Joaquín", "Sabina", 18));
       personas.add(new Persona("Raúl", "Yusta", 29));
       personas.add(new Persona("José", "Benítez", 53));
       personas.add(new Persona("Cabra", "Loca", 19));
       
       //Comenzamos con la escritura
       try (var raf = new RandomAccessFile("raf_personas.dat", "rw")) {
            //Abrimos el fichero para escribir
            //Empezamos a escribir en fichero
            for(Persona p:personas) {
                raf.writeUTF(p.getNombre());
                raf.writeUTF(p.getApellidos());
                raf.writeInt(p.getEdad());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (var raf = new RandomAccessFile("raf_personas.dat", "r")) {
            //Ahora comenzamos con la lectura
            
            while(true) {
                try {
                    System.out.print(raf.readUTF() + ", "); //Nombre
                    System.out.print(raf.readUTF() + ", "); //Apellidos
                    System.out.println(raf.readInt() + "."); //Nombre
                    
                } catch (EOFException e) {
                    //Fin de fichero
                    break;
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        //Hasta ahora hemos usado un acceso muy parecido al de streams, pero...
        //Y si quiero ahora recuperar la tercera persona?
        //Entonces tenemos que tener registros con el mismo tamaño.
        //Es decir, tenemos que asegurar que los Strings tienen el mismo tamaño
        
       //Comenzamos con la escritura, pero ahora con registros de tamaño fijo!
       try (var raf = new RandomAccessFile("raf_personas.dat", "rw")) {
            //Abrimos el fichero para escribir
            //Empezamos a escribir en fichero
            for(Persona p:personas) {
                //Fijamos buffer de 30bytes;
                var nombre =  Arrays.copyOf(p.getNombre().getBytes(StandardCharsets.UTF_8), 30);
                //Escribimos el tamaño real del String en bytes
                raf.writeInt(p.getNombre().getBytes(StandardCharsets.UTF_8).length);
                //Escribimos el buffer
                raf.write(nombre);
                
                //Fijamos buffer de 30bytes;
                var apellidos =  Arrays.copyOf(p.getApellidos().getBytes(StandardCharsets.UTF_8), 30);
                //Escribimos el tamaño real del String en bytes
                raf.writeInt(p.getApellidos().getBytes(StandardCharsets.UTF_8).length);
                //Escribimos el buffer
                raf.write(apellidos);
                
                raf.writeInt(p.getEdad());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       //Ahora leemos la tercera persona (Raúl Yusta)
        try (var raf = new RandomAccessFile("raf_personas.dat", "r")) {
            raf.seek(2*72);
            try {
                var numBytesNombre = raf.readInt();
                byte[] nombre = new byte[30];
                raf.read(nombre);
                var StrNombre =  Arrays.copyOf(nombre, numBytesNombre);
                System.out.print( new String(StrNombre, StandardCharsets.UTF_8)+ ", "); //Nombre

                var numBytesApellidos = raf.readInt();
                byte[] apellidos = new byte[30];
                raf.read(apellidos);
                var StrApellidos =  Arrays.copyOf(apellidos, numBytesApellidos);
                System.out.print(new String(StrApellidos, StandardCharsets.UTF_8) + ", "); //Apellidos

                System.out.println(raf.readInt() + "."); //Nombre

            } catch (EOFException e) {
                //Fin de fichero
                System.err.println("Se llegó al final de fichero");
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
       
    }
    
}
