package connection;

import java.sql.*;

public class conn {
    static Connection connection = null;

    public static Connection getConnection()
    {
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sys",
                    "root", "123456");

            return connection;


        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        return connection;
    }

    public void executeUpdate(String q) {
    }

    public ResultSet executeQuery(String s1) {
        return null;
    }
} // class ends
