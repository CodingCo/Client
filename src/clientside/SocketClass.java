package clientside;

import Utility.Utility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.*;

/**
 *
 * @author Awesomeness
 */
public class SocketClass implements Runnable, SocketIF {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<SocketListener> listeners;
    private boolean keepListening;
    private final String ipAddress;
    private final int port;
    private Properties property = Utility.initProperties("serverproperties.txt");

    // Constructor
    public SocketClass() {
        this.listeners = new ArrayList();
        ipAddress = property.getProperty("ipaddress");
        port = Integer.parseInt(property.getProperty("port"));
    }

    // Methods
    private void openResources() throws IOException {
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    private void closeResources() throws IOException {
        this.in.close();
        this.out.close();
    }

    @Override
    public void connect() throws IOException {
        this.socket = new Socket(ipAddress, port);
        System.out.println("Connecting to: " + socket.getRemoteSocketAddress()); // Temp
        openResources();
        keepListening = true;
        new Thread(this).start();
    }

    @Override
    public void send(String data) {
        System.out.println("Message to server: " + data);
        out.println(data);
    }

    @Override
    public void close() throws IOException {
        socket.close();
        closeResources();
        keepListening = false;
    }

    @Override
    public void notifyListeners(String data) {
        System.out.println("How many listeners in socketclass: " + listeners.size()); // Temp
        for (SocketListener listener : listeners) {
            listener.messageArrived(data);
        }
    }

    @Override
    public void registerListeners(SocketListener listener) {
        listeners.add(listener);
    }

    @Override
    public void unRegisterListeners(SocketListener listener) {
        listeners.remove(listener);
    }

    // Listens for input
    @Override
    public void run() {
        String response = "";

        try {
            while (keepListening) {
                System.out.println("I'm in the listening thread.");
                response = in.readLine();
                System.out.println("Message from server : " + response); // Temp
                notifyListeners(response);
            }
        } catch (IOException e) {
        }

    }

}
