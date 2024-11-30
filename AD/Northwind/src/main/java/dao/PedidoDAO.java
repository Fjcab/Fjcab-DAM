package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Pedido;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class PedidoDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    public boolean registrarPedido(Pedido pedido) throws SQLException {
        connection = new DBConnection().getConnection();

        String query = String.format("INSERT INTO %s (%s,%s,%s) VALUE (?,?,?)",
                SchemaDB.TAB_PED, SchemaDB.COL_ID_PROD, SchemaDB.COL_DESCRP, SchemaDB.COL_T_PRICE);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, pedido.getIdProducto());
        preparedStatement.setString(2, pedido.getDescripcion());
        preparedStatement.setDouble(3, pedido.getPrecioTotal());
        int filasAfectadas = preparedStatement.executeUpdate();
        return filasAfectadas > 0;
    }
    public void registrarLista() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/lista_pedidos.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] pedidoLista = linea.split(",");
                if (pedidoLista.length == 3) {
                    int idProducto = Integer.parseInt(pedidoLista[0].trim());
                    String descripcion = pedidoLista[1].trim();
                    double precioTotal = Double.parseDouble(pedidoLista[2].trim());
                    Pedido pedido = new Pedido(idProducto, descripcion, precioTotal);

                    boolean registrado = registrarPedido(pedido);
                    if (registrado) {
                        System.out.println("pedido registrado: " + descripcion);
                    } else {
                        System.out.println("No se pudo registrar el empleado: " + descripcion);
                    }
                } else {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al registrar el pedido: " + e.getMessage());
        }
    }

    public void tablaPedidos() throws SQLException {
        connection = new DBConnection().getConnection();
        statement = connection.createStatement();
        String query = String.format("SELECT * FROM %s", SchemaDB.TAB_PED);
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {

            int id = resultSet.getInt(SchemaDB.COL_ID);
            int idProducto = resultSet.getInt(SchemaDB.COL_ID_PROD);
            String descripcion = resultSet.getString(SchemaDB.COL_DESCRP);
            double precioTotal = resultSet.getDouble(SchemaDB.COL_T_PRICE);

            Pedido pedido = new Pedido(id, idProducto, descripcion, precioTotal);
            pedido.mostrarDatos();
        }
    }
}


