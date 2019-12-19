package framework.sqlconnection;

import framework.utiles.JsonConfigReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseConnection {
    private static DataBaseConnection instance;
    private static Connection connection;
    private static String url = JsonConfigReader.getJsonParameterValue("url");
    private static String username = JsonConfigReader.getJsonParameterValue("username");
    private static String password = JsonConfigReader.getJsonParameterValue("password");

    private DataBaseConnection() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public static DataBaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DataBaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DataBaseConnection();
        }

        return instance;
    }

    public static ResultSet getAnswer(String query) {
        try {
            return getInstance().getConnection().createStatement().executeQuery(query);
        } catch (SQLException e) {
            return null;
        }
    }
}
