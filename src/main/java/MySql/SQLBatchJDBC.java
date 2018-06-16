package MySql;

import java.sql.*;

public class SQLBatchJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String userName = "root";
        String password = "root";
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement stat = connection.createStatement()) {
            connection.setAutoCommit(false);

            stat.addBatch("DROP TABLE IF EXISTS Books;");
            stat.addBatch("CREATE TABLE IF NOT EXISTS Books (" +
                    "id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                    "name CHAR(30) NOT NULL, " +
                    "PRIMARY KEY (id));");

            stat.addBatch("insert into Books (NAME) values ('Inferno')");
            stat.addBatch("insert into Books (NAME) values ('DaVinchi Code')");
            stat.addBatch("insert into Books set name = 'Solomon Key'");

            if (stat.executeBatch().length == 5) {
                connection.commit();
            } else {
                connection.rollback();
            }
        }
    }
}
