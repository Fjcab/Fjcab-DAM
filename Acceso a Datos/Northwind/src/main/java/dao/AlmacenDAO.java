package dao;

import database.DBConnection0;
import database.SchemaDB;

import java.sql.*;

public class AlmacenDAO {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public boolean existeBaseDeDatos() throws SQLException {
        connection = new DBConnection0().getConnection();
        String checkDBQuery ="SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = ?";
        preparedStatement = connection.prepareStatement(checkDBQuery);
        preparedStatement.setString(1, SchemaDB.DBNAME);
        resultSet = preparedStatement.executeQuery();

        boolean dbExists = resultSet.next();

        resultSet.close();
        preparedStatement.close();
        return dbExists;
    }

    public void CrearBD() throws SQLException {
        connection = new DBConnection0().getConnection();
        statement = connection.createStatement();

        String query = String.format("CREATE DATABASE IF NOT EXISTS %s", SchemaDB.DBNAME);
        statement.execute(query);

        query = String.format("USE %s", SchemaDB.DBNAME);
        statement.execute(query);

        query = String.format("CREATE TABLE IF NOT EXISTS %s (" +
                "%s INT PRIMARY KEY, " +
                "%s VARCHAR(100), " +
                "%s VARCHAR(255), " +
                "%s INT, " +
                "%s DECIMAL(10, 2))",
                SchemaDB.TAB_PROD, SchemaDB.COL_ID, SchemaDB.COL_NAME, SchemaDB.COL_DESCRP, SchemaDB.COL_QTY, SchemaDB.COL_PRICE);
        statement.execute(query);

        query = String.format("CREATE TABLE IF NOT EXISTS %s (" +
                "%s INT AUTO_INCREMENT PRIMARY KEY, " +
                "%s VARCHAR(50), " +
                "%s VARCHAR(100), " +
                "%s VARCHAR(100) UNIQUE KEY)",
                SchemaDB.TAB_EMP, SchemaDB.COL_ID, SchemaDB.COL_NAME, SchemaDB.COL_SURNM, SchemaDB.COL_MAIL);
        statement.execute(query);

        query = String.format("CREATE TABLE IF NOT EXISTS %s (" +
                "%s INT AUTO_INCREMENT PRIMARY KEY, " +
                "%s INT, " +
                "%s VARCHAR(255), " +
                "%s DECIMAL(10, 2), " +
                "FOREIGN KEY (%s) REFERENCES %s(%s))",
                SchemaDB.TAB_PED, SchemaDB.COL_ID, SchemaDB.COL_ID_PROD, SchemaDB.COL_DESCRP, SchemaDB.COL_T_PRICE,
                SchemaDB.COL_ID_PROD, SchemaDB.TAB_PROD, SchemaDB.COL_ID);
        statement.execute(query);

        query = String.format("CREATE TABLE IF NOT EXISTS %s (" +
                "%s INT AUTO_INCREMENT PRIMARY KEY, " +
                "%s INT UNIQUE KEY, " +
                "FOREIGN KEY (%s) REFERENCES %s(%s))",
                SchemaDB.TAB_PRODFAV, SchemaDB.COL_ID, SchemaDB.COL_ID_PROD,
                SchemaDB.COL_ID_PROD, SchemaDB.TAB_PROD, SchemaDB.COL_ID);
        statement.execute(query);
        statement.close();
        connection.close();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        ProductoFavDAO productoFavDAO = new ProductoFavDAO();
        System.out.println("Creando lista de Epleados:");
        empleadoDAO.registrarArchivo();
        System.out.println("Creando lista de Productos:");
        productoDAO.registrarArray();
        System.out.println("Creando lista de Pedidos:");
        pedidoDAO.registrarLista();
        System.out.println("Creando lista de Productos Favoritos:");
        productoFavDAO.registrarProductoFav();
    }
    public void ComprobaroCrearBD() throws SQLException {
        if(existeBaseDeDatos()){
            System.out.println("La base de datos ya existe.");
        }else{
            System.out.println("La base de datos no existe.");
            System.out.println("Creando la base...");
            CrearBD();
            System.out.println("Base de datos creada.");
        }
    }
}
