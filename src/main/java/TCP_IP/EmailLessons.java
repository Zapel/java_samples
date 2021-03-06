package TCP_IP;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class EmailLessons {
    public static void main(String[] args) throws IOException, MessagingException {
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream ( Paths.get("mail","mail.properties"))) {
            props.load(in);
        }
        List<String> lines = Files.readAllLines (Paths.get(args[0]), Charset.forName ("UTF-8"));

        String from = lines.get (0);
        String to = lines.get (1);
        String subject = lines.get (2);

        StringBuilder builder = new StringBuilder ();
        for (int i = 3; i < lines.size (); i ++) {
            builder.append (lines.get (i));
            builder.append ("\n");
        }

        Console console = System.console ();
        String password = new String (console.readPassword ("Password: "));

        Session mailSession = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(builder.toString ());

        Transport tr = mailSession.getTransport();
        try {
            tr.connect(null, password);
            tr.sendMessage(message, message.getAllRecipients());
        } finally {
            tr.close();
        }
    }
}
