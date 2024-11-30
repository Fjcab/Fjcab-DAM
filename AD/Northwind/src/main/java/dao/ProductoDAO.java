package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Producto;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;

public class ProductoDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private ArrayList<Producto> productos = new ArrayList<>();

    public void obtenerProductos() {
    String urlString = "https://dummyjson.com/products";
    URL url;
    {
        try {
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = bufferedReader.readLine();
            JSONObject response = new JSONObject(linea);
            JSONArray products =  response.getJSONArray("products");
            for (Object cosas : products){
                if (cosas instanceof JSONObject){
                    int id = ((JSONObject)cosas).getInt("id");
                    String nombre = ((JSONObject)cosas).getString("title");
                    String descripcion = ((JSONObject)cosas).getString("description");
                    int cantidad = ((JSONObject)cosas).getInt("stock");
                    double precio = ((JSONObject)cosas).getDouble("price");
                    Producto producto = new Producto(id, nombre, descripcion, cantidad, precio);
                    productos.add(producto);
                }
            }
        } catch (MalformedURLException e) {
            System.out.println("La url no es valida");
        } catch (IOException e) {
            System.out.println("Error en la conexión");
        }
    }
    }

    public boolean registrarProducto(Producto producto) throws SQLException {
        connection = new DBConnection().getConnection();
        String query = String.format("INSERT INTO %s (%s,%s,%s,%s,%s) VALUE (?,?,?,?,?)",
                SchemaDB.TAB_PROD,SchemaDB.COL_ID, SchemaDB.COL_NAME, SchemaDB.COL_DESCRP,
                SchemaDB.COL_QTY, SchemaDB.COL_PRICE);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, producto.getId());
        preparedStatement.setString(2, producto.getNombre());
        preparedStatement.setString(3, producto.getDescripcion());
        preparedStatement.setInt(4, producto.getCantidad());
        preparedStatement.setDouble(5, producto.getPrecio());
        int filasAfectadas = preparedStatement.executeUpdate();
        return filasAfectadas > 0;
    }

    public void registrarArray() {
        obtenerProductos();
        for (Producto producto: productos){
            boolean registrado = false;
            try {
                registrado = registrarProducto(producto);
            if (registrado){
                System.out.println("Producto "+producto.getId()+" registrado");
            }
            } catch (SQLException e) {
                System.out.println(producto.getId()+" ya esta en la base de datos");
            }
        }
    }

    public void tablaProductos() throws SQLException {
        connection = new DBConnection().getConnection();
        statement = connection.createStatement();
        String query = String.format("SELECT * FROM %s", SchemaDB.TAB_PROD);
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {

            int id = resultSet.getInt(SchemaDB.COL_ID);
            String nombre = resultSet.getString(SchemaDB.COL_NAME);
            String descripcion = resultSet.getString(SchemaDB.COL_DESCRP);
            int cantidad = resultSet.getInt(SchemaDB.COL_QTY);
            double precio = resultSet.getDouble(SchemaDB.COL_PRICE);

            Producto producto = new Producto(id, nombre, descripcion, cantidad, precio);
            producto.mostrarDatos();
        }

    }
    public void precioBajo() throws SQLException {
        connection = new DBConnection().getConnection();
        String query = String.format("SELECT * FROM %s WHERE %s < ?" ,
                SchemaDB.TAB_PROD, SchemaDB.COL_PRICE);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, 600);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(SchemaDB.COL_ID);
            String nombre = resultSet.getString(SchemaDB.COL_NAME);
            String descripcion = resultSet.getString(SchemaDB.COL_DESCRP);
            int cantidad = resultSet.getInt(SchemaDB.COL_QTY);
            double precio = resultSet.getDouble(SchemaDB.COL_PRICE);
            Producto producto = new Producto(id, nombre, descripcion, cantidad, precio);
            producto.mostrarDatos();
        }
    }
    public ArrayList<Producto> precioAlto() throws SQLException {
        ArrayList<Producto> precioAlto = new ArrayList<>();
        connection = new DBConnection().getConnection();
        String query = String.format("SELECT * FROM %s WHERE %s > ?" ,
                SchemaDB.TAB_PROD, SchemaDB.COL_PRICE);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, 1000);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(SchemaDB.COL_ID);
            String nombre = resultSet.getString(SchemaDB.COL_NAME);
            String descripcion = resultSet.getString(SchemaDB.COL_DESCRP);
            int cantidad = resultSet.getInt(SchemaDB.COL_QTY);
            double precio = resultSet.getDouble(SchemaDB.COL_PRICE);
            Producto producto = new Producto(id, nombre, descripcion, cantidad, precio);
            precioAlto.add(producto);
        }
            return precioAlto;
    }
}
