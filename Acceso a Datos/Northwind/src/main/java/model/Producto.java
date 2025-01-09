package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio;

    public void mostrarDatos(){
        System.out.println("Id = " + id);
        System.out.println("Nombre = " + nombre);
        System.out.println("Descripción = " + descripcion);
        System.out.println("Cantidad = " + cantidad);
        System.out.println("Precio = " + precio);
        System.out.println();
    }
}
