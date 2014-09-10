package clientside;

import java.util.ArrayList;

/**
 *
 * @author simon
 */
public class ClientSide implements Runnable {

    private ArrayList<IFlistener> observers;

    // Constructor
    public ClientSide() {
        this.observers = new ArrayList();
    }

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
