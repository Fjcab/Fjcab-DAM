package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ProductoFav extends Producto implements Serializable {
    private int id;
    private int idProducto;


    public ProductoFav(int idProducto) {
        this.idProducto = idProducto;
    }
    public ProductoFav(int id, int idProducto, String nombre, String descripcion, int cantidad, double precio) {
        super(idProducto, nombre, descripcion, cantidad, precio);
        this.id = id;
        this.idProducto = idProducto;
    }


    public void mostrarDatos(){
        System.out.println("Id = " + id);
        System.out.println("Id-Producto = " + idProducto);
        System.out.println("Descripción = " + super.getDescripcion());
        System.out.println("Cantidad = " + super.getCantidad());
        System.out.println("Precio = " + super.getPrecio());
        System.out.println();
    }
}
