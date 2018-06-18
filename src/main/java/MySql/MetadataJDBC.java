package MySql;

        import java.sql.*;

        import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;

public class MetadataJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String userName = "root";
        String password = "root";
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement stat = connection.createStatement()) {
            stat.executeUpdate("DROP TABLE IF EXISTS Books;");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Books (" +
                    "id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                    "name CHAR(30) NOT NULL, " +
                    "PRIMARY KEY (id));");

            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[] {"Table"});
            while (resultSet.next()) {
                //System.out.println(resultSet.getString(1));
                //System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                //System.out.println(resultSet.getString(4));
            }

            System.out.println("---------------------");

            ResultSet resultSet1 = stat.executeQuery("select * from Books");
            ResultSetMetaData resultSetMetaData = resultSet1.getMetaData();
            for (int i = 1; i <= resultSetMetaData.getColumnCount() ; i++) {
                System.out.println(resultSetMetaData.getColumnLabel(i));
                System.out.println(resultSetMetaData.getColumnType(i));
            }
        }
    }
}
