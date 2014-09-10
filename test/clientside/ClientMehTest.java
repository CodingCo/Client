/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientside;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Awesomeness
 */
public class ClientMehTest {
    
    private SocketIF mock;
    private int status;
    
    public ClientMehTest() {
        this.status = 0;
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mock = new SocketMock();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of connect method, of class ClientMeh.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        String msg = "";
        String name = "";
        ClientSide instance = new ClientSide(mock);
        instance.connect(msg, name);
        // If resonse from server is ONLINE# -> succes
        assertEquals(status, 1);
    }

    /**
     * Test of sendMessage method, of class ClientMeh.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        String msg = "";
        ClientSide instance = new ClientSide();
        instance.sendMessage(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyzeServerCommands method, of class ClientMeh.
     */
    @Test
    public void testAnalyzeServerCommands() {
        System.out.println("analyzeServerCommands");
        String cmd = "";
        ClientSide instance = new ClientSide();
        instance.analyzeServerCommands(cmd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class ClientMeh.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        ClientSide instance = new ClientSide();
        instance.closeConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isConnected method, of class ClientMeh.
     */
    @Test
    public void testIsConnected() {
        System.out.println("isConnected");
        ClientSide instance = new ClientSide();
        boolean expResult = false;
        boolean result = instance.isConnected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerObserver method, of class ClientMeh.
     */
    @Test
    public void testRegisterObserver() {
        System.out.println("registerObserver");
        ViewListener obs = null;
        ClientSide instance = new ClientSide();
        instance.registerObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unRegisterObserver method, of class ClientMeh.
     */
    @Test
    public void testUnRegisterObserver() {
        System.out.println("unRegisterObserver");
        ViewListener obs = null;
        ClientSide instance = new ClientSide();
        instance.unRegisterObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyObservers method, of class ClientMeh.
     */
    @Test
    public void testNotifyObservers() {
        System.out.println("notifyObservers");
        String msg = "";
        ClientSide instance = new ClientSide();
        instance.notifyObservers(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of messageArrived method, of class ClientMeh.
     */
    @Test
    public void testMessageArrived() {
        System.out.println("messageArrived");
        String data = "";
        ClientSide instance = new ClientSide();
        instance.messageArrived(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public void setStatus(int val){
        status += val;
    }
    
}
