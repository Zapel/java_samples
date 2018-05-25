package TCP_IP;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.Properties;

public class EmailLessons {
    public static void main(String[] args) throws IOException {
        final Properties properties = new Properties();
        properties.load(EmailLessons.class.getClassLoader().getResourceAsStream("mail.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress());


    }
}
