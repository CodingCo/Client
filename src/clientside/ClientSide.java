package clientside;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Awesomeness
 */
public class ClientSide implements SocketListener {

    // --
    private String userName;
    // --
    private SocketIF con;
    private ArrayList<ViewListener> observers;
    private boolean connected;

    public ClientSide() {
        this.con = new SocketClass();
        this.observers = new ArrayList<>();
        setConnected(false);
    }

    //Methods
    public void connect(String msg, String name) {
        try {
            con.connect();
            sendMessage(msg);
            this.userName = name;
        } catch (IOException ex) {
        }
    }

    public void sendMessage(String msg) {
        con.send(msg);
    }

    public void analyzeServerCommands(String cmd) {

        if (cmd.equals("CLOSE#")) {
            setConnected(false);
            closeConnection();
        } else if (cmd.startsWith("ONLINE#")) {
            setConnected(true);
            notifyObservers(cmd);
        } else if (cmd.startsWith("MESSAGE#")) {
            notifyObservers(cmd);
        }

    }

    public void closeConnection() {
        try {
            con.close();
            notifyObservers("Connection closed.");
        } catch (IOException ex) {
        }
    }

    public boolean isConnected() {
        return connected;
    }

    private void setConnected(boolean status) {
        connected = status;
    }

    // Observer pattern solutions
    public void registerObserver(ViewListener obs) {
        observers.add(obs);
    }

    public void unRegisterObserver(ViewListener obs) {
        observers.remove(obs);
    }

    public void notifyObservers(String msg) {
        for (ViewListener obs : observers) {
            obs.messageArrived(msg); // <- String
        }
    }

    @Override
    public void messageArrived(String data) {
        analyzeServerCommands(data);
    }
    
    // A test
    public static void main(String[] args) throws InterruptedException {
        ClientSide con = new ClientSide();
        con.connect("", "");
        Thread.sleep(1500);
        System.out.println("Sending message");
        con.sendMessage("Client test message");
    }

}
