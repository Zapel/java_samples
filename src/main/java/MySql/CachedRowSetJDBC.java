package MySql;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class CachedRowSetJDBC {
    static String userName = "root";
    static String password = "root";
    static String url = "jdbc:mysql://localhost:3306/test";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = getData();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
        }

        CachedRowSet cachedRowSet = (CachedRowSet) resultSet;
        cachedRowSet.setUrl(url);
        cachedRowSet.setUsername(userName);
        cachedRowSet.setPassword(password);

        /*
        cachedRowSet.setCommand("select * from Books where id =?");
        cachedRowSet.setInt(1, 1);
        cachedRowSet.setPageSize(20);
        cachedRowSet.execute();
        do {
            while (cachedRowSet.next()) {
                System.out.println(cachedRowSet.getInt("id"));
                System.out.println(cachedRowSet.getString("name"));
            }
        } while (cachedRowSet.nextPage());
        */

        CachedRowSet cachedRowSet2 = (CachedRowSet) resultSet;
        cachedRowSet2.setTableName("Books");
        cachedRowSet2.absolute(1);
        cachedRowSet2.deleteRow();
        cachedRowSet2.beforeFirst();
        while (cachedRowSet2.next()) {
            System.out.println(cachedRowSet2.getInt("id"));
            System.out.println(cachedRowSet2.getString("name"));
        }

        cachedRowSet2.acceptChanges(DriverManager.getConnection(url, userName, password));
        //cachedRowSet2.setUrl(url);
        //cachedRowSet2.setUsername(userName);
        //cachedRowSet2.setPassword(password);
        //cachedRowSet2.acceptChanges();
    }

    static ResultSet getData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(url, userName, password);
            Statement stat = connection.createStatement()) {
            stat.executeUpdate("DROP TABLE IF EXISTS Books;");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Books (" +
                    "id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                    "name CHAR(30) NOT NULL, " +
                    "PRIMARY KEY (id));");

            stat.executeUpdate("insert into Books (NAME) values ('Inferno')");
            stat.executeUpdate("insert into Books (NAME) values ('DaVinchi Code')");
            stat.executeUpdate("insert into Books set name = 'Solomon Key'");

            //CachedRowSet cachedRowSet = new CachedRowSetImpl();
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = factory.createCachedRowSet();

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("select * from Books");
            cachedRowSet.populate(resultSet);
            return cachedRowSet;
        }
    }
}
