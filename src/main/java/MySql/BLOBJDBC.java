package MySql;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class BLOBJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        String userName = "root";
        String password = "root";
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE Books");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Books (" +
                    "id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                    "name CHAR(30) NOT NULL, " +
                    "img BLOB," +
                    "PRIMARY KEY (id));");

            BufferedImage imageIn = ImageIO.read(new File("smile.jpg"));
            Blob blob = connection.createBlob();
            try (OutputStream outputStream = blob.setBinaryStream(1)) {
                ImageIO.write(imageIn, "jpg", outputStream);
            }

            PreparedStatement stat = connection.prepareStatement("insert into Books (name, img) values (?, ?)");
            stat.setString(1, "Smile");
            stat.setBlob(2, blob);
            stat.execute();

            ResultSet resultSet = statement.executeQuery("select * from Books");
            while (resultSet.next()) {
                BufferedImage imageOut = ImageIO.read(blob.getBinaryStream());
                File outputFile = new File("smileOut.png");
                ImageIO.write(imageOut, "png", outputFile);
            }
        }
    }
}
