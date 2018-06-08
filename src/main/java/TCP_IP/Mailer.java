package TCP_IP;

import javax.mail.Session;
import java.util.Properties;

public class Mailer {
    public static void main(String[] args) {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", 465);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", 465);

        Session session = Session.getDefaultInstance(props);
    }
}
