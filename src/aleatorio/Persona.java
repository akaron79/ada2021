/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aleatorio;

import serializacion.*;
import java.io.Serializable;

/**
 *
 * @author vicente
 */
public class Persona implements Serializable {
    protected String m_nombre;
    protected String m_apellidos;
    protected int m_edad;
    

    public Persona() {
        m_nombre = null;
        m_apellidos = null;
        m_edad = -1;
    }

    
    public Persona(String pi_nombre, String pi_apellidos, int pi_edad) {
        this.m_nombre = pi_nombre;
        this.m_apellidos = pi_apellidos;
        this.m_edad = pi_edad;
    }

    
    public String getNombre() {
        return m_nombre;
    }

    public void setNombre(String pi_nombre) {
        this.m_nombre = pi_nombre;
    }

    public String getApellidos() {
        return m_apellidos;
    }

    public void setApellidos(String pi_apellidos) {
        this.m_apellidos = pi_apellidos;
    }

    public int getEdad() {
        return m_edad;
    }

    public void setEdad(int pi_edad) {
        this.m_edad = pi_edad;
    }
    
}
