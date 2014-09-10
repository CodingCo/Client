package clientside;

import java.io.IOException;

/**
 *
 * @author Awesomeness
 */
public interface SocketIF {

    public void send(String data);

    public void connect() throws IOException;

    public void close() throws IOException;
    
    public void registerListeners(SocketListener listener);

    public void unRegisterListeners(SocketListener listener);

    public void notifyListeners(String data);
    
}
