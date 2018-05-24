package TCP_IP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(8189)) {
            Socket socket = serverSocket.accept();
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            //printWriter.println("Hello");

            while (scanner.hasNextLine()) {
                String str =scanner.nextLine();
                printWriter.println("you have sent: " + str);
                System.out.println(str);
                if(str.equals("exit")) {
                    break;
                }
            }
        }
    }
}
