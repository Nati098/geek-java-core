package advanced.hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static final int PORT = 8000;
    public static final String END_KEYWORD = "/exit";

    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");
            socket = serverSocket.accept();
            System.out.println("Connected client from " + socket.getRemoteSocketAddress());
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
                if (str.equals(END_KEYWORD)) {
                    dos.writeUTF(END_KEYWORD);
                    break;
                }
                else {
                    System.out.println("Client: " + str);
                }
            }

        }
        catch (IOException e) {
            System.out.println("Server cannot run");
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Socket is null");
                e.printStackTrace();
            }
        }

    }

}
