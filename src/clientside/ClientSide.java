package clientside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author simon
 */
public class ClientSide implements Runnable {

    private Socket clientSocket;
    private ArrayList<IFlistener> observers;
    private BufferedReader in;
    private PrintWriter out;
    private String userName;
    private int connectionAttempts;
    private boolean listen;
    private boolean connected;

    // Constructor
    public ClientSide() {
        this.observers = new ArrayList<>();
        this.connectionAttempts = 0;
        this.listen = true;
        this.connected = false;
    }

    // Methods
    public void openStreams() throws IOException {              // Opens the input and output streams (opens tunnel)
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.out = new PrintWriter(clientSocket.getOutputStream(), true); // true -> autoFlush
    }

    public void closeStreams() throws IOException {
        this.in.close();
        this.out.close();
    }

    public void connect(String msg, String name) {              // Connects to the server
        try {
            this.userName = name;
            this.clientSocket = new Socket(InetAddress.getLocalHost(), 9090);
            openStreams();
            sendMessage(msg);
            new Thread(new ClientSide()).start();
        } catch (IOException e) {
        }

    }

    public void sendMessage(String msg) {                       // Sends message to server
        out.print(msg);
    }

    public void closeConnection() {
        try {
            closeStreams();
            clientSocket.close();
            listen = false;
            connectionAttempts = 0;
            notifyObservers("Connection closed");
        } catch (IOException ex) {
        }
    }

    public void analyzeServerCommands(String cmd) {
        if (cmd.equals("CLOSE#") && connectionAttempts == 0) {
            closeConnection();
            notifyObservers("Conenction rejected");
        } else if (cmd.equals("CLOSE#")) {
            closeConnection();
            connected = false;
            connectionAttempts = 0;
            notifyObservers("Connection closed");
        } else if (cmd.startsWith("ONLINE#") && connectionAttempts == 0) {
            connected = true;
            ++connectionAttempts;
            notifyObservers(cmd);
        } else if (cmd.startsWith("ONLINE#")) {
            notifyObservers(cmd);
        } else if (cmd.startsWith("MESSAGE#")) {
            notifyObservers(cmd);
        }
    }

    // Observer pattern solutions
    public void registerObserver(IFlistener obs) {
        observers.add(obs);
    }

    public void unRegisterObserver(IFlistener obs) {
        observers.remove(obs);
    }

    public void notifyObservers(String msg) {
        for (IFlistener obs : observers) {
            obs.messageArrived(msg); // <- String
        }
    }

    public boolean isConnected() {
        return connected;
    }

    // Thread method --> Listens for input from server!
    @Override
    public void run() {
        String response;

        try {
            while (listen) {
                response = in.readLine();                       // Blocking call
                analyzeServerCommands(response);
            }
        } catch (IOException e) {
        }

    }

}
