package File;

import java.io.*;
import java.util.Scanner;

public class ScannerPrintWriterLesson {
    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(new FileReader("temp.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("temp.txt"))) {
            writer.write("str1");
            writer.write("\n");
            writer.write("str2");
        }

        //Scanner scanner1 = new Scanner(new FileInputStream("temp.txt"));
        //PrintWriter writer1 = new PrintWriter(new FileOutputStream("temp.txt"));
    }
}
