package MySql;

import java.sql.*;

public class UpdateResultSetJDBC {
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

            Statement stat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //PreparedStatement preparedStatement = connection.prepareStatement("sql", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = stat.executeQuery("select * from Books");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }

            System.out.println("----------------------");

            resultSet.last();
            resultSet.updateString("name", "new Value");
            resultSet.updateRow();

            resultSet.moveToInsertRow();
            resultSet.updateString("name", "inserted row");
            resultSet.insertRow();

            resultSet.absolute(2);
            resultSet.deleteRow();

            resultSet.beforeFirst();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }
        }
    }
}
