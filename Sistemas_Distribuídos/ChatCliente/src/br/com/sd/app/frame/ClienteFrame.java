package br.com.sd.app.frame;

import br.com.sd.app.bean.ChatMessage;
import br.com.sd.app.bean.ChatMessage.Action;
import br.com.sd.app.service.ClienteService;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Set;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ClienteFrame extends javax.swing.JFrame {

    private Socket socket;
    private ChatMessage message;
    private ClienteService service;

    public ClienteFrame() {
        initComponents();
        login();
    }

    private class ListenerSocket implements Runnable {

        private ObjectInputStream input;

        public ListenerSocket(Socket socket) {
            try {
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }

        @Override
        public void run() {
            ChatMessage message = null;
            try {
                while ((message = (ChatMessage) input.readObject()) != null) {
                    Action action = message.getAction();

                    if (action.equals(Action.CONNECT)) {
                        connected(message);
                    } else if (action.equals(Action.DISCONNECT)) {
                        disconnected();
                        socket.close();
                    } else if (action.equals(Action.SEND_ONE)) {
                        receive(message);
                    } else if (action.equals(Action.USERS_ONLINE)) {
                        refreshOnlines(message);
                    }
                }
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }

    private void login() {
        JLabel lblMensagem = new JLabel("Digite o seu nome ou apelido para continuar:");
        JTextField txtNome = new JTextField();
        Object[] login = {lblMensagem, txtNome};

        do {
            JOptionPane.showMessageDialog(null, login);

            if (!txtNome.getText().isEmpty()) {
                this.message = new ChatMessage();
                this.message.setAction(Action.CONNECT);
                this.message.setName(txtNome.getText());

                this.service = new ClienteService();
                this.socket = this.service.connect();

                new Thread(new ListenerSocket(this.socket)).start();

                this.service.send(message);
            }
        } while (txtNome.getText().isEmpty());
    }

    private void connected(ChatMessage message) {
        if (message.getText().equals("NO")) {
            JOptionPane.showMessageDialog(this, "Conexão não realizada!\nTente novamente com um novo nome.");
            login();
            return;
        }

        this.message = message;

        JOptionPane.showMessageDialog(this, "Você está conectado!");

        this.setTitle(message.getName());
        this.setVisible(true);
    }

    private void disconnected() {
        JOptionPane.showMessageDialog(this, "Você desconectou!");
    }

    private void receive(ChatMessage message) {
        try {
            Date date = new Date();
            StyledDocument doc = txtPaneReceive.getStyledDocument();

            if (message.getNameReserved() != null) {
                SimpleAttributeSet keyWord = new SimpleAttributeSet();
                StyleConstants.setBold(keyWord, true);
                StyleConstants.setForeground(keyWord, Color.MAGENTA);
                SimpleAttributeSet keyWord1 = new SimpleAttributeSet();
                StyleConstants.setBold(keyWord1, true);
                StyleConstants.setForeground(keyWord1, Color.BLUE);
                SimpleAttributeSet keyWord2 = new SimpleAttributeSet();
                StyleConstants.setForeground(keyWord2, Color.GRAY);

                doc.insertString(doc.getLength(), "(Privado) ", keyWord);
                doc.insertString(doc.getLength(), message.getName(), keyWord1);
                doc.insertString(doc.getLength(), " (" + date.getHours() + ":" + date.getMinutes() + ")", keyWord2);
                doc.insertString(doc.getLength(), ": ", null);
                doc.insertString(doc.getLength(), message.getText() + "\r\n", null);
            } else if (message.getText().equals("conectou!")) {
                SimpleAttributeSet keyWord1 = new SimpleAttributeSet();
                StyleConstants.setBold(keyWord1, true);
                StyleConstants.setForeground(keyWord1, Color.GREEN);
                SimpleAttributeSet keyWord2 = new SimpleAttributeSet();
                StyleConstants.setForeground(keyWord2, Color.GREEN);

                doc.insertString(doc.getLength(), message.getName(), keyWord1);
                doc.insertString(doc.getLength(), " (" + date.getHours() + ":" + date.getMinutes() + ")", keyWord2);
                doc.insertString(doc.getLength(), ": ", keyWord2);
                doc.insertString(doc.getLength(), message.getText() + "\r\n", keyWord2);
            } else if (message.getText().equals("desconectou!")) {
                SimpleAttributeSet keyWord1 = new SimpleAttributeSet();
                StyleConstants.setBold(keyWord1, true);
                StyleConstants.setForeground(keyWord1, Color.RED);
                SimpleAttributeSet keyWord2 = new SimpleAttributeSet();
                StyleConstants.setForeground(keyWord2, Color.RED);

                doc.insertString(doc.getLength(), message.getName(), keyWord1);
                doc.insertString(doc.getLength(), " (" + date.getHours() + ":" + date.getMinutes() + ")", keyWord2);
                doc.insertString(doc.getLength(), ": ", keyWord2);
                doc.insertString(doc.getLength(), message.getText() + "\r\n", keyWord2);
            } else {
                SimpleAttributeSet keyWord1 = new SimpleAttributeSet();
                StyleConstants.setBold(keyWord1, true);
                StyleConstants.setForeground(keyWord1, Color.BLUE);
                SimpleAttributeSet keyWord2 = new SimpleAttributeSet();
                StyleConstants.setForeground(keyWord2, Color.GRAY);

                doc.insertString(doc.getLength(), message.getName(), keyWord1);
                doc.insertString(doc.getLength(), " (" + date.getHours() + ":" + date.getMinutes() + ")", keyWord2);
                doc.insertString(doc.getLength(), ": ", null);
                doc.insertString(doc.getLength(), message.getText() + "\r\n", null);
            }
        } catch (BadLocationException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void refreshOnlines(ChatMessage message) {
        System.out.println(message.getSetOnlines().toString());

        Set<String> names = message.getSetOnlines();

        names.remove(message.getName());

        String[] array = (String[]) names.toArray(new String[names.size()]);

        this.listOnlines.setListData(array);
        this.listOnlines.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listOnlines.setLayoutOrientation(JList.VERTICAL);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSair = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listOnlines = new javax.swing.JList();
        btnEnviar = new javax.swing.JLabel();
        txtSend = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPaneReceive = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));

        jPanel5.setBackground(new java.awt.Color(255, 153, 0));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ChatSD");

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sd/app/img/logout.png"))); // NOI18N
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSair)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(294, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSair)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        listOnlines.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jScrollPane3.setViewportView(listOnlines);

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sd/app/img/send.png"))); // NOI18N
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarMouseClicked(evt);
            }
        });

        txtSend.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtSend.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSendKeyPressed(evt);
            }
        });

        jScrollPane2.setViewportView(txtPaneReceive);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtSend, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnviar))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(txtSend))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
        ChatMessage message = new ChatMessage();
        message.setName(this.message.getName());
        message.setAction(Action.DISCONNECT);
        this.service.send(message);
        disconnected();
        System.exit(0);
    }//GEN-LAST:event_btnSairMouseClicked

    private void btnEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseClicked
        try {
            String text = this.txtSend.getText();
            String name = this.message.getName();
            Date date = new Date();
            StyledDocument doc = txtPaneReceive.getStyledDocument();

            this.message = new ChatMessage();

            if (this.listOnlines.getSelectedIndex() > -1) {
                this.message.setNameReserved((String) this.listOnlines.getSelectedValue());
                this.message.setAction(Action.SEND_ONE);
                this.listOnlines.clearSelection();

                if (!text.isEmpty()) {
                    this.message.setName(name);
                    this.message.setText(text);

                    SimpleAttributeSet keyWord = new SimpleAttributeSet();
                    StyleConstants.setBold(keyWord, true);
                    StyleConstants.setForeground(keyWord, Color.MAGENTA);
                    SimpleAttributeSet keyWord1 = new SimpleAttributeSet();
                    StyleConstants.setBold(keyWord1, true);
                    SimpleAttributeSet keyWord2 = new SimpleAttributeSet();
                    StyleConstants.setForeground(keyWord2, Color.GRAY);

                    doc.insertString(doc.getLength(), "(Privado para " + this.message.getNameReserved() + ") ", keyWord);
                    doc.insertString(doc.getLength(), "Eu", keyWord1);
                    doc.insertString(doc.getLength(), " (" + date.getHours() + ":" + date.getMinutes() + ")", keyWord2);
                    doc.insertString(doc.getLength(), ": ", null);
                    doc.insertString(doc.getLength(), text + "\r\n", null);

                    this.service.send(this.message);
                }
            } else {
                this.message.setAction(Action.SEND_ALL);

                if (!text.isEmpty()) {
                    this.message.setName(name);
                    this.message.setText(text);

                    SimpleAttributeSet keyWord1 = new SimpleAttributeSet();
                    StyleConstants.setBold(keyWord1, true);
                    SimpleAttributeSet keyWord2 = new SimpleAttributeSet();
                    StyleConstants.setForeground(keyWord2, Color.GRAY);

                    doc.insertString(doc.getLength(), "Eu", keyWord1);
                    doc.insertString(doc.getLength(), " (" + date.getHours() + ":" + date.getMinutes() + ")", keyWord2);
                    doc.insertString(doc.getLength(), ": ", null);
                    doc.insertString(doc.getLength(), text + "\r\n", null);

                    this.service.send(this.message);
                }
            }

            this.txtSend.setText("");
        } catch (BadLocationException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEnviarMouseClicked

    private void txtSendKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSendKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                String text = this.txtSend.getText();
                String name = this.message.getName();
                Date date = new Date();
                StyledDocument doc = txtPaneReceive.getStyledDocument();

                this.message = new ChatMessage();

                if (this.listOnlines.getSelectedIndex() > -1) {
                    this.message.setNameReserved((String) this.listOnlines.getSelectedValue());
                    this.message.setAction(Action.SEND_ONE);
                    this.listOnlines.clearSelection();

                    if (!text.isEmpty()) {
                        this.message.setName(name);
                        this.message.setText(text);

                        SimpleAttributeSet keyWord = new SimpleAttributeSet();
                        StyleConstants.setBold(keyWord, true);
                        StyleConstants.setForeground(keyWord, Color.MAGENTA);
                        SimpleAttributeSet keyWord1 = new SimpleAttributeSet();
                        StyleConstants.setBold(keyWord1, true);
                        SimpleAttributeSet keyWord2 = new SimpleAttributeSet();
                        StyleConstants.setForeground(keyWord2, Color.GRAY);

                        doc.insertString(doc.getLength(), "(Privado para " + this.message.getNameReserved() + ") ", keyWord);
                        doc.insertString(doc.getLength(), "Eu", keyWord1);
                        doc.insertString(doc.getLength(), " (" + date.getHours() + ":" + date.getMinutes() + ")", keyWord2);
                        doc.insertString(doc.getLength(), ": ", null);
                        doc.insertString(doc.getLength(), text + "\r\n", null);

                        this.service.send(this.message);
                    }
                } else {
                    this.message.setAction(Action.SEND_ALL);

                    if (!text.isEmpty()) {
                        this.message.setName(name);
                        this.message.setText(text);

                        SimpleAttributeSet keyWord1 = new SimpleAttributeSet();
                        StyleConstants.setBold(keyWord1, true);
                        SimpleAttributeSet keyWord2 = new SimpleAttributeSet();
                        StyleConstants.setForeground(keyWord2, Color.GRAY);

                        doc.insertString(doc.getLength(), "Eu", keyWord1);
                        doc.insertString(doc.getLength(), " (" + date.getHours() + ":" + date.getMinutes() + ")", keyWord2);
                        doc.insertString(doc.getLength(), ": ", null);
                        doc.insertString(doc.getLength(), text + "\r\n", null);

                        this.service.send(this.message);
                    }
                }

                this.txtSend.setText("");
            }
        } catch (BadLocationException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_txtSendKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnEnviar;
    private javax.swing.JLabel btnSair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listOnlines;
    private javax.swing.JTextPane txtPaneReceive;
    private javax.swing.JTextField txtSend;
    // End of variables declaration//GEN-END:variables
}
