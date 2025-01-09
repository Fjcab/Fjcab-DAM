package Serializar;

import java.io.Serializable;

// Si queremos serializar un objeto, lo primero es que su clase implemente la interfaz Serializable
public class Persona implements Serializable {
    private String nombre;
    private int edad;
    private String direccion;

    public Persona(String nombre, int edad, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Dirección: " + direccion;
    }
}
