package br.com.sd.app.service;

import br.com.sd.app.bean.ChatMessage;
import br.com.sd.app.bean.ChatMessage.Action;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ServidorService {

    private ServerSocket serverSocket;
    private Socket socket;
    private Map<String, ObjectOutputStream> mapOnlines = new HashMap<>();

    public ServidorService() {
        try {
            int porta = 8500;
            serverSocket = new ServerSocket(porta);
            System.out.println("Servidor ligado na porta " + porta);

            while (true) {
                socket = serverSocket.accept();
                new Thread(new ListenerSocket(socket)).start();
            }

        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    private class ListenerSocket implements Runnable {

        private ObjectOutputStream output;
        private ObjectInputStream input;

        public ListenerSocket(Socket socket) {
            try {
                this.output = new ObjectOutputStream(socket.getOutputStream());
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
                        boolean isConnect = connect(message, output);
                        if (isConnect) {
                            mapOnlines.put(message.getName(), output);
                            sendOnlines();
                            System.out.println(message.getName() + " conectou");
                            message.setText("conectou!");
                            sendAll(message);
                        }
                    } else if (action.equals(Action.DISCONNECT)) {
                        disconnect(message, output);
                        sendOnlines();
                        return;
                    } else if (action.equals(Action.SEND_ONE)) {
                        sendOne(message);
                    } else if (action.equals(Action.SEND_ALL)) {
                        sendAll(message);
                    }
                }
            } catch (IOException ex) {
                ChatMessage cm = new ChatMessage();
                cm.setName(message.getName());
                disconnect(cm, output);
                sendOnlines();
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }

    private boolean connect(ChatMessage message, ObjectOutputStream output) {
        if (mapOnlines.size() == 0) {
            message.setText("YES");
            send(message, output);
            return true;
        }
        if (mapOnlines.containsKey(message.getName())) {
            message.setText("NO");
            send(message, output);
            return false;
        } else {
            message.setText("YES");
            send(message, output);
            return true;
        }
    }

    private void disconnect(ChatMessage message, ObjectOutputStream output) {
        mapOnlines.remove(message.getName());
        message.setText("desconectou!");
        message.setAction(Action.SEND_ONE);
        sendAll(message);
        System.out.println(message.getName() + " desconectou");
    }

    private void send(ChatMessage message, ObjectOutputStream output) {
        try {
            output.writeObject(message);
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    private void sendOne(ChatMessage message) {
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
            if (kv.getKey().equals(message.getNameReserved())) {
                try {
                    kv.getValue().writeObject(message);
                } catch (IOException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            }
        }
    }

    private void sendAll(ChatMessage message) {
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
            if (!kv.getKey().equals(message.getName())) {
                message.setAction(Action.SEND_ONE);
                try {
                    kv.getValue().writeObject(message);
                } catch (IOException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            }
        }
    }

    private void sendOnlines() {
        Set<String> setNames = new HashSet<>();
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
            setNames.add(kv.getKey());
        }

        ChatMessage message = new ChatMessage();
        message.setAction(Action.USERS_ONLINE);
        message.setSetOnlines(setNames);

        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
            message.setName(kv.getKey());
            try {
                kv.getValue().writeObject(message);
            } catch (IOException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }
}
