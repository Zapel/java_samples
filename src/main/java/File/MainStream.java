package File;

import java.io.*;

public class MainStream {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("temp.txt");
        /*
        int j = 0;
        while ((j = inputStream.read()) != -1) {
            System.out.println(j);
        }
        */

        byte[] bytes = new byte[inputStream.available()];
        while (inputStream.read(bytes) != -1) {
            for (int i = 0; i < bytes.length; i++) {
                //if(bytes[i] == 0) {
                //    break;
                //}
                System.out.println(bytes[i]);
            }
        }

        System.out.println();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("temp1.txt"));

        byte[] bufBytes = new byte[bufferedInputStream.available()];
        while (bufferedInputStream.read(bufBytes) != -1) {
            for (int i = 0; i < bufBytes.length; i++) {
                System.out.println(bufBytes[i]);
            }
        }

        try (OutputStream outputStream = new FileOutputStream("temp.txt")) {
            outputStream.write(49);
            outputStream.write(10);
            outputStream.write(50);
        }
    }
}
