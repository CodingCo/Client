package clientSideTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ThomasHedegaard
 */
public class TestServer {

    private static boolean keepRunning = true;

    // Constructor
    public TestServer() {

    }

    // Main
    public static void main(String[] args) {
        try {
            ServerSocket listen = new ServerSocket(57807, 10, InetAddress.getLoopbackAddress());
            System.out.println("Server started on: " + listen.getInetAddress() + "\n"
                    + "Listening on port: " + listen.getLocalPort());

            while (keepRunning) {
                System.out.println("\n\nWaiting for client!");
                Socket client = listen.accept();
                System.out.println("Client connected!");
                new Thread(new clientHandler(client)).start();

            }
        } catch (IOException e) {
        }
    }

    // ClientHandler
    private static class clientHandler implements Runnable {

        private Socket client;

        // Constrcutor
        public clientHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                while (true) {
                    String response = in.readLine();
                    System.out.println("Message from client: " + response);
                    Thread.sleep(4000);
                    out.println("ONLINE#Lars,Ole,Peter");
                }

            } catch (IOException | InterruptedException e) {
            }
        }

    }

}
