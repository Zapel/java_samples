package TCP_IP.HerbSchildt;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UCDemo {
    public static void main(String[] args) throws IOException {
        int c;
        URL hp = new URL("http://ukr.net");
        URLConnection hpCon = hp.openConnection();

        long d = hpCon.getDate();
        if(d == 0) {
            System.out.println("Сведения о дате отсутствуют.");
        }

        long len = hpCon.getContentLengthLong();
        if (len == -1) {
            System.out.println("Длина содержимого не доступна.");
        } else {
            System.out.println("Длина содержимого: " + len);
        }
        if (len != 0) {
            System.out.println("=== Содержимое ===");
            InputStream input = hpCon.getInputStream();
            while ((c =input.read()) != -1) {
                System.out.print((char) c);
            }
            input.close();
        } else {
            System.out.println("Содержимое не доступно.");
        }

    }

}
