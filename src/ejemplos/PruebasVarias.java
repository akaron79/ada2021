/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplos;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author vicente
 */
public class PruebasVarias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            var propiedades = new Properties();
            try {
                //Si esto peta y salta al catch, se debe acabar el programa inmediatamente
                propiedades.load(Files.newInputStream(Path.of("pruebas.properties")));
                int contador = 0;
                ArrayList<String> frases = null;
                ArrayList<String> frasesTotales = null; //no veo por qué necesitas un frases y un frasesTotales...
                String ruta =  propiedades.getProperty("rutaFilePeliculas");

                try {
                    frasesTotales = (ArrayList<String>) Files.readAllLines(Path.of(ruta), StandardCharsets.UTF_8);
                } catch (IOException ex) {
                    System.err.println("Error cargando properties");
                }

                for(int i = 0; i < frasesTotales.size();i++ ){ //este for no tiene ninguna utilidad
                    contador++;

                }

                var estadoFrases = new boolean [contador];
                for (int f = 0; f < estadoFrases.length;f++){
                    estadoFrases[f]= false;
                }
                
                //Compruebo que frasesTotales tiene todo
                frasesTotales.forEach((frase) -> System.out.println(frase));

                
            } catch (IOException ex) {
                System.err.println("Error cargando properties");
            }

            
    }
    
}
