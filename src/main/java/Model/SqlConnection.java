package Model;
import java.sql.*;

public class SqlConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=KantineDB;encrypt=false;";
    private static final String USER = "sa";
    private static final String PASS = "1234";

    private static Connection connection;

    private SqlConnection() {
        // Forhindrer instantiation fra andre klasser
    }

    public static Connection getConnection() throws Exception {
        if (connection == null || connection.isClosed()) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        }
        return connection;
    }
}
