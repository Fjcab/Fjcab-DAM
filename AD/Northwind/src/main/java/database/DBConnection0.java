package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection0 {
    private static Connection connection;
    private void createConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%s/", SchemaDB.HOST, SchemaDB.PORT);
        connection = DriverManager.getConnection(url,"root","");
    }
    public Connection getConnection() throws SQLException {
        if(connection == null){
            createConnection();
        }
        return connection;
    }
    public void closeConnection(){
        try {
            connection.close();
            connection=null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
