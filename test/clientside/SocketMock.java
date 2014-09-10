package clientside;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Awesomeness
 */
public class SocketMock implements SocketIF {

    private ClientMehTest test;
    
    public SocketMock(){
        this.test = new ClientMehTest();
    }
    
    // Methods
    @Override
    public void send(String data) {
    }

    @Override
    public void connect() throws IOException {
        test.setStatus(1);
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public void registerListeners(SocketListener listener) {
    }

    @Override
    public void unRegisterListeners(SocketListener listener) {
    }

    @Override
    public void notifyListeners(String data) {
    }

    // A static class that sets up a local server for tests only
    private static class testServer implements Runnable {

        @Override
        public void run() {
            try {
                ServerSocket listen = new ServerSocket();

            } catch (IOException ex) {
            }

        }

    }

}
