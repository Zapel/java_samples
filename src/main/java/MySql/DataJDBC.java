package MySql;

import java.sql.*;

public class DataJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String userName = "root";
        String password = "root";
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE Books;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Books (" +
                    "id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                    "name CHAR(30) NOT NULL, " +
                    "dt DATE , " +
                    "PRIMARY KEY (id));");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into Books (name, dt) values ('someName', ?)");
            preparedStatement.setDate(1, new Date(1528944640388L));
            preparedStatement.execute();

            System.out.println(preparedStatement);

            statement.executeUpdate("insert into Books (name, dt) values ('someName', '2018-06-14')");

            ResultSet resultSet = statement.executeQuery("select  * from Books");
            while (resultSet.next()) {
                System.out.println(resultSet.getDate("dt"));
            }
        }
    }
}
