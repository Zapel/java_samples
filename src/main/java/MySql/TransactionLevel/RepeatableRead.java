package MySql.TransactionLevel;

import java.sql.*;

public class RepeatableRead {
    static String userName = "root";
    static String password = "root";
    static String connectionUrl = "jdbc:mysql://localhost:3306/test";

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection conn = DriverManager.getConnection(connectionUrl, userName, password)) {
            Statement stat = conn.createStatement();
            conn.setAutoCommit(false);
            //conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            ResultSet resultSet = stat.executeQuery("select * from Books");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            new OtherTransactions().start();
            Thread.sleep(2000);

            ResultSet resultSet2 = stat.executeQuery("select * from Books");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("name"));
            }
        }
    }

    static class OtherTransactions extends Thread {
        @Override
        public void run() {
            try(Connection conn = DriverManager.getConnection(connectionUrl, userName, password)) {
                Statement stat = conn.createStatement();
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                //conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
                stat.executeUpdate("update Books set name = 'new Value' where id =1");
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
