package TCP_IP;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailSend {
    public static void main(String[] args) {
        try {
            String host = "smtp.gmail.com";
            String user = "lazebaoleg@gmail.com";
            String pass = "zapel1706";
            String to = "zapel176@ukr.net";
            String from = "lazebaoleg@gmail.com";
            String subject = "Mail Test!";
            String messageText = "Your Is Test Email: ";
            boolean sessionDebug = false;

            //Properties props = System.getProperties();
            Properties props = new Properties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttis.required", "true");

            //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
