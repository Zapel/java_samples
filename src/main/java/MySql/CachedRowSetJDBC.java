package MySql;

import java.sql.*;

public class CachedRowSetJDBC {
    static String userName = "root";
    static String password = "root";
    static String connectionUrl = "jdbc:mysql://localhost:3306/test";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = getData();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
        }
    }

    static ResultSet getData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement stat = connection.createStatement()) {
            stat.executeUpdate("DROP TABLE IF EXISTS Books;");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Books (" +
                    "id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                    "name CHAR(30) NOT NULL, " +
                    "PRIMARY KEY (id));");

            stat.executeUpdate("insert into Books (NAME) values ('Inferno')");
            stat.executeUpdate("insert into Books (NAME) values ('DaVinchi Code')");
            stat.executeUpdate("insert into Books set name = 'Solomon Key'");

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("select * from Books");
            return resultSet;
        }
    }
}
