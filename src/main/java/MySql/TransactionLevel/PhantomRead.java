package MySql.TransactionLevel;

import java.sql.*;

public class PhantomRead {
    static String userName = "root";
    static String password = "root";
    static String connectionUrl = "jdbc:mysql://localhost:3306/test";

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection conn = DriverManager.getConnection(connectionUrl, userName, password)) {
            Statement stat = conn.createStatement();
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            //conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            ResultSet resultSet = stat.executeQuery("select count(*) from Books");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }

            new OtherTransactions().start();
            Thread.sleep(2000);

            ResultSet resultSet2 = stat.executeQuery("select count(*) from Books");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getInt(1));
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
                stat.executeUpdate("insert into Books (NAME) values ('zapel')");
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
