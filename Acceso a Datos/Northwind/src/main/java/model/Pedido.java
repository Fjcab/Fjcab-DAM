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
public class Pedido implements Serializable {
    private int id;
    private int idProducto;
    private String descripcion;
    private double precioTotal;

    public Pedido(int idProducto, String descripcion, double precioTotal) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precioTotal = precioTotal;
    }
    public void mostrarDatos(){
        System.out.println("Id = " + id);
        System.out.println("Id-Producto = " + idProducto);
        System.out.println("Descripción = " + descripcion);
        System.out.println("Precio-Total= " + precioTotal);
        System.out.println();
    }

}
