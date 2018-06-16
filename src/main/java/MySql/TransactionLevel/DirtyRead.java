package MySql.TransactionLevel;

import java.sql.*;


public class DirtyRead {
    static String userName = "root";
    static String password = "root";
    static String connectionUrl = "jdbc:mysql://localhost:3306/test";

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection conn = DriverManager.getConnection(connectionUrl, userName, password)) {
            Statement stat = conn.createStatement();
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            //conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            stat.execute("update Books set name = 'new Value' where id = 1");
            new OtherTransactions().start();
            Thread.sleep(2000);
            conn.rollback();
        }
    }

    static class OtherTransactions extends Thread {
        @Override
        public void run() {
            try(Connection conn = DriverManager.getConnection(connectionUrl, userName, password)) {
                Statement stat = conn.createStatement();
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                //conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                ResultSet resultSet = stat.executeQuery("select * from Books");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
