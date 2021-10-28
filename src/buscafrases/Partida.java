/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscafrases;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author vicente
 */
public class Partida {
    protected ArrayList<String> frases;
    protected int puntuacion;
    protected Reto reto;
    protected Properties propiedades;
    
    public Partida() {
        iniciar();
    }
    
    
    public void cargaProperties() {
        propiedades = new Properties();
        try {
            //Si esto peta y salta al catch, se debe acabar el programa inmediatamente
            propiedades.load(Files.newInputStream(Path.of("busca_frases.properties")));
        } catch (IOException ex) {
            System.err.println("Error cargando properties.");
        }
    }
    
    public void cargaFrases() {

        try {
            frases = (ArrayList<String>) Files.readAllLines(Path.of(propiedades.getProperty("rutaFicheroFrases")), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.err.println("Error leyendo del fichero de frases.");
        }
    }
    
    
    public void iniciar () {
        //leemos las properties la ruta en la que guardo las frases
        cargaProperties();
       
        //cargamos el fichero de frases
        cargaFrases();
        
        //se elije una frase al azar y la sacamos del array para no repetir
        //instancimamos el objeto reto
        Reto reto = new Reto(frases.remove(ThreadLocalRandom.current().nextInt(0, frases.size()+1)));
        
        //Compruebo que frasesTotales tiene todo
        frases.forEach((frase) -> System.out.println(frase));
        
        //reseteamos los puntos
        puntuacion = 0;
    }
    
}
