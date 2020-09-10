package advanced.hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    private static final String SERVER_ADDRESS = "localhost";

    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            socket = new Socket(SERVER_ADDRESS, Server.PORT);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            Thread readingThread = new Thread(() -> {
                try {
                    while (true) {
                        dos.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            readingThread.setDaemon(true);
            readingThread.start();

            while (true) {
                String str = dis.readUTF();

                if (str.equals(Server.END_KEYWORD)) {
                    System.out.println("Exit");
                    dos.writeUTF(Server.END_KEYWORD);
                    break;
                }
                else {
                    System.out.println("Server: " + str);
                }
            }


        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
