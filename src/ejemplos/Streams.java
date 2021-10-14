/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vicente
 */
public class Streams {
    public static void main (String [] args) {
        
        
        Path p1 = Path.of("nombre_fichero");
        Path p2 = Paths.get(System.getProperty("user.home"), "directorio", "nombre_fichero");
        Path p3 = Path.of(System.getProperty("user.home"), "directorio", "nombre_fichero");
        
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p3.getName(3));
        
        var lineas = new ArrayList<String>();
        ArrayList<String> frases;
        lineas.add("Y otra");
        lineas.add("Y otra más");
        lineas.add("Y otra más aun");
        String frase;
        
        try {
            //Files.newBufferedWriter(p1, StandardCharsets.UTF_8, CREATE, WRITE);
            Files.write(p1, lineas, StandardCharsets.UTF_8, CREATE, APPEND);
            frases = (ArrayList<String>) Files.readAllLines(p1, StandardCharsets.UTF_8);
            for (Iterator<String> it = frases.iterator(); it.hasNext();) {
                frase = it.next();
                System.out.println(frase);
            }
            
            frases.forEach(
                    (fras) -> System.out.println(fras)
            );
            
        } catch (IOException ex) {
            Logger.getLogger(Streams.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Path pdata = Path.of("ejemploData.dat");
        try {
          var dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(pdata)));
          dos.writeUTF("Meto una cadena");
          dos.writeUTF("Y luego otra");
          dos.writeInt(27); //ahora un entero
          dos.writeDouble(27.27); //ahora un double
          dos.writeBoolean(true);
          dos.writeBoolean(true);
          dos.writeBoolean(false);
          dos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Streams.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Y ahora leemos el fichero
        try {
          var dis = new DataInputStream(new BufferedInputStream(Files.newInputStream(pdata)));
          System.out.println(dis.readUTF());
          System.out.println(dis.readUTF());
          System.out.println(dis.readInt()); //ahora un entero
          System.out.println(dis.readDouble()); //ahora un double
          System.out.println(dis.readBoolean());
          System.out.println(dis.readBoolean());
          System.out.println(dis.readBoolean());
        } catch (IOException ex) {
            Logger.getLogger(Streams.class.getName()).log(Level.SEVERE, null, ex);
        }
            
//    Ejemplo de stream de entrada de texto desde fichero
//        int caracter = 0;
//        FileReader fr = null;
//        
//        try {
//            fr = new FileReader("textoUTF8.txt", StandardCharsets.UTF_8);
//            
//            while((caracter = fr.read())!=-1) {
//                System.out.print((char) caracter);
//            }
//        } catch (FileNotFoundException ex) {
//            //Logger.getLogger(Streams.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("No se pudo abrir el fichero.");
//        } catch (IOException ex) {
//            System.out.println("No se pudo leer el fichero.");
//        } finally {
//            if(fr != null) try {
//                fr.close();
//            } catch (IOException ex) {
//                System.out.println("No se pudo cerrar el fichero.");
//            }
//        }


// Ejemplo de stream de entrada binaria desde fichero y con Buffer
//        int byteLeido = 0;
//        FileInputStream fis = null;
//        BufferedInputStream bis = null;
//        
//        try {
//            fis = new FileInputStream("textoUTF8.txt");
//            bis = new BufferedInputStream(fis); //este constructor no genera excepciones
//            
//            while((byteLeido = bis.read())!=-1) {
//                System.out.println(byteLeido);
//            }
//        } catch (FileNotFoundException ex) {
//            //Logger.getLogger(Streams.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("No se pudo abrir el fichero.");
//        } catch (IOException ex) {
//            System.out.println("No se pudo leer el fichero.");
//        } finally {
//            try {
//                if(bis != null) bis.close();
//                if(fis != null) fis.close();
//            } catch (IOException ex) {
//                System.out.println("No se pudo cerrar el fichero.");
//            }
//        }

// Ejemplo de stream de entrada de texto desde fichero y con Buffer

//       System.out.println("\u25a2  \u25cf");

//       System.out.println("Arg1: " + args[0] + " Arg2: " + args[1]);

//        int caracterLeido = 0;
//        FileReader fr = null;
//        BufferedReader br = null;
//        
//        try {
//            fr = new FileReader("textoUTF8.txt", StandardCharsets.UTF_8);
//            br = new BufferedReader(fr); //este constructor no genera excepciones
//            
//            while((caracterLeido = br.read())!=-1) {
//                System.out.print((char) caracterLeido);
//            }
//        } catch (FileNotFoundException ex) {
//            //Logger.getLogger(Streams.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("No se pudo abrir el fichero.");
//        } catch (IOException ex) {
//            System.out.println("No se pudo leer el fichero.");
//        } finally {
//            try {
//                if(br != null) br.close();
//                if(fr != null) fr.close();
//            } catch (IOException ex) {
//                System.out.println("No se pudo cerrar el fichero.");
//            }
//        }
//        

       

    } //main
} //class
