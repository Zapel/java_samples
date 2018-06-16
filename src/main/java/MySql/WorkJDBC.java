package MySql;

import java.sql.*;

public class WorkJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String userName = "root";
        String password = "root";
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement()) {
            //statement.executeUpdate("DROP TABLE booksnew;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Books (" +
                    "id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                    "name CHAR(30) NOT NULL, " +
                    "PRIMARY KEY (id));");
            statement.executeUpdate("INSERT INTO Books (NAME) VALUES ('Inferno')");
            statement.executeUpdate("insert into Books set name = 'Solomon Key'");
            ResultSet resultSet1 = statement.executeQuery("select * from Books");
            while (resultSet1.next()) {
                System.out.println(resultSet1.getInt(1));
                System.out.println(resultSet1.getString(2));
                System.out.println("--------------------");

                System.out.println();

                System.out.println(resultSet1.getInt("id"));
                System.out.println(resultSet1.getString("name"));
                System.out.println("********************");
            }

            System.out.println("_____________________");

            ResultSet resultSet2 = statement.executeQuery("select name from Books where id = 1");
            System.out.println(resultSet2);
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString(1));
            }
        }
    }
}
