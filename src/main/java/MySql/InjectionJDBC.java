package MySql;

import java.sql.*;

public class InjectionJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String userName = "root";
        String password = "root";
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement()) {
            //statement.executeUpdate("DROP TABLE Users;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Users (" +
                    "id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                    "name CHAR(30) NOT NULL, " +
                    "password CHAR(30) NOT NULL, " +
                    "PRIMARY KEY (id));");
            //statement.executeUpdate("insert into Users (name, password) values ('Zapel', '170678')");
            //statement.executeUpdate("insert into Users set name = 'Oleg', password = 'fisher1706'");

            //String userId = "1";
            String userId = "1' or 1 = '1";

            //ResultSet resultSet = statement.executeQuery("select * from Users where id = '" + userId + "'");
            //while (resultSet.next()) {
                //System.out.println("userName: " + resultSet.getString("name"));
                //System.out.println("userPassword: " + resultSet.getString("password"));
            //}
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Users where id = ?");
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("userName: " + resultSet.getString("name"));
                System.out.println("userPassword: " + resultSet.getString("password"));
            }
        }
    }
}
