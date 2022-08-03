package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ApplicationConnection {
    private static Connection connection;
    static {
        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/test",
                            "postgres",
                            "22799");
//System.out.println("connected.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}







