package TCP_IP;

import java.io.IOException;
import java.util.Properties;

public class MainEmail {
    public static void main(String[] args) throws IOException {
        final Properties properties = new Properties();
        properties.load(EmailLessons.class.getClassLoader().getResourceAsStream("mail.properties"));



    }
}
