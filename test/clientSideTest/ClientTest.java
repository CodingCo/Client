package clientSideTest;

import clientside.SocketClass;
import clientside.SocketIF;
import java.io.IOException;

/**
 *
 * @author ThomasHedegaard
 */
public class ClientTest {

    SocketIF con;

    public ClientTest() {
        this.con = new SocketMock();
    }

    public void connectToServer() throws IOException {
        con.connect();
    }

    public void closeConToServer() throws IOException {
        con.close();
    }

    // Main
    public static void main(String[] args) {
        try {
            ClientTest test = new ClientTest();
            test.connectToServer();
            System.out.println("Connected to server!");
            test.closeConToServer();
            System.out.println("Disconnected from server!");
        } catch (IOException e) {
            System.err.println("Error in server connection");
            System.exit(1);
        }

    }
}
