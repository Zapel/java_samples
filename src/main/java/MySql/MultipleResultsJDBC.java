package MySql;

import java.sql.*;

public class MultipleResultsJDBC {
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
                    "PRIMARY KEY (id));");
            statement.executeUpdate("insert into Books (NAME) values ('Inferno')");
            statement.executeUpdate("insert into Books set name = 'Solomon Key'");

            CallableStatement callableStatement = connection.prepareCall("{call getCount()}");
            boolean hasResults = callableStatement.execute();
            while (hasResults) {
                ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1));
                }
                hasResults = callableStatement.getMoreResults();
            }
        }
    }
}
