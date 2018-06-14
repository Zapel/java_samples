package MySql;

import java.sql.*;

public class ScrollableJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String userName = "root";
        String password = "root";
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS Books;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Books (" +
                    "id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                    "name CHAR(30) NOT NULL, " +
                    "PRIMARY KEY (id));");
            statement.executeUpdate("insert into Books (NAME) values ('Inferno')");
            statement.executeUpdate("insert into Books (NAME) values ('DaVinchi Code')");
            statement.executeUpdate("insert into Books set name = 'Solomon Key'");

            Statement statement1 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //PreparedStatement preparedStatement = connection.prepareStatement("", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement1.executeQuery("select * from Books");
            if (resultSet.next())
                System.out.println(resultSet.getString("name"));
            if (resultSet.next())
                System.out.println(resultSet.getString("name"));
            if (resultSet.previous())
                System.out.println(resultSet.getString("name"));
            if (resultSet.relative(2))
                System.out.println(resultSet.getString("name"));
            if (resultSet.relative(- 2))
                System.out.println(resultSet.getString("name"));
            if (resultSet.absolute(2))
                System.out.println(resultSet.getString("name"));
            if (resultSet.first())
                System.out.println(resultSet.getString("name"));
            if (resultSet.last())
                System.out.println(resultSet.getString("name"));
            //resultSet.beforeFirst();
            //resultSet.afterLast();
        }
    }
}
