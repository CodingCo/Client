package clientside;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class ClientGUI extends javax.swing.JFrame implements ViewListener {

    //== Field
    private ClientSide client;
    private DefaultListModel model;

    //== Construcor
    public ClientGUI() {
        initComponents();
        client = new ClientSide();
        model = new DefaultListModel();
        jListOnlineUsers.setModel(model);

        client.registerObserver(this);

        manageEnabledButtons();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListOnlineUsers = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonClose = new javax.swing.JButton();
        jButtonConnect = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMessageInput = new javax.swing.JTextArea();
        jButtonSend = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaChatBox = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CodeBusters' New Masterpiece");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jListOnlineUsers.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jListOnlineUsers);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Online users: ");

        jButtonClose.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonClose.setText("Close Chat");
        jButtonClose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jButtonConnect.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonConnect.setText("Connect");
        jButtonConnect.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonClose, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonClose, jButtonConnect});

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextAreaMessageInput.setColumns(20);
        jTextAreaMessageInput.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jTextAreaMessageInput.setRows(5);
        jTextAreaMessageInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaMessageInputKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTextAreaMessageInput);

        jButtonSend.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonSend.setText("Send");
        jButtonSend.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextAreaChatBox.setColumns(20);
        jTextAreaChatBox.setRows(5);
        jScrollPane1.setViewportView(jTextAreaChatBox);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateErrorMessage(String message) {
        UIManager.put("OptionPane.messageFont", new FontUIResource(
                new Font("Tahoma", Font.BOLD, 18)));
        JOptionPane.showMessageDialog(null, message);
    }

    private String generateInputMessage(String message) {
        String input;
        UIManager.put("OptionPane.messageFont", new FontUIResource(
                new Font("Tahoma", Font.BOLD, 18)));
        input = JOptionPane.showInputDialog(message);
        if (input == null) {
            return "";
        } else if (!input.isEmpty()) {
            return input;
        } else {
            generateErrorMessage("Not valid input, please re-enter");
        }
        return generateInputMessage(message);
    }

    private void manageEnabledButtons() {
        jTextAreaChatBox.setEditable(false);
        jTextAreaChatBox.setEnabled(client.isConnected());
        jTextAreaMessageInput.setEnabled(client.isConnected());
        jListOnlineUsers.setEnabled(client.isConnected());
        jButtonSend.setEnabled(client.isConnected());
        jButtonConnect.setEnabled(!client.isConnected());
        jButtonClose.setEnabled(client.isConnected());
    }
    //== Creates timestamp and username 
        private String getTimeStamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Calendar currentDate = new GregorianCalendar();
        return " " + sdf.format(currentDate.getTime()) + "/ " + client.getUserName() + ": "; 
    }

    //== Commands from the client to the server (CONNECT#NAME)(SEND#NAME#MESSAGE)(CLOSE#)
    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        if (!jTextAreaMessageInput.getText().isEmpty()) {
            String message = jTextAreaMessageInput.getText();
            client.sendMessage(generateSendCommand(getTimeStamp() + message));
            jTextAreaMessageInput.setText("");
            jListOnlineUsers.clearSelection();
        } else {
            generateErrorMessage("You can't send an empty message");
        }
    }//GEN-LAST:event_jButtonSendActionPerformed

    private String generateSendCommand(String message) {
        String command = "SEND#";
        if (jListOnlineUsers.isSelectionEmpty()) {                                //== Sending to all users
            command += "*#" + message;
        } else if (jListOnlineUsers.getSelectedIndices().length == 1) {           //== Sending to one user
            command += jListOnlineUsers.getSelectedValue() + "#" + message;
            jTextAreaChatBox.append("\n" + message);
        } else {                                                                   //== Sending to a group of users
            int index = 0;
            for (Object user : jListOnlineUsers.getSelectedValuesList()) {
                if (index > 0) {
                    command += ",";
                }
                command += user;
                index++;
            }
            command += "#" + message;
            jTextAreaChatBox.append("\n" + message);
        }
        return command;
    }

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        String name = generateInputMessage("Type your name and press OK");
        if (!name.isEmpty()) {
            client.connect("CONNECT#" + name, name);
        }
        manageEnabledButtons();
    }//GEN-LAST:event_jButtonConnectActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        client.sendMessage("CLOSE#");
        manageEnabledButtons();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    //== If enter was hit. Enables Send-button
    private void jTextAreaMessageInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaMessageInputKeyTyped
        if (evt.getKeyChar() == '\n') {
            String message = jTextAreaMessageInput.getText();
            client.sendMessage(message);
        }
        if (!jTextAreaMessageInput.getText().isEmpty()) {
            jButtonSend.setEnabled(true);
        } else {
            jButtonSend.setEnabled(false);
        }
    }//GEN-LAST:event_jTextAreaMessageInputKeyTyped

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        jListOnlineUsers.clearSelection();
    }//GEN-LAST:event_jPanel1MouseClicked

    private String obtainMessage(String message) {
        int sharps = 0;
        String chatMessage = "";
        for (Character character : message.toCharArray()) {
            if (sharps >= 2) {
                chatMessage += character;
            }
            if (character == '#') {
                sharps++;
            }
        }
        return chatMessage;
    }

    private void updateOnlineUsersList(String message) {
        int sharps = 0;
        String userString = "";
        for (Character character : message.toCharArray()) {                       //== "CUTS" "ONLINE#" AWAY. ALLOWS "#" IN USERNAMES
            if (sharps >= 1) {
                userString += character;
            }
            if (character == '#') {
                sharps++;
            }
        }

        String[] names = userString.split(",");                                   //== SEPARATES ALL THE USERS
        ArrayList<User> onlineUsers = new ArrayList<>();
        for (String name : names) {
            onlineUsers.add(new User(name));
        }

        model.clear();                                                            //== CLEARS AND REFILLS THE LIST
        for (User user : onlineUsers) {
            model.addElement(user);
        }

        jLabel1.setText("Online users: " + onlineUsers.size());
    }

    @Override
    public void messageArrived(String message) {
        if (message.startsWith("MESSAGE#")) {                                     //== WHEN A "MESSAGE#" COMMAND HAS ARRIVED
            jTextAreaChatBox.append("\n" + obtainMessage(message));
        } else if (message.startsWith("ONLINE#")) {                               //== WHEN A "ONLINE#" COMMAND HAS ARRIVED
            updateOnlineUsersList(message);
        } else if (message.equals("Connection closed.")) {
            jTextAreaChatBox.append("\n" + message);
            manageEnabledButtons();
        } else if (message.equals("You are now connected!")) {
            jTextAreaChatBox.setText(message);
        } else {                                                                  //== ELSE, IT IS A CLOSE-MESSAGE 
            jTextAreaChatBox.append("\n" + message);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jListOnlineUsers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaChatBox;
    private javax.swing.JTextArea jTextAreaMessageInput;
    // End of variables declaration//GEN-END:variables

}
