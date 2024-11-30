import dao.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String opcion;
        AlmacenDAO almacenDAO = new AlmacenDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        ProductoFavDAO productoFavDAO = new ProductoFavDAO();

        try {
            almacenDAO.ComprobaroCrearBD();
        System.out.println("La base de datos y las tablas están listas.");
        System.out.println();
            do{
            menu();
            opcion = sc.next();
                switch (opcion) {
                    case "1":
                        System.out.println("Mostrando lista de Empleados:");
                        empleadoDAO.tablaEmpleados();
                        break;
                    case "2":
                        System.out.println("Mostrando lista de Productos:");
                        productoDAO.tablaProductos();
                        break;
                    case "3":
                        System.out.println("Mostrando lista de Pedidos:");
                        pedidoDAO.tablaPedidos();
                        break;
                    case "4":
                        System.out.println("Mostrando lista de Producto con precio menor a 600€:");
                        productoDAO.precioBajo();
                        break;
                    case "5":
                        System.out.println("Mostrando lista de Productos Favoritos:");
                        productoFavDAO.tablaFavoritos();
                        break;
                    case "6":
                        System.out.println("Fin");
                        break;
                    default:
                        System.out.println("Introduce un valor valido.");
                }
            } while(!opcion.equals("6"));

        } catch (SQLException e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }
    public static void menu(){
        System.out.println("1.Mostrar lista de Empleados");
        System.out.println("2.Mostrar lista de Productos:");
        System.out.println("3.Mostrar lista de Pedidos:");
        System.out.println("4.Mostrar lista de Producto con precio menor a 600€:");
        System.out.println("5.Mostrar lista de Productos Favoritos:");
        System.out.println("6.Salir");
    }
}
