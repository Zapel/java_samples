package File;

import org.omg.CORBA.portable.InputStream;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("temp.txt");
        /*
        int i = 0;
        while ((i = reader.read()) != -1) {
            System.out.println((char) i);
        }
        */

        /*
        char[] chars = new char[50];

        while (reader.read(chars) != -1) {
            System.out.println(chars);
        }

        System.out.println();

        while (reader.read(chars) != -1) {
            for(int i = 0; i < chars.length; i ++) {
                if(Character.isAlphabetic(chars[i]) || Character.isWhitespace(chars[i])) {
                    System.out.println(chars);
                }
            }
        }

        System.out.println();


        BufferedReader bufferedReader = new BufferedReader(new FileReader("temp.txt"));

        while (bufferedReader.read() != -1) {
            System.out.println(bufferedReader.readLine());
        }
        */

        Writer writer = new FileWriter("temp.txt" );

        writer.write("str1\n");
        writer.write("str2\n");
        writer.write("str3\n");
        writer.write("str4\n");
        writer.write("str5\n");
        //writer.flush();
        writer.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("temp1.txt"));

        bufferedWriter.write("str1");
        bufferedWriter.newLine();
        bufferedWriter.write("str2");
        bufferedWriter.newLine();
        bufferedWriter.write("str3");
        bufferedWriter.close();


        InputStream inputStream;
        OutputStream outputStream;
    }
}
