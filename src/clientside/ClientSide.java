package clientside;

import java.io.BufferedReader;
import java.io.PrintWriter;
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

    // Constructor
    public ClientSide() {
        this.observers = new ArrayList();
    }

    // Methods
    public void openStreams() {                     // Opens the input and output streams
    }

    public void connect(String name) {              // Connects to the server
        this.userName = name;
    }

    public void sendMessage(String msg) {           // Sends message to server

    }

    public void closeConnection() {                 // Closes the connection   

    }

    // Observer solutions
    public void registerObserver(IFlistener obs) {
        observers.add(obs);
    }

    public void unRegisterObserver(IFlistener obs) {
        observers.remove(obs);
    }

    public void notifyObservers() {
        String temp = "";
        for (IFlistener obs : observers) {
            obs.messageArrived(temp); // <- String
        }
    }

    // Thread method
    @Override
    public void run() {
    }

}
