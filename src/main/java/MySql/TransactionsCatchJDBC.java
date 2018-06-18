package MySql;

import java.sql.*;

public class TransactionsCatchJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String userName = "root";
        String password = "root";
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement stat = connection.createStatement();
            connection.setAutoCommit(false);

            stat.executeUpdate("DROP TABLE IF EXISTS Books;");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Books (" +
                    "id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                    "name CHAR(30) NOT NULL, " +
                    "PRIMARY KEY (id));");

            stat.executeUpdate("insert into Books (NAME) values ('Inferno')");
            stat.executeUpdate("insert into Books (NAME) values ('DaVinchi Code')");
            stat.executeUpdate("insert into Books set name = 'Solomon Key'");

            connection.commit();

        } catch (SQLException exp) {
            connection.rollback();
        }
    }
}
