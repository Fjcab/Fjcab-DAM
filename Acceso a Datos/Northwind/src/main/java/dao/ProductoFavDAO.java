package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Producto;
import model.ProductoFav;

import java.sql.*;
import java.util.ArrayList;

public class ProductoFavDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private ProductoDAO productoDAO = new ProductoDAO();

    public void registrarProductoFav() throws SQLException {
        ArrayList<Producto> precioAlto = productoDAO.precioAlto();
        for (Producto producto : precioAlto) {
            ProductoFav productoFav = new ProductoFav(producto.getId());
        connection = new DBConnection().getConnection();
        String query = String.format("INSERT INTO %s (%s) VALUE (?)",
                SchemaDB.TAB_PRODFAV,SchemaDB.COL_ID_PROD);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, productoFav.getIdProducto());
        preparedStatement.execute();
        }
    }

    public void tablaFavoritos() throws SQLException {
        connection = new DBConnection().getConnection();
        statement = connection.createStatement();
        String query = String.format(
                "SELECT %s.%s, %s.%s, %s.%s, %s.%s, %s.%s, %s.%s " +
                        "FROM %s " +
                        "JOIN %s ON %s.%s = %s.%s",
                SchemaDB.TAB_PRODFAV, SchemaDB.COL_ID,        // productos_fav.id
                SchemaDB.TAB_PRODFAV, SchemaDB.COL_ID_PROD,  // productos_fav.id_producto
                SchemaDB.TAB_PROD, SchemaDB.COL_NAME,        // productos.nombre
                SchemaDB.TAB_PROD, SchemaDB.COL_DESCRP,        // productos.descripcion
                SchemaDB.TAB_PROD, SchemaDB.COL_QTY,         // productos.cantidad
                SchemaDB.TAB_PROD, SchemaDB.COL_PRICE,       // productos.precio
                SchemaDB.TAB_PRODFAV,                        // productos_fav
                SchemaDB.TAB_PROD,                           // productos
                SchemaDB.TAB_PRODFAV, SchemaDB.COL_ID_PROD,  // productos_fav.id_producto
                SchemaDB.TAB_PROD, SchemaDB.COL_ID           // productos.id
        );
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {

            int id = resultSet.getInt(SchemaDB.COL_ID);
            int idProducto = resultSet.getInt(SchemaDB.COL_ID_PROD);
            String nombre= resultSet.getString(SchemaDB.COL_NAME);
            String descripcion= resultSet.getString(SchemaDB.COL_DESCRP);
            int cantidad = resultSet.getInt(SchemaDB.COL_QTY);
            double precio = resultSet.getDouble(SchemaDB.COL_PRICE);

            ProductoFav productoFav = new ProductoFav(id, idProducto, nombre, descripcion, cantidad, precio);
            productoFav.mostrarDatos();
        }
    }
}
