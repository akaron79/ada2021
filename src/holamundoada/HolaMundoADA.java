/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundoada;

//Array de Frases leído de fichero
//Se pregunta qué se quiere hacer (jugar o cargar partida)
//Si es jugar se elige una frase y empieza el loop de juego
//Si es cargar, se lee de fichero todo lo que se ha guardado y continúa el loop del juego
//En el loop de juego se muestran con asteriscos lo que no se conoce y las letras que se conocen
//Se cuenta el número de intentos
//Las opciones en el bucle son: 
// . Descubrir letra ==> cuenta un intento y descubre los aciertos
// . Resolver ==> pide la frase entera: si coincide acaba y da puntos. Si no, quita puntos
// . Guardar ==> almacena en disco el estado del juego y continúa pidiendo intentos.

//Clases: Partida, Frase

/**
 *
 * @author vicente
 */
public class HolaMundoADA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hola mundo ADA");
    }
 
}
