package TCP_IP;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.Properties;

public class Mailer {
    public static void main(String[] args) {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.ukr.net");
        props.put("mail.smtp.socketFactory.port", 63449);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", 63449);

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator (){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication ("zapel176@ukr.net", "170678" );
            }
        });

        try {
            Message message = new MimeMessage (session);
            message.setFrom (new InternetAddress ("zapel176@ukr.net"));
            message.setRecipients( Message.RecipientType.TO, InternetAddress.parse ("zapel1706@ukr.net"));
            message.setSubject ("Тестовое письмо");
            message.setText ("Проверка качества отправки пиьма");

            Transport.send (message);

            JOptionPane.showMessageDialog (null, "Письмо успешно отправленно.");

        } catch (Exception exp) {
            JOptionPane.showMessageDialog (null, "Что-то пошло не так. " + exp);
        }
    }
}
