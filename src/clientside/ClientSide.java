package clientside;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ThomasHedegaard
 */
public class ClientSide implements SocketListener {

    // --
    private String userName;
    // --
    private SocketIF con;
    private ArrayList<ViewListener> observers;
    private boolean connected;
    private int connectionAttemps;

    public ClientSide() {
        this.con = new SocketClass();
        this.observers = new ArrayList<>();
        this.connectionAttemps = 0;
        setConnected(false);
        con.registerListeners(this);
    }

    //Methods
    public void connect(String msg, String name) {
        try {
            con.connect();
            sendMessage(msg);
            setConnected(true);
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

            if (connectionAttemps == 0) {
                notifyObservers("You are now connected!");
                ++connectionAttemps;
            }

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
            setConnected(false);
            connectionAttemps = 0;
        } catch (IOException ex) {
        }
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean status) {
        connected = status;
    }
    
    public String getUserName(){
        return this.userName;
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
            obs.messageArrived(msg); 
        }
    }

    @Override
    public void messageArrived(String data) {
        analyzeServerCommands(data);
    }

}
