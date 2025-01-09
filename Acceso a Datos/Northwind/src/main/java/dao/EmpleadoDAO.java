package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Empleado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class EmpleadoDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    public boolean registrarEmpleado(Empleado empleado) throws SQLException {
        connection = new DBConnection().getConnection();

        String query = String.format("INSERT INTO %s (%s,%s,%s) VALUE (?,?,?)",
                SchemaDB.TAB_EMP, SchemaDB.COL_NAME, SchemaDB.COL_SURNM, SchemaDB.COL_MAIL);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, empleado.getNombre());
        preparedStatement.setString(2, empleado.getApellidos());
        preparedStatement.setString(3, empleado.getCorreo());
        int filasAfectadas = preparedStatement.executeUpdate();
        return filasAfectadas > 0;
    }

    public void registrarArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/lista_empleados.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] empleadoLista = linea.split(",");
                if (empleadoLista.length == 3) {
                    String nombre = empleadoLista[0].trim();
                    String apellidos = empleadoLista[1].trim();
                    String correo = empleadoLista[2].trim();
                    Empleado empleado = new Empleado(nombre, apellidos, correo);

                    boolean registrado = registrarEmpleado(empleado);
                    if (registrado) {
                        System.out.println("Empleado registrado: " + nombre + " " + apellidos);
                    } else {
                        System.out.println("No se pudo registrar el empleado: " + nombre + " " + apellidos);
                    }
                } else {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al registrar el empleado: " + e.getMessage());
        }
    }

    public void tablaEmpleados() throws SQLException {
        connection = new DBConnection().getConnection();
        statement = connection.createStatement();
        String query = String.format("SELECT * FROM %s", SchemaDB.TAB_EMP);
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {

            int id = resultSet.getInt(SchemaDB.COL_ID);
            String nombre = resultSet.getString(SchemaDB.COL_NAME);
            String apellidos = resultSet.getString(SchemaDB.COL_SURNM);
            String correo = resultSet.getString(SchemaDB.COL_MAIL);

            Empleado empleado = new Empleado(id, nombre, apellidos, correo);
            empleado.mostrarDatos();
        }
    }
}
